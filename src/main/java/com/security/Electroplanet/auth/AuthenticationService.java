package com.security.Electroplanet.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.Electroplanet.Repository.UserRepository;
import com.security.Electroplanet.config.JwtService;
import com.security.Electroplanet.entites.Role;
import com.security.Electroplanet.entites.User;
import com.security.Electroplanet.token.Token;
import com.security.Electroplanet.token.TokenRepository;
import com.security.Electroplanet.token.TokenType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;

    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
       var user = User.builder()
               .firstname(request.getFirstname())
               .lastname(request.getLastname())
               .email(request.getEmail())
               .password(passwordEncoder.encode(request.getPassword()))
               .role(request.getRole())
               .build();
       var saveUser =  repository.save(user);
       var jwtToken =  jwtService.generateToken(user);
       var refreshToken = jwtService.generateRefershToken(user);
        saveUserToken(saveUser, jwtToken);
        return  AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken =  jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefershToken(user);
        revokeAllUserToken(user);
        saveUserToken(user, jwtToken);
        return  AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }
    private void  revokeAllUserToken(User user){
        var validUserToken = tokenRepository.findAllValidTokenByUser(user.getId());
                if(validUserToken.isEmpty())
                    return;
                validUserToken.forEach(t -> {
                    t.setExpired(true);
                    t.setRevoked(true);
                });
                tokenRepository.saveAll(validUserToken);
    }
    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
    }


    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response)  throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUserEmail(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserToken(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}

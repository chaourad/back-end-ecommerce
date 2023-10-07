package com.security.Electroplanet.config;

import com.security.Electroplanet.token.TokenRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private  final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;
    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull  HttpServletResponse response,
            @NotNull FilterChain filterChain
    ) throws ServletException, IOException {
        if (request.getServletPath().contains("/api/v1/auth")) {
            filterChain.doFilter(request, response);
            return;
        }
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        //check jwt
        if(authHeader == null || !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }
        //extract jwt token
        jwt = authHeader.substring(7);
        //extarct useremail
        userEmail =jwtService.extractUserEmail(jwt);

        //if we have useremail  is not authenticate if equals null
        if(userEmail !=null && SecurityContextHolder.getContext().getAuthentication()== null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            //check the token valid in the database
            var isTokenValid = tokenRepository.findByToken(jwt)
                    .map(t -> !t.isExpired() && !t.isExpired())
                    .orElse(false);

            //check the user find or not
            if(jwtService.isTokenValid(jwt, userDetails )&& isTokenValid){
                //if token valide i need to update
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                //enforce auth
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                //update securit context holder
                SecurityContextHolder.getContext().setAuthentication(authToken);

            }
        }
        filterChain.doFilter(request , response);

    }
}

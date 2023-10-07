package com.security.Electroplanet.config;

import com.security.Electroplanet.entites.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${application.security.jwt.secret-key}")
    private  String secretKey;
    @Value("${application.security.jwt.expiration}")
    private Long jwtExpiration;
    @Value("${application.security.jwt.refresh-token.expiration}")
    private Long refreshExpiration;

    public String extractUserEmail(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    public  <T> T extractClaims(String token , Function<Claims , T>claimsResolver){
        final Claims claims = extractAllCliams(token);
        return claimsResolver.apply(claims);
    }
    public String generateToken(UserDetails userDetails) {
        User user = (User) userDetails; // Cast UserDetails en User

        Map<String, Object> claims = new HashMap<>();
        // Add user's role to the claims
        claims.put("userId", user.getId());
        claims.put("username",user.getFirstname());
        claims.put("role", userDetails.getAuthorities().stream().findFirst().orElse(null).getAuthority());

        return buildToken(claims, userDetails, jwtExpiration);
    }

    public  String generateToken(
            Map<String , Object> extractClaims ,
            UserDetails userDetails
    ){
        return  buildToken(extractClaims , userDetails ,jwtExpiration);
    }
    public  String generateRefershToken(

            UserDetails userDetails
    ){
        return  buildToken(new HashMap<>() , userDetails ,refreshExpiration);
    }
    private String buildToken(
            Map<String , Object> extractClaims ,
            UserDetails userDetails,
            Long expiration
    ){
        return  Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public  boolean isTokenValid(String token , UserDetails userDetails){
        final  String userEmail = extractUserEmail(token);
        return  (userEmail.equals(userDetails.getUsername())) && !isTokenNotExpired(token);
    }

    private boolean isTokenNotExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return  extractClaims(token, Claims::getExpiration);
    }

    private Claims extractAllCliams(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

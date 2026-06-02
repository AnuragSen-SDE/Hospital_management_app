package com.learnng.HospitalManagement.security.jwt;

import com.learnng.HospitalManagement.security.entity.CustomeUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.secret}")
    private  String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    @Override
    public String generateToken(UserDetails userDetails) {
        CustomeUserDetails customeUserDetails = (CustomeUserDetails) userDetails;
        Map<String ,Object> map = new HashMap<>();
        map.put("role",customeUserDetails.getRole().name());
        return createToken(map,userDetails);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        Claims claims = extractAllClaims(token);
        return !claims.getExpiration()
                .before(new Date())
                && claims
                .getSubject()
                .equals(userDetails.getUsername());
    }

    @Override
    public boolean isTokenExpired(String token) {
        return extractAllClaims(token)
                .getExpiration()
                .before(new Date());
    }


    @Override
    public String extractUserName(String token) {
        return extractAllClaims(token)
                .getSubject();
    }

    private String createToken(Map<String ,Object> claims , UserDetails userDetails){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey())
                .compact();
    }

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    private Claims extractAllClaims( String token ) {
        return Jwts.parser().setSigningKey(getSigningKey()).build().parseSignedClaims(token)
                .getBody();
    }
}

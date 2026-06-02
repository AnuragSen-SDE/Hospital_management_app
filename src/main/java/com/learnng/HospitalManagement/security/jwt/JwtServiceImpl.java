package com.learnng.HospitalManagement.security.jwt;

import com.learnng.HospitalManagement.security.entity.CustomeUserDetails;
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

    private String createToken(Map<String ,Object> claims , UserDetails userDetails){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSiningKey())
                .compact();
    }

    private SecretKey getSiningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }
}

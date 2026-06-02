package com.learnng.HospitalManagement.security.jwt;

import com.learnng.HospitalManagement.security.entity.CustomeUserDetails;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String generateToken(UserDetails userDetails);
    boolean isTokenValid(String token,UserDetails userDetails);
    boolean isTokenExpired(String token);
    String extractUserName( String token );

}

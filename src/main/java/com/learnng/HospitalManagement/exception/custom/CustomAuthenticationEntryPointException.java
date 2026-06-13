package com.learnng.HospitalManagement.exception.custom;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnng.HospitalManagement.exception.entity.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class CustomAuthenticationEntryPointException implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(authException.getMessage())
                .status(HttpStatus.UNAUTHORIZED.value())
                .build();
        objectMapper.writeValue(
                response.getOutputStream(),
                errorResponse
        );
    }
}

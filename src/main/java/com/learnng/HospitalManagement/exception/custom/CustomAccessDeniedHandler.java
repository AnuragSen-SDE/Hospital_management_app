package com.learnng.HospitalManagement.exception.custom;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnng.HospitalManagement.exception.entity.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;


@RequiredArgsConstructor
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException
    ) throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(accessDeniedException.getMessage())
                .status(HttpStatus.FORBIDDEN.value())
                .build();
        objectMapper.writeValue(
                response.getOutputStream(),
                errorResponse
        );
    }
}

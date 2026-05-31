package com.learnng.HospitalManagement.auth.controller;

import com.learnng.HospitalManagement.auth.entity.LoginRequestdto;
import com.learnng.HospitalManagement.auth.service.AuthService;
import com.learnng.HospitalManagement.util.Entity.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<ApiResponse> loginRequest(
            @Valid @RequestBody LoginRequestdto loginRequest
            ) {
        authService.login(loginRequest);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message("Login Successfully")
                        .status(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/ping")
    public String ping() {
        return "working";
    }
}

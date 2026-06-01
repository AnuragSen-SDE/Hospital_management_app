package com.learnng.HospitalManagement.auth.controller;

import com.learnng.HospitalManagement.auth.entity.LoginRequestdto;
import com.learnng.HospitalManagement.auth.entity.SignupRequestDto;
import com.learnng.HospitalManagement.auth.entity.SignupResponseDto;
import com.learnng.HospitalManagement.auth.service.AuthService;
import com.learnng.HospitalManagement.util.Entity.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginRequest(
            @Valid @RequestBody LoginRequestdto loginRequest
            ) {
        System.out.println("request at controller");
        authService.login(loginRequest);
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message("Login Successfully")
                        .status(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signupRequest(
            @Valid @RequestBody SignupRequestDto signupRequestDto
            ){
        SignupResponseDto responseDto = authService.signUp(signupRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.builder()
                                .message("Registered Successfully")
                                .status(HttpStatus.CREATED.value())
                                .data(responseDto)
                                .build()
                );
    }

    @GetMapping("/ping")
    public String ping() {
        return "working";
    }
}

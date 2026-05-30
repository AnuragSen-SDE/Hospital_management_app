package com.learnng.HospitalManagement.auth.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginRequest {

    @Email(message = "Please enter a valid email")
    String email;

    @Size(min = 8)
    String password;
}

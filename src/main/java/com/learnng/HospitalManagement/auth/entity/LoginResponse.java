package com.learnng.HospitalManagement.auth.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponse {

    @Email(message = "Please enter a valid email")
    String email;

    @Size(min = 8)
    String password;

    String Role;
}

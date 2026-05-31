package com.learnng.HospitalManagement.auth.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginRequestdto {

    @Email(message = "Please enter a valid email")
    String email;

    @Size(min = 8)
    String password;
}

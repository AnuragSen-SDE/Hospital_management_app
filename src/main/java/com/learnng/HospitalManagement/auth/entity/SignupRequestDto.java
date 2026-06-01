package com.learnng.HospitalManagement.auth.entity;

import com.learnng.HospitalManagement.user.entity.type.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDto {
    @Email
    @Size(min = 5)
    @NotBlank(message = "Email can't be empty")
    private String email;

    @Size(min = 8)
    @NotBlank(message = "Password can't be empty")
    private String password;

    @NotBlank(message = "Role Can't be empyt")
    private Role role;
}

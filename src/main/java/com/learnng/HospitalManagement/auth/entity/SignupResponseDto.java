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
public class SignupResponseDto {

    private String email;

    private String password;

}

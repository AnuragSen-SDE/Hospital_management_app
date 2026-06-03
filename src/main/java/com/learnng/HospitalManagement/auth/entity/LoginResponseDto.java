package com.learnng.HospitalManagement.auth.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginResponseDto {
     private String jwtToke;
}

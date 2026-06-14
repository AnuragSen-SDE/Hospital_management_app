package com.learnng.HospitalManagement.user.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    @NotBlank(message = "Role Must not be null")
    private String name;


    private String description;
}

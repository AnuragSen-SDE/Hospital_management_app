package com.learnng.HospitalManagement.user.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserPermissionDto {

    @NotBlank(message = "Permission Value Can't be null or Blank")
    private String name;

    private String description;
}

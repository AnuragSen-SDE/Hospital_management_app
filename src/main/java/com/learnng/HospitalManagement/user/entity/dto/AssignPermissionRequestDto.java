package com.learnng.HospitalManagement.user.entity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class AssignPermissionRequestDto {
    private Set<Long> permissionIds;
}

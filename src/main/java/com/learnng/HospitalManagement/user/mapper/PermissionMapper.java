package com.learnng.HospitalManagement.user.mapper;

import com.learnng.HospitalManagement.user.entity.Permission;
import com.learnng.HospitalManagement.user.entity.dto.PermissionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    PermissionDto toDto(Permission permission);

    Permission toEntity(PermissionDto permissionDto);
}

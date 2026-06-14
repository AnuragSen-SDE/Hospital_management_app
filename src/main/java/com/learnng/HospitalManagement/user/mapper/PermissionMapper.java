package com.learnng.HospitalManagement.user.mapper;

import com.learnng.HospitalManagement.user.entity.Permission;
import com.learnng.HospitalManagement.user.entity.dto.UserPermissionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    UserPermissionDto toDto(Permission permission);

    Permission toEntity(UserPermissionDto userPermissionDto);
}

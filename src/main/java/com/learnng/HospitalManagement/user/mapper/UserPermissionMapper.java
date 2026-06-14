package com.learnng.HospitalManagement.user.mapper;

import com.learnng.HospitalManagement.user.entity.UserPermissions;
import com.learnng.HospitalManagement.user.entity.dto.UserPermissionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserPermissionMapper {
    UserPermissionDto toDto(UserPermissions userPermissions);

    UserPermissions toEntity(UserPermissionDto userPermissionDto);
}

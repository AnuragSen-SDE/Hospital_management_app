package com.learnng.HospitalManagement.user.mapper;

import com.learnng.HospitalManagement.user.entity.Role;
import com.learnng.HospitalManagement.user.entity.dto.RoleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto toDto (Role role);
    Role toEntity ( RoleDto roleDto);
}

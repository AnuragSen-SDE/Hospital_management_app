package com.learnng.HospitalManagement.user.service.impl;

import com.learnng.HospitalManagement.exception.custom.UserPermissionException;
import com.learnng.HospitalManagement.user.entity.Permission;
import com.learnng.HospitalManagement.user.repository.PermissionRepository;
import com.learnng.HospitalManagement.user.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PermissionImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Override
    public Permission createUserPermission(Permission permission) {
        permission.setName(permission.getName().trim().toUpperCase());
        if (permissionRepository.existsByName(permission.getName()))
            throw new UserPermissionException("Permission Already Exist");


        return permissionRepository.save(permission);
    }

    @Override
    public List<Permission> findAllPermissionsByIds(Set<Long> permissionIds) {
        return permissionRepository.findAllById(permissionIds);
    }
}

package com.learnng.HospitalManagement.user.service.impl;

import com.learnng.HospitalManagement.exception.custom.UserPermissionException;
import com.learnng.HospitalManagement.user.entity.UserPermissions;
import com.learnng.HospitalManagement.user.repository.UserPermissionRepository;
import com.learnng.HospitalManagement.user.service.UserPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPermissionImpl implements UserPermissionService {

    private final UserPermissionRepository userPermissionRepository;

    @Override
    public UserPermissions createUserPermission(UserPermissions userPermissions) {
        userPermissions.setName(userPermissions.getName().trim().toUpperCase());
        if (userPermissionRepository.existsByName(userPermissions.getName()))
            throw new UserPermissionException("Permission Already Exist");


        return userPermissionRepository.save(userPermissions);
    }
}

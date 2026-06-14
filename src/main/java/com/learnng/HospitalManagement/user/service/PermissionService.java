package com.learnng.HospitalManagement.user.service;

import com.learnng.HospitalManagement.user.entity.Permission;

import java.util.List;
import java.util.Set;

public interface PermissionService {
    Permission createUserPermission(Permission permission);
    List<Permission> findAllPermissionsByIds(Set<Long> permissionIds);
}

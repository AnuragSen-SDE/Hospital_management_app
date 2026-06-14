package com.learnng.HospitalManagement.user.service;

import com.learnng.HospitalManagement.user.entity.Role;

import java.util.Set;

public interface RoleService {
    Role createRole(Role role);
    void addPermission(Long roleId, Set<Long> permissionIds);
}

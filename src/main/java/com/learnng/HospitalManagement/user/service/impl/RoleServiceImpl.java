package com.learnng.HospitalManagement.user.service.impl;

import com.learnng.HospitalManagement.exception.custom.RoleException;
import com.learnng.HospitalManagement.exception.custom.UserPermissionException;
import com.learnng.HospitalManagement.user.entity.Permission;
import com.learnng.HospitalManagement.user.entity.Role;
import com.learnng.HospitalManagement.user.repository.RoleRepository;
import com.learnng.HospitalManagement.user.service.PermissionService;
import com.learnng.HospitalManagement.user.service.RoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final PermissionService permissionService;

    @Override
    public Role createRole(Role role) {
        role.setName(role.getName().trim().toUpperCase());
        if (roleRepository.existsByName(role.getName()))
            throw new RoleException("Role Already Exist");

        return roleRepository.save(role);
    }

    @Transactional
    @Override
    public void addPermission(Long roleId, Set<Long> permissionIds) {
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RoleException("Role Not Found"));
        List<Permission> permissions = permissionService.findAllPermissionsByIds(permissionIds);

        if (permissionIds.size() != permissions.size()) throw new RoleException("One or more permissions not found");

        role.getPermissions().addAll(permissions);
        roleRepository.save(role);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> new RoleException("No Role Found With Specific Name"));
    }
}

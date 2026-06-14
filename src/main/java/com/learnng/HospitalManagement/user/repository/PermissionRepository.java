package com.learnng.HospitalManagement.user.repository;

import com.learnng.HospitalManagement.user.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Long> {
    boolean existsByName(String name);
}

package com.learnng.HospitalManagement.user.repository;

import com.learnng.HospitalManagement.user.entity.UserPermissions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPermissionRepository extends JpaRepository<UserPermissions,Long> {
    boolean existsByName(String name);
}

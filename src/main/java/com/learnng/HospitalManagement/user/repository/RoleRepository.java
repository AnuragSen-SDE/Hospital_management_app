package com.learnng.HospitalManagement.user.repository;

import com.learnng.HospitalManagement.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    boolean existsByName(String name);
}

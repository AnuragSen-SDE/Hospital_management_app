package com.learnng.HospitalManagement.user.repository;

import com.learnng.HospitalManagement.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    boolean existsByName(String name);
    Optional<Role> findByName(String name);
}

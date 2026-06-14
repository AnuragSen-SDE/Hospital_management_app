package com.learnng.HospitalManagement.user.controller;

import com.learnng.HospitalManagement.user.entity.Role;
import com.learnng.HospitalManagement.user.entity.dto.AssignPermissionRequestDto;
import com.learnng.HospitalManagement.user.entity.dto.RoleDto;
import com.learnng.HospitalManagement.user.mapper.RoleMapper;
import com.learnng.HospitalManagement.user.service.RoleService;
import com.learnng.HospitalManagement.util.Entity.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/roles")
@RequiredArgsConstructor
@Slf4j
public class RoleController {

    private final RoleMapper roleMapper;
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<ApiResponse> createRole(
            @Valid @RequestBody RoleDto roleDto
    ) {
        Role role = roleService.createRole(roleMapper.toEntity(roleDto));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.CREATED.value())
                                .message("Role Created Successfully")
                                .data(roleMapper.toDto(role))
                                .build()
                );
    }

    @PostMapping("/{role_id}/permissions")
    public ResponseEntity<ApiResponse> assignPermission (
            @PathVariable(name = "role_id") Long roleId,
            @Valid @RequestBody AssignPermissionRequestDto assignPermissionRequestDto
            ) {

        System.out.println("ASSIGN PERMISSION API HIT");
        roleService.addPermission(roleId,assignPermissionRequestDto.getPermissionIds());
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.OK.value())
                                .message("Permission Added Successfully")
                                .build()
                );
    }



}

package com.learnng.HospitalManagement.user.controller;

import com.learnng.HospitalManagement.user.entity.Permission;
import com.learnng.HospitalManagement.user.entity.dto.PermissionDto;
import com.learnng.HospitalManagement.user.mapper.PermissionMapper;
import com.learnng.HospitalManagement.user.service.PermissionService;
import com.learnng.HospitalManagement.util.Entity.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/permissions")
public class PermissionController {

    private final PermissionService permissionService;
    private final PermissionMapper permissionMapper;

    @PostMapping
    public ResponseEntity<ApiResponse> createPermission(
            @Valid @RequestBody PermissionDto permissionDto
    ) {
        Permission permission = permissionService.createUserPermission(permissionMapper.toEntity(permissionDto));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.CREATED.value())
                                .message("Permission Created Successfully")
                                .data(permissionMapper.toDto(permission))
                                .build()
                );

    }

}

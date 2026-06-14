package com.learnng.HospitalManagement.user.controller;

import com.learnng.HospitalManagement.user.entity.UserPermissions;
import com.learnng.HospitalManagement.user.entity.dto.UserPermissionDto;
import com.learnng.HospitalManagement.user.mapper.UserPermissionMapper;
import com.learnng.HospitalManagement.user.service.UserPermissionService;
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
@RequestMapping("api/v1/user/permissions")
public class UserPermissionController {

    private final UserPermissionService userPermissionService;
    private final UserPermissionMapper userPermissionMapper;

    @PostMapping
    public ResponseEntity<ApiResponse> createPermission(
            @Valid @RequestBody UserPermissionDto userPermissionDto
    ) {
        UserPermissions userPermissions = userPermissionService.createUserPermission(userPermissionMapper.toEntity(userPermissionDto));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.CREATED.value())
                                .message("Permission Created Successfully")
                                .data(userPermissionMapper.toDto(userPermissions))
                                .build()
                );

    }

}

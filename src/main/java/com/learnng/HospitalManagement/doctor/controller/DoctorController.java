package com.learnng.HospitalManagement.doctor.controller;

import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.doctor.entity.dto.DoctorDto;
import com.learnng.HospitalManagement.doctor.mapper.DoctorMapper;
import com.learnng.HospitalManagement.doctor.service.DoctorService;
import com.learnng.HospitalManagement.util.Entity.ApiResponse;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/doctor")
public class DoctorController {

    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;

    @PostMapping
    public ResponseEntity<ApiResponse> registerDoctor(
            @Valid @RequestBody DoctorDto doctorDto
            ) {

        Doctor doctor = doctorService.registerDoctor(doctorMapper.toDoctorEntity(doctorDto));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.CREATED.value())
                                .message("Doctor Registered Successfully")
                                .data(doctor)
                                .build()
                );
    }

}

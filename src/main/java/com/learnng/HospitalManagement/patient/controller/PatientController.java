package com.learnng.HospitalManagement.patient.controller;


import com.learnng.HospitalManagement.patient.entity.Patient;
import com.learnng.HospitalManagement.patient.entity.dto.PatientDto;
import com.learnng.HospitalManagement.patient.mapper.PatientMapper;
import com.learnng.HospitalManagement.patient.service.PatientService;
import com.learnng.HospitalManagement.security.entity.CustomeUserDetails;
import com.learnng.HospitalManagement.util.Entity.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/patient")
@Slf4j
public class PatientController {

    //private static final Log log = LogFactory.getLog(PatientController.class);
    private final PatientService patientService;
    private final PatientMapper patientMapper;

    @PostMapping
    @PreAuthorize("hasAuthority('PATIENT_CREATE')")
    public ResponseEntity<ApiResponse> registerPatient(
            @AuthenticationPrincipal CustomeUserDetails userDetails,
            @Valid @RequestBody PatientDto patientDto
            ) {

        Patient patient = patientService.registerPatient(userDetails,patientMapper.toPatientEntity(patientDto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        new ApiResponse(
                                HttpStatus.CREATED.value(),
                                "Patient Created Successfully",
                                patientMapper.toPatientDto(patient)
                        )
                );
    }

    @GetMapping
    @PreAuthorize("hasAuthority('PATIENT_VIEW')")
    public ResponseEntity<ApiResponse> getAllPatient() {
        List<PatientDto> patientDtos =  patientService.getAllPatient().stream().map(patientMapper::toPatientDto).toList();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authorities : " + authentication.getAuthorities());
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .status(HttpStatus.OK.value())
                        .message("All Patient data retrived successfully")
                        .data(patientDtos)
                        .build()
        );
    }


}

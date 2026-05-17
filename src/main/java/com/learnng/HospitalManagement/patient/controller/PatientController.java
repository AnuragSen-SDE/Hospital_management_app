package com.learnng.HospitalManagement.patient.controller;


import com.learnng.HospitalManagement.patient.entity.Patient;
import com.learnng.HospitalManagement.patient.entity.dto.PatientDto;
import com.learnng.HospitalManagement.patient.mapper.PatientMapper;
import com.learnng.HospitalManagement.patient.service.PatientService;
import com.learnng.HospitalManagement.util.Entity.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/patient")
public class PatientController {

    private final PatientService patientService;
    private final PatientMapper patientMapper;

    @PostMapping
    public ResponseEntity<ApiResponse> registerPatient(
            @Valid @RequestBody PatientDto patientDto
            ) {
        Patient patient = patientService.registerPatient(patientMapper.toPatientEntity(patientDto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        new ApiResponse(
                                HttpStatus.CREATED.value(),
                                "Patient Created Successfully",
                                patientMapper.toPatientDto(patient)
                        )
                );
    }

}

package com.learnng.HospitalManagement.prescription.controller;

import com.learnng.HospitalManagement.prescription.entity.Prescription;
import com.learnng.HospitalManagement.prescription.entity.dto.PrescriptionDto;
import com.learnng.HospitalManagement.prescription.mapper.PrescriptionMapper;
import com.learnng.HospitalManagement.prescription.service.PrescriptionService;
import com.learnng.HospitalManagement.util.Entity.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/prescription")
@RequiredArgsConstructor
public class PrescriptionController {
    private final PrescriptionService prescriptionService;
    private final PrescriptionMapper prescriptionMapper;

    @PostMapping
    public ResponseEntity<ApiResponse> createPrescription(
            @Valid @RequestBody PrescriptionDto prescriptionDto
            ) {
        Prescription prescription = prescriptionService.createPrescription(prescriptionDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.CREATED.value())
                                .message("Prescription Created successfully")
                                .data(prescriptionMapper.toPrescriptionDto(prescription))
                                .build()
                );
    }
}

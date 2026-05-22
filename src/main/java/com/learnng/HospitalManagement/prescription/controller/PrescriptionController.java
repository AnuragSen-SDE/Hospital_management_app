package com.learnng.HospitalManagement.prescription.controller;

import com.learnng.HospitalManagement.prescription.entity.Prescription;
import com.learnng.HospitalManagement.prescription.entity.dto.AddMedicineRequest;
import com.learnng.HospitalManagement.prescription.entity.dto.PrescriptionDto;
import com.learnng.HospitalManagement.prescription.mapper.PrescriptionMapper;
import com.learnng.HospitalManagement.prescription.service.PrescriptionService;
import com.learnng.HospitalManagement.util.Entity.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/prescription")
@RequiredArgsConstructor
public class PrescriptionController {
    private final PrescriptionService prescriptionService;
    private final PrescriptionMapper prescriptionMapper;

    @PostMapping
    public ResponseEntity<ApiResponse> registerPrescription(
            @Valid @RequestBody PrescriptionDto prescriptionDto
            ) {
        Prescription prescription = prescriptionService.registerPrescription(prescriptionDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.CREATED.value())
                                .message("Prescription Created successfully")
                                .data(prescriptionMapper.toPrescriptionDto(prescription))
                                .build()
                );
    }

    @PostMapping("/{prescriptionId}")
    public ResponseEntity<ApiResponse> addMedicineToPrescription(
            @PathVariable(name = "prescriptionId") Long prescriptionId,
            @Valid @RequestBody AddMedicineRequest addMedicineRequest
            ) {
        prescriptionService.addMedicine(prescriptionId,addMedicineRequest);

        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.OK.value())
                                .message("Medicine Added successfully")
                                .build()
                );
    }

    @GetMapping("/{prescriptionId}")
    public ResponseEntity<ApiResponse> getPrescriptionById(
            @PathVariable(name = "prescriptionId") Long prescriptionId
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.OK.value())
                                .message("Prescription Retrived Successfully")
                                .data(prescriptionMapper.toPrescriptionDto(prescriptionService.findPrescriptionById(prescriptionId)))
                                .build()
                );
    }

    @PostMapping("/{prescriptionId}/save")
    public ResponseEntity<ApiResponse> finalizeAndSavePrescription(
            @PathVariable ( name = "prescriptionId") Long prescriptionId
    ) {
        prescriptionService.finalizePrescription(prescriptionId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.OK.value())
                                .message("Prescription Saved successfully")
                                .build()
                );
    }
}

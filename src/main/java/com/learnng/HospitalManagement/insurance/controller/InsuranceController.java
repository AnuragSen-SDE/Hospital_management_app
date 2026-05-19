package com.learnng.HospitalManagement.insurance.controller;

import com.learnng.HospitalManagement.insurance.entiy.dto.InsuranceDto;
import com.learnng.HospitalManagement.insurance.mapper.InsuranceMapper;
import com.learnng.HospitalManagement.insurance.service.InsuranceService;
import com.learnng.HospitalManagement.util.Entity.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/insurance")
@RequiredArgsConstructor
public class InsuranceController {

    private final InsuranceService insuranceService;
    private final InsuranceMapper insuranceMapper;

    @PostMapping
    public ResponseEntity<ApiResponse> createInsurance(
            @Valid @RequestBody InsuranceDto insuranceDto
            ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.CREATED.value())
                                .message("Insurance created successfully")
                                .data(
                                        insuranceMapper
                                                .toInsuranceDto(
                                                        insuranceService
                                                                .createInsurance(
                                                                        insuranceDto
                                                                )
                                                )
                                )
                                .build()
                );
    }

}

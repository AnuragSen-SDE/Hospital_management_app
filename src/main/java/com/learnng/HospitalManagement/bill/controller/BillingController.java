package com.learnng.HospitalManagement.bill.controller;

import com.learnng.HospitalManagement.bill.entiy.Billing;
import com.learnng.HospitalManagement.bill.entiy.dto.BillingDto;
import com.learnng.HospitalManagement.bill.mapper.BillingMapper;
import com.learnng.HospitalManagement.bill.service.BillingService;
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
@RequiredArgsConstructor
@RequestMapping("api/v1/billing")
public class BillingController {

    private final BillingService billingService;
    private final BillingMapper billingMapper;

    @PostMapping
    public ResponseEntity<ApiResponse> generateBill(
            @Valid @RequestBody BillingDto billingDto
            ) {
        Billing billing = billingService.generateBillingDetails(billingDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.CREATED.value())
                                .message("Bill generated Successfully")
                                .data(billingMapper.toDto(billing))
                                .build()
                );
    }
}

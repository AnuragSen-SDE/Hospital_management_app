package com.learnng.HospitalManagement.payment.controller;

import com.learnng.HospitalManagement.payment.entity.Payment;
import com.learnng.HospitalManagement.payment.entity.dto.PaymentDto;
import com.learnng.HospitalManagement.payment.mapper.PaymentMapper;
import com.learnng.HospitalManagement.payment.service.PaymentService;
import com.learnng.HospitalManagement.util.Entity.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    @PostMapping
    public ResponseEntity<ApiResponse> processPayment(
            @Valid @RequestBody PaymentDto paymentDto
            ) {
        Payment payment = paymentService.processPayment(paymentDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.builder()
                                .status(HttpStatus.CREATED.value())
                                .message("Payment Processed Successfully")
                                .data(paymentMapper.toDto(payment))
                                .build()
                );
    }
}

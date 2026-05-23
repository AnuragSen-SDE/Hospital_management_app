package com.learnng.HospitalManagement.payment.entity.dto;

import com.learnng.HospitalManagement.bill.entiy.Billing;
import com.learnng.HospitalManagement.payment.entity.type.PaymentMethod;
import com.learnng.HospitalManagement.payment.entity.type.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {

    private Long id;

    @NotNull( message = "billing Id is required")
    private Long billingId;

    @NotNull( message = "Payment method is required")
    private PaymentMethod paymentMethod;

    private PaymentStatus paymentStatus;

    private String transactionId;

    private LocalDateTime paidAt;

    private Double amount;


}

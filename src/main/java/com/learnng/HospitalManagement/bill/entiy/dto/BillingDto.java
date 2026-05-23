package com.learnng.HospitalManagement.bill.entiy.dto;

import com.learnng.HospitalManagement.payment.entity.type.PaymentStatus;
import com.learnng.HospitalManagement.payment.entity.type.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class BillingDto {

    private Long id;

    @NonNull
    private Long patientId;

    @NotNull
    private Long doctorId;

    @NotNull
    private Long appointmentId;

    @NotNull
    private Long prescriptionId;

    private double totalAmount;

    private Set<BillingItemDto> billingItems;

    private PaymentStatus paymentStatus;

    private PaymentMethod paymentMethod;

    private LocalDateTime paidAt;

    private String Note;
}

package com.learnng.HospitalManagement.bill.entiy.dto;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.bill.entiy.BillingItem;
import com.learnng.HospitalManagement.bill.entiy.type.BillingStatus;
import com.learnng.HospitalManagement.bill.entiy.type.PaymentMethod;
import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.patient.entity.Patient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.LuhnCheck;

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

    private Set<BillingItem> billingItems;

    private BillingStatus billingStatus;

    private PaymentMethod paymentMethod;

    private LocalDateTime paidAt;

    private String Note;
}

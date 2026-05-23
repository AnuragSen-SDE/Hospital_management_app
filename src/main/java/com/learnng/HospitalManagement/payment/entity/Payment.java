package com.learnng.HospitalManagement.payment.entity;

import com.learnng.HospitalManagement.bill.entiy.Billing;
import com.learnng.HospitalManagement.payment.entity.type.PaymentMethod;
import com.learnng.HospitalManagement.payment.entity.type.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "payment")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(nullable = false)
    private String transactionId;

    private LocalDateTime paidAt;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Billing billing;

    @Column(nullable = false)
    private Double amount;
}

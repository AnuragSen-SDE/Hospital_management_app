package com.learnng.HospitalManagement.bill.entiy;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.payment.entity.Payment;
import com.learnng.HospitalManagement.payment.entity.type.PaymentStatus;
import com.learnng.HospitalManagement.payment.entity.type.PaymentMethod;
import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.patient.entity.Patient;
import com.learnng.HospitalManagement.prescription.entity.Prescription;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;

    @OneToOne
    @JoinColumn(nullable = false,updatable = true)
    private Appointment appointment;

    @OneToOne
    @JoinColumn(nullable = false,unique = true)
    private Prescription prescription;

    @Column(nullable = false)
    private double totalAmount;

    @OneToMany(
            cascade = {CascadeType.REMOVE,CascadeType.MERGE,CascadeType.PERSIST},
            mappedBy = "billing",
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<BillingItem> billingItems = new ArrayList<>();

    private LocalDateTime paidAt;

    private String Note;

    @OneToMany(
            cascade = {CascadeType.REMOVE,CascadeType.MERGE,CascadeType.PERSIST},
            mappedBy = "billing",
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Set<Payment> payments = new HashSet<>();


}

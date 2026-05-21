package com.learnng.HospitalManagement.prescription.entity;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.patient.entity.Patient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.TimeZoneColumn;
import org.springframework.data.domain.Page;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NotNull
    private Patient patient;

    @OneToOne
    @JoinColumn(nullable = false)
    private Appointment appointment;

    @NotNull
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "prescription"
    )
    private List<PrescriptionMedicine> prescribedMedicine;

    private String note;

    private LocalDateTime prescribedAt;

}

package com.learnng.HospitalManagement.prescription.entity;

import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.patient.entity.Patient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;

import javax.print.Doc;

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
    private Patient patient;
}

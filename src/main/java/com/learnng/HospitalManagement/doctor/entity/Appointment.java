package com.learnng.HospitalManagement.doctor.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate appointmentDate;
    private LocalDate appointmentTime;
    private String status;
    private List<String> symptoms;
    private String note;
    private LocalDate createdAt;

}

/*
id
appointmentDate
appointmentTime
status
symptoms
notes
createdAt
 */

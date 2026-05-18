package com.learnng.HospitalManagement.appointment.entity.dto;

import com.learnng.HospitalManagement.appointment.entity.AppointmentStatus;
import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.patient.entity.Patient;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
public class AppointmentDto {

    private Long id;

    @NotNull
    @FutureOrPresent(message = "Appointment date cannot be in the past")
    private LocalDate appointmentDate;

    @NotNull
    @FutureOrPresent(message = "Appointment Time can't be in the past")
    private LocalDateTime appointmentTime;

    @NotNull
    private AppointmentStatus status;

    @NotNull(message = "Symptoms cannot be empty")
    private List<String> symptoms;

    @Size(max = 500)
    private String note;

    @NotNull
    @FutureOrPresent(message = "Appointment cannot be created in the past")
    private LocalDateTime createdAt;

    @NotNull
    private Long doctorId;

    @NotNull
    private Long patientId;
}

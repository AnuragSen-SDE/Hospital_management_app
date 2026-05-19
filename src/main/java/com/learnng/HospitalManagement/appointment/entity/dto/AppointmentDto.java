package com.learnng.HospitalManagement.appointment.entity.dto;

import com.learnng.HospitalManagement.appointment.entity.AppointmentStatus;
import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.doctor.entity.type.AvailableDays;
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
import java.time.LocalTime;
import java.util.List;

@Builder
@Getter
@Setter
public class AppointmentDto {

    private Long id;

    @NotNull
    private AvailableDays appointmentDay;

    @NotNull
    @FutureOrPresent(message = "Appointment Date and time can't be in the past")
    private LocalDateTime appointmentDateAndTime;

    @NotNull(message = "Symptoms cannot be empty")
    private List<String> symptoms;

    @Size(max = 500)
    private String note;


    @NotNull
    private Long doctorId;

    @NotNull
    private Long patientId;
}

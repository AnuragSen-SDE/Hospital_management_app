package com.learnng.HospitalManagement.prescription.entity.dto;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.patient.entity.Patient;
import com.learnng.HospitalManagement.prescription.entity.PrescriptionMedicine;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
public class PrescriptionDto {

    private Long id;

    @NotBlank
    private Long  doctorId;

    @NotBlank
    private Long  patientId;

    @NotBlank
    private Long  appointmentId;

    private List<PrescriptionMedicine> prescribedMedicine;

    @Size(max = 200)
    private String note;
}

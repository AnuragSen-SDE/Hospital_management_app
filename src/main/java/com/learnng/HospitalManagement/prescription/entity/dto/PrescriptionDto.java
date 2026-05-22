package com.learnng.HospitalManagement.prescription.entity.dto;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.medicine.entity.Medicine;
import com.learnng.HospitalManagement.patient.entity.Patient;
import com.learnng.HospitalManagement.prescription.entity.Prescription;
import com.learnng.HospitalManagement.prescription.entity.PrescriptionMedicine;
import jakarta.persistence.*;
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

    @NotNull
    private Long doctorId;


    @NotNull
    private Long patientId;

    @NotNull
    private Long appointmentId;

    private List<PrescriptionMedicineDto> prescribedMedicine;

    private String note;

    private LocalDateTime prescribedAt;
}

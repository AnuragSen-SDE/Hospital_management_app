package com.learnng.HospitalManagement.patient.service;

import com.learnng.HospitalManagement.doctor.entity.type.AvailableDays;
import com.learnng.HospitalManagement.patient.entity.Patient;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface PatientService {
    List<Patient> getAllPatient();
    Patient getPatientByName();
    Patient registerPatient(Patient patient);
    boolean existById(Long id);
    Patient getPatientById(Long id);
    boolean existsByIdAppointmentDayAndAppointmentTime(
            Long id,
            AvailableDays appointmentDay,
            LocalTime appointmentTime
    );

}

package com.learnng.HospitalManagement.patient.repository;

import com.learnng.HospitalManagement.doctor.entity.type.AvailableDays;
import com.learnng.HospitalManagement.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;

public interface PatientRepository  extends JpaRepository<Patient,Long> {
    boolean existsByEmail(String email);
    boolean existById(Long id);
//    boolean existsByIdAndAppointmentDayAndAppointmentTime(
//            Long id,
//            AvailableDays appointmentDay,
//            LocalTime appointmentTime
//    );
}

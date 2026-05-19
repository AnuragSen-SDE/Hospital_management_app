package com.learnng.HospitalManagement.doctor.service;

import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.doctor.entity.type.AvailableDays;

import java.time.LocalDateTime;
import java.time.LocalTime;

public interface DoctorService {
    Doctor registerDoctor(Doctor doctor);
    boolean existsById(Long id);
    Doctor getDoctorById(Long id);
    Boolean findDoctorWithDoctorIdAndAppointmentDayAndAppointmentTime(
            Long id,
            AvailableDays appointmentDay,
            LocalTime appointmentTime
    );

    boolean isDoctorAvailableSpecificDay(AvailableDays day);
}

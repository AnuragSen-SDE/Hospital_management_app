package com.learnng.HospitalManagement.appointment.repository;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.appointment.entity.AppointmentStatus;
import com.learnng.HospitalManagement.doctor.entity.type.AvailableDays;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
//    boolean existsByDoctorIdAppointmentDayAndAppointmentTime (
//            Long id,
//            AvailableDays appointmentDay,
//            LocalTime appointmentTime
//    );
//
//    boolean existsByPatientIdAppointmentDayAndAppointmentTime (
//            Long id,
//            AvailableDays appointmentDay,
//            LocalTime appointmentTime
//    );

    boolean existsByDoctorIdAndAppointmentDateTimeAndStatus(
            Long doctorId,
            LocalDateTime appointmentDateAndTime,
            AppointmentStatus status
    );

    boolean existsByPatientIdAndAppointmentDateTimeAndStatus(
            Long patientId,
            LocalDateTime appointmentDateAndTime,
            AppointmentStatus status
    );
}

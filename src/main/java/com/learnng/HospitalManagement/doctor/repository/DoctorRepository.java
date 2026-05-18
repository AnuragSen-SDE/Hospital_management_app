package com.learnng.HospitalManagement.doctor.repository;

import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.doctor.entity.type.AvailableDays;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByEmail(String email);
    boolean existsByRoomNumber(String roomNumber);
    boolean existsById(Long id);
//    boolean existsByIdAndAvailableDaysAndAppointments(
//            Long id,
//            AvailableDays appointmentDay,
//            LocalTime appointmentTime
//    );
}

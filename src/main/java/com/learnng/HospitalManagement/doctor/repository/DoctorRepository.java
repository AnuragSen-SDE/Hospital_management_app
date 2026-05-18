package com.learnng.HospitalManagement.doctor.repository;

import com.learnng.HospitalManagement.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByEmail(String email);
    boolean existsByRoomNumber(String roomNumber);
}

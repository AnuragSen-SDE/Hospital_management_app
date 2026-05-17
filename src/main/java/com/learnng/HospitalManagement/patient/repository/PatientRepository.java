package com.learnng.HospitalManagement.patient.repository;

import com.learnng.HospitalManagement.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository  extends JpaRepository<Patient,Long> {
    boolean existsByEmail(String email);
}

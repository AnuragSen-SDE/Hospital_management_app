package com.learnng.HospitalManagement.repository;

import com.learnng.HospitalManagement.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository  extends JpaRepository<Patient,Long> {
}

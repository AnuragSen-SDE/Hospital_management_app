package com.learnng.HospitalManagement.repository;

import com.learnng.HospitalManagement.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;

public interface PatientRepository  extends JpaRepository<Patient,Long> {
    Patient findByName(String name);

    @Query("SELECT p.bloodGroup , COUNT(p) FROM Patient p group by p.bloodGroup")
    List<Object[]> countPatientByBloodGroup();

}

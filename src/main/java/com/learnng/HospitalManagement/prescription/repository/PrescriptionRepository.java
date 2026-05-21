package com.learnng.HospitalManagement.prescription.repository;

import com.learnng.HospitalManagement.prescription.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {
    boolean existsByAppointmentId(Long appointmentId);
}

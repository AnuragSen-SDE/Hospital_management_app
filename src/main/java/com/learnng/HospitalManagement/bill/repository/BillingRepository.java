package com.learnng.HospitalManagement.bill.repository;

import com.learnng.HospitalManagement.bill.entiy.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing,Long> {
    boolean existsByPrescriptionId(Long prescriptionId);
}

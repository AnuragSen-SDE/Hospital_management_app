package com.learnng.HospitalManagement.insurance.Repository;

import com.learnng.HospitalManagement.insurance.entiy.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance,Long> {
    boolean existsByPolicyNumberOrPatientId(String policyNumber,Long patientId);

}

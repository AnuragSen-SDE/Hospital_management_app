package com.learnng.HospitalManagement.insurance.service;

import com.learnng.HospitalManagement.insurance.entiy.Insurance;
import com.learnng.HospitalManagement.insurance.entiy.dto.InsuranceDto;

public interface InsuranceService {
    Insurance createInsurance(InsuranceDto insuranceDto);
    boolean checkIfAlreadyExistWithPolicyNumberOrPatientId( String policyNumber,Long patientId);
}

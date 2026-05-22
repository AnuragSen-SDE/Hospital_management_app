package com.learnng.HospitalManagement.insurance.service.Impl;

import com.learnng.HospitalManagement.exception.custom.InsuranceException;
import com.learnng.HospitalManagement.insurance.Repository.InsuranceRepository;
import com.learnng.HospitalManagement.insurance.entiy.Insurance;
import com.learnng.HospitalManagement.insurance.entiy.dto.InsuranceDto;
import com.learnng.HospitalManagement.insurance.mapper.InsuranceMapper;
import com.learnng.HospitalManagement.insurance.service.InsuranceService;
import com.learnng.HospitalManagement.patient.entity.Patient;
import com.learnng.HospitalManagement.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final InsuranceMapper insuranceMapper;
    private final PatientService patientService;

    @Override
    public Insurance createInsurance(InsuranceDto insuranceDto) {
        if (insuranceRepository
                .existsByPolicyNumberOrPatientId(insuranceDto.getPolicyNumber(),insuranceDto.getPatientId()))
            throw new InsuranceException("Insurance Already Exist");

        Insurance insurance = insuranceMapper.toInsuranceEntity(insuranceDto);
        Patient patient = patientService.getPatientById(insuranceDto.getPatientId());
        insurance.setPatient(patient);

        return insuranceRepository.save(insurance);
    }

    @Override
    public boolean checkIfAlreadyExistWithPolicyNumberOrPatientId(String policyNumber, Long patientId) {
        return false;
    }
}

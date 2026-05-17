package com.learnng.HospitalManagement.patient.service.impl;

import com.learnng.HospitalManagement.patient.entity.Patient;
import com.learnng.HospitalManagement.patient.repository.PatientRepository;
import com.learnng.HospitalManagement.patient.service.PatientService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;


    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientByName() {
        return null;
    }

    @Override
    public Patient registerPatient(Patient patient) {
        if (patientRepository.existsByEmail(patient.getEmail())) throw new  IllegalArgumentException("Patient Already Exist with this email");
        return patientRepository.save(patient);
    }
}

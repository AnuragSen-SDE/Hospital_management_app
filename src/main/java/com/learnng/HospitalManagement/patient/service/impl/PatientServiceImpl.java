package com.learnng.HospitalManagement.patient.service.impl;

import com.learnng.HospitalManagement.doctor.entity.type.AvailableDays;
import com.learnng.HospitalManagement.exception.custom.PatientException;
import com.learnng.HospitalManagement.patient.entity.Patient;
import com.learnng.HospitalManagement.patient.repository.PatientRepository;
import com.learnng.HospitalManagement.patient.service.PatientService;
import com.learnng.HospitalManagement.security.entity.CustomeUserDetails;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
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

        CustomeUserDetails userDetails = (CustomeUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (patientRepository.existsByEmail(userDetails.getUsername())) throw new PatientException("Patient Already Exist with this email");
        patient.setEmail(userDetails.getUsername());
        return patientRepository.save(patient);
    }

    @Override
    public boolean existById(Long id) {
        return patientRepository.existsById(id);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(()-> new PatientException("Patient Does not exist"));
    }

    @Override
    public boolean existsByIdAppointmentDayAndAppointmentTime(Long id, AvailableDays appointmentDay, LocalTime appointmentTime) {
        return false;//patientRepository.existsByIdAndAppointmentDayAndAppointmentTime(id,appointmentDay,appointmentTime);
    }
}

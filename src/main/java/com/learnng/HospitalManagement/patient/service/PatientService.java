package com.learnng.HospitalManagement.patient.service;

import com.learnng.HospitalManagement.patient.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatient();
    Patient getPatientByName();
}

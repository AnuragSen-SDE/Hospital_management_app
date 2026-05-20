package com.learnng.HospitalManagement.prescription.service;

import com.learnng.HospitalManagement.prescription.entity.Prescription;
import com.learnng.HospitalManagement.prescription.entity.dto.PrescriptionDto;

public interface PrescriptionService {
    Prescription createPrescription(PrescriptionDto prescriptionDto);
}

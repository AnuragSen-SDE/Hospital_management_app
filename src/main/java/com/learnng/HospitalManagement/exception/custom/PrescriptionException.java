package com.learnng.HospitalManagement.exception.custom;

import com.learnng.HospitalManagement.prescription.entity.Prescription;

public class PrescriptionException extends  RuntimeException{
    public PrescriptionException(String  message) {super(message);}
}

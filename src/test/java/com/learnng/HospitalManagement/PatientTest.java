package com.learnng.HospitalManagement;

import com.learnng.HospitalManagement.patient.entity.Patient;
import com.learnng.HospitalManagement.patient.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void PrintAllPatient(){
        List<Patient> patients = patientRepository.findAll();
        System.out.println(patients);
    }
}

package com.learnng.HospitalManagement;

import com.learnng.HospitalManagement.Entity.Patient;
import com.learnng.HospitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatientRepository(){
        List<Patient> list = patientRepository.findAll();

        for (Patient item : list) System.out.println(item);

    }
}

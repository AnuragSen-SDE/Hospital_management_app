package com.learnng.HospitalManagement;

import com.learnng.HospitalManagement.Entity.Patient;
import com.learnng.HospitalManagement.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatientRepository(){
        List<Patient> list = patientRepository.findAll();

        for (Patient item : list) System.out.println(item);

        System.out.println(patientRepository.findByName("Sarbanando Sonowal"));

        List<Object[]> items = patientRepository.countPatientByBloodGroup();
        items.forEach((item) -> {
            System.out.println(item[0] + " " + item[1]);
        });
        System.out.println(patientRepository.findByName("Sarbanando Sonowal"));

    }
}

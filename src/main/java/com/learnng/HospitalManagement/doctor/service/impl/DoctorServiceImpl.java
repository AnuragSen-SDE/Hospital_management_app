package com.learnng.HospitalManagement.doctor.service.impl;

import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.doctor.repository.DoctorRepository;
import com.learnng.HospitalManagement.doctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor registerDoctor(Doctor doctor) {
        if(doctorRepository.existsByEmail(doctor.getEmail()) || doctorRepository.existsByPhoneNumber(doctor.getEmail()))
            throw new  IllegalArgumentException("Doctor Already Exist With the specified phone number or email");

        if(doctorRepository.existsByRoomNumber(doctor.getRoomNumber()))
            throw new  IllegalArgumentException("Doctor Already Exist With the specified Room number");

        return doctorRepository.save(doctor);
    }

}

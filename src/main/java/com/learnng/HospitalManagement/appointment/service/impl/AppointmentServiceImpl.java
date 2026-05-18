package com.learnng.HospitalManagement.appointment.service.impl;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.appointment.repository.AppointmentRepository;
import com.learnng.HospitalManagement.appointment.service.AppointmentService;
import com.learnng.HospitalManagement.doctor.service.DoctorService;
import com.learnng.HospitalManagement.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;

    @Override
    public Appointment createAppointment(Appointment appointment) {

        return null;
    }
}

package com.learnng.HospitalManagement.appointment.service.impl;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import com.learnng.HospitalManagement.appointment.entity.AppointmentStatus;
import com.learnng.HospitalManagement.appointment.entity.dto.AppointmentDto;
import com.learnng.HospitalManagement.appointment.mapper.AppointmentMapper;
import com.learnng.HospitalManagement.appointment.repository.AppointmentRepository;
import com.learnng.HospitalManagement.appointment.service.AppointmentService;
import com.learnng.HospitalManagement.doctor.entity.Doctor;
import com.learnng.HospitalManagement.doctor.entity.type.AvailableDays;
import com.learnng.HospitalManagement.doctor.service.DoctorService;
import com.learnng.HospitalManagement.exception.custom.AppointmentException;
import com.learnng.HospitalManagement.patient.entity.Patient;
import com.learnng.HospitalManagement.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private static final Log log = LogFactory.getLog(AppointmentServiceImpl.class);
    private final AppointmentRepository appointmentRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final AppointmentMapper appointmentMapper;

    @Transactional
    @Override
    public Appointment createAppointment(AppointmentDto appointmentDto) {

        if( appointmentDto.getAppointmentDateTime().isBefore(LocalDateTime.now())){
            throw new AppointmentException("Appointment time can't be in the past");
        }

        if (!doctorService.isDoctorAvailableSpecificDay(appointmentDto.getAppointmentDay()))
            throw new AppointmentException("Doctor is not available on this day");

        if(appointmentRepository.existsByDoctorIdAndAppointmentDateTimeAndStatus(
                appointmentDto.getDoctorId(),
                appointmentDto.getAppointmentDateTime(),
                AppointmentStatus.SCHEDULED
        ) ){
            throw new AppointmentException("Doctor is not available on this time");
        }

        if(appointmentRepository.existsByPatientIdAndAppointmentDateTimeAndStatus(
                appointmentDto.getPatientId(),
                appointmentDto.getAppointmentDateTime(),
                AppointmentStatus.SCHEDULED
        )){
            throw new AppointmentException(
                    "Patient Already has An appointment on the " +
                            appointmentDto.getAppointmentDay() +
                            " at " +
                            appointmentDto.getAppointmentDateTime()
            );
        }





        //fetch doctor data
        Doctor doctor = doctorService.getDoctorById(appointmentDto.getDoctorId());

        //fetch patient data
        Patient patient = patientService.getPatientById(appointmentDto.getPatientId());




        Appointment appointment = appointmentMapper.toAppointment(appointmentDto);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setStatus(AppointmentStatus.SCHEDULED);
        appointment.setCreatedAt(LocalDateTime.now());

        return appointmentRepository.save(appointment);
    }

    @Override
    public void updateAppointmentStatus(Long appointmentId,AppointmentStatus status) {

        Appointment appointment = appointmentRepository
                .findById(
                        appointmentId
                ).orElseThrow(
                        () -> new AppointmentException("Appointment Not found with id : " + appointmentId)
                );
        if (appointment.getStatus().equals(AppointmentStatus.COMPLETED))
            throw new AppointmentException("Appointment Already Completed Now Can't be updated");

        appointment.setStatus(status);
        appointmentRepository.save(appointment);

    }

}

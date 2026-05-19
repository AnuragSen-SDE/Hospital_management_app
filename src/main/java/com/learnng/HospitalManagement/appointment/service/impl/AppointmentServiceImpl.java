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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final AppointmentMapper appointmentMapper;

    @Transactional
    @Override
    public Appointment createAppointment(AppointmentDto appointmentDto) {

        if( appointmentDto.getAppointmentDateAndTime().isBefore(LocalDateTime.now())){
            throw new AppointmentException("Appointment time can't be in the past");
        }

        if( appointmentRepository.existsByPatientIdAndAppointmentDateTimeAndStatus(
                appointmentDto.getPatientId(),
                appointmentDto.getAppointmentDateAndTime(),
                AppointmentStatus.SCHEDULED
        )){
            throw new AppointmentException(
                    "Patient Already has An appointment on the " +
                            appointmentDto.getAppointmentDay() +
                            " at " +
                            appointmentDto.getAppointmentDateAndTime()
            );
        }

        if( appointmentRepository.existsByDoctorIdAndAppointmentDateTimeAndStatus(
                appointmentDto.getDoctorId(),
                appointmentDto.getAppointmentDateAndTime(),
                AppointmentStatus.SCHEDULED
        )){
            throw new AppointmentException("Doctor is not available on this day");
        }

        if (!doctorService.isDoctorAvailableSpecificDay(appointmentDto.getAppointmentDay())) throw new AppointmentException("Doctor is not available on this day");

        //fetch doctor data
        Doctor doctor = doctorService.getDoctorById(appointmentDto.getDoctorId());
        // need to check whether doctor is available in this day or not
//        if( doctorService.findDoctorWithDoctorIdAndAppointmentDayAndAppointmentTime(
//                appointmentDto.getDoctorId(),
//                appointmentDto.getAppointmentDay(),
//                appointmentDto.getAppointmentTime()
//        )){
//            throw new IllegalArgumentException("Doctor is not available on this day");
//        }

//        if( appointmentRepository.existsByDoctorIdAppointmentDayAndAppointmentTime(
//                appointmentDto.getDoctorId(),
//                appointmentDto.getAppointmentDay(),
//                appointmentDto.getAppointmentTime()
//        )){
//            throw new IllegalArgumentException("Doctor is not available on this day");
//        }



        //fetch patient data
        Patient patient = patientService.getPatientById(appointmentDto.getPatientId());

        //check if the patent has existing appointment on the same day and time
//        if( patientService.existsByIdAppointmentDayAndAppointmentTime(
//                appointmentDto.getPatientId(),
//                appointmentDto.getAppointmentDay(),
//                appointmentDto.getAppointmentTime()
//        )){
//            throw new IllegalArgumentException(
//                    "Patient Already has An appointment on the " +
//                            appointmentDto.getAppointmentDay() +
//                            " at " +
//                            appointmentDto.getAppointmentTime()
//                            );
//        }

//        if( appointmentRepository.existsByPatientIdAppointmentDayAndAppointmentTime(
//                appointmentDto.getPatientId(),
//                appointmentDto.getAppointmentDay(),
//                appointmentDto.getAppointmentTime()
//        )){
//            throw new IllegalArgumentException(
//                    "Patient Already has An appointment on the " +
//                            appointmentDto.getAppointmentDay() +
//                            " at " +
//                            appointmentDto.getAppointmentTime()
//            );
//        }




        Appointment appointment = appointmentMapper.toAppointment(appointmentDto);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setStatus(AppointmentStatus.SCHEDULED);
        appointment.setCreatedAt(LocalDateTime.now());

        return appointmentRepository.save(appointment);
    }

}

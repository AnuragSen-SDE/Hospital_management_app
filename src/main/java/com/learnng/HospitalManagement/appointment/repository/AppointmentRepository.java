package com.learnng.HospitalManagement.appointment.repository;

import com.learnng.HospitalManagement.appointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}

package com.learnng.HospitalManagement.Entity;

import com.learnng.HospitalManagement.Entity.type.BloodGroup;
import jakarta.persistence.*;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate birthDate;
    private String email;
    private String gender;

    @Enumerated(EnumType.STRING)
    private BloodGroup bloodGroup;

    @OneToOne
    @JoinColumn(name = "insurance")
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointment;

}

package com.learnng.HospitalManagement.user.entity;

import com.learnng.HospitalManagement.user.entity.type.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean isActive = false;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

}

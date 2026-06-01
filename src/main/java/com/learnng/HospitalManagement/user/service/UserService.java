package com.learnng.HospitalManagement.user.service;

import com.learnng.HospitalManagement.user.entity.User;

public interface UserService {
    boolean existsByEmail(String  email);
    User saveUser(User user);
}

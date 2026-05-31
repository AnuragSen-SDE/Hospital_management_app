package com.learnng.HospitalManagement.user.service;

import com.learnng.HospitalManagement.user.entity.User;

public interface UserService {
    boolean existByEmail(String  email);
}

package com.learnng.HospitalManagement.auth.service;

import com.learnng.HospitalManagement.auth.entity.LoginRequest;

public interface AuthService {
    void login(LoginRequest request);
}

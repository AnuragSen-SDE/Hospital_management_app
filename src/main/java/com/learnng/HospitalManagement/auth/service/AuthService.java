package com.learnng.HospitalManagement.auth.service;

import com.learnng.HospitalManagement.auth.entity.LoginRequestdto;

public interface AuthService {
    void login(LoginRequestdto request);
}

package com.learnng.HospitalManagement.auth.service;

import com.learnng.HospitalManagement.auth.entity.LoginRequestdto;
import com.learnng.HospitalManagement.auth.entity.SignupRequestDto;
import com.learnng.HospitalManagement.auth.entity.SignupResponseDto;

public interface AuthService {
    void login(LoginRequestdto request);
    SignupResponseDto signUp (SignupRequestDto requestDto );
}

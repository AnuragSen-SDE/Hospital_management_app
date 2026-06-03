package com.learnng.HospitalManagement.auth.service;

import com.learnng.HospitalManagement.auth.entity.LoginRequestdto;
import com.learnng.HospitalManagement.auth.entity.LoginResponseDto;
import com.learnng.HospitalManagement.auth.entity.SignupRequestDto;
import com.learnng.HospitalManagement.auth.entity.SignupResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestdto request);
    SignupResponseDto signUp (SignupRequestDto requestDto );
    String getUserName(String token );
}

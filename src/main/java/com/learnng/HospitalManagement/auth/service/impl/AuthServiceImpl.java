package com.learnng.HospitalManagement.auth.service.impl;

import com.learnng.HospitalManagement.auth.entity.LoginRequestdto;
import com.learnng.HospitalManagement.auth.entity.SignupRequestDto;
import com.learnng.HospitalManagement.auth.entity.SignupResponseDto;
import com.learnng.HospitalManagement.auth.service.AuthService;
import com.learnng.HospitalManagement.exception.custom.UserException;
import com.learnng.HospitalManagement.security.entity.CustomeUserDetails;
import com.learnng.HospitalManagement.user.entity.User;
import com.learnng.HospitalManagement.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @Override
    public void login(LoginRequestdto request) {


        try {
            System.out.println("request at service");
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
            ));

            CustomeUserDetails userDetails = (CustomeUserDetails) authentication.getPrincipal();
            System.out.println("Login User Detalis "+userDetails);
        }
        catch(Exception ex) {
            System.out.println("exception caught at service");
            ex.printStackTrace();
            throw new UserException("Invalid Credentials");
        }
    }

    @Override
    public SignupResponseDto sigUp(SignupRequestDto requestDto) {
        if (userService.existByEmail(requestDto.getEmail())) throw new UserException("User Already Exist With this email ");

//        User user = User.builder()
//                .email(requestDto.getEmail())
//                .
//                .build();
        return null;
    }
}

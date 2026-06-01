package com.learnng.HospitalManagement.user.service.impl;

import com.learnng.HospitalManagement.exception.custom.UserException;
import com.learnng.HospitalManagement.user.entity.User;
import com.learnng.HospitalManagement.user.repository.UserRepository;
import com.learnng.HospitalManagement.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public boolean existByEmail(String email) {
       return userRepository.existByEmail(email);
    }
}

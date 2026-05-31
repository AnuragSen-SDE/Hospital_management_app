package com.learnng.HospitalManagement.security.service;

import com.learnng.HospitalManagement.exception.custom.UserException;
import com.learnng.HospitalManagement.security.entity.CustomeUserDetails;
import com.learnng.HospitalManagement.user.entity.User;
import com.learnng.HospitalManagement.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService  implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("request at CustomUserDetailsService ");
        User user = userRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("Invalid Credentials")
        );
        return new CustomeUserDetails(user);
    }

}

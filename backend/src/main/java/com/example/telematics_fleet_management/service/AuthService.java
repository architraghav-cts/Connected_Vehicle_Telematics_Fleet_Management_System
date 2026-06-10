package com.example.telematics_fleet_management.service;

import com.example.telematics_fleet_management.model.User;
import com.example.telematics_fleet_management.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserRepository userRepository;

    AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User validateUser(String email, String password){
        User user = userRepository.findByEmail(email);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }

        return null;
    }
}
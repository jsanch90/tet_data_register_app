package com.data.register.api.data_register_rest_api.security.services;

import com.data.register.api.data_register_rest_api.models.User;
import com.data.register.api.data_register_rest_api.models.repositories.UserRepository;
import com.data.register.api.data_register_rest_api.utils.ResourceNotFoundException;
import com.data.register.api.data_register_rest_api.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    JWTServices jwtServices;

    public ServerResponse<String> createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (!userRepository.existsById(user.getUsername())) {
            userRepository.save(user);
            return new ServerResponse<>("User created", true);
        }
        return new ServerResponse<>("User already exist", false);
    }

    public ServerResponse<String> userLogin(User user) throws ResourceNotFoundException {
        if (userRepository.existsById(user.getUsername())) {
            if (bCryptPasswordEncoder.matches(user.getPassword(), userRepository
                    .findById(user.getUsername())
                    .orElseThrow(() -> new ResourceNotFoundException("Invalid username"))
                    .getPassword())) {
                return new ServerResponse<>(jwtServices.getJWTToken(user.getUsername()), true);
            }
            return new ServerResponse<>("Invalid Password", false);
        }
        return new ServerResponse<>("User does not exist", false);
    }
}

package com.data.register.api.data_register_rest_api.controllers;

import com.data.register.api.data_register_rest_api.models.User;
import com.data.register.api.data_register_rest_api.models.repositories.UserRepository;
import com.data.register.api.data_register_rest_api.security.services.UserServices;
import com.data.register.api.data_register_rest_api.utils.ResourceNotFoundException;
import com.data.register.api.data_register_rest_api.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    @ResponseBody
    public ServerResponse<String> addNewUser(@RequestBody User user) {
        return userServices.createUser(user);
    }

    @GetMapping(path = "/all")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping(path = "/login")
    @ResponseBody
    public ServerResponse<String> login(@RequestBody User user) throws ResourceNotFoundException {
        return userServices.userLogin(user);
    }


}

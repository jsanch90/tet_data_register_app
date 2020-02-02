package com.data.register.api.data_register_rest_api.controllers;

import com.data.register.api.data_register_rest_api.models.User;
import com.data.register.api.data_register_rest_api.models.repositories.UserRepository;
import com.data.register.api.data_register_rest_api.security.services.UserServices;
import com.data.register.api.data_register_rest_api.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController// This means that this class is a Controller
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    UserServices userServices;

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    @ResponseBody
    public ServerResponse<String> addNewUser(@RequestBody User user) {
        return userServices.createUser(user);
    }

    @GetMapping(path = "/all")
    public Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @PostMapping(path = "/login")
    @ResponseBody
    public ServerResponse<String> login(@RequestBody User user) {
        return userServices.userLogin(user);
    }


}

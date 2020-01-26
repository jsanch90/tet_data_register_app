package com.data.register.api.data_register_rest_api.controllers;

import com.data.register.api.data_register_rest_api.models.Register;
import com.data.register.api.data_register_rest_api.models.User;
import com.data.register.api.data_register_rest_api.models.repositories.RegisterRepository;
import com.data.register.api.data_register_rest_api.models.repositories.UserRepository;
import com.data.register.api.data_register_rest_api.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "register")
public class RegisterController {

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user_registers")
    public List<Register> getCoursesByInstructor(@RequestParam(value = "userId") String userId) throws ResourceNotFoundException {
        User u = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid username"));
        return registerRepository.findByUser(u);
    }

    @GetMapping(path = "/all")
    public Iterable<Register> getAllRegisters() {
        return registerRepository.findAll();
    }

    @PostMapping("/add")
    public Register createRegister(@RequestParam(name = "userId") String userId,
                                   @Valid @RequestBody Register register) throws ResourceNotFoundException {
        return userRepository.findById(userId).map(user -> {
            register.setUser(user);
            return registerRepository.save(register);
        }).orElseThrow(() -> new ResourceNotFoundException("Register could not be created"));

    }
}

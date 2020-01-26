package com.data.register.api.data_register_rest_api.controllers;

import com.data.register.api.data_register_rest_api.models.Register;
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

    @GetMapping("/{userId}")
    public List<Register> getCoursesByInstructor(@PathVariable(value = "userId") String userId) {
        return registerRepository.findByUser(userId);
    }

   /* @PostMapping(path = "/add")
    public void saveRegister(@RequestBody Register register) {
        registerRepository.save(register);
    }*/

    @GetMapping(path = "/all")
    public Iterable<Register> getAllRegisters() {
        return registerRepository.findAll();
    }

    @PostMapping("/add/{userId}/")
    public Register createCourse(@PathVariable(value = "userId") String userId,
                                 @Valid @RequestBody Register register) throws ResourceNotFoundException {
        return userRepository.findById(userId).map(user -> {
            register.setUser(user);
            return registerRepository.save(register);
        }).orElseThrow(() -> new ResourceNotFoundException("instructor not found"));

    }

   /* @GetMapping(path = "/user_registers")
    public Iterable<Register> getUserRegisters() {

    }*/

}

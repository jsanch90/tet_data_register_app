package com.data.register.api.data_register_rest_api.models.repositories;

import com.data.register.api.data_register_rest_api.models.Register;
import com.data.register.api.data_register_rest_api.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegisterRepository extends CrudRepository<Register, Integer> {
    List<Register> findByUser(User u);
}

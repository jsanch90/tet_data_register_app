package com.data.register.api.data_register_rest_api.models.repositories;

import com.data.register.api.data_register_rest_api.models.Register;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RegisterRepository extends CrudRepository<Register, Integer> {
    List<Register> findByUser(String userId);

    //Optional<Register> findByIdAndUserId(Integer id, String userId);
}

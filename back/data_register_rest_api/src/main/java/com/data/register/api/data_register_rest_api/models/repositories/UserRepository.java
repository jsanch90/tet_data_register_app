package com.data.register.api.data_register_rest_api.models.repositories;

import com.data.register.api.data_register_rest_api.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}

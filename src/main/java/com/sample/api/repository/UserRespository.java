package com.sample.api.repository;

import com.sample.api.dto.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRespository extends CrudRepository<User, Long> {
}

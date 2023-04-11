package com.spring.swagger.repository;

import com.spring.swagger.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}

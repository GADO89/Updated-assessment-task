package com.spring.swagger.springsecurity.dao;

import java.util.List;

import com.spring.swagger.springsecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubscriberRepo extends JpaRepository<Users,Long> {

    List<Users> findByEmail(String email);
}

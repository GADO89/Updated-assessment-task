package com.spring.swagger.springsecurity.service;

import com.spring.swagger.springsecurity.dao.SubscriberRepo;
import com.spring.swagger.springsecurity.model.Users;
import com.spring.swagger.springsecurity.model.SubscriberSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private SubscriberRepo subscriberRepo;

    @Autowired
    public CustomUserDetailsService(SubscriberRepo subscriberRepo) {
        this.subscriberRepo = subscriberRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Users> users = subscriberRepo.findByEmail(username);
        if(users.isEmpty()){
            throw  new UsernameNotFoundException("User Email not exist " + username);
        }
        return new SubscriberSecurity(users.get(0));
    }
}

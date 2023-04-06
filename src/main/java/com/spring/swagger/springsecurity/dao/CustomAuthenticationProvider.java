package com.spring.swagger.springsecurity.dao;

import com.spring.swagger.springsecurity.model.Admin;
import com.spring.swagger.springsecurity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private SubscriberRepo subscriberRepo;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public CustomAuthenticationProvider(SubscriberRepo subscriberRepo, PasswordEncoder passwordEncoder) {
        this.subscriberRepo = subscriberRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName(); // true
        String password = authentication.getCredentials().toString();
        List<Users> users = subscriberRepo.findByEmail(userName);
        System.out.println(users.size());
        if(users.isEmpty()){
            throw new BadCredentialsException("Invalid User you must be register");
        } else {
            if (passwordEncoder.matches(password, users.get(0).getPassword())){
                //List<GrantedAuthority> authorityList = new ArrayList<>();
               // authorityList.add(new SimpleGrantedAuthority(subscribers.get(0).getRole()));
                return new UsernamePasswordAuthenticationToken(userName,password,getAuthority(users.get(0).getAuthorities()));
            } else {
                throw new BadCredentialsException("Invalid Password");
            }
        }
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Admin> adminList){
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (Admin admin : adminList){ //
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(admin.getName()));
        }
        return simpleGrantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

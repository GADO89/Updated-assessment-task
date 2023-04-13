package com.spring.swagger.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //Logic to get the user form the Database

        return new User("admin","admin123",new ArrayList<>());
    }

    public com.spring.swagger.entity.User save(com.spring.swagger.entity.User user) {
        return null;
    }

    public List<com.spring.swagger.entity.User> getAllProduct() {
        return null;
    }

    public void saveProductToDB(MultipartFile file, String name, String desc, int price) {
    }

    public void deleteProductById(Long id) {
    }

    public void chageProductName(Long id, String name) {
    }

    public void changeProductDescription(Long id, String description) {
    }
}

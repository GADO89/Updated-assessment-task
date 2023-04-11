package com.spring.swagger.service;


import com.spring.swagger.entity.User;
import com.spring.swagger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserUploadService {

    @Autowired
    private UserRepository repo;

    public User save(User user){
        return repo.save(user);
    }

    public List<User> getAllProduct() {
        return null;
    }

    public List<User> findAll() {
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

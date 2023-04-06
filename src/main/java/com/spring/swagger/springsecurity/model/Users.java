package com.spring.swagger.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email; //  username

    private String password; // password

    @JsonIgnore
    @OneToMany(mappedBy = "users",fetch = FetchType.EAGER)
    private List<Admin> authorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Admin> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Admin> authorities) {
        this.authorities = authorities;
    }
}

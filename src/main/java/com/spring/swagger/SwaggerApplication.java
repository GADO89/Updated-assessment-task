package com.spring.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
//@ComponentScan("com.spring.swagger")
//@EntityScan(basePackages = "com.spring.swagger")
public class SwaggerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

/////////////////////////////////////////////////////////////////////////////////////////
}

package com.sample;

import com.sample.user.service.UserDetailsService;
import com.sample.user.service.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityJwtApplication.class, args);
    }

    @Autowired
    UserRolesService userRolesService;

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public CommandLineRunner initQuery(ApplicationContext applicationContext) {
        return args -> {
            userRolesService.saveAllRoles();
            userDetailsService.createDummyUser();
        };
    }

}

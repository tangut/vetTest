package com;

import com.domain.Role;
import com.domain.User;
import com.repos.UserRepo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // добавление администратора при инициализации
    @Bean
    ApplicationRunner init(UserRepo repo){
        return args -> {
            User admin = new User();
            admin.setActive(true);
            admin.setUsername("admin");
            admin.setPassword("a");
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(Role.ADMIN);
            roleSet.add(Role.USER);
            admin.setRoles(roleSet);
            repo.save(admin);
        };
    }
}


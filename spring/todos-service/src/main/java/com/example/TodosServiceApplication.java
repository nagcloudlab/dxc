package com.example;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class TodosServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodosServiceApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner initDb(UserRepository userRepository) {
//        return args -> {
//            User user = new User();
//            user.setUsername("jerry");
//            user.setPassword("123456");
//            user.setName("Jerry");
//            userRepository.save(user);
//        };
//    }

}

package com.example;

import com.example.service.GreetingService;
import com.example.service.TransferService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
// -or-
@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class Application  {

    public static void main(String[] args) {
        // init / boot phase
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(Application.class, args);


    }
}

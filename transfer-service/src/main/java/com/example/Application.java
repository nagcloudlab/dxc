package com.example;

import com.config.DxcAuoConfiguration;
import com.example.service.GreetingService;
import com.example.service.TransferService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
// -or-
@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class Application {
    public static void main(String[] args) {

        // init / boot phase
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(Application.class,args);
        System.out.println("-".repeat(100));


        GreetingService greetingService = applicationContext.getBean(GreetingService.class);
        System.out.println(
                greetingService.getGreetMessage()
        );
        System.out.println("-".repeat(100));

    }
}

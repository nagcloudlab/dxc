package com.example;

import com.example.service.TransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages = {"com.example"})
@EnableTransactionManagement
public class Application {
    public static void main(String[] args) {

        // init / boot phase
        ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Application.class);


        System.out.println("-".repeat(100));
        // use
        TransferService transferService = applicationContext.getBean("transferService", TransferService.class);
        transferService.transfer(100, "1", "2");


        System.out.println("-".repeat(100));
        // destroy

    }
}

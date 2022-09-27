package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Value("${dxc.greet.message:hello}")
    private String message;

    public String getGreetMessage(){
        return message;
    }

}

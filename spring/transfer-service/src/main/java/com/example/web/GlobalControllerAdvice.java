package com.example.web;

import com.example.exception.AccountNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler({
            AccountNotFoundException.class,
    })
    public String handleException(Throwable t){
        return "redirect:error.html";
    }


}

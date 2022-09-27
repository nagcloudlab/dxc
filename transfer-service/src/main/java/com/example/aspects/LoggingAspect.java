package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class LoggingAspect {

    Logger LOGGER = LoggerFactory.getLogger("ts");

//    @Before(value = "execution(void trans*(..))")
//    public void doLogBefore(JoinPoint joinPoint) {
//        LOGGER.info("before:" + joinPoint.toString());
//    }
//
//    @AfterReturning(value = "execution(void trans*(..))", returning = "r")
//    public void doLogAfterReturning(JoinPoint joinPoint, Object r) {
//        LOGGER.info("AfterReturning:" + joinPoint.toString());
//    }
//
//    @AfterThrowing(value = "execution(void trans*(..))", throwing = "e")
//    public void doLogAfterReturning(JoinPoint joinPoint, Throwable e) {
//        LOGGER.info("AfterThrowing:" + joinPoint.toString());
//    }
//
//    @After(value = "execution(void trans*(..))")
//    public void doLogAfter(JoinPoint joinPoint) {
//        LOGGER.info("After:" + joinPoint.toString());
//    }
//

    @Around(value = "execution(void trans*(..))")
    public void doLogAfter(ProceedingJoinPoint joinPoint) {
        try {
            LOGGER.info("Before:" + joinPoint.toString());
            joinPoint.proceed();
            LOGGER.info("AfterReturning:" + joinPoint.toString());
        } catch (Throwable e) {
            LOGGER.info("AfterThrowing:" + joinPoint.toString());
        } finally {
            LOGGER.info("After:" + joinPoint.toString());
        }
    }
//


}

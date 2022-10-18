package com.example.repository;

import com.example.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//@Component
@Repository
@Qualifier("jpa")
public class JpaAccountRepository implements AccountRepository{

    Logger LOGGER = LoggerFactory.getLogger("ts");


    @PersistenceContext
    EntityManager entityManager;

    public JpaAccountRepository(){
        LOGGER.info("JpaAccountRepository component instantiated");
    }

    public Account loadAccount(String number) {
        LOGGER.info("Loading account - "+number);
        return entityManager.find(Account.class,number);
    }

    public void updateAccount(Account account) {
        entityManager.merge(account);
        LOGGER.info("Updating account - "+account.getNumber());
    }

}

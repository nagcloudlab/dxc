package com.example.repository;

import com.example.model.Account;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//@Component
@Repository
@Qualifier("jpa")
public class JpaAccountRepository implements AccountRepository{

    private static final Logger LOGGER = Logger.getLogger("ts");

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

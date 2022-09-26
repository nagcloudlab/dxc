package com.example.repository;

import com.example.model.Account;
import org.apache.log4j.Logger;

public class JpaAccountRepository implements AccountRepository{

    private static final Logger LOGGER = Logger.getLogger("ts");

    public JpaAccountRepository(){
        LOGGER.info("JpaAccountRepository component instantiated");
    }

    public Account loadAccount(String number) {
        LOGGER.info("Loading account - "+number);
        return new Account(number, 100.00);
    }

    public void updateAccount(Account account) {
        LOGGER.info("Updating account - "+account.getNumber());
    }

}

package com.example.service;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Component(value = "transferService")
@Service(value = "transferService")
public class UPITransferService implements TransferService {

    private static final Logger LOGGER = Logger.getLogger("ts");
    private AccountRepository accountRepository;

    public UPITransferService(/*@Qualifier("jdbc")*/ AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        LOGGER.info("UPITransferService component instantiated");
    }

    @Transactional
    @Override
    public void transfer(double amount, String source, String destination) {
        LOGGER.info("Transfer initiated");

        Account sourceAccount = accountRepository.loadAccount(source);
        Account destinationAccount = accountRepository.loadAccount(destination);

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);

        accountRepository.updateAccount(sourceAccount);
        if (1 == 2)
            throw new IllegalStateException("oops");
        accountRepository.updateAccount(destinationAccount);
        LOGGER.info("transfer completed");
    }

}

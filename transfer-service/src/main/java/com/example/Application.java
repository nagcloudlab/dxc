package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.repository.JpaAccountRepository;
import com.example.service.TransferService;
import com.example.service.UPITransferService;

public class Application {
    public static void main(String[] args) {

        // init / boot phase
        AccountRepository jdbcAccountRepository = new JdbcAccountRepository();
        AccountRepository jpaAccountRepository = new JpaAccountRepository();
        TransferService transferService = new UPITransferService(jpaAccountRepository);


        System.out.println("-".repeat(100));
        // use
        transferService.transfer(300.00, "1", "2");
        System.out.println("-".repeat(1));
        transferService.transfer(300.00, "1", "2");


        System.out.println("-".repeat(100));
        // destroy

    }
}

package com.example.repository;

import com.example.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//@Component
@Qualifier("jdbc")
public class JdbcAccountRepository implements AccountRepository {

    Logger LOGGER = LoggerFactory.getLogger("ts");

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        LOGGER.info("JdbcAccountRepository component instantiated");
    }

    public Account loadAccount(String number) {
        LOGGER.info("Loading account - " + number);
        String sql = "select * from accounts where number=?";
        return jdbcTemplate.queryForObject(sql, (rs, rowIdx) -> {
            return new Account(rs.getString("number"), rs.getDouble("balance"));
        }, number);
    }

    public void updateAccount(Account account) {
        LOGGER.info("Updating account - " + account.getNumber());
        String sql = "update accounts set balance=? where number=?";
        jdbcTemplate.update(sql, account.getBalance(), account.getNumber());
    }

}

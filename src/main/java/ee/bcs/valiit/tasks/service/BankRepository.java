package ee.bcs.valiit.tasks.service;

import ee.bcs.valiit.tasks.Bank2Customers;
import ee.bcs.valiit.tasks.controller.Bank2;
import ee.bcs.valiit.tasks.controller.Bank2Transfer;
import ee.bcs.valiit.tasks.controller.UpdateBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void addAcc(Bank2 bank2) {
        String sql = "INSERT INTO bank2 (account_nr, balance) VALUES (:account_nrParameter, :balanceParameter)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", bank2.getAccountNr());
        paramMap.put("balanceParameter", bank2.getBalance());
        jdbcTemplate.update(sql, paramMap);
    }

    public void newCustomer(Bank2Customers bank2Customers) {
        String sql = "INSERT INTO bank2customers (id_card_nr, name, family_name) " +
                "VALUES (:id_card_nrParameter, :nameParameter, :family_nameParameter)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id_card_nrParameter", bank2Customers.getIdCardNr());
        paramMap.put("nameParameter", bank2Customers.getName());
        paramMap.put("family_nameParameter", bank2Customers.getFamilyName());
        jdbcTemplate.update(sql, paramMap);

    }

    public Integer getBalance(Bank2 bank2){
        String sql = "SELECT balance FROM bank2 WHERE account_nr = :account_nrParameter";
        Map<String, Object> paramMapGet = new HashMap<>();
        paramMapGet.put("account_nrParameter", bank2.getAccountNr());
        return jdbcTemplate.queryForObject(sql, paramMapGet, Integer.class);

    }

    public void updateBalance(Bank2 bank2) {
        String sql1 = "UPDATE bank2 SET balance = :balanceParameter WHERE account_nr = :account_nrParameter";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", bank2.getAccountNr());
        jdbcTemplate.update(sql1, paramMap);

    }

    public void addTransactionHistory(Bank2 bank2) {
        String sql11 = "INSERT INTO bank2transactions (account_nr, date_time, deposit) VALUES(:account_nrParameter, " +
                ":date_timeParameter, :depositParameter)";
        Map<String, Object> paramMap11 = new HashMap<>();
        paramMap11.put("account_nrParameter", bank2.getAccountNr());
        paramMap11.put("date_timeParameter", LocalDateTime.now().toString());
        jdbcTemplate.update(sql11, paramMap11);

    }


    public void withdraw(Bank2 bank2) {

        String sql = "SELECT balance FROM bank2 WHERE account_nr = :account_nrParameter";
        Map<String, Object> paramMapGet = new HashMap<>();
        paramMapGet.put("account_nrParameter", bank2.getAccountNr());
        int currentBalance = jdbcTemplate.queryForObject(sql, paramMapGet, Integer.class);

        String sql1 = "UPDATE bank2 SET balance = :balanceParameter WHERE account_nr = :account_nrParameter";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", bank2.getAccountNr());
        jdbcTemplate.update(sql1, paramMap);

        String sql11 = "INSERT INTO bank2transactions (account_nr, date_time, withdraw) VALUES(:account_nrParameter, " +
                ":date_timeParameter, :withdrawParameter)";
        Map<String, Object> paramMap11 = new HashMap<>();
        paramMap11.put("account_nrParameter", bank2.getAccountNr());
        paramMap11.put("date_timeParameter", LocalDateTime.now().toString());

        jdbcTemplate.update(sql11, paramMap11);

    }

    public void transfer(Bank2Transfer bank2Transfer){
        String sql = "SELECT balance FROM bank2 WHERE account_nr = :fromAccountNrParameter";
        Map<String, Object> paramMapGet = new HashMap<>();
        paramMapGet.put("fromAccountNrParameter", bank2Transfer.getFromAccountNr());
        int currentBalance = jdbcTemplate.queryForObject(sql, paramMapGet, Integer.class);

        String sql1 = "UPDATE bank2 SET balance = :fromAccountBalanceParameter WHERE account_nr = :fromAccountNrParameter";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("fromAccountNrParameter", bank2Transfer.getFromAccountNr());
        paramMap.put("fromAccountBalanceParameter", currentBalance - bank2Transfer.getTransferAmount());
        jdbcTemplate.update(sql1, paramMap);

        String sql2 = "SELECT balance FROM bank2 WHERE account_nr = :toAccountNrParameter";
        Map<String, Object> paramMapGet2 = new HashMap<>();
        paramMapGet2.put("toAccountNrParameter", bank2Transfer.getToAccountNr());
        int currentBalance2 = jdbcTemplate.queryForObject(sql2, paramMapGet2, Integer.class);

        String sql3 = "UPDATE bank2 SET balance = :toAccountBalanceParameter WHERE account_nr = :toAccountNrParameter";
        Map<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("toAccountNrParameter", bank2Transfer.getToAccountNr());
        paramMap2.put("toAccountBalanceParameter", currentBalance2 + bank2Transfer.getTransferAmount());
        jdbcTemplate.update(sql3, paramMap2);

        String sql11 = "INSERT INTO bank2transactions (account_nr, date_time, transfer, to_account) " +
                " VALUES (:account_nrParameter, :date_timeParameter, :transferParameter, :to_accountParameter)";
        Map<String, Object> paramMap11 = new HashMap<>();
        paramMap11.put("account_nrParameter", bank2Transfer.getFromAccountNr());
        paramMap11.put("date_timeParameter", LocalDateTime.now().toString());
        paramMap11.put("transferParameter", bank2Transfer.getTransferAmount());
        paramMap11.put("to_accountParameter", bank2Transfer.getToAccountNr());
        jdbcTemplate.update(sql11, paramMap11);


    }


}

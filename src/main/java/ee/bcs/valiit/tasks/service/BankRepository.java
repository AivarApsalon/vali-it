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

    public Integer getBalance(String accountNr) {
        String sql = "SELECT balance FROM bank2 WHERE account_nr = :account_nrParameter";
        Map<String, Object> paramMapGet = new HashMap<>();
        paramMapGet.put("account_nrParameter", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMapGet, Integer.class);

    }

    public void updateBalance(String accountNr, int newBalance) {
        String sql1 = "UPDATE bank2 SET balance = :balanceParameter WHERE account_nr = :account_nrParameter";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", accountNr);
        paramMap.put("balanceParameter", newBalance);
        jdbcTemplate.update(sql1, paramMap);

    }

    public void addTransactionHistory(String accountNr, int amount) {
        String sql11 = "INSERT INTO bank2transactions (account_nr, date_time, deposit_withdraw) VALUES(:account_nrParameter, " +
                ":date_timeParameter, :deposit_withdrawParameter)";
        Map<String, Object> paramMap11 = new HashMap<>();
        paramMap11.put("account_nrParameter", accountNr);
        paramMap11.put("deposit_withdrawParameter", amount);
        paramMap11.put("date_timeParameter", LocalDateTime.now().toString());
        jdbcTemplate.update(sql11, paramMap11);

    }

    public void addTransferTransactionHistory(String fromAccountNr, String toAccountNr, int amount) {
        String sql11 = "INSERT INTO bank2transactions (account_nr, date_time, to_account, transfer) VALUES(:account_nrParameter, " +
                ":date_timeParameter, :to_accountParameter, :transferParameter)";
        Map<String, Object> paramMap11 = new HashMap<>();
        paramMap11.put("account_nrParameter", fromAccountNr);
        paramMap11.put("date_timeParameter", LocalDateTime.now().toString());
        paramMap11.put("transferParameter", amount);
        paramMap11.put("to_accountParameter", toAccountNr);
        jdbcTemplate.update(sql11, paramMap11);

    }


}

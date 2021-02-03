package ee.bcs.valiit.tasks.tasks.service;

import ee.bcs.valiit.tasks.tasks.controller.Bank2;
import ee.bcs.valiit.tasks.tasks.controller.Bank2Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BankRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void addAcc(Bank2 bank2) {
        String sql = "INSERT INTO bank2accounts (account_nr, customer_id, balance) " +
                "VALUES (:account_nrParameter, :customer_idParameter, :balanceParameter)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", bank2.getAccountNr());
        paramMap.put("balanceParameter", 0);
        paramMap.put("customer_idParameter", bank2.getCustomerId());
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
        String sql = "SELECT balance FROM bank2accounts WHERE account_nr = :account_nrParameter";
        Map<String, Object> paramMapGet = new HashMap<>();
        paramMapGet.put("account_nrParameter", accountNr);
        try {
            return jdbcTemplate.queryForObject(sql, paramMapGet, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void updateBalance(String accountNr, int newBalance) {
        String sql1 = "UPDATE bank2accounts SET balance = :balanceParameter WHERE account_nr = :account_nrParameter";
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

    public String findPasswordByIdCardNumber(String idCardNr){
        Map<String, Object> paramMap = new HashMap<>();
        String sql = "SELECT password FROM bank2customers WHERE id_card_nr = :idCardNrParameter";
        paramMap.put("idCardNrParameter", idCardNr);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }

    public List<Bank2Customers> getCustomers() {
        String sql = "SELECT * FROM bank2customers";
        return jdbcTemplate.query(sql, new HashMap<>(), new BankCustomersRowMapper());
    }

    private class BankCustomersRowMapper implements RowMapper<Bank2Customers> {
        @Override
        public Bank2Customers mapRow(ResultSet resultSet, int i) throws SQLException {
            Bank2Customers bank2Customers = new Bank2Customers();
            bank2Customers.setName(resultSet.getString("name"));
            bank2Customers.setFamilyName(resultSet.getString("family_name"));
            bank2Customers.setIdCardNr(resultSet.getString("id_card_nr"));
            bank2Customers.setCustomerId(resultSet.getInt("id"));
            return bank2Customers;
        }

    }

}

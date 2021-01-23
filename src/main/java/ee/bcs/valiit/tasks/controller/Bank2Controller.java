package ee.bcs.valiit.tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("bank2")
@RestController

public class Bank2Controller {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @PostMapping("create-acc")
    public void addAcc(@RequestBody Bank2 bank2) {
        String sql = "INSERT INTO bank2 (account_nr, balance) VALUES(:account_nrParameter, :balanceParameter)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", bank2.getAccountNr());
        paramMap.put("balanceParameter", bank2.getBalance());
        jdbcTemplate.update(sql, paramMap);
    }

    @GetMapping("get-balance")
    public Integer getBalance(@RequestBody Bank2 bank2) {
        String sql = "SELECT balance FROM bank2 WHERE account_nr = :account_nrParameter";
        Map<String, Object> paramMapGet = new HashMap<>();
        paramMapGet.put("account_nrParameter", bank2.getAccountNr());
        return jdbcTemplate.queryForObject(sql, paramMapGet, Integer.class);

    }

    @PutMapping("add-balance")
    public void addBalance(@RequestBody Bank2 bank2) {
        String sql = "SELECT balance FROM bank2 WHERE account_nr = :account_nrParameter";
        Map<String, Object> paramMapGet = new HashMap<>();
        paramMapGet.put("account_nrParameter", bank2.getAccountNr());
        int currentBalance = jdbcTemplate.queryForObject(sql, paramMapGet, Integer.class);

        String sql1 = "UPDATE bank2 SET balance = :balanceParameter WHERE account_nr = :account_nrParameter";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", bank2.getAccountNr());
        paramMap.put("balanceParameter", currentBalance + bank2.getAddAmount());
        jdbcTemplate.update(sql1, paramMap);

    }

    @PutMapping("withdraw")
    public void withDraw(@RequestBody Bank2 bank2) {
        String sql = "SELECT balance FROM bank2 WHERE account_nr = :account_nrParameter";
        Map<String, Object> paramMapGet = new HashMap<>();
        paramMapGet.put("account_nrParameter", bank2.getAccountNr());
        int currentBalance = jdbcTemplate.queryForObject(sql, paramMapGet, Integer.class);
        System.out.println(currentBalance);

        String sql1 = "UPDATE bank2 SET balance = :balanceParameter WHERE account_nr = :account_nrParameter";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", bank2.getAccountNr());
        paramMap.put("balanceParameter", currentBalance - bank2.getWithdrawAmount());
        jdbcTemplate.update(sql1, paramMap);

    }

    @PutMapping("transfer")
    public void transfer(@RequestBody Bank2Transfer bank2Transfer) {
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

    }

    @DeleteMapping("delete-account")
    public void deleteAccount(@RequestBody Bank2 bank2) {
        String sql = "DELETE FROM bank2 WHERE account_nr = :account_nrParameter";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", bank2.getAccountNr());
        jdbcTemplate.update(sql, paramMap);

    }











}
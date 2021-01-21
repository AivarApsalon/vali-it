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
        paramMap.put("account_nrParameter", bank2.getAccount_nr());
        paramMap.put("balanceParameter", bank2.getBalance());
        jdbcTemplate.update(sql, paramMap);
    }

    @PutMapping("add-balance")
    public void addBalance(@RequestBody Bank2 bank2) {
        String sql = "UPDATE bank2 SET balance = :balanceParameter WHERE account_nr = :account_nrParameter";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nrParameter", bank2.getAccount_nr());
        paramMap.put("balanceParameter", bank2.getBalance());
        jdbcTemplate.update(sql, paramMap);
    }


}

package ee.bcs.valiit.tasks.controller;


import ee.bcs.valiit.tasks.Employee;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;

@RequestMapping("bank")
@RestController
public class BankControllerA {
    HashMap<String, Integer> accountMap = new HashMap<>();


    @PostMapping("create-account")
    public Integer createAccount(@RequestBody String account) {
        accountMap.put(account, 0);
        return accountMap.get(account);
    }

    @GetMapping("account-number/{nr}")
    public Integer getAccountNr(@PathVariable("nr") String nr) {
        return accountMap.get(nr);
    }




}

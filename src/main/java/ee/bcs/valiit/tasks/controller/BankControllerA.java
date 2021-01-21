package ee.bcs.valiit.tasks.controller;


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

    @PutMapping("add-to-account/{account}/{amount}")
    public void addToAccount(@PathVariable("account") String account, @PathVariable("amount") int amount) {
        int currentBalance = accountMap.get(account);
        int newBalance = currentBalance + amount;
        accountMap.put(account, newBalance);

    }

    @PutMapping("withdraw-from-account/{account}/{amount}")
    public void withdrawFromAccount(@PathVariable("account") String account, @PathVariable("amount") int amount) {
        int currentBalance = accountMap.get(account);
        int newBalance = currentBalance - amount;
        accountMap.put(account, newBalance);
    }

    @PutMapping("transfer/{fromaccount}/{toaccount}/{amount}")
    public void transfer(@PathVariable("fromaccount") String fromAccount,
                         @PathVariable("toaccount") String toAccount, @PathVariable int amount) {
        int fromCurrentBalance = accountMap.get(fromAccount);
        int fromNewBalance = fromCurrentBalance - amount;
        accountMap.put(fromAccount, fromNewBalance);
        int toCurrentBalance = accountMap.get(toAccount);
        int toNewBalance = toCurrentBalance + amount;
        accountMap.put(toAccount, toNewBalance);
    }

}

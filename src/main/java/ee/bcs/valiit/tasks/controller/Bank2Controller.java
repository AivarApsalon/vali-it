package ee.bcs.valiit.tasks.controller;

import ee.bcs.valiit.tasks.Bank2Customers;
import ee.bcs.valiit.tasks.service.BankRepository;
import ee.bcs.valiit.tasks.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("bank2")
@RestController

public class Bank2Controller {

    @Autowired
    private BankService bankService;

    @PostMapping("create-acc")
    public void addAcc(@RequestBody Bank2 bank2) {
        bankService.addAcc(bank2);

    }

    @PostMapping("new-customer")
    public void newCustomer(@RequestBody Bank2Customers bank2Customers) {
        bankService.newCustomer(bank2Customers);

    }

    @GetMapping("get-balance")
    public Integer getBalance(@RequestBody Bank2 bank2) {
        return bankService.getBalance(bank2.getAccountNr());

    }

    @PutMapping("deposit")
    public void deposit(@RequestBody Bank2 bank2) {
        bankService.deposit(bank2.getAccountNr(), bank2.getAddAmount());

    }

    @PutMapping("withdraw")
    public void withdraw(@RequestBody Bank2 bank2) {
        bankService.withdraw(bank2.getAccountNr(), bank2.getWithdrawAmount());

    }

    @PutMapping("transfer")
    public void transfer(@RequestBody Bank2Transfer bank2Transfer) {
        bankService.transfer(bank2Transfer.getFromAccountNr(), bank2Transfer.getToAccountNr(),
                bank2Transfer.getTransferAmount());

    }

}
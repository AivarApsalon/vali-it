package ee.bcs.valiit.tasks.tasks.controller;

import ee.bcs.valiit.tasks.tasks.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("get-balance/{acc-nr}")
    public Integer getBalance(@PathVariable("acc-nr") String accountNr) {
        return bankService.getBalance(accountNr);



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

    @GetMapping("customers-list")
    public List<Bank2Customers> bank2Customerslist() {
        return bankService.bank2Customerslist();
    }


}
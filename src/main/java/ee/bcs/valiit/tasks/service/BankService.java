package ee.bcs.valiit.tasks.service;

import ee.bcs.valiit.tasks.Bank2Customers;
import ee.bcs.valiit.tasks.controller.Bank2;
import ee.bcs.valiit.tasks.controller.Bank2Transfer;
import ee.bcs.valiit.tasks.controller.UpdateBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public void addAcc(Bank2 bank2) {
        bankRepository.addAcc(bank2);

    }

    public void newCustomer(Bank2Customers bank2Customers) {
        bankRepository.newCustomer(bank2Customers);

    }

    public Integer getBalance(Bank2 bank2) {
        return bankRepository.getBalance(bank2);

    }


    public void deposit(Bank2 bank2) {
        bankRepository.addTransactionHistory(bank2);


    }

    public void withdraw(Bank2 bank2) {
        bankRepository.withdraw(bank2);

    }

        public void transfer(Bank2Transfer bank2Transfer){
    bankRepository.transfer(bank2Transfer);

    }



}

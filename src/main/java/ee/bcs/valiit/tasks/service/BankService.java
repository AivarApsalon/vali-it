package ee.bcs.valiit.tasks.service;

import ee.bcs.valiit.tasks.controller.Bank2Customers;
import ee.bcs.valiit.tasks.controller.Bank2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Integer getBalance(String accountNr) {
        return bankRepository.getBalance(accountNr);

    }

    public void deposit(String accountNr, int amount) {
        int balance = bankRepository.getBalance(accountNr);
        int newBalance = balance + amount;
        bankRepository.updateBalance(accountNr, newBalance);
        bankRepository.addTransactionHistory(accountNr, amount);
    }

    public void withdraw(String accountNr, int amount) {
        int balance = bankRepository.getBalance(accountNr);
        int newBalance = balance - amount;
        bankRepository.updateBalance(accountNr, newBalance);
        bankRepository.addTransactionHistory(accountNr, amount * -1);
    }

    public void transfer(String fromAccountNr, String toAccountNr, int amount) {

        int fromAccountBalance = bankRepository.getBalance(fromAccountNr);
        int fromAccountNewBalance = fromAccountBalance - amount;
        bankRepository.updateBalance(fromAccountNr, fromAccountNewBalance);

        int toAccountBalance = bankRepository.getBalance(toAccountNr);
        int toAccountNewBalance = toAccountBalance + amount;
        bankRepository.updateBalance(toAccountNr, toAccountNewBalance);
        bankRepository.addTransferTransactionHistory(fromAccountNr, toAccountNr, amount);

    }

    public List<Bank2Customers> bank2Customerslist() {
        return bankRepository.getCustomers();
    }


}
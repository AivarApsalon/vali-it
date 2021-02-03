package ee.bcs.valiit.tasks.tasks.service;

import ee.bcs.valiit.tasks.tasks.controller.Bank2;
import ee.bcs.valiit.tasks.tasks.controller.Bank2Customers;
import ee.bcs.valiit.tasks.tasks.controller.Bank2Exception;
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
        Integer balance = bankRepository.getBalance(accountNr);
        if (balance == null) {
            throw new Bank2Exception("Invalid account number!");
        }
        return balance;
    }


    public void deposit(String accountNr, int amount) {
        Integer balance = bankRepository.getBalance(accountNr);
        validateDepositOrWithdraw(amount, balance);

        int newBalance = balance + amount;
        bankRepository.updateBalance(accountNr, newBalance);
        bankRepository.addTransactionHistory(accountNr, amount);
    }


    public void withdraw(String accountNr, int amount) {
        Integer balance = bankRepository.getBalance(accountNr);
        validateDepositOrWithdraw(amount, balance);

        int newBalance = balance - amount;
        if (newBalance < 0) {
            throw new Bank2Exception("Not enough money on account!");
        }
        bankRepository.updateBalance(accountNr, newBalance);
        bankRepository.addTransactionHistory(accountNr, amount * -1);
    }


    public void transfer(String fromAccountNr, String toAccountNr, int amount) {
        Integer fromAccountBalance = bankRepository.getBalance(fromAccountNr);
        Integer toAccountBalance = bankRepository.getBalance(toAccountNr);
        validateTransfer(amount, fromAccountBalance, toAccountBalance);
        if (fromAccountNr.equals(toAccountNr)) {
            throw new Bank2Exception("Invalid account number!");
        }
        int fromAccountNewBalance = fromAccountBalance - amount;
        bankRepository.updateBalance(fromAccountNr, fromAccountNewBalance);

        int toAccountNewBalance = toAccountBalance + amount;
        bankRepository.updateBalance(toAccountNr, toAccountNewBalance);
        bankRepository.addTransferTransactionHistory(fromAccountNr, toAccountNr, amount);

    }


    private void validateTransfer(int amount, Integer fromAccountBalance, Integer toAccountBalance) {
        if (fromAccountBalance == null || toAccountBalance == null) {
            throw new Bank2Exception("Invalid account number!");
        }
        if (amount <= 0) {
            throw new Bank2Exception("Invalid amount entered!");
        }
        if (fromAccountBalance < amount) {
            throw new Bank2Exception("Not enough money on account!");
        }
    }


    private void validateDepositOrWithdraw(int amount, Integer balance) {
        if (balance == null) {
            throw new Bank2Exception("Invalid account number!");
        }
        if (amount <= 0) {
            throw new Bank2Exception("Invalid amount entered!");
        }
    }


    public List<Bank2Customers> bank2Customerslist() {
        return bankRepository.getCustomers();
    }


}
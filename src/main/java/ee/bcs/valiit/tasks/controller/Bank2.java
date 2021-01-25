package ee.bcs.valiit.tasks.controller;

import java.time.LocalDateTime;

public class Bank2 {
    private String accountNr;
    private int balance;
    private String addAmount;
    private String withdrawAmount;

    public String getAddAmount() {
        return addAmount;
    }

    public void setAddAmount(String addAmount) {
        this.addAmount = addAmount;
    }

    public String getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(String withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public String getAccountNr() {

        return accountNr;
    }

    public void setAccountNr(String accountNr) {

        this.accountNr = accountNr;
    }

    public int getBalance() {

        return balance;
    }

    public void setBalance(int balance) {

        this.balance = balance;
    }
}

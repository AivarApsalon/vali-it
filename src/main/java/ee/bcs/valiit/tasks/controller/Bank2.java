package ee.bcs.valiit.tasks.controller;

public class Bank2 {
    private String accountNr;
    private int balance;
    private int addAmount;
    private int withdrawAmount;


    public int getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(int withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public int getAddAmount() {
        return addAmount;
    }

    public void setAddAmount(int addAmount) {
        this.addAmount = addAmount;
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

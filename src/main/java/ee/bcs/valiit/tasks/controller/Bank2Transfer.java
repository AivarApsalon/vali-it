package ee.bcs.valiit.tasks.controller;

public class Bank2Transfer {
    private String fromAccountNr;
    private int fromAccountBalance;
    private String toAccountNr;
    private int toAccountBalance;
    private int transferAmount;


    public String getFromAccountNr() {
        return fromAccountNr;
    }

    public void setFromAccountNr(String fromAccountNr) {
        this.fromAccountNr = fromAccountNr;
    }

    public int getFromAccountBalance() {
        return fromAccountBalance;
    }

    public void setFromAccountBalance(int fromAccountBalance) {
        this.fromAccountBalance = fromAccountBalance;
    }

    public String getToAccountNr() {
        return toAccountNr;
    }

    public void setToAccountNr(String toAccountNr) {
        this.toAccountNr = toAccountNr;
    }

    public int getToAccountBalance() {
        return toAccountBalance;
    }

    public void setToAccountBalance(int toAccountBalance) {
        this.toAccountBalance = toAccountBalance;
    }

    public int getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(int transferAmount) {
        this.transferAmount = transferAmount;
    }
}

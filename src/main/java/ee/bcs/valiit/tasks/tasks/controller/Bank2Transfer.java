package ee.bcs.valiit.tasks.tasks.controller;

public class Bank2Transfer {
    private String fromAccountNr;
    private String toAccountNr;
    private int transferAmount;


    public String getFromAccountNr() {
        return fromAccountNr;
    }

    public void setFromAccountNr(String fromAccountNr) {
        this.fromAccountNr = fromAccountNr;
    }


    public String getToAccountNr() {
        return toAccountNr;
    }

    public void setToAccountNr(String toAccountNr) {
        this.toAccountNr = toAccountNr;
    }


    public int getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(int transferAmount) {
        this.transferAmount = transferAmount;
    }
}

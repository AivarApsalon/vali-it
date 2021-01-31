package ee.bcs.valiit.tasks.tasks.controller;

import java.math.BigDecimal;

public class Bank {
    private String eesNimi;
    private String pereNimi;
    private String kontoNr;
    private int summa;

    public String getEesNimi() {
        return eesNimi;
    }

    public void setEesNimi(String eesNimi) {
        this.eesNimi = eesNimi;
    }

    public String getPereNimi() {
        return pereNimi;
    }

    public void setPereNimi(String pereNimi) {
        this.pereNimi = pereNimi;
    }

    public String getKontoNr() {
        return kontoNr;
    }

    public void setKontoNr(String kontoNr) {
        this.kontoNr = kontoNr;
    }

    public int getSumma() {
        return summa;
    }

    public void setSumma(int summa) {
        this.summa = summa;
    }
}

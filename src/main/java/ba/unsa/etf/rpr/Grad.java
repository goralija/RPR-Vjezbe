package ba.unsa.etf.rpr;

public class Grad {
    private int id;
    private String ime;
    private int broj_stanovnika;
    private int drzava;

    public Grad() {}

    public Grad(int id, String ime, int broj_stanovnika, int drzava) {
        this.id = id;
        this.ime = ime;
        this.broj_stanovnika = broj_stanovnika;
        this.drzava = drzava;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getBroj_stanovnika() {
        return broj_stanovnika;
    }

    public void setBroj_stanovnika(int broj_stanovnika) {
        this.broj_stanovnika = broj_stanovnika;
    }

    public int getDrzava() {
        return drzava;
    }

    public void setDrzava(int drzava) {
        this.drzava = drzava;
    }
}

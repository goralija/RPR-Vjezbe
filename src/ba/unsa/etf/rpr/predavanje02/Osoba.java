package ba.unsa.etf.rpr.predavanje02;
import java.lang.Object;

public class Osoba {

    protected String ime = "";
    protected String prezime = "";

    public Osoba (String ime, String prezime) {
        this.ime = ime; this.prezime = prezime;
    }
    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
}

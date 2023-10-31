package ba.unsa.etf.rpr.predavanje02;

public class Korisnik extends Osoba {
    Racun racun;
    public Korisnik(String ime, String prezime) {
        super(ime, prezime);
    }
    public void dodajRacun(Racun racun) {
        this.racun = racun;
    }
    public Racun getRacun() {
        return racun;
    }
    public void setRacun(Racun racun) {
        this.racun = racun;
    }
}

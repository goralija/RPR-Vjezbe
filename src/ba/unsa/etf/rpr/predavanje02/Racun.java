package ba.unsa.etf.rpr.predavanje02;

public class Racun {
    private Long brojRacuna;
    private Osoba korisnikRacuna;
    private boolean odobrenjePrekoracenja;
    private Double stanjeRacuna;

    public Racun(Long broj, Osoba vlasnik) {
        brojRacuna = broj; korisnikRacuna = vlasnik; odobrenjePrekoracenja = false; stanjeRacuna = 0.0;
    }

    private boolean provjeriOdobrenjePrekoracenja(Double vrijednost) {
        return odobrenjePrekoracenja && stanjeRacuna >= vrijednost;
    }

    public boolean izvrsiUplatu (Double suma) {
        if (suma>=0) {
            stanjeRacuna = stanjeRacuna + suma;
            return true;
        }
        return false;
    }

    public boolean izvrsiIsplatu (Double suma) {
        if (suma >= 0 && suma <= stanjeRacuna) {
            stanjeRacuna = stanjeRacuna - suma;
            return true;
        }
        return false;
    }

    public void odobriPrekoracenje(Double suma) {
        if (provjeriOdobrenjePrekoracenja(suma)) {
            odobrenjePrekoracenja = true;
        }
    }


    public Long getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(Long brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    public Osoba getKorisnikRacuna() {
        return korisnikRacuna;
    }

    public void setKorisnikRacuna(Osoba korisnikRacuna) {
        this.korisnikRacuna = korisnikRacuna;
    }

    public boolean isOdobrenjePrekoracenja() {
        return odobrenjePrekoracenja;
    }

    public void setOdobrenjePrekoracenja(boolean odobrenjePrekoracenja) {
        this.odobrenjePrekoracenja = odobrenjePrekoracenja;
    }

    public Double getStanjeRacuna() {
        return stanjeRacuna;
    }

    public void setStanjeRacuna(Double stanjeRacuna) {
        this.stanjeRacuna = stanjeRacuna;
    }
}

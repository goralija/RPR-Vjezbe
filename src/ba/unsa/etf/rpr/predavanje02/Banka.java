package ba.unsa.etf.rpr.predavanje02;
import java.util.ArrayList;
import java.util.List;

public class Banka {
    private long brojRacuna;
    private List<Korisnik> korisnici;
    private List<Uposlenik> uposlenici;

    public Banka() {
        this.brojRacuna = 0;
        this.korisnici=new ArrayList<>();
        this.uposlenici=new ArrayList<>();
    }

    public Korisnik kreirajNovogKorisnika (String ime, String prezime) {
        Korisnik korisnik = new Korisnik(ime, prezime);
        korisnici.add(korisnik);
        return korisnik;
    }

    public Uposlenik kreirajNovogUposlenika (String ime, String prezime) {
        Uposlenik uposlenik = new Uposlenik(ime, prezime);
        uposlenici.add(uposlenik);
        return uposlenik;
    }

    public Racun kreirajRacunZaKorisnika(Korisnik neki) {
        Racun racun = new Racun(brojRacuna, neki);
        neki.dodajRacun(racun);
        brojRacuna++;
        return racun;
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public List<Uposlenik> getUposlenici() {
        return uposlenici;
    }

    public void setUposlenici(List<Uposlenik> uposlenici) {
        this.uposlenici = uposlenici;
    }
}

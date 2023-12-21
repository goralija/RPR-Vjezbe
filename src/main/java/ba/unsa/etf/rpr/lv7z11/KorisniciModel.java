package ba.unsa.etf.rpr.lv7z11;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici = FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutniKorisnik = new SimpleObjectProperty<>();

    public KorisniciModel() {
        napuni();
    }

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }

    public SimpleObjectProperty trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }

    public void dodaj() {
        Korisnik novi = new Korisnik();
        korisnici.add(novi);
        trenutniKorisnik.set(novi);
    }

    public void napuni() {
        korisnici.add(new Korisnik("belmin","durmo","bd@gmail.com","durmilica","nekasifra"));
        korisnici.add(new Korisnik("harun","goralija","hg@gmail.com","gora","neka druga"));
        trenutniKorisnik.set(null);
    }
}

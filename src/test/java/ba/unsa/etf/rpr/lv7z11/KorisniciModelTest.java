package ba.unsa.etf.rpr.lv7z11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorisniciModelTest {
    @Test
    void getTrenutniKorisnik() {
        KorisniciModel model = new KorisniciModel();
        model.setTrenutniKorisnik(model.getKorisnici().get(1));
        assertEquals("harun", model.getTrenutniKorisnik().getIme());
    }

    @Test
    void trenutniKorisnikProperty() {
        KorisniciModel model = new KorisniciModel();
        assertEquals(null, model.getTrenutniKorisnik());
    }

    @Test
    void dodaj() {
        KorisniciModel model = new KorisniciModel();
        model.dodaj();
        model.dodaj();
        assertEquals(4, model.getKorisnici().size());
    }

    @Test
    void napuni() {
        KorisniciModel model = new KorisniciModel();
        model.napuni();
        assertEquals(false, model.getKorisnici().isEmpty());
    }
}
package ba.unsa.etf.rpr.predavanje02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {
    private static Imenik imenik = new Imenik();

    @BeforeAll
    public static void pocetni() {
        imenik.dodaj("emin", new MobilniBroj(62, "024-432"));
        imenik.dodaj("alem", new FiksniBroj(Grad.KUPRES, "002-412"));
    }

    @Test
    void dajBrojPronadjen() {
        String broj = imenik.dajBroj("emin");
        assertEquals(broj, "062/024-432");
    }

    @Test
    void dajBrojNijePronadjen() {
        String broj = imenik.dajBroj("emir");
        assertNull(broj);
    }

    @Test
    void dodaj() {
        imenik.dodaj("emir", new MobilniBroj(61, "038-512"));

        String broj = imenik.dajBroj("emir");

        assertEquals(broj, "061/038-512");
    }

    @Test
    void dajImePronadjeno() {
        String ime = imenik.dajIme(new MobilniBroj(62, "024-432"));
        assertEquals(ime, "emin");
    }

    @Test
    void dajImeNijePronadjeno() {
        String ime = imenik.dajIme(new MobilniBroj(63, "024-432"));
        assertNull(ime);
    }

    @Test
    void naSlovoPronadjen() {
        String rez = imenik.naSlovo('e');
        assertEquals(rez, "1. emin - 062/024-432\r\n");
        imenik.dodaj("emir", new FiksniBroj(Grad.SARAJEVO, "092-854"));
        rez = imenik.naSlovo('e');
        assertEquals(rez, "1. emin - 062/024-432\r\n2. emir - 033/092-854\r\n");
    }

    @Test
    void naSlovoNijePronadjen() {
        String rez = imenik.naSlovo('g');
        assertEquals(rez, "");
    }

}
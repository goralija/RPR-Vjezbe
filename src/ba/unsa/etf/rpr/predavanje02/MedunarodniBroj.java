package ba.unsa.etf.rpr.predavanje02;

import java.util.Objects;

public class MedunarodniBroj extends TelefonskiBroj{
    private String drzava;
    private String broj;

    MedunarodniBroj(String drzava, String broj) {
        this.broj = drzava + broj;
    }

    @Override
    public String ispisi() {
        if (broj != null) {
            return drzava + broj;
        }
        else return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedunarodniBroj that = (MedunarodniBroj) o;
        return Objects.equals(broj, that.broj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(broj);
    }
}

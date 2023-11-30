package ba.unsa.etf.rpr;

import java.util.List;
import java.util.ArrayList;

public class NastavnikSaOcjenama extends Nastavnik implements MozeOcijeniti{
    private List<Ocjena> ocjene = new ArrayList<>();

    public NastavnikSaOcjenama(String ime, String prezime, String titula) {
        super(ime, prezime, titula);
    }

    @Override
    public Ocjena ocijeni(int x, LicneInformacije osoba) {
        Ocjena novaOcjena = new Ocjena(osoba,x);  // Osoba koja ocjenjuje nije specificirana
        ocjene.add(novaOcjena);
        return novaOcjena;
    }

    public List<Ocjena> getOcjene() {
        return ocjene;
    }
}

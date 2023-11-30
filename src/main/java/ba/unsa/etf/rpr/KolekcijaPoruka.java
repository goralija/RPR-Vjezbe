package ba.unsa.etf.rpr;

import java.util.List;
import java.util.ArrayList;

public class KolekcijaPoruka {
    private List<String> poruke;

    public KolekcijaPoruka(List<?> listaObjekata) {
        this.poruke = new ArrayList<>();
        for (Object obj : listaObjekata) {
            if (obj instanceof LicneInformacije || obj instanceof Student ||
                    obj instanceof Nastavnik || obj instanceof Predmet) {
                poruke.add(((Predstavljiv) obj).predstavi());
            }
        }
    }

    public List<String> getPoruke() {
        return poruke;
    }
}

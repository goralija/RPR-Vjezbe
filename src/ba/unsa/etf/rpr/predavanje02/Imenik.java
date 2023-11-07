package ba.unsa.etf.rpr.predavanje02;

import java.util.*;

public class Imenik {
    private Map<String, TelefonskiBroj> brojevi;

    public Imenik () {
        brojevi = new HashMap<>();
    }

    public Map<String, TelefonskiBroj> getBrojevi() {
        return brojevi;
    }

    public void dodaj(String ime, TelefonskiBroj broj) {
        this.brojevi.put(ime, broj);
    }

    public String dajBroj(String ime) {
        TelefonskiBroj broj = this.brojevi.get(ime);
        if (broj != null) return broj.ispisi();
        else return null;
    }

    public String dajIme(TelefonskiBroj broj) {
        for (Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()) {
            if (entry.getValue().ispisi().equals(broj.ispisi())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String naSlovo(char s) {
        //1. Ime Prezime - broj
        //2. Ime Prezime - broj
        StringBuilder builder = new StringBuilder();
        int brojac = 1;

        for (Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()) {
            if (entry.getKey().startsWith(String.valueOf(s))) {
                builder.append(brojac)
                        .append(". ")
                        .append(entry.getKey())
                        .append(" - ")
                        .append(entry.getValue().ispisi())
                        .append(System.lineSeparator());
                brojac++;}

        }
        return builder.toString();
    }

    public Set<String> izGrada(Grad g) {
        // vraca skup stringova koji sadrzi imena i prezimena svih koji zive u gradu g
        // skup treba biti sortiran abecedno
        Set<String> results = new TreeSet<String>();
        for (Map.Entry<String, TelefonskiBroj> entry : this.brojevi.entrySet()) {
            if (jeLiIzGrada(entry.getValue(), g)) {
                results.add(entry.getKey());
            }
        }
        return results;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g) {
        Set<TelefonskiBroj> rez = new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                return o1.ispisi().compareTo(o2.ispisi());
            }
        });
        for (Map.Entry<String, TelefonskiBroj> entry : brojevi.entrySet()) {
            if (entry.getValue() instanceof FiksniBroj) {
                FiksniBroj fb = (FiksniBroj) entry.getValue();
                if (fb.getGrad() == g) rez.add(fb);
            }

        }
        return rez;
    }

    private boolean jeLiIzGrada(TelefonskiBroj broj, Grad g) {
        if (broj instanceof FiksniBroj) {
            return g.equals(((FiksniBroj) broj).getGrad());
        }
        else return false;
    }
}

package ba.unsa.etf.rpr.predavanje02;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj {

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    private Grad grad;
    private String broj;

    FiksniBroj(Grad grad, String broj) {
        if (null == grad) throw new BrojException("Neispravan pozivni broj!");
        this.grad = grad; this.broj = broj;
    }

    @Override
    public String ispisi() {
        if (grad != null && broj != null) return grad.getPozivniBroj() + "/" + broj;
        else return null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(grad, broj);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiksniBroj that = (FiksniBroj) o;
        return grad == that.grad && Objects.equals(broj, that.broj);
    }
}

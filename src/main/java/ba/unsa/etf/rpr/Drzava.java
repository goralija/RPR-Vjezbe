package ba.unsa.etf.rpr;

public class Drzava {
    private int id;
    private String ime;
    private int glavni_grad;

    public Drzava() {}

    public Drzava(int id, String ime, int glavni_grad) {
        this.id = id;
        this.ime = ime;
        this.glavni_grad = glavni_grad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public int getGlavni_grad() {
        return glavni_grad;
    }

    public void setGlavni_grad(int glavni_grad) {
        this.glavni_grad = glavni_grad;
    }
}

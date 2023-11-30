package ba.unsa.etf.rpr;

public class Student extends LicneInformacije {
    private String godinaStudija,brojIndexa;

    Student(String ime, String prezime, String godSt, String bri){
        super(ime,prezime);
        this.godinaStudija=godSt;
        this.brojIndexa=bri;
    }

    public String getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public String getBrojIndexa() {
        return brojIndexa;
    }

    public void setBrojIndexa(String brojIndexa) {
        this.brojIndexa = brojIndexa;
    }
}

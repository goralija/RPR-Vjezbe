package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import ba.unsa.etf.rpr.Laptop;

public interface LaptopDao {
    void dodajLaptopUListu (Laptop laptop);
    Laptop dodajLaptopUFile (Laptop laptop) throws IOException;
    Laptop getLaptop (String procesor);
    void napuniListu(ArrayList<Laptop> laptopi);
    List<Laptop> vratiPodatkeIzDatoteke() throws IOException, ClassNotFoundException;
}

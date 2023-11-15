package ba.unsa.etf.rpr;

import java.io.File;
import ba.unsa.etf.rpr.Laptop;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;


//treba da bude implementirana tako što će se
//vršiti zapis laptopa iz liste u .json file i to ćete realizirati koristeći ObjectMapper
//klasu

public class LaptopDaoJSONFile implements LaptopDao {

    private File file;
    private ArrayList<Laptop> laptopi;

    public LaptopDaoJSONFile() {
        laptopi = new ArrayList<>();
        file = new File("src/main/resources/laptopi.json");
    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        laptopi.add(laptop);
    }

    @Override
    public Laptop getLaptop(String procesor) {
        Laptop temp = new Laptop();
        for (Laptop el : laptopi)
            if (el.getProcesor().equals(procesor))
                return el;
        throw new NeodgovarajuciProcesorException("Neodgovarajuci procesor!");
    }

    @Override
    public void napuniListu(ArrayList<Laptop> l) {
        laptopi.addAll(l);
    }

    @Override
    public Laptop dodajLaptopUFile(Laptop laptop) throws IOException {
        laptopi.add(laptop);
        JsonMapper mapper = new JsonMapper();
        String temp = mapper.writeValueAsString(laptopi);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(temp.getBytes());
        fos.close();
        return laptop;
    }

    @Override
    public ArrayList<Laptop> vratiPodatkeIzDatoteke() throws IOException {
        ArrayList<Laptop> rez;
        JsonMapper mapper = new JsonMapper();
        return mapper.readValue(file, new TypeReference<ArrayList<Laptop>>() {
        });
    }
}
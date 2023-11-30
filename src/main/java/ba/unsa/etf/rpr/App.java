package ba.unsa.etf.rpr;

import java.util.List;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        List<String> imenaIPrezimena = new ArrayList<>();
        imenaIPrezimena.add("Ana Ivanovic");
        imenaIPrezimena.add("Marko Markovic");
        KolekcijaImena staraKolekcija = new KolekcijaImena(imenaIPrezimena);
        Pobjednik pobjednikStare = new Pobjednik(staraKolekcija);
        System.out.println("Pobjednik (stara kolekcija): " + pobjednikStare.getIme() + " " + pobjednikStare.getPrezime());


        List<String> imena = new ArrayList<>();
        imena.add("Ivana");
        imena.add("Petar");
        List<String> prezimena = new ArrayList<>();
        prezimena.add("Peric");
        prezimena.add("Ivic");
        KolekcijaImenaIPrezimena novaKolekcija = new KolekcijaImenaIPrezimena(imena, prezimena);
        Pobjednik pobjednikNova = new Pobjednik(novaKolekcija);
        System.out.println("Pobjednik (nova kolekcija): " + pobjednikNova.getIme() + " " + pobjednikNova.getPrezime());
    }
}

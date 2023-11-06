package ba.unsa.etf.rpr.predavanje02;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static Scanner ulaz = new Scanner(System.in);
    public static Imenik imenik = new Imenik();

    private static void ispisiImenik() {
        System.out.println(imenik.toString());
    }

    private static void izGradaBrojevi() {
        System.out.println("Unesite grad: ");
        String input = ulaz.nextLine();
        try {
            Grad g = Grad.valueOf(input);
            Set<TelefonskiBroj> rez = imenik.izGradaBrojevi(g);
            for (TelefonskiBroj broj : rez) {
                System.out.println(broj.ispisi());
            }
        }
        catch (Exception e) {
            System.out.println("Pogresan grad");
            return;
        }
    }

    private static void izGrada() {
        System.out.println("Unesite grad: ");
        String input = ulaz.nextLine();
        try {
            Grad g = Grad.valueOf(input);
            Set<String> rez = imenik.izGrada(g);
            System.out.println(rez);
        }
        catch (Exception e) {
            System.out.println("Pogresan grad");
            return;
        }
    }

    private static void naSlovo() {
        System.out.println("Unesite prvo slovo imena: ");
        String a = ulaz.nextLine();
        String rez = imenik.naSlovo(a.toCharArray()[0]);
        System.out.println(rez);
    }

    private static TelefonskiBroj unesiBrojTelefona() {
        System.out.println("Unesi tip broja (mobilni, fiksni, medjunarodni): ");
        String input = ulaz.nextLine();
        switch (input) {
            case "mobilni":
                System.out.println("Unesite pozivni broj mreze: ");
                int mreza = ulaz.nextInt();
                System.out.println("Unesite broj mobilnog telefona: ");
                String broj = ulaz.nextLine();
                return new MobilniBroj(mreza, broj);
            case "fiksni":
                System.out.println("Unesite pozivni broj grada: ");
                String grad = ulaz.nextLine();
                System.out.println("Unesite broj fiksnog telefona: ");
                String fbroj = ulaz.nextLine();
                return new FiksniBroj(Grad.izPozivnog(grad), fbroj);
            case "medjunarodni":
                System.out.println("Unesite pozivni broj drzave: ");
                String pozivni = ulaz.nextLine();
                System.out.println("Unesite broj telefona: ");
                String mbroj = ulaz.nextLine();
                return new MedunarodniBroj(pozivni, mbroj);
        }
        return null;
    }

    private static void dajIme() {
        TelefonskiBroj broj = unesiBrojTelefona();
        String ime = imenik.dajIme(broj);
        if (ime==null) System.out.println("Ne postoji u imeniku");
        else System.out.println("Vlasnik broja " + broj.ispisi() + " je " + ime);
    }

    private static void dodajBroj() {
        System.out.println("Unesite ime: ");
        String ime = ulaz.nextLine();
        TelefonskiBroj broj = unesiBrojTelefona();
        imenik.dodaj(ime,broj);
    }

    private static void dajBroj() {
        System.out.println("Unesite ime: ");
        String ime = ulaz.nextLine();
        String broj = imenik.dajBroj(ime);
        if (broj != null) System.out.println(broj);
        else System.out.println("Broj ne postoji u imeniku");
    }

    public static void main(String[] args) {
        // omogucuje korisniku da unosom naredbi pomocu tastature pozove sve metode klasa navedenih iznad
        while(true) {
            System.out.println("Unesite komandu (dodaj, dajBroj, dajIme, naSlovo, izGrada, izGradaBrojevi, imenik, izlaz): ");
            String input = ulaz.nextLine();
            switch (input) {
                case "dodaj": dodajBroj(); break;
                case "dajBroj": dajBroj(); break;
                case "dajIme": dajIme(); break;
                case "naSlovo": naSlovo(); break;
                case "izGrada": izGrada(); break;
                case "izGradaBrojevi": izGradaBrojevi(); break;
                case "imenik": ispisiImenik(); break;
                case "izlaz": System.exit(0);
                default: System.out.println("Pogresna komanda!");
            }
        }
    }
}



// 2.
// napisi minimalno 3 JUnit testa, a u jednom od njih ubaci i testiraj neku metodu sa definisanim tipom izuzetka

// 3.
// Napisati test vezan za Mocking testiranje
// u prvom testu se koristi Mapa (String, String)
// drugi test - 2 klase, bazna i izvedena
// bazna klasa bi trebala imati privatni atribut tipa izvedene klase a izvedena bi trebala imati public metodu
// koja ce se testirati
// pronadji nacin testiranja metode izvedene klase preko metoda bazne klase
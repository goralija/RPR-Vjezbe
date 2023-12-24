package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static GeografijaDAO baza = new GeografijaDAO();
    public static String ispisiGradove() throws SQLException {
        ArrayList<Grad> gradovi = baza.gradovi();
        StringBuilder b = new StringBuilder();
        for (Grad x : gradovi) {
            b.append(x.getIme() + "(" + (baza.nadjiDrzavu(x.getDrzava())).getIme() + ") - " + x.getBroj_stanovnika());
            b.append("\n");
        }
        return b.toString();
    }
    static void glavniGrad() {
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite naziv drzave ciji glavni grad zelite: ");
        String ime = ulaz.nextLine();
        try {
            Grad grad = baza.glavniGrad(ime);
            if (grad==null) System.out.println("Nepostojeca drzava");
            else System.out.println(grad.getIme());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Svi gradovi, sa drzavom kojoj pripadaju te brojem stanovnika: ");
        String a = ispisiGradove();
        System.out.println(a);
        glavniGrad();
    }
}

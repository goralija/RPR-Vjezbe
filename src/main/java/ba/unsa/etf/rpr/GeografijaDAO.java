package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeografijaDAO {
    private static GeografijaDAO instance = null;
    private Connection conn;
    private PreparedStatement upitSviGradovi, dodavanjeGrada, dodavanjeDrzave, upitZaDrzavu, upitZaDrzavu2, upitZaGrad, azuriranjeGrada, brisanjeDrzave, brisanjeGradova;
    GeografijaDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/baza?serverTimezone=UTC","gora","root");
            upitSviGradovi = conn.prepareStatement("select * from grad order by broj_stanovnika desc");
            dodavanjeGrada = conn.prepareStatement("insert into grad values(?,?,?,?)");
            dodavanjeDrzave = conn.prepareStatement("insert into drzava values(?,?,?)");
            upitZaDrzavu = conn.prepareStatement("select * from drzava where naziv=?");
            upitZaDrzavu2 = conn.prepareStatement("select * from drzava where id=?");
            upitZaGrad = conn.prepareStatement("select * from grad where id=?");
            azuriranjeGrada = conn.prepareStatement("update grad set naziv=?,broj_stanovnika=?,drzava=? where id=?");
            brisanjeDrzave = conn.prepareStatement("delete from drzava where naziv=?");
            brisanjeGradova = conn.prepareStatement("delete from grad where drzava=?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static GeografijaDAO getInstance() {
        if (instance == null) instance = new GeografijaDAO();
        return instance;
    }
    public static void removeInstance() {
        try {
            instance.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        instance = null;
    }

    ArrayList<Grad> gradovi() throws SQLException {
        ArrayList<Grad> gradovi = new ArrayList<>();
        ResultSet rs = upitSviGradovi.executeQuery();
        while (rs.next()) {
            gradovi.add(new Grad(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
        }
        return gradovi;
    }

    void dodajGrad(Grad grad) throws SQLException {
        dodavanjeGrada.setInt(1,grad.getId());
        dodavanjeGrada.setString(2,grad.getIme());
        dodavanjeGrada.setInt(3,grad.getBroj_stanovnika());
        dodavanjeGrada.setInt(4,grad.getDrzava());
        dodavanjeGrada.executeUpdate();
    }

    void dodajDrzavu(Drzava drzava) throws SQLException {
        dodavanjeDrzave.setInt(1,drzava.getId());
        dodavanjeDrzave.setString(2,drzava.getIme());
        dodavanjeDrzave.setInt(3,drzava.getGlavni_grad());
        dodavanjeDrzave.executeUpdate();
    }

    Drzava nadjiDrzavu(String drzava) throws SQLException {
        upitZaDrzavu.setString(1,drzava);
        ResultSet rs = upitZaDrzavu.executeQuery();
        if(!rs.next()) return null;
        else return new Drzava(rs.getInt(1),rs.getString(2),rs.getInt(3));
    }
    Drzava nadjiDrzavu(int i) throws SQLException {
        upitZaDrzavu2.setInt(1,i);
        ResultSet rs = upitZaDrzavu2.executeQuery();
        if(!rs.next()) return null;
        else return new Drzava(rs.getInt(1),rs.getString(2),rs.getInt(3));
    }

    Grad glavniGrad(String drzava) throws SQLException {
        upitZaDrzavu.setString(1,drzava);
        ResultSet rs = upitZaDrzavu.executeQuery();
        if(rs.next()) {
            upitZaGrad.setInt(1,rs.getInt(3));
            ResultSet rs2 = upitZaGrad.executeQuery();
            rs2.next();
            return new Grad(rs2.getInt(1),rs2.getString(2),rs2.getInt(3),rs2.getInt(4));
        }
        return null;
    }

    void obrisiDrzavu(String drzava) throws SQLException {
        upitZaDrzavu.setString(1,drzava);
        ResultSet rs = upitZaDrzavu.executeQuery();
        rs.next();
        brisanjeDrzave.setString(1, drzava);
        brisanjeDrzave.executeUpdate();
        brisanjeGradova.setInt(1, rs.getInt(1));
        brisanjeGradova.executeUpdate();
    }

    void izmijeniGrad(Grad grad) throws SQLException {
        azuriranjeGrada.setString(1, grad.getIme());
        azuriranjeGrada.setInt(2, grad.getBroj_stanovnika());
        azuriranjeGrada.setInt(3, grad.getDrzava());
        azuriranjeGrada.setInt(4, grad.getId());
        azuriranjeGrada.executeUpdate();
    }

    //ako baza db ne postoji popuni je sa Pariz, London, Beč, Manchester i Graz i njihovim drzavama
}

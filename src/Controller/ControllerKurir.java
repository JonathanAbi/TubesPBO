package Controller;

import KoneksiDatabase.DatabaseHandler;
import Model.Kurir;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class ControllerKurir extends javax.swing.JFrame {

    static DatabaseHandler conn = new DatabaseHandler();
    static Kurir kurir = new Kurir();

    public static ArrayList<Kurir> getAllUsers() {

        ArrayList<Kurir> userKurir = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM kurir";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                kurir.setName(rs.getString("Nama"));
                kurir.setTelepon(rs.getString("Telepon"));
                kurir.setKapasitasBeratBarang(rs.getDouble("Kapasitas Barang"));
                kurir.setBeratBarangBawaan(rs.getDouble("Berat Barang Bawaan "));
                userKurir.add(kurir);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (userKurir);
    }

    public static void addKurir(String nama, String username, String pass, String telepon, String kapasitas, String totalKapasitas) {
        conn.connect();
        String query = "INSERT INTO kurir(nama, username, pass, telepon, kapasitas_berat_barang, total_berat_barang) VALUES(?,?,?,?,?,?)";
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(pass.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            pass = s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setString(2, username);
            stmt.setString(3, pass);
            stmt.setString(4, telepon);
            stmt.setString(5, kapasitas);
            stmt.setString(6, totalKapasitas);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil melakukan penamabahan");

        } catch (SQLException e) {
            if (e.getMessage().contains("'username'")) {
                JOptionPane.showMessageDialog(null, "Username sudah digunakan");
            } else if (e.getMessage().contains("'pass'")) {
                JOptionPane.showMessageDialog(null, "Password sudah digunakan");
            } else {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error fatal !");
            }

        }

    }

    public static void hitungKapasitasBarang() {
        if(kurir.getBeratBarangBawaan() < kurir.getKapasitasBeratBarang()) {
            JOptionPane.showMessageDialog(null, "Barang sudah melebihi kapasitas");
        }
    }

}

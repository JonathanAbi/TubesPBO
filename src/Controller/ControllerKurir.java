/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabaseHandler;
import Model.Kurir;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class ControllerKurir {

    static DatabaseHandler conn = new DatabaseHandler();
    static Kurir kurir = new Kurir();

    public static void addKurir(String nama, String username, String pass, String telepon, String kapasitas, String totalBerat) {
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
            stmt.setString(6, totalBerat);
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

    public static void updateKurir(String id, String nama, String username, String pass, String telepon, String kapasitas, String totalBerat) {
        conn.connect();
        String query = "UPDATE kurir SET nama='" + nama
                + "',username='" + username
                + "',pass='" + pass
                + "',telepon='" + telepon
                + "',kapasitas_berat_barang='" + kapasitas
                + "',total_berat_barang='" + totalBerat
                + "' WHERE kurir_id='" + id + "'";
        
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
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil melakukan update");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal melakukan update");
        }
    }

    public static void deleteKurir(String name) {
        conn.connect();

        String query = "DELETE FROM kurir WHERE nama='" + name + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal menghapus data");
        }
    }
}

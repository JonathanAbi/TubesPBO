package Controller;

import Database.DatabaseHandler;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class RegisterController {

    public void register(String nama, String userName, String pass, String telepon, String alamat, String kelurahan, String kecamatan, String kota, String provinsi, String kodePos) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String query = "INSERT INTO customers(nama,username,pass,telepon,alamat,kelurahan,kecamatan,kota,provinsi,kode_post) VALUES(?,?,?,?,?,?,?,?,?,?)";
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
            stmt.setString(2, userName);
            stmt.setString(3, pass);
            stmt.setString(4, telepon);
            stmt.setString(5, alamat);
            stmt.setString(6, kelurahan);
            stmt.setString(7, kecamatan);
            stmt.setString(8, kota);
            stmt.setString(9, provinsi);
            stmt.setString(10, kodePos);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil melakukan registrasi");
            
        } catch (SQLException e) {
            if (e.getMessage().contains("'username'")) {
                JOptionPane.showMessageDialog(null, "Username sudah digunakan");
            } else if (e.getMessage().contains("'telepon'")) {
                JOptionPane.showMessageDialog(null, "Telepon sudah digunakan");
            } else {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error fatal pusing!");
            }
        }
    }
}

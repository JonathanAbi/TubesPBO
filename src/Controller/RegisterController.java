package Controller;

import Database.DatabaseHandler;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class RegisterController {

    public String register(String nama, String userName, String pass, String telepon, String alamat, String kelurahan, String kecamatan, String kota, String provinsi, String kodePos) {

        String query;
        //for hashing the password
        pass = Hasher.password(pass);
        try {
//            PreparedStatement stmt = conn.con.prepareStatement(query);
//            stmt.setString(1, nama);
//            stmt.setString(2, userName);
//            stmt.setString(3, pass);
//            stmt.setString(4, telepon);
//            stmt.setString(5, alamat);
//            stmt.setString(6, kelurahan);
//            stmt.setString(7, kecamatan);
//            stmt.setString(8, kota);
//            stmt.setString(9, provinsi);
//            stmt.setString(10, kodePos);
//            stmt.executeUpdate();

            DatabaseHandler conn = new DatabaseHandler();
            conn.connect();
            PreparedStatement stmt;
            //for insert customer data
            query = "INSERT INTO customers(nama,username,pass,telepon) VALUES(?,?,?,?)";
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setString(2, userName);
            stmt.setString(3, pass);
            stmt.setString(4, telepon);
            stmt.executeUpdate();
            
            //for insert alamat data
            query = "INSERT INTO alamat(alamat_status, alamat, kelurahan, kecamatan, kota, provinsi, kodePos) VALUE (0,?,?,?,?,?,?)";
            stmt = conn.con.prepareStatement(query);
            stmt.setString(1, alamat);
            stmt.setString(2, kelurahan);
            stmt.setString(3, kecamatan);
            stmt.setString(4, kota);
            stmt.setString(5, provinsi);
            stmt.setString(6, kodePos);
            stmt.executeUpdate();
            
            Statement stat = conn.con.createStatement();
            ResultSet result;
            //for insert alamat_id to cutomers
            query = "SELECT alamat_id FROM alamat WHERE alamat = '"+alamat+"' AND kelurahan = '"+kelurahan+"' AND kecamatan = '"+kecamatan+"' AND kota = '"+kota+"' AND provinsi = '"+provinsi+"' AND kode_post = '"+kodePos+"'";
            result = stat.executeQuery(query);
            int alamatID = result.getInt("alamat_id");
            
            query = "UPDATE customers SET alamat_id ="+alamatID+" WHERE username = '"+userName+"'";
            stat.executeUpdate(query);
            
            //for insert user_id to alamat
            query = "SELECT customer_id FROM customers WHERE username = '"+userName+"'";
            result = stat.executeQuery(query);
            int customerID = result.getInt("customer_id");
            
            query = "UPDATE alamat SET customer_id = '"+customerID+"' alamat = '"+alamat+"' AND kelurahan = '"+kelurahan+"' AND kecamatan = '"+kecamatan+"' AND kota = '"+kota+"' AND provinsi = '"+provinsi+"' AND kode_post = '"+kodePos+"'";
            stat.executeUpdate(query);
            
            return "Berhasil melakukan registrasi";

        } catch (SQLException e) {
            if (e.getMessage().contains("'username'")) {
                return "Username sudah digunakan";
            } else if (e.getMessage().contains("'telepon'")) {
                return "Telepon sudah digunakan";
            } else {
                e.printStackTrace();
                return "Error fatal ini mah!";
            }
        }
    }
}

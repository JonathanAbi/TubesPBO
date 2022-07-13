package Controller;

import Database.DatabaseHandler;
import Model.Alamat;
import Model.Customer;
import Model.SingletonProfile;
import Model.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginController {

    public String LoginController(String tipe, String userName, String pass) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String tempPass = pass;
        pass = Hasher.password(pass);
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("select * from " + tipe + " where username='" + userName + "'");

            if (result.next()) {
                if (pass.equals(result.getString("pass"))) {
                    if (tipe.equals("customers")) {
                        String telepon = result.getString("telepon");
                        String nama = result.getString("nama");
                        String username = result.getString("username");
                        int id = result.getInt("customer_id");
                        ArrayList<Alamat> listAlamat = new ArrayList<>();
                        result = stat.executeQuery("select * from alamat where customer_id='" + result.getString("customer_id") + "'");
                        while (result.next()) {
                            Alamat temp = new Alamat(result.getInt("alamat_id"),result.getString("alamat"), result.getString("kelurahan"), result.getString("kecamatan"), result.getString("kota"), result.getString("provinsi"), result.getString("kode_post"), result.getInt("alamat_status"));
                            listAlamat.add(temp);
                        }
                        Customer customer = new Customer(listAlamat, telepon, nama, username, tempPass, id);
                        SingletonProfile.getInstance().setUser(customer);
                    }
                    return "Login Berhasil!";
                } else {
                    return "Password Salah!";
                }
            } else {
                return "User tidak ditemukan!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}

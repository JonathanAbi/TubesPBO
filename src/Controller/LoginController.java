package Controller;

import Database.DatabaseHandler;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    public String LoginController(String tipe, String userName, String pass) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();

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
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result=stat.executeQuery("select * from "+tipe+" where username='"+userName+"'");
            if(result.next()){
                if(pass.equals(result.getString("pass"))){
                    return "Login Berhasil!";
                }else{
                    return "Password Salah!";
                }
            }else{
                return "User tidak ditemukan!";
            }
        } catch (SQLException e) {
            return "Error";
        }
    }
}

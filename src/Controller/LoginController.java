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
        
        pass = Hasher.password(pass);
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

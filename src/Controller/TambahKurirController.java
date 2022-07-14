/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabaseHandler;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author glenn
 */
public class TambahKurirController {
    public String addKurir(String nama, String username, String password, String telepon, double kapasitas) {
        password = Hasher.password(password);
        DatabaseHandler c = new DatabaseHandler();
        try {
            c.connect();
            String query = "INSERT INTO kurir(nama, username, pass, telepon, kapasitas_berat_barang) VALUE (?,?,?,?,?)";
            PreparedStatement stmt = c.con.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.setString(4, telepon);
            stmt.setDouble(5, kapasitas);
            stmt.execute();
            c.disconnect();
            return "Berhasil menambahkan kurir";
        } catch (SQLException e) {
            if (e.getMessage().contains("'username'")) {
                return "Username sudah dipakai";
            }
            return "Gagal menambahkan kurir "+e.getMessage();
        }
    }
}

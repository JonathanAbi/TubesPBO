/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabaseHandler;
import Model.SingletonProduk;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author glenn
 */
public class TambahProdukController {

    SingletonProduk produk = SingletonProduk.getInstance();
    DatabaseHandler c = new DatabaseHandler();

    public static void main(String[] args) {

    }

    public String tambahProdukBaru(String nama, Double berat, String warna, int jumlahS, int jumlahM, int jumlahL, int jumlahXL, Double harga) {
        String query = "INSERT INTO barang(nama, berat, harga, warna, stok_ukuran_S, stok_ukuran_M, stok_ukuran_L, stok_ukuran_XL) VALUE (?,?,?,?,?,?,?,?)";
        try {
            c.connect();
            PreparedStatement stmt = c.con.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setDouble(2, berat);
            stmt.setDouble(3, harga);
            stmt.setString(4, warna);
            stmt.setInt(5, jumlahS);
            stmt.setInt(6, jumlahM);
            stmt.setInt(7, jumlahL);
            stmt.setInt(8, jumlahXL);
            stmt.execute();
            return "Berhasil tamabah produk!";
        } catch (SQLException e) {
            return "gagal tambah produk!";
        }
    }
}

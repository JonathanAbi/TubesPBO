/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabaseHandler;
import Model.Produk;
import Model.SingletonProduk;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author glenn
 */
public class SingletonProdukContorller {

    SingletonProduk produkS = SingletonProduk.getInstance();

    void getProdukFromDB() {
        produkS.reset();
        DatabaseHandler c = new DatabaseHandler();

        try {
            c.connect();

            PreparedStatement stmt;
            String query = "SELECT * FROM barang";
            stmt = c.con.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                int id = result.getInt("barang_id");
                String nama = result.getString("nama");
                double berat = result.getDouble("berat");
                double harga = result.getDouble("harga");
                String warna = result.getString("warna");
                int s = result.getInt("stok_ukuran_S");
                int m = result.getInt("stok_ukuran_M");
                int l = result.getInt("stok_ukuran_L");
                int xl = result.getInt("stok_ukuran_XL");
                int[] stok = {s, m, l, xl};
                Produk produk = new Produk(nama, berat, warna, stok, harga, id);
                produkS.addProduk(produk);
            }

            c.disconnect();
        } catch (Exception e) {
        }

    }
}

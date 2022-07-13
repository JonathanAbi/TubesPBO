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
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author glenn
 */
public class UpdateStokController {

    SingletonProdukController produkCt = new SingletonProdukController();
    SingletonProduk produkS = SingletonProduk.getInstance();

    public ArrayList<Produk> getProdukList() {
        produkCt.addProdukToSingleton();
        return produkS.getListProduk();
    }

    public String[] getNameList() {
        produkCt.addProdukToSingleton();
        String[] nameList = new String[getProdukList().size()];
        ArrayList<Produk> produkList = getProdukList();
        for (int i = 0; i < nameList.length; i++) {
            nameList[i] = produkList.get(i).getNama();
        }
        return nameList;
    }

    public Produk getProdukByIndex(int i) {
        return getProdukList().get(i);
    }

    public int getProdukStock(int i, int ukuran) {
        return getProdukByIndex(i).getStock()[ukuran];
    }

    public String updateStokToDB(int id, int ukuran, int jumlah) {
        String[] ukuranName = {"stok_ukuran_S", "stok_ukuran_M", "stok_ukuran_L", "stok_ukuran_XL"};
        String query = "UPDATE barang SET " + ukuranName[ukuran] + " = ? WHERE barang_id = ?";
        DatabaseHandler c = new DatabaseHandler();
        try {
            c.connect();
            PreparedStatement stmt = c.con.prepareStatement(query);
            stmt.setInt(1, jumlah);
            stmt.setInt(2, id);
            stmt.execute();
            c.disconnect();
            produkCt.addProdukToSingleton();
            return "Berhasil update stok!";
        } catch (SQLException e) {
            c.disconnect();
            return "gagal update stok!";
        }
    }

}

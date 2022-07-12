package Controller;

import Model.*;
import Database.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.border.MatteBorder;

public class KeranjangController {


    public boolean updateDatabase(ArrayList <Produk> listProduk, ArrayList <UkuranEnum> listUkuran, ArrayList <Integer> listJumlah) {
        boolean berhasil;
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try{
            for (int i = 0; i < listProduk.size(); i++) {
                int index = SingletonKeranjang.getInstance().getListProduk().indexOf(listProduk.get(i));
                int in;
                UkuranEnum ukuran = SingletonKeranjang.getInstance().getUkuranAt(index);
                String pointer;
                switch (ukuran) {
                    case S:
                        pointer = "stok_ukuran_S";
                        in = 0;
                        break;
                    case M:
                        pointer = "stok_ukuran_M";
                        in = 1;
                        break;
                    case L:
                        pointer = "stok_ukuran_L";
                        in = 2;
                        break;
                    default:
                        pointer = "stok_ukuran_XL";
                        in = 3;
                        break;
                }
                PreparedStatement stat = conn.con.prepareStatement("UPDATE barang SET " + pointer + " =  ? WHERE barang_id = ?");
                stat.setInt(1,listProduk.get(i).getStock()[in]);
                stat.setInt(2,listProduk.get(i).getId());
//                stat.setInt(1,SingletonKeranjang.getInstance().getJumlahAt(index));
//                stat.setInt(2,SingletonKeranjang.getInstance().getProdukAt(index).getId());
                stat.executeUpdate();
                EtalasePanelBarangController c = new EtalasePanelBarangController();
                c.getProduk();
                SingletonKeranjang.getInstance().getListProduk().remove(index);
                SingletonKeranjang.getInstance().getUkuran().remove(index);
                SingletonKeranjang.getInstance().getJumlah().remove(index);
                SingletonKeranjang.getInstance().removeLength();
            }
            JOptionPane.showMessageDialog(null, "Berhasil menghapus barang dari keranjang");
            berhasil = true;
        }
        catch (SQLException e){
            berhasil = false;
            JOptionPane.showMessageDialog(null, "Error menghapus barang dari keranjang");
        }
        conn.disconnect();
        return berhasil;
    }
}

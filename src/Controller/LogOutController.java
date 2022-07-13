package Controller;

import Database.DatabaseHandler;
import Model.*;
import View.Etalase;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LogOutController {
    
    public void updateDatabase(ArrayList <Produk> listProduk){
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
                stat.executeUpdate();
                EtalasePanelBarangController c = new EtalasePanelBarangController();
                c.getProduk();
            }
            JOptionPane.showMessageDialog(null, "Berhasil menghapus barang dari keranjang");
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error menghapus barang dari keranjang");
        }
        conn.disconnect();
    }
    
    public LogOutController(){
        updateDatabase(SingletonKeranjang.getInstance().getListProduk());
        SingletonProfile.getInstance().reset();
        SingletonKeranjang.getInstance().reset();
        new Etalase();
    }
}

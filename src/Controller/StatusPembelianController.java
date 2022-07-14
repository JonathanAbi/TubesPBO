package Controller;

import Database.DatabaseHandler;
import Model.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import View.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusPembelianController {
 
    public ArrayList<Pesanan> getPesanan(){
        ArrayList <Pesanan> pesanan = new ArrayList<>();
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try{
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("select * from pesanan where customer_id='" + SingletonProfile.getInstance().getUser().getId() + "'");
            while(result.next()){
                Pesanan temp = new Pesanan(result.getInt("pesanan_id"),result.getInt("barang_id"),result.getInt("jumlah"),UkuranEnum.values()[result.getInt("ukuran")],result.getString("warna"),result.getDouble("harga_total"),result.getDouble("biaya_pengiriman"),PembayaranEnum.values()[result.getInt("jenis_pembayaran")],PengirimanEnum.values()[result.getInt("status_pengiriman")]);
                pesanan.add(temp);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        conn.disconnect();
        return pesanan;
    }
}

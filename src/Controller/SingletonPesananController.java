/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabaseHandler;
import Model.PembayaranEnum;
import Model.PengirimanEnum;
import Model.Pesanan;
import Model.SingletonPesanan;
import Model.UkuranEnum;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author glenn
 */
public class SingletonPesananController {
    SingletonPesanan pesananS = SingletonPesanan.getInstance();
    
    public void addPesananToSingleton() {
        pesananS.reset();
        DatabaseHandler c = new DatabaseHandler();
        try {
            c.connect();
            String query = "SELECT * FROM pesanan";
            PreparedStatement stmt = c.con.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            while(result.next()) {
                int id = result.getInt("pesanan_id");
                int customerId = result.getInt("customer_id");
                int kurirId = result.getInt("kurir_id");
                int alamatId = result.getInt("alamat_id");
                int barangId = result.getInt("barang_id");
                int jumlah = result.getInt("jumlah");
                UkuranEnum ukuran = UkuranEnum.values()[result.getInt("ukuran")];
                String warna = result.getString("warna");
                double hargaSatuan = result.getDouble("harga_satuan");
                double biayaPengiriman = result.getDouble("biaya_pengiriman");
                PembayaranEnum jenisPembayaran = PembayaranEnum.values()[result.getInt("jenis_pembayaran")];
                boolean statusPembayaran = result.getBoolean("status_pembayaran");
                PengirimanEnum statusPengiriman = PengirimanEnum.values()[result.getInt("status_pengiriman")];
                Pesanan pesanan = new Pesanan(id, customerId, kurirId, barangId, alamatId, jumlah, ukuran, warna, hargaSatuan, biayaPengiriman, jenisPembayaran, statusPembayaran, statusPengiriman);
                pesananS.addPesanan(pesanan);
            }
            
            c.disconnect();
        } catch (Exception e) {
        }
    }
}

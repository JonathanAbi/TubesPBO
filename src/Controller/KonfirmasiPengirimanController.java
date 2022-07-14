/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabaseHandler;
import Model.Customer;
import Model.PengirimanEnum;
import Model.Pesanan;
import Model.Produk;
import Model.SingletonCustomer;
import Model.SingletonPesanan;
import Model.SingletonProduk;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author glenn
 */
public class KonfirmasiPengirimanController {

    SingletonPesananController pesananCt = new SingletonPesananController();
    SingletonPesanan pesananS = SingletonPesanan.getInstance();

    public Pesanan getPesananTerdepan() {
        pesananCt.addPesananToSingleton();
        ArrayList<Pesanan> listPesanan = pesananS.getListProduk();
        ArrayList<Pesanan> paket = new ArrayList<>();
        for (Pesanan pesanan : listPesanan) {
            if (pesanan.getStatusPengiriman() == PengirimanEnum.PENGEMASAN) {
                return pesanan;
            }
        }
        return null;
    }
    
    public String getNamaCustomer(int id) {
        SingletonCustomerController customerCt = new SingletonCustomerController();
        SingletonCustomer customerS = SingletonCustomer.getInstance();
        customerCt.addCustomerToDB();
        for (Customer customer : customerS.getListCustomer()) {
            if (customer.getId()==id) {
                return customer.getName();
            }
        }
        return "";
    }
    
    public String getNamaProduk(int id) {
        SingletonProdukController produkCt = new SingletonProdukController();
        SingletonProduk produkS = SingletonProduk.getInstance();
        produkCt.addProdukToSingleton();
        for (Produk produk : produkS.getListProduk()) {
            if (produk.getId()==id) {
                return produk.getNama();
            }
        }
        return null;
    }
    
    public String kirimBarang(int idPesanan) {
        DatabaseHandler c = new DatabaseHandler();
        try {
            c.connect();
            
            String query = "UPDATE pesanan SET status_pengiriman = ? WHERE pesanan_id = ?";
            PreparedStatement stmt = c.con.prepareStatement(query);
            stmt.setInt(1, 1);
            stmt.setInt(2, idPesanan);
            stmt.execute();            
            c.disconnect();
            return "konfirmasi kirim barang berhasil!";
        } catch (Exception e) {
            return "konfirmasi kirim barang gagal!";
        }
    }
}

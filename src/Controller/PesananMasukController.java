/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.PengirimanEnum;
import Model.Pesanan;
import Model.Produk;
import Model.SingletonCustomer;
import Model.SingletonPesanan;
import Model.SingletonProduk;
import java.util.ArrayList;

/**
 *
 * @author glenn
 */
public class PesananMasukController {
    SingletonPesananController pesananCt = new SingletonPesananController();
    SingletonPesanan pesananS = SingletonPesanan.getInstance();
    
    public ArrayList<Pesanan> getPesananMasukList() {
        pesananCt.addPesananToSingleton();
        ArrayList<Pesanan> pesananMasuk = new ArrayList<>();
        for (Pesanan pesanan : pesananS.getListProduk()) {
            if (pesanan.getStatusPengiriman() == PengirimanEnum.PENGEMASAN) {
                pesananMasuk.add(pesanan);
            }
        }
        return pesananMasuk;
    }
    public Customer getCustomer(int customerId) {
        SingletonCustomerController customerCt = new SingletonCustomerController();
        SingletonCustomer customerS = SingletonCustomer.getInstance();
        customerCt.addCustomerToDB();
        
        for (Customer customer : customerS.getListCustomer()) {
            if (customer.getId()==customerId) {
                return customer;
            }
        }
        return null;
    }
    
    public Produk getProduk(int produkId) {
        SingletonProdukController produkCt = new SingletonProdukController();
        SingletonProduk produkS = SingletonProduk.getInstance();
        produkCt.addProdukToSingleton();
        for (Produk produk : produkS.getListProduk()) {
            if (produk.getId()==produkId) {
                return produk;
            }
        }
        return null;
    }
}

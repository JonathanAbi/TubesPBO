/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.Pesanan;
import Model.Produk;
import Model.SingletonCustomer;
import Model.SingletonPesanan;
import Model.SingletonProduk;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author glenn
 */
public class RiwayatPenjualanController {
    SingletonPesananController pesananCt = new SingletonPesananController();
    SingletonPesanan pesananS = SingletonPesanan.getInstance();
    
    public ArrayList<Pesanan> getPesananList() {
        pesananCt.addPesananToSingleton();
        return pesananS.getListProduk();
    }
    public Customer getCustomer(int customerId) {
        SingletonCustomerController customerCt = new SingletonCustomerController();
        SingletonCustomer customerS = SingletonCustomer.getInstance();
        customerCt.addCustomerToDB();
        JOptionPane.showMessageDialog(null, "cuslist length-- "+customerS.getListCustomer().size());
        
//        for (int i = 0; i < customerS.getListCustomer().size(); i++) {
//            Customer customer = customerS.getListCustomer().get(i);
//        }
//        for (Customer customer : customerS.getListCustomer()) {
//            JOptionPane.showMessageDialog(null, "masuk loop");
//            if (customer.getId()==customerId) {
//                return customer;
//            }
//        }
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

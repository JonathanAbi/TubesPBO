/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Produk;
import Model.SingletonProduk;
import java.util.ArrayList;
/**
 *
 * @author glenn
 */
public class UpdateHargaController {
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
}

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
public class UpdateStokController {
    SingletonProduk produkS = SingletonProduk.getInstance();
    
    public ArrayList<Produk> getProdukList() {
        return produkS.getListProduk();        
    }
    public String[] getNameList() {
        String[] nameList = new String[getProdukList().size()];
        ArrayList<Produk> produkList = getProdukList();
        for (int i = 0; i < nameList.length; i++) {
            nameList[i] = produkList.get(i).getNama();
            System.out.println("masuk");
        }
        return nameList;
    }
}

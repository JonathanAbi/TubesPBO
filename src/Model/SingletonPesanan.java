/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author glenn
 */
public class SingletonPesanan {
    private static SingletonPesanan instance;
    private ArrayList<Pesanan> listPesanan = new ArrayList<>();
    
    public static SingletonPesanan getInstance() {
        if (instance == null) {
            instance = new SingletonPesanan();
        }
        return instance;
    }
    
    public void reset(){
        this.listPesanan = new ArrayList<>();
    }
    
    public ArrayList<Pesanan> getListProduk(){
        return listPesanan;
    }
    
    public Pesanan getProduk(int index){
        return listPesanan.get(index);
    }
    
    public void addProduk(Pesanan p){
        this.listPesanan.add(p);
    }
}

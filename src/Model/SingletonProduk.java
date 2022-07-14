package Model;

import java.util.ArrayList;

public class SingletonProduk {
    private static SingletonProduk instance;
    private ArrayList<Produk> listProduk = new ArrayList<>();
    
    private SingletonProduk(){
        
    }
    
    public static SingletonProduk getInstance(){
        if(instance == null){
            instance = new SingletonProduk();
        }
        return instance;
    }
    
    public void reset(){
        this.listProduk = new ArrayList<>();
    }
    
    public ArrayList<Produk> getListProduk(){
        return listProduk;
    }
    
    public Produk getProduk(int index){
        return listProduk.get(index);
    }
    
    public void addProduk(Produk p){
        this.listProduk.add(p);
    }
}

package Model;

import java.util.ArrayList;


public class SingletonKeranjang {
    private static SingletonKeranjang instance;
    private ArrayList <Produk> listProduk = new ArrayList<>();
    private ArrayList <UkuranEnum> ukuran = new ArrayList<>();
    private ArrayList <Integer> jumlah = new ArrayList<>();
    int length = 0;
    
    private SingletonKeranjang(){
        
    }
    
    public static SingletonKeranjang getInstance(){
        if(instance == null){
            instance = new SingletonKeranjang();
        }
        return instance;
    }
    
    public void reset(){
        this.listProduk = new ArrayList<>();
        this.ukuran = new ArrayList<>();
        this.jumlah = new ArrayList<>();
    }
    
    public void addLength(){
        this.length++;
    }
    
    public int getLength(){
        return length;
    }
    
    public Produk getProduk(int index) {
        return listProduk.get(index);
    }
    
    public void addBarang(Produk p){
        addLength();
        this.listProduk.add(p);
    }
    
    public UkuranEnum getUkuran(int index) {
        return ukuran.get(index);
    }

    public void addUkuran(UkuranEnum ukuran) {
        this.ukuran.add(ukuran);
    }

    public int getJumlah(int index) {
        return jumlah.get(index);
    }
    
    public void addJumlah(int jumlah) {
        this.jumlah.add(jumlah);
    }
    
    public void hapusBarang(int index){
        this.jumlah.remove(index);
        this.ukuran.remove(index);
        this.listProduk.remove(index);
        this.length--;
    }
}

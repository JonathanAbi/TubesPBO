
package Model;

import java.util.ArrayList;

public class Etalase {
    ArrayList<Produk> listProduk;

    public Etalase(ArrayList<Produk> listProduk) {
        this.listProduk = listProduk;
    }

    public ArrayList<Produk> getListProduk() {
        return listProduk;
    }

    public void setListProduk(ArrayList<Produk> listProduk) {
        this.listProduk = listProduk;
    }
    
}

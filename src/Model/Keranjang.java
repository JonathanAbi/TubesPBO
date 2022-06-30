
package Model;

import java.util.ArrayList;

public class Keranjang {
    ArrayList<Produk> listBarang;

    public Keranjang(ArrayList<Produk> listBarang) {
        this.listBarang = listBarang;
    }

    public ArrayList<Produk> getListBarang() {
        return listBarang;
    }

    public void setListBarang(ArrayList<Produk> listBarang) {
        this.listBarang = listBarang;
    }
    
}

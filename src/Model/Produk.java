
package Model;

public class Produk{
    private int id;
    private String nama;
    private Double berat;
    private String warna;
    private int[] stock;
    private Double harga;

    public Produk(String nama, Double berat, String warna, int[] stock, Double harga, int id) {
        this.id = id;
        this.nama = nama;
        this.berat = berat;
        this.warna = warna;
        this.stock = stock;
        this.harga = harga;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Double getBerat() {
        return berat;
    }

    public void setBerat(Double berat) {
        this.berat = berat;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public int[] getStock() {
        return stock;
    }

    public void setStock(int[] stock) {
        this.stock = stock;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }
    
}

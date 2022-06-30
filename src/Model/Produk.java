
package Model;

public class Produk extends Thing{
    private String nama;
    private String berat;
    private String warna;
    private int[] stock;
    private Double harga;

    public Produk(String nama, String berat, String warna, int[] stock, Double harga, int id) {
        super(id);
        this.nama = nama;
        this.berat = berat;
        this.warna = warna;
        this.stock = stock;
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
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

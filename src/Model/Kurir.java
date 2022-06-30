
package Model;

public class Kurir extends Regular{
    private Double kapasitasBeratBarang;
    private Double beratBarangBawaan;

    public Kurir(Double kapasitasBeratBarang, Double beratBarangBawaan, String telepon, String name, String username, String password, int id) {
        super(telepon, name, username, password, id);
        this.kapasitasBeratBarang = kapasitasBeratBarang;
        this.beratBarangBawaan = beratBarangBawaan;
    }

    public Double getKapasitasBeratBarang() {
        return kapasitasBeratBarang;
    }

    public void setKapasitasBeratBarang(Double kapasitasBeratBarang) {
        this.kapasitasBeratBarang = kapasitasBeratBarang;
    }

    public Double getBeratBarangBawaan() {
        return beratBarangBawaan;
    }

    public void setBeratBarangBawaan(Double beratBarangBawaan) {
        this.beratBarangBawaan = beratBarangBawaan;
    }
    
}

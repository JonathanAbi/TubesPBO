
package Model;

public class Pesanan{
    private int id;
    private int customerId;
    private int kurirId;
    private int barangId;
    private int alamatId;
    private int jumlah;
    private UkuranEnum ukuran;
    private String warna;
    private Double hargaTotal;
    private Double biayaPengiriman;
    private PembayaranEnum jenisPembayaran;
    private boolean statusPembayaran;
    private PengirimanEnum statusPengiriman;
    
    public Pesanan(int id, int customerId, int kurirId, int barangId, int alamatId, int jumlah, UkuranEnum ukuran, String warna, Double hargaSatuan, Double biayaPengiriman, PembayaranEnum jenisPembayaran, boolean statusPembayaran, PengirimanEnum statusPengiriman) {
        this.id = id;
        this.customerId = customerId;
        this.kurirId = kurirId;
        this.barangId = barangId;
        this.alamatId = alamatId;
        this.jumlah = jumlah;
        this.ukuran = ukuran;
        this.warna = warna;
        this.hargaTotal = hargaSatuan;
        this.biayaPengiriman = biayaPengiriman;
        this.jenisPembayaran = jenisPembayaran;
        this.statusPembayaran = statusPembayaran;
        this.statusPengiriman = statusPengiriman;
    }

    

    public Pesanan(int id, int barangID,int jumlah, UkuranEnum ukuran, String warna, Double hargaTotal, Double biayaPengiriman, PembayaranEnum jenisPembayaran, PengirimanEnum statusPengiriman) {
        this.id = id;
        this.jumlah = jumlah;
        this.ukuran = ukuran;
        this.warna = warna;
        this.hargaTotal = hargaTotal;
        this.biayaPengiriman = biayaPengiriman;
        this.jenisPembayaran = jenisPembayaran;
        this.barangId = barangID;
        this.statusPengiriman = statusPengiriman;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getKurirId() {
        return kurirId;
    }

    public void setKurirId(int kurirId) {
        this.kurirId = kurirId;
    }

    public int getBarangId() {
        return barangId;
    }

    public void setBarangId(int barangId) {
        this.barangId = barangId;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public UkuranEnum getUkuran() {
        return ukuran;
    }

    public void setUkuran(UkuranEnum ukuran) {
        this.ukuran = ukuran;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public Double getHargaTotal() {
        return hargaTotal;
    }

    public void setHargaTotal(Double hargaTotal) {
        this.hargaTotal = hargaTotal;
    }

    public Double getBiayaPengiriman() {
        return biayaPengiriman;
    }

    public void setBiayaPengiriman(Double biayaPengiriman) {
        this.biayaPengiriman = biayaPengiriman;
    }

    public PembayaranEnum getJenisPembayaran() {
        return jenisPembayaran;
    }

    public void setJenisPembayaran(PembayaranEnum jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }

    public boolean isStatusPembayaran() {
        return statusPembayaran;
    }

    public void setStatusPembayaran(boolean statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }

    public PengirimanEnum getStatusPengiriman() {
        return statusPengiriman;
    }

    public void setStatusPengiriman(PengirimanEnum statusPengiriman) {
        this.statusPengiriman = statusPengiriman;
    }

    public void setAlamatId(int alamatId) {
        this.alamatId = alamatId;
    }

    public int getAlamatId() {
        return alamatId;
    }
}

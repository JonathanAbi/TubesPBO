package Model;

public class Alamat {

    private String alamatLengkap;
    private String kelurahan;
    private String kecamatan;
    private String kota;
    private String provinsi;
    private String kodePos;
    private AlamatEnum status;

    public Alamat() {

    }

    public Alamat(String alamatLengkap, String kelurahan, String kecamatan, String kota, String provinsi, String kodePos, int status) {
        this.alamatLengkap = alamatLengkap;
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.kota = kota;
        this.provinsi = provinsi;
        this.kodePos = kodePos;
        if (status == 0) {
            this.status = AlamatEnum.PERMANENT;
        } else {
            this.status = AlamatEnum.TEMPORARY;
        }
    }

    public String getAlamatLengkap() {
        return alamatLengkap;
    }

    public void setAlamatLengkap(String alamatLengkap) {
        this.alamatLengkap = alamatLengkap;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public AlamatEnum getStatus() {
        return status;
    }

    public void setStatus(int status) {
        if (status == 0) {
            this.status = AlamatEnum.PERMANENT;
        } else {
            this.status = AlamatEnum.TEMPORARY;
        }
    }

}

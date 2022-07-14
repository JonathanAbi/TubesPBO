
package Model;

public enum PengirimanEnum {
    PENGEMASAN,MENUNGGU_KURIR,DIANTAR,SAMPAI;
    public String getString() {
        if (this == PENGEMASAN) {
            return "Pengemasan";
        } else if(this == MENUNGGU_KURIR) {
            return "Menunggu Kurir";
        } else if(this == DIANTAR) {
            return "Diantar";
        } else {
            return "Sampai";
        }
    }
}

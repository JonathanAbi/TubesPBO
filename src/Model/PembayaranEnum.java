
package Model;

public enum PembayaranEnum {
    TRANSFER_BANK,COD,OVO,GOPAY,DANA;
    
    public String getString() {
        if (this==TRANSFER_BANK) {
            return "Transfer Bank";
        } else if(this == COD) {
            return "COD";
        } else if(this == OVO) {
            return "OVO";
        } else if(this == GOPAY) {
            return "GoPay";
        } else {
            return "DANA";
        }
    }
}

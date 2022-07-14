
package Controller;

import Database.DatabaseHandler;
import Model.PembayaranEnum;
import Model.Pesanan;
import Model.SingletonProfile;
import Model.UkuranEnum;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RiwayatPembelianController {
    public ArrayList<Pesanan> getRiwayat(){
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        ArrayList<Pesanan> riwayatPembelian = new ArrayList<>();
        try{
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("select * from pesanan where customer_id='" + SingletonProfile.getInstance().getUser().getId() + "' and status_pengiriman = 3");
            while(result.next()){
                Pesanan temp = new Pesanan(result.getInt("pesanan_id"),result.getInt("barang_id"),result.getInt("jumlah"),UkuranEnum.values()[result.getInt("ukuran")],result.getString("warna"),result.getDouble("harga_total"),result.getDouble("biaya_pengiriman"),PembayaranEnum.values()[result.getInt("jenis_pembayaran")]);
                riwayatPembelian.add(temp);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return riwayatPembelian;
    }
}

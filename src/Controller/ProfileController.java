package Controller;

import Database.DatabaseHandler;
import Model.Alamat;
import Model.AlamatEnum;
import Model.Customer;
import Model.SingletonProfile;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProfileController {

    Customer customer = (Customer) SingletonProfile.getInstance().getUser();
    int index = 0;
    String query;

    public int cariIndexAlamat() {
        for (int i = 0; i < customer.getAlamat().size(); i++) {
            Alamat temp = customer.getAlamat().get(i);
            if (temp.getStatus() == AlamatEnum.PERMANENT) {
                index = i;
                break;
            }
        }
        return index;
    }

    public String update(String nama, String userName, String pass, String telepon, String alamat, String kelurahan, String kecamatan, String kota, String provinsi, String kodePos) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String tempPass=pass;
        pass = Hasher.password(pass);
        try {
            java.sql.Statement stat = conn.con.createStatement();
            stat.executeUpdate("update customers set nama='" + nama + "',username='" + userName + "',pass='" + pass + "',telepon='" + telepon + "' where customer_id=" + customer.getId());
            stat.executeUpdate("update alamat set alamat='" + alamat + "',kelurahan='" + kelurahan + "',kecamatan='" + kecamatan + "',kota='" + kota + "',provinsi='" + provinsi + "',kode_post='" + kodePos + "' where customer_id=" + customer.getId());
            customer.setName(nama);
            customer.setUsername(userName);
            customer.setPassword(tempPass);
            customer.setTelepon(telepon);
            customer.getAlamat().get(index).setAlamatLengkap(alamat);
            customer.getAlamat().get(index).setKecamatan(kecamatan);
            customer.getAlamat().get(index).setKelurahan(kelurahan);
            customer.getAlamat().get(index).setKota(kota);
            customer.getAlamat().get(index).setProvinsi(provinsi);
            customer.getAlamat().get(index).setKodePos(kodePos);
            return "Berhasil melakukan update data";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Gagal melakukan update data";
        }
    }
}

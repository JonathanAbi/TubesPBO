package Controller;

import Database.DatabaseHandler;
import Model.Alamat;
import Model.Customer;
import Model.SingletonProfile;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TambahAlamatController {
    
    public String tambahAlamat(String alamat, String kelurahan, String kecamatan, String kota, String provinsi, String kodePos) {
        String query;
        try {
            DatabaseHandler conn = new DatabaseHandler();
            conn.connect();
            PreparedStatement stmt;
            ResultSet result;
            query = "INSERT INTO alamat(alamat_status,customer_id,alamat,kelurahan,kecamatan,kota,provinsi,kode_post) VALUES(?,?,?,?,?,?,?,?)";
            stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, 1);
            stmt.setInt(2, SingletonProfile.getInstance().getUser().getId());
            stmt.setString(3, alamat);
            stmt.setString(4, kelurahan);
            stmt.setString(5, kecamatan);
            stmt.setString(6, kota);
            stmt.setString(7, provinsi);
            stmt.setString(8, kodePos);
            stmt.executeUpdate();
            ArrayList<Alamat> listAlamat = new ArrayList<>();
            result = stmt.executeQuery("select * from alamat where customer_id='" + SingletonProfile.getInstance().getUser().getId() + "'");
            while (result.next()) {
                Alamat temp = new Alamat(result.getInt("alamat_id"), result.getString("alamat"), result.getString("kelurahan"), result.getString("kecamatan"), result.getString("kota"), result.getString("provinsi"), result.getString("kode_post"), result.getInt("alamat_status"));
                listAlamat.add(temp);
            }
            Customer customer = (Customer) SingletonProfile.getInstance().getUser();
            customer.setAlamat(listAlamat);
            return "Berhasil tambah alamat";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Gagal tambah alamat";
        }
    }
}

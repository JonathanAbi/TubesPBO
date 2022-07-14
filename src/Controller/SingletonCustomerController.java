/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.DatabaseHandler;
import Model.Alamat;
import Model.AlamatEnum;
import Model.Customer;
import Model.SingletonCustomer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author glenn
 */
public class SingletonCustomerController {
    SingletonCustomer customerS = SingletonCustomer.getInstance();

    public void addCustomerToSingleton() {
        customerS.reset();
        DatabaseHandler c = new DatabaseHandler();

        try {
            c.connect();

            PreparedStatement stmt;
            String query = "SELECT * FROM customers";
            stmt = c.con.prepareStatement(query);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                String name = result.getString("nama");
                String username = result.getString("username");
                String password = result.getString("pass");
                String alamat = result.getString("alamat");
                int id = result.getInt("customer_id");
                ArrayList<Alamat> listAlamat = getAlamatList(id);
                String telepon = result.getString("telepon");
                Customer customer = new Customer(listAlamat, telepon, name, username, password, id);
                customerS.addCustomer(customer);
            }

            c.disconnect();
        } catch (Exception e) {
        }

    }
    
    ArrayList<Alamat> getAlamatList(int customerId) {
        ArrayList<Alamat> listAlamat = new ArrayList<>();
        DatabaseHandler c = new DatabaseHandler();
        
        try {
            c.connect();
            
            String query = "SELECT * FROM alamat WHERE customer_id = ?";
            PreparedStatement stmt = c.con.prepareStatement(query);
            stmt.setInt(1, customerId);
            ResultSet result = stmt.executeQuery();
            while(result.next()) {
                int id = result.getInt("alamat_id");
                String alamatLengkap = result.getString("alamat");
                String kelurahan = result.getString("kelurahan");
                String kecamatan = result.getString("kecamatan");
                String kota = result.getString("kota");
                String provinsi = result.getString("provinsi");
                String kodePos = result.getString("kodePos");
                int alamatStatus = result.getInt("alamat_status");
                Alamat alamat = new Alamat(id, alamatLengkap, kelurahan, kecamatan, kota, provinsi, kodePos, alamatStatus);
                listAlamat.add(alamat);
            }
            c.disconnect();
        } catch (Exception e) {
            c.disconnect();
        }
        return listAlamat;
    }
}

package Controller;

import Model.*;
import java.util.ArrayList;
import Database.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EtalaseController {
    
    public ArrayList <Produk> getProduk(){
        ArrayList <Produk> listProduk = new ArrayList<>();
        Produk produk;
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try{
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("select * from barang");
            while(result.next()){
                int id = result.getInt("barang_id");
                String nama = result.getString("nama");
                String berat = String.valueOf(result.getDouble("berat"));
                String warna = result.getString("warna");
                int[] stock = new int[4];
                stock[0] = result.getInt("stok_ukuran_S");
                stock[1] = result.getInt("stok_ukuran_M");
                stock[2] = result.getInt("stok_ukuran_L");
                stock[3] = result.getInt("stok_ukuran_XL");
                Double harga = result.getDouble("harga");
                produk = new Produk(nama, berat, warna, stock, harga, id);
                listProduk.add(produk);
            }
        }
        catch (SQLException e){
            
        }
        
        
        return listProduk;
    }
    
    
    public JPanel getPanelBarang(int iterasi){
        ArrayList <Produk> listProduk = getProduk();
        //panel utama
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));
        for (int i = 0; i < 4; i++) {
            if(iterasi+i > listProduk.size()){
                break;
            }
            Produk produk = listProduk.get(iterasi+i);
            JPanel panelBarang = new JPanel();
            panel.setSize(250,300);
            panel.setLayout(null);
            
            String txt = produk.getNama() + " - " + produk.getWarna();
            JLabel lblNamaProduk = new JLabel(txt);
            lblNamaProduk.setBounds(10,100,230,50);
            lblNamaProduk.setFont(new Font("Serif", Font.PLAIN, 20));
            
            JButton btn = new JButton("Add to Cart");
            btn.setFont(new Font("Serif", Font.PLAIN, 10));
            btn.setBounds(150,225,75,50);
            
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                }
            });
        }
        
        return panel;
    }
}

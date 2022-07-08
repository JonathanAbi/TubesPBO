package Controller;

import Model.*;
import java.util.ArrayList;
import Database.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.*;
import javax.swing.JSpinner.DefaultEditor;

public class EtalasePanelBarangController {
    UkuranEnum ukuran;
    JSpinner jumlah;
    int[] stok = new int[4];
    int in;
    String pointerDB = "";
    
    public void updateDatabase(String pointer, int id, int stokBaru){
        System.out.println("Masuk update database");
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try{
            PreparedStatement stat = conn.con.prepareStatement("UPDATE barang SET " + pointer + " =  ? WHERE barang_id = ?");
            stat.setInt(1, stokBaru);
            stat.setInt(2,id);
            stat.executeUpdate();
            getProduk();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error update barang ke database");
        }
        conn.disconnect();
    }
    
    public void getProduk(){
        Produk produk;
        SingletonProduk.getInstance().reset();
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
                SingletonProduk.getInstance().addProduk(produk);
            }
        }
        catch (SQLException e){
            
        }
        conn.disconnect();
    }
    
    public void updateStok(int index){
        Produk temp = SingletonProduk.getInstance().getProduk(index);
        stok = temp.getStock();
    }
    
    public JPanel getPanelBarang(int index) {
        JPanel panelBarang = new JPanel();
        ukuran = null;
        Produk produk = SingletonProduk.getInstance().getProduk(index);
        stok = produk.getStock();
        panelBarang = new JPanel();
        panelBarang.setSize(250, 300);
        panelBarang.setBackground(Color.WHITE);
        panelBarang.setLayout(null);

        //label nama
        String txt = produk.getNama() + " - " + produk.getWarna();
        JLabel lblNamaProduk = new JLabel(txt);
        lblNamaProduk.setBounds(10, 215, 200, 25);
        lblNamaProduk.setFont(new Font("Serif", Font.PLAIN, 22));

        //label harga
        JLabel lblHarga = new JLabel("Rp. " + String.valueOf(produk.getHarga()));
        lblHarga.setBounds(10, 240, 120, 20);
        lblHarga.setFont(new Font("Serif", Font.PLAIN, 17));

        //radio button
        JRadioButton radioS = new JRadioButton("S");
        radioS.setBounds(10, 260, 40, 20);
        radioS.setBackground(Color.WHITE);
        radioS.setFont(new Font("Serif", Font.PLAIN, 15));

        JRadioButton radioM = new JRadioButton("M");
        radioM.setBounds(50, 260, 40, 20);
        radioM.setBackground(Color.WHITE);
        radioM.setFont(new Font("Serif", Font.PLAIN, 15));

        JRadioButton radioL = new JRadioButton("L");
        radioL.setBounds(90, 260, 40, 20);
        radioL.setBackground(Color.WHITE);
        radioL.setFont(new Font("Serif", Font.PLAIN, 15));

        JRadioButton radioXL = new JRadioButton("XL");
        radioXL.setBounds(130, 260, 50, 20);
        radioXL.setBackground(Color.WHITE);
        radioXL.setFont(new Font("Serif", Font.PLAIN, 15));

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radioS);
        radioGroup.add(radioM);
        radioGroup.add(radioL);
        radioGroup.add(radioXL);

        radioS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                in = 0;
                ukuran = UkuranEnum.S;
                pointerDB = "stok_ukuran_S";
            }
        });

        radioM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                in = 1;
                ukuran = UkuranEnum.M;
                pointerDB = "stok_ukuran_M";
            }
        });

        radioL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                in = 2;
                ukuran = UkuranEnum.L;
                pointerDB = "stok_ukuran_L";
            }
        });

        radioXL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                in = 3;
                ukuran = UkuranEnum.XL;
                pointerDB = "stok_ukuran_XL";
            }
        });

        //button add to cart
        JButton btn = new JButton("+");
        btn.setFont(new Font("Serif", Font.PLAIN, 10));
        btn.setBounds(190, 225, 50, 50);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int jmlhBeli = (Integer)jumlah.getValue();
                if (ukuran == null) {
                    JOptionPane.showMessageDialog(null, "Mohon pilih ukuran terlebih dahulu");
                }else if(stok[in] == 0){
                    JOptionPane.showMessageDialog(null, "Maaf untuk ukuran tersebut stok habis");
                }else if(jmlhBeli == 0){
                    JOptionPane.showMessageDialog(null, "Jumlah beli harus lebih dari 0!!");
                }else if(jmlhBeli > stok[in]){
                    JOptionPane.showMessageDialog(null, "Maaf untuk ukuran tersebut stok tersisa " + stok[in]);
                } else {
                    try{
                        SingletonKeranjang.getInstance().addBarang(produk);
                        SingletonKeranjang.getInstance().addUkuran(ukuran);
                        SingletonKeranjang.getInstance().addJumlah(jmlhBeli);
                        updateDatabase(pointerDB, produk.getId(),stok[in]-jmlhBeli);
                        updateStok(index);
                    }catch(Exception a){
                        JOptionPane.showMessageDialog(null, "Maaf gagal menambahkan barang ke dalam keranjang");
                    }
                }
            }
        });

        //Spinner jumlah
        jumlah = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        jumlah.setBounds(135, 240, 40, 20);
        ((DefaultEditor) jumlah.getEditor()).getTextField().setEditable(false);

        //input panel
        panelBarang.add(lblNamaProduk);
        panelBarang.add(lblHarga);
        panelBarang.add(radioS);
        panelBarang.add(radioM);
        panelBarang.add(radioL);
        panelBarang.add(radioXL);
        panelBarang.add(jumlah);
        panelBarang.add(btn);
        return panelBarang;
    }
    
}

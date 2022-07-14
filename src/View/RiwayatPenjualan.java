/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.RiwayatPenjualanController;
import Model.Customer;
import Model.Pesanan;
import Model.Produk;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author glenn
 */
public class RiwayatPenjualan {
    JFrame frame;
    JTable table;
    RiwayatPenjualanController riwayat = new RiwayatPenjualanController();
    
    
    public static void main(String[] args) {
        new RiwayatPenjualan();
    }
    RiwayatPenjualan() {
        frame = new JFrame("Tambah Produk");
        frame.setSize(450, 490);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel title, namaProdukLb, beratLb, hargaLb, ukuranLb, warnaLb, sLb, mLb, lLb, xlLb;
        Font titleF = new Font("Sans Serif", Font.BOLD, 35);

        title = new JLabel("Riwayat Penjualan");
        title.setFont(titleF);
        title.setBounds(0, 0, 450, 37);
        title.setHorizontalAlignment(JLabel.CENTER);
        frame.add(title);
        
        String[] column = {"ID Pesanan", "Nama", "Produk", "Ukuran", "Jumlah", "Harga Total", "Status Pengiriman"};
        ArrayList<Pesanan> pesananList = riwayat.getPesananList();
        String[][] rData = new String[pesananList.size()][column.length];//row and column
        for (int i = 0; i < rData.length; i++) {
            System.out.println("masuk");
            Pesanan pesanan = pesananList.get(i);
            rData[i][0] = pesanan.getId()+"";
            Customer customer = riwayat.getCustomer(pesanan.getCustomerId());
            rData[i][1] = customer.getName();
            Produk produk = riwayat.getProduk(pesanan.getBarangId());
            rData[i][2] = produk.getNama();
            rData[i][3] = pesanan.getUkuran().getString();
            rData[i][4] = pesanan.getJumlah()+"";
            rData[i][5] = pesanan.getHargaTotal()+"";
            rData[i][6] = pesanan.getStatusPengiriman().getString();
        }
        table = new JTable(rData, column);
        table.setBounds(40, 0, 450, 450);
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

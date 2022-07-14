/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author glenn
 */
public class RiwayatPenjualan {
    JFrame frame;
    JTable table;
    
    
    
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
        
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

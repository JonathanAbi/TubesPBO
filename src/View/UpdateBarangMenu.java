/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;



/**
 *
 * @author glenn
 */
public class UpdateBarangMenu extends JFrame implements ActionListener {
    JFrame frame;
    JButton uStok, uHarga, uTambahProduk;
    public static void main(String[] args) {
        new UpdateBarangMenu();
    }
    public UpdateBarangMenu() {
        frame = new JFrame("Menu Update Barang");
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font title = new Font("Sans Serif", Font.BOLD, 30);
        frame.setLayout(null);
        
        int btWidth = 300;
        int btHeight = 90;
        uStok = new JButton("Update Stock");
        uStok.setBounds(43, 0, btWidth, btHeight);
        uStok.setFont(title);
        frame.add(uStok);
        
        uHarga = new JButton("Update Harga");
        uHarga.setBounds(43, btHeight+5, btWidth, btHeight);
        uHarga.setFont(title);
        frame.add(uHarga);
        
        uTambahProduk = new JButton("Tambah Produk");
        uTambahProduk.setBounds(43, (btHeight*2)+10, btWidth, btHeight);
        uTambahProduk.setFont(title);
        frame.add(uTambahProduk);
        
        
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==uStok) {
            new UpdateHarga();
        } else if(e.getSource()==uHarga) {
            new UpdateStock();
        } else if(e.getSource()==uTambahProduk) {
            new TambahProduk();
        }
    } 
}

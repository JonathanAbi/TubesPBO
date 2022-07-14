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
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author glenn
 */
public class RiwayatPenjualan extends JFrame implements MouseListener{
    JFrame frame;
    JTable table;
    JLabel exit;
    RiwayatPenjualanController riwayat = new RiwayatPenjualanController();
    
    
    public static void main(String[] args) {
        new RiwayatPenjualan();
    }
    RiwayatPenjualan() {
        frame = new JFrame("Riwayat Penjualan");
        frame.setSize(1100, 490);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        
        String[] column = {"ID Pesanan", "Nama", "Produk", "Ukuran", "Jumlah", "Harga Total", "Status Pengiriman"};
        ArrayList<Pesanan> pesananList = riwayat.getPesananList();
        String[][] rData = new String[pesananList.size()][column.length];
        for (int i = rData.length-1; i >= 0; i--) {
            Pesanan pesanan = pesananList.get(i);
            rData[i][0] = pesanan.getId()+"";
            int cutomerId = pesanan.getCustomerId();
            Customer customer = riwayat.getCustomer(cutomerId);
            rData[i][1] = customer.getName();
            int produkId = pesanan.getBarangId();
            Produk produk = riwayat.getProduk(produkId);
            rData[i][2] = produk.getNama();
            rData[i][3] = pesanan.getUkuran().getString();
            rData[i][4] = pesanan.getJumlah()+"";
            rData[i][5] = pesanan.getHargaTotal()+"";
            rData[i][6] = pesanan.getStatusPengiriman().getString();
        }
        table = new JTable(rData, column);
        JScrollPane sp = new JScrollPane(table);
        table.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        table.setRowHeight(30);
        table.setEnabled(false);
        
        exit = new JLabel("<<Kembali ke menu admin");
        exit.setBounds(30, 420, 170, 18);
        frame.add(exit);
        
        exit.addMouseListener(this);
        
        frame.add(sp);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == exit) {
            frame.dispose();
            new MenuAdmin();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == exit) {
            exit.setForeground(Color.red);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == exit) {
            exit.setForeground(Color.black);
        }
    }
}

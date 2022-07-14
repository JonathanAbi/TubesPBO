/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author glenn
 */
public class MenuAdmin extends JFrame implements ActionListener, MouseListener{
    JLabel exit;
    JFrame frame;
    JButton bUpdate, bRiwayat, bKonfirmasi, bPesananMasuk, bTambahKurir;
    
    public static void main(String[] args) {
        new MenuAdmin();
    }
    
    MenuAdmin() {
        frame = new JFrame("Menu Admin");
        frame.setSize(480, 460);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        int btWidth = 300;
        int btHeight = 50;
        
        Font titleF = new Font("Sans Serif", Font.BOLD, 35);
        Font regularF = new Font("Sans Serif", Font.PLAIN, 25);
        
        JLabel title = new JLabel("Menu Admin");
        title.setBounds(43, 0, 400, 40);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(titleF);
        frame.add(title);
        
        
        bUpdate = new JButton("Update Produk");
        bUpdate.setBounds(85, 50, btWidth, btHeight);
        bUpdate.setFont(regularF);
        frame.add(bUpdate);
        
        bRiwayat = new JButton("Riwayat Penjualan");
        bRiwayat.setBounds(85, 110, btWidth, btHeight);
        bRiwayat.setFont(regularF);
        frame.add(bRiwayat);
        
        bKonfirmasi = new JButton("Konfirmasi Pengiriman");
        bKonfirmasi.setBounds(85, 170, btWidth, btHeight);
        bKonfirmasi.setFont(regularF);
        frame.add(bKonfirmasi);
        
        bPesananMasuk = new JButton("Pesanan Masuk");
        bPesananMasuk.setBounds(85, 230, btWidth, btHeight);
        bPesananMasuk.setFont(regularF);
        frame.add(bPesananMasuk);
        
        bTambahKurir = new JButton("Tambah Kurir");
        bTambahKurir.setBounds(85, 290, btWidth, btHeight);
        bTambahKurir.setFont(regularF);
        frame.add(bTambahKurir);
        
        exit = new JLabel("<Logout>");
        exit.setFont(regularF);
        exit.setBounds(40, 360, 170, 35);
        frame.add(exit);
        
        exit.addMouseListener(this);
        
        bUpdate.addActionListener(this);
        bRiwayat.addActionListener(this);
        bKonfirmasi.addActionListener(this);
        bPesananMasuk.addActionListener(this);
        bTambahKurir.addActionListener(this);
        
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        if (e.getSource()==bUpdate) {
            new UpdateBarangMenu();
        } else if(e.getSource()==bRiwayat) {
            new RiwayatPenjualan();
        } else if(e.getSource()==bKonfirmasi) {
            new KonfirmasiPengiriman();
        } else if(e.getSource()==bPesananMasuk) {
            new PesananMasuk();
        } else if(e.getSource()==bTambahKurir) {
            new TambahKurir();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == exit) {
            frame.dispose();
            new ChooseLogin();
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

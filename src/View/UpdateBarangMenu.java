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
public class UpdateBarangMenu extends JFrame implements ActionListener, MouseListener {

    JFrame frame;
    JButton uStok, uHarga, uTambahProduk;
    JLabel exit;

    public static void main(String[] args) {
        new UpdateBarangMenu();
    }

    public UpdateBarangMenu() {
        frame = new JFrame("Menu Update Barang");
        frame.setSize(400, 380);
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
        uHarga.setBounds(43, btHeight + 5, btWidth, btHeight);
        uHarga.setFont(title);
        frame.add(uHarga);

        uTambahProduk = new JButton("Tambah Produk");
        uTambahProduk.setBounds(43, (btHeight * 2) + 10, btWidth, btHeight);
        uTambahProduk.setFont(title);
        frame.add(uTambahProduk);
        
        exit = new JLabel("<<Kembali ke menu admin");
        exit.setBounds(20, 300, 170, 18);
        frame.add(exit);
        
        exit.addMouseListener(this);

        uStok.addActionListener(this);
        uHarga.addActionListener(this);
        uTambahProduk.addActionListener(this);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == uStok) {
            frame.dispose();
            new UpdateStock();
        } else if (e.getSource() == uHarga) {
            frame.dispose();
            new UpdateHarga();
        } else if (e.getSource() == uTambahProduk) {
            frame.dispose();
            new TambahProduk();
        }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author glenn
 */
public class TambahProduk extends JFrame implements ActionListener, KeyListener {
    
    JFrame frame;
    JTextField namaProduk, berat, harga, warna, s, m, l, xl;
    JButton submit;
    String nama, warnaProduk;
    Double beratProduk;
    int jumlahS, jumlahM, jumlahL, jumlahXL;
    
    public static void main(String[] args) {
        new TambahProduk();
    }
    
    public TambahProduk() {
        frame = new JFrame("Tambah Produk");
        frame.setSize(450, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        JLabel title, namaProdukLb, beratLb, hargaLb, ukuranLb, warnaLb, sLb, mLb, lLb, xlLb;
        Font titleF = new Font("Sans Serif", Font.BOLD, 35);
        
        title = new JLabel("Tambah Produk");
        title.setFont(titleF);
        title.setBounds(0, 0, 450, 37);
        title.setHorizontalAlignment(JLabel.CENTER);
        frame.add(title);
        
        JPanel inputArea = new JPanel();
        inputArea.setBounds(0, 40, 450, 500);
        inputArea.setLayout(null);
        frame.add(inputArea);
        
        Font regularF = new Font("Sans Serif", Font.PLAIN, 25);
        
        namaProdukLb = new JLabel("Nama:");
        namaProdukLb.setBounds(15, 10, 150, 27);
        namaProdukLb.setFont(regularF);
        inputArea.add(namaProdukLb);
        
        namaProduk = new JTextField();
        namaProduk.setBounds(170, 10, 250, 27);
        namaProduk.setFont(regularF);
        inputArea.add(namaProduk);
        
        beratLb = new JLabel("Berat:");
        beratLb.setBounds(15, 45, 150, 27);
        beratLb.setFont(regularF);
        inputArea.add(beratLb);
        
        berat = new JTextField();
        berat.setBounds(170, 45, 250, 27);
        berat.setFont(regularF);
        inputArea.add(berat);
        
        warnaLb = new JLabel("Warna:");
        warnaLb.setBounds(15, 80, 150, 27);
        warnaLb.setFont(regularF);
        inputArea.add(warnaLb);
        
        warna = new JTextField();
        warna.setBounds(170, 80, 250, 27);
        warna.setFont(regularF);
        inputArea.add(warna);
        
        ukuranLb = new JLabel("Jumlah Stok per Ukuran");
        ukuranLb.setBounds(15, 115, 350, 27);
        ukuranLb.setFont(regularF);
        inputArea.add(ukuranLb);
        
        sLb = new JLabel("S:");
        sLb.setBounds(15, 150, 150, 27);
        sLb.setFont(regularF);
        inputArea.add(sLb);
        
        s = new JTextField();
        s.setBounds(170, 150, 250, 27);
        s.setFont(regularF);
        inputArea.add(s);
        
        mLb = new JLabel("M:");
        mLb.setBounds(15, 185, 150, 27);
        mLb.setFont(regularF);
        inputArea.add(mLb);
        
        m = new JTextField();
        m.setBounds(170, 185, 250, 27);
        m.setFont(regularF);
        inputArea.add(m);
        
        lLb = new JLabel("L:");
        lLb.setBounds(15, 215, 150, 27);
        lLb.setFont(regularF);
        inputArea.add(lLb);
        
        l = new JTextField();
        l.setBounds(170, 215, 250, 27);
        l.setFont(regularF);
        inputArea.add(l);
        
        xlLb = new JLabel("XL:");
        xlLb.setBounds(15, 250, 150, 27);
        xlLb.setFont(regularF);
        inputArea.add(xlLb);
        
        xl = new JTextField();
        xl.setBounds(170, 250, 250, 27);
        xl.setFont(regularF);
        inputArea.add(xl);
        
        submit = new JButton("Submit");
        submit.setBounds(15, 285, 150, 40);
        submit.setFont(regularF);
        inputArea.add(submit);
        
        berat.addKeyListener(this);
        s.addKeyListener(this);
        m.addKeyListener(this);
        l.addKeyListener(this);
        xl.addKeyListener(this);
        
        submit.addActionListener(this);
        
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            if (namaProduk.getText().isBlank() || berat.getText().isBlank() || warna.getText().isBlank() || s.getText().isBlank() || m.getText().isBlank() || l.getText().isBlank() || xl.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "semua form harus terisi");
            } else {
                nama = namaProduk.getText();
                beratProduk = Double.parseDouble(berat.getText());
                warnaProduk = warna.getText();
                jumlahS = Integer.parseInt(s.getText());
                jumlahM = Integer.parseInt(m.getText());
                jumlahL = Integer.parseInt(l.getText());
                jumlahXL = Integer.parseInt(xl.getText());
                int[] stok = {jumlahS, jumlahM, jumlahL, jumlahXL};
            }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == berat) {
            doubleInputCheck(berat);
        } else if (e.getSource() == s) {
            integerInputCheck(s);
        } else if (e.getSource() == m) {
            integerInputCheck(m);
        } else if (e.getSource() == l) {
            integerInputCheck(l);
        } else if (e.getSource() == xl) {
            integerInputCheck(xl);
        }
    }
    
    void doubleInputCheck(JTextField tf) {
        try {
            Double.parseDouble(tf.getText());
        } catch (NumberFormatException ea) {
            tf.setText("");
            JOptionPane.showMessageDialog(null, "input harus double");
        }
    }
    
    void integerInputCheck(JTextField tf) {
        try {
            Integer.parseInt(tf.getText());
        } catch (NumberFormatException ea) {
            tf.setText("");
            JOptionPane.showMessageDialog(null, "input harus integer");
        }
    }
    
}

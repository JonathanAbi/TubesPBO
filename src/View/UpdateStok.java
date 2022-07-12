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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author glenn
 */
public class UpdateStok extends JFrame implements ActionListener {
    JFrame frame;
    JComboBox produkCb;
    JTextField hargaAwalTf, hargaAkhirTf;
    JButton update;
    
    public static void main(String[] args) {
        new UpdateStok();
    }
    public UpdateStok() {
        frame = new JFrame("Update Stok");
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        Font titleF = new Font("Sans Serif", Font.BOLD, 35);
        JLabel title = new JLabel("Update Stok");
        title.setFont(titleF);
        title.setBounds(0, 0, 450, 37);
        title.setHorizontalAlignment(JLabel.CENTER);
        frame.add(title);
        
        JPanel inputArea = new JPanel();
        inputArea.setBounds(0, 40, 500, 500);
        
        Font regularF = new Font("Sans Serif", Font.PLAIN, 25);
        JLabel namaProduk, hargaAwal, hargaAkhir;
        
        namaProduk = new JLabel("Pilih Produk:");
        namaProduk.setBounds(15, 10, 150, 27);
        namaProduk.setFont(regularF);
        inputArea.add(namaProduk);
        
        String[] apa = {"test", "halo"};
        produkCb = new JComboBox(apa);
        produkCb.setSelectedIndex(-1);
        produkCb.setBounds(170, 10, 250, 27);
        inputArea.add(produkCb);
        
        hargaAwal = new JLabel("Harga Awal:");
        hargaAwal.setBounds(15, 45, 150, 30);
        hargaAwal.setFont(regularF);
        inputArea.add(hargaAwal);
        
        hargaAwalTf = new JTextField();
        hargaAwalTf.setBounds(170, 45, 250, 27);
        hargaAwalTf.setText("-");
        hargaAwalTf.setFont(regularF);
        hargaAwalTf.setForeground(Color.red);
        hargaAwalTf.setEditable(false);
        inputArea.add(hargaAwalTf);
        
        hargaAkhir = new JLabel("Harga baru:");
        hargaAkhir.setBounds(15, 83, 150, 27);
        hargaAkhir.setFont(regularF);
        inputArea.add(hargaAkhir);
        
        hargaAkhirTf = new JTextField();
        hargaAkhirTf.setBounds(170, 83, 250, 27);
        hargaAkhirTf.setForeground(Color.blue);
        hargaAkhirTf.setFont(regularF);
        inputArea.add(hargaAkhirTf);
        
        update = new JButton("UPDATE");
        update.setBounds(15, 126, 200, 50);
        update.setFont(regularF);
        inputArea.add(update);
        
        produkCb.addActionListener(this);
        update.addActionListener(this);
        
        inputArea.setLayout(null);
        frame.add(inputArea);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==produkCb) {
            hargaAkhirTf.setText("");
        } else if(e.getSource()==update) {
            
        }
    }
}

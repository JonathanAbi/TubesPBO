package View;

import Controller.EtalaseController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import Model.Produk;

public class Etalase {
    
    public static void main(String[] args) {
        new Etalase();
    }
    
//    public ArrayList<Produk> getProduk(){
//        
//    }
    
    public Etalase(){
        Font fontButton = new Font("Serif", Font.PLAIN, 10);
        JFrame frame = new JFrame("Etalase");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        
        //panel judul
        JPanel panelJudul = new JPanel();
        panelJudul.setPreferredSize(new Dimension(600, 100));
        panelJudul.setBackground(Color.PINK);
        panelJudul.setLayout(null);
        
        //label judul
        JLabel judul = new JLabel("Etalase");
        judul.setBounds(225, 10, 200, 100);
        judul.setFont(new Font("Serif", Font.BOLD, 35));
        
        //button keranjang
        JButton buttonKeranjang = new JButton("Keranjang");
        buttonKeranjang.setFont(fontButton);
        buttonKeranjang.setBounds(500, 10, 75, 50);
        buttonKeranjang.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //pengisian panel judul
        panelJudul.add(judul);
        panelJudul.add(buttonKeranjang);
        
        //panel barang
        JPanel panelListBarang = new JPanel();
        panelListBarang.setPreferredSize(new Dimension(600, 600));
        panelListBarang.setBackground(Color.BLUE);
        panelListBarang.setLayout(new GridLayout(0,2));
        
        //scroll pane
        JScrollPane scrollPane = new JScrollPane(panelListBarang, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        ArrayList <Produk> listProduk = getProduk();
        
        //temp barang
        JPanel panelProduk = new JPanel();
        panelProduk.setSize(200, 300);
        panelProduk.setBackground(Color.RED);
        
        JPanel panelProduk1 = new JPanel();
        panelProduk1.setSize(200, 300);
        panelProduk1.setBackground(Color.GREEN);
        
        JPanel panelProduk2 = new JPanel();
        panelProduk2.setSize(200, 300);
        panelProduk2.setBackground(Color.ORANGE);
        
        JPanel panelProduk3 = new JPanel();
        panelProduk3.setSize(200, 300);
        panelProduk3.setBackground(Color.BLACK);
        
        JPanel panelProduk4 = new JPanel();
        panelProduk4.setSize(200, 300);
        panelProduk4.setBackground(Color.CYAN);
        
        JPanel panelProduk5 = new JPanel();
        panelProduk5.setSize(200, 300);
        panelProduk5.setBackground(Color.MAGENTA);
        
        panelListBarang.add(panelProduk);
        panelListBarang.add(panelProduk1);
        panelListBarang.add(panelProduk2);
        panelListBarang.add(panelProduk3);
        panelListBarang.add(panelProduk4);
        panelListBarang.add(panelProduk5);
        
        frame.add(panelJudul,BorderLayout.NORTH);
        frame.add(panelListBarang);
        frame.add(scrollPane,BorderLayout.EAST);
        frame.setVisible(true);
    }
}

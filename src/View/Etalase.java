package View;

import Controller.EtalaseController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import Model.Produk;
import java.util.ArrayList;

public class Etalase {
    
    JPanel panelListBarang;
    JFrame frame;
    ArrayList <Produk> keranjang = new ArrayList <>();
    ArrayList <Produk> listProduk;
    int iterasi = 0;
    
    public static void main(String[] args) {
        new Etalase();
    }
    
    public JPanel getPanelBarang(ArrayList <Produk> listProduk, int iterasi, ArrayList <Produk> keranjang){
        //panel utama
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 600));
        panel.setLayout(new GridLayout(2,2));
        for (int i = 0; i < 4; i++) {
            if(iterasi+i > listProduk.size()){
                break;
            }
            Produk produk = listProduk.get(iterasi+i);
            JPanel panelBarang = new JPanel();
            panelBarang.setSize(250,300);
            panelBarang.setBackground(Color.WHITE);
            panelBarang.setLayout(null);
            
            String txt = produk.getNama() + " - " + produk.getWarna();
            JLabel lblNamaProduk = new JLabel(txt);
            lblNamaProduk.setBounds(10,215,200,25);
            lblNamaProduk.setFont(new Font("Serif", Font.PLAIN, 22));
            
            JLabel lblHarga = new JLabel("Rp. " + String.valueOf(produk.getHarga()));
            lblHarga.setBounds(10,240,200,20);
            lblHarga.setFont(new Font("Serif", Font.PLAIN, 17));
            
            int[] stok = produk.getStock();
            txt = "| S : " + stok[0] +" | M : " + stok[1] +" | L : " + stok[2] +" | XL : " + stok[3] +" |";
            JLabel lblStock = new JLabel(txt);
            lblStock.setBounds(10,260,200,15);
            lblStock.setFont(new Font("Serif", Font.PLAIN, 15));
            
            JButton btn = new JButton("+");
            btn.setFont(new Font("Serif", Font.PLAIN, 10));
            btn.setBounds(190,225,50,50);
            
            
                      
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    keranjang.add(produk);
                }
            });
            panelBarang.add(lblNamaProduk);
            panelBarang.add(lblHarga);
            panelBarang.add(lblStock);
            panelBarang.add(btn);
            panel.add(panelBarang);
        }
        return panel;
    }
    
    public Etalase(){
        EtalaseController controller = new EtalaseController();
        Font fontButton = new Font("Serif", Font.PLAIN, 10);
        frame = new JFrame("Etalase");
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
        buttonKeranjang.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//                for (int i = 0; i < keranjang.size(); i++) {
//                    Produk temp = keranjang.get(i);
//                    System.out.println(temp.getNama() + " - " + temp.getWarna());
//                }
            }
            
        });
        
        //pengisian panel judul
        panelJudul.add(judul);
        panelJudul.add(buttonKeranjang);
        
        //get produk
        listProduk = controller.getProduk();
        
        //panel barang
        panelListBarang = getPanelBarang(listProduk,iterasi,keranjang);
        
        
        //button next
        JButton next = new JButton(">");
        next.setSize(100, 600);
        next.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listProduk.size()-(iterasi+4) <= 4){
                    iterasi = listProduk.size() - 4;
                }else{
                    iterasi += 4;
                }
                frame.remove(panelListBarang);
                panelListBarang = getPanelBarang(listProduk,iterasi,keranjang);
                frame.add(panelListBarang,BorderLayout.CENTER);
                frame.invalidate();
                frame.validate();
                frame.repaint();
            }
        });
        
        //button prev
        JButton prev = new JButton("<");
        prev.setSize(100, 600);
        prev.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(iterasi-4 < 0){
                    iterasi = 0;
                }else{
                    iterasi -= 4;
                }
                frame.remove(panelListBarang);
                panelListBarang = getPanelBarang(listProduk,iterasi,keranjang);
                frame.add(panelListBarang,BorderLayout.CENTER);
                frame.invalidate();
                frame.validate();
                frame.repaint();
            }
        });
        
        frame.add(panelJudul,BorderLayout.NORTH);
        frame.add(panelListBarang,BorderLayout.CENTER);
        frame.add(next,BorderLayout.EAST);
        frame.add(prev,BorderLayout.WEST);
        frame.setVisible(true);
    }
}

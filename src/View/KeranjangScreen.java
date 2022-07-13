package View;

import Controller.KeranjangController;
import Model.*;
import Database.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.*;

public class KeranjangScreen {

    PanelKeranjang[] keranjang;
    
    public boolean update(ArrayList <Produk> listProduk, ArrayList <UkuranEnum> listUkuran, ArrayList <Integer> listJumlah) {
        KeranjangController c = new KeranjangController();
        return c.updateDatabase(listProduk,listUkuran,listJumlah);
    }
    
    public static void main(String[] args) {
        new Etalase();
    }
    
    public KeranjangScreen() {
        //font
        Font fontButton = new Font("Serif", Font.PLAIN, 14);

        //frame
        JFrame frame = new JFrame("Keranjang");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLayout(null);

        //Button back
        JButton back = new JButton("back");
        back.setBounds(0, 0, 100, 50);
        back.setFont(fontButton);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Etalase();
            }
        });
        
        //Button delete
        JButton delete = new JButton("Delete");
        delete.setBounds(380, 0, 100, 50);
        delete.setFont(fontButton);
        delete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList <Produk> listProduk = new ArrayList<>();
                ArrayList <UkuranEnum> listUkuran = new ArrayList<>();
                ArrayList <Integer> listJumlah = new ArrayList<>();
                for (int i = 0; i < SingletonKeranjang.getInstance().getLength(); i++) {
                    if(keranjang[i].chosen){
                        listProduk.add(keranjang[i].produk);
                        listUkuran.add(keranjang[i].ukuran);
                        listJumlah.add(keranjang[i].jumlah);
                    }
                }
                if(update(listProduk,listUkuran,listJumlah)){
                    frame.dispose();
                    new KeranjangScreen();
                }
            }
        });
        
        //Button bayar
        JButton bayar = new JButton("bayar");
        bayar.setBounds(490, 0, 100, 50);
        bayar.setFont(fontButton);
        bayar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        //Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBounds(5, 55, 575, 600);

        //panel list
        JPanel panelList = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panelList.add(new JPanel(), gbc);
        mainPanel.add(new JScrollPane(panelList));
        int jmlhBarang = SingletonKeranjang.getInstance().getLength();
        keranjang = new PanelKeranjang[jmlhBarang];
        for (int i = 0; i < jmlhBarang; i++) {
            keranjang[i] = new PanelKeranjang(i);
            gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panelList.add(keranjang[i],gbc,0);
        }
        frame.add(back);
        frame.add(delete);
        frame.add(bayar);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}

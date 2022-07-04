/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerKurir;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author kevin
 */
public class ViewPengiriman {
     public ViewPengiriman() {

        JFrame frame = new JFrame("Menu Kurir");
        frame.setSize(600, 700);
        frame.setLocationRelativeTo(null);
        Font myFont = new Font("Serif", Font.BOLD, 18);

        //enter name label
        JLabel label = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label6 = new JLabel();
        JLabel label7 = new JLabel();
        JLabel label8 = new JLabel();

        label8.setText("FORM KURIR");
        label8.setBounds(10, 30, 300, 30);
        Font myFont5 = new Font("Arial Black", Font.BOLD, 28);
        label8.setFont(myFont5);
        label8.setForeground(Color.BLUE);
        label8.setOpaque(true);

        label.setText("ID Kurir");
        label.setBounds(10, 100, 100, 30);
        label.setFont(myFont);
        
        label2.setText("Nama Kurir");
        label2.setBounds(10, 150, 100, 30);
        label2.setFont(myFont);
        
        label3.setText("Username");
        label3.setBounds(10, 200, 100, 30);
        label3.setFont(myFont);
        
        label4.setText("Password");
        label4.setBounds(10, 250, 100, 30);
        label4.setFont(myFont);
        
        label5.setText("Telepon");
        label5.setBounds(10, 300, 100, 30);
        label5.setFont(myFont);

        label6.setText("Kapasitas Berat Barang");
        label6.setBounds(10, 350, 200, 30);
        label6.setFont(myFont);

        label7.setText("Total Berat Barang");
        label7.setBounds(10, 400, 200, 30);
        label7.setFont(myFont);
        
        JTextField id = new JTextField();
        JTextField nama = new JTextField();
        JTextField username = new JTextField();
        JPasswordField pass = new JPasswordField();
        JTextField telepon = new JTextField();
        JTextField kapasitasBarang = new JTextField();
        JTextField totalKapasitas = new JTextField();
        
        id.setBounds(210, 100, 120, 30);
        id.setBackground(Color.WHITE);
        
        nama.setBounds(210, 150, 200, 30);
        nama.setBackground(Color.WHITE);
        
        username.setBounds(210, 200, 200, 30);
        username.setBackground(Color.WHITE);
        
        pass.setBounds(210, 250, 200, 30);
        pass.setBackground(Color.WHITE);

        telepon.setBounds(210, 300, 200, 30);
        telepon.setBackground(Color.WHITE);

        kapasitasBarang.setBounds(210, 350, 100, 30);
        kapasitasBarang.setBackground(Color.WHITE);

        totalKapasitas.setBounds(210, 400, 100, 30);
        totalKapasitas.setBackground(Color.WHITE);

        // Absolute Position
        JButton buttonSave = new JButton("SAVE");
        buttonSave.setBounds(10, 460, 100, 40);
        JButton buttonUpdate = new JButton("UPDATE");
        buttonUpdate.setBounds(130, 460, 100, 40);
        JButton buttonRefresh = new JButton("REFRESH");
        buttonRefresh.setBounds(250, 460, 100, 40);
        JButton buttonDelete = new JButton("DELETE");
        buttonDelete.setBounds(70, 520, 100, 40);
        JButton buttonExit = new JButton("Exit");
        buttonExit.setBounds(190, 520, 100, 40);
        buttonSave.setEnabled(true);

        frame.add(label);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(label6);
        frame.add(label7);
        frame.add(label8);
        frame.add(id);
        frame.add(nama);
        frame.add(telepon);
        frame.add(username);
        frame.add(pass);
        frame.add(kapasitasBarang);
        frame.add(totalKapasitas);
        frame.add(buttonExit);
        frame.add(buttonRefresh);
        frame.add(buttonSave);
        frame.add(buttonUpdate);
        frame.add(buttonDelete);
        frame.setLayout(null);
        frame.setVisible(true);

        buttonSave.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                if (nama.getText().isEmpty() || telepon.getText().isEmpty() || kapasitasBarang.getText().isEmpty()
                        || totalKapasitas.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom wajib diisi!");
                } else {
                    ControllerKurir.addKurir(nama.getText(), username.getText(), pass.getText(), telepon.getText(), kapasitasBarang.getText(), totalKapasitas.getText());
                    //ControllerKurir.hitungKapasitasBarang();
                }
                
            }
        });

        buttonRefresh.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                nama.setText("");
                telepon.setText("");
                username.setText("");
                pass.setText("");
                kapasitasBarang.setText("");
                totalKapasitas.setText("");

            }
        });
        
        buttonUpdate.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                if (nama.getText().isEmpty() || telepon.getText().isEmpty() || kapasitasBarang.getText().isEmpty()
                        || totalKapasitas.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom wajib diisi!");
                } else {
                    ControllerKurir.updateKurir(id.getText(),nama.getText(), username.getText(), pass.getText(), telepon.getText(), kapasitasBarang.getText(), totalKapasitas.getText());
                    new ViewDataKurir();
                }
                
            }
        });
        
        buttonDelete.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                if (nama.getText().isEmpty() || telepon.getText().isEmpty() || kapasitasBarang.getText().isEmpty()
                        || totalKapasitas.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom wajib diisi!");
                } else {
                    ControllerKurir.deleteKurir(nama.getText());
                    new ViewDataKurir();
                }
                
            }
        });

    }
}

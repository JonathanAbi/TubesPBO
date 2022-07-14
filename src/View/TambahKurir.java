/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.TambahKurirController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author glenn
 */
public class TambahKurir extends JFrame implements ActionListener, KeyListener, MouseListener {

    JFrame frame;
    JLabel exit;
    JTextField namaTf, usernameTf, teleponTf, kapasitasBarangTf;
    JPasswordField passwordJp;
    JButton submit;
    TambahKurirController kurir = new TambahKurirController();

    public static void main(String[] args) {
        new TambahKurir();
    }

    TambahKurir() {
        frame = new JFrame("Tambah Kurir");
        frame.setSize(480, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel title, nama, username, password, telepon, kapasitasBarang;

        Font titleF = new Font("Sans Serif", Font.BOLD, 30);
        Font regularF = new Font("Sans Serif", Font.PLAIN, 25);

        title = new JLabel("Tambah Kurir");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0, 0, frame.size().width, 33);
        title.setFont(titleF);
        frame.add(title);

        nama = new JLabel("Nama:");
        nama.setBounds(30, 50, 200, 33);
        nama.setFont(regularF);
        frame.add(nama);

        namaTf = new JTextField();
        namaTf.setBounds(200, 50, 250, 33);
        namaTf.setFont(regularF);
        frame.add(namaTf);

        username = new JLabel("Username:");
        username.setBounds(30, 90, 200, 33);
        username.setFont(regularF);
        frame.add(username);

        usernameTf = new JTextField();
        usernameTf.setBounds(200, 90, 250, 33);
        usernameTf.setFont(regularF);
        frame.add(usernameTf);

        password = new JLabel("Password:");
        password.setBounds(30, 130, 200, 33);
        password.setFont(regularF);
        frame.add(password);

        passwordJp = new JPasswordField();
        passwordJp.setBounds(200, 130, 250, 33);
        passwordJp.setFont(regularF);
        frame.add(passwordJp);

        telepon = new JLabel("Telepon:");
        telepon.setBounds(30, 170, 200, 33);
        telepon.setFont(regularF);
        frame.add(telepon);

        teleponTf = new JTextField();
        teleponTf.setBounds(200, 170, 250, 33);
        teleponTf.setFont(regularF);
        frame.add(teleponTf);

        kapasitasBarang = new JLabel("Kapasitas Barang:");
        kapasitasBarang.setBounds(5, 210, 200, 33);
        kapasitasBarang.setFont(new Font("Sans Serif", Font.PLAIN, 22));
        frame.add(kapasitasBarang);

        kapasitasBarangTf = new JTextField();
        kapasitasBarangTf.setBounds(200, 210, 250, 33);
        kapasitasBarangTf.setFont(regularF);
        frame.add(kapasitasBarangTf);
        
        submit = new JButton("+Tambah kurir");
        submit.setBounds(200, 250, 200, 50);
        submit.setFont(regularF);
        frame.add(submit);
        
        exit = new JLabel("<<Kembali menu admin");
        exit.setBounds(15, 310, 170, 18);
        frame.add(exit);
        
        exit.addMouseListener(this);
        
        submit.addActionListener(this);
        
        kapasitasBarangTf.addKeyListener(this);
        teleponTf.addKeyListener(this);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit) {
            if (namaTf.getText().isBlank()||usernameTf.getText().isBlank()||passwordJp.getText().isBlank()||teleponTf.getText().isBlank()||kapasitasBarangTf.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Form harus terisi semua!");
            } else {
                frame.dispose();
                String nama = namaTf.getText();
                String username = usernameTf.getText();
                String password = passwordJp.getText();
                String telepon = teleponTf.getText();
                double kapasitas = Double.parseDouble(kapasitasBarangTf.getText());
                JOptionPane.showMessageDialog(null, kurir.addKurir(nama, username, password, telepon, kapasitas));
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource()==kapasitasBarangTf) {
            doubleInputCheck(kapasitasBarangTf);
        } else if(e.getSource()==teleponTf) {
            integerInputCheck(teleponTf);
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
            JOptionPane.showMessageDialog(null, "input harus berupa angkat");
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

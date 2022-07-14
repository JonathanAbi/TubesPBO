/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.UpdateHargaController;
import Model.Produk;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author glenn
 */
public class UpdateHarga extends JFrame implements ActionListener, KeyListener, MouseListener {

    JFrame frame;
    JComboBox produkCb;
    JTextField hargaAwalTf, hargaAkhirTf;
    JButton update;
    Double hargaAkhir;
    UpdateHargaController harga = new UpdateHargaController();
    String[] nameList;
    int produkIndex, produkId;
    JLabel exit;

    public static void main(String[] args) {
        new UpdateHarga();
    }

    public UpdateHarga() {
        frame = new JFrame("Update Harga");
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Font titleF = new Font("Sans Serif", Font.BOLD, 35);
        JLabel title = new JLabel("Update Harga");
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

        nameList = harga.getNameList();
        produkCb = new JComboBox(nameList);
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
        hargaAkhirTf.setEditable(false);
        hargaAkhirTf.setFont(regularF);
        inputArea.add(hargaAkhirTf);

        update = new JButton("UPDATE");
        update.setBounds(15, 126, 200, 50);
        update.setFont(regularF);
        inputArea.add(update);

        exit = new JLabel("<<Kembali ke update menu");
        exit.setBounds(15, 185, 170, 18);
        inputArea.add(exit);

        produkCb.addActionListener(this);
        update.addActionListener(this);

        hargaAkhirTf.addKeyListener(this);

        exit.addMouseListener(this);

        inputArea.setLayout(null);
        frame.add(inputArea);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == produkCb) {
            hargaAkhirTf.setEditable(true);
            produkIndex = produkCb.getSelectedIndex();
            Produk produk = harga.getProdukByIndex(produkIndex);
            produkId = produk.getId();
            hargaAwalTf.setText(produk.getHarga().toString());
            hargaAkhirTf.setText("");
        } else if (e.getSource() == update) {
            if (hargaAwalTf.getText().isBlank() || hargaAkhirTf.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "input tidak boleh kosong");
            } else {
                double hargaAkhir = Double.parseDouble(hargaAkhirTf.getText());
                frame.dispose();
                JOptionPane.showMessageDialog(null, harga.updateHargaToDB(produkId, hargaAkhir));
                new UpdateBarangMenu();
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
        if (e.getSource() == hargaAkhirTf) {
            doubleInputCheck(hargaAkhirTf);
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

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == exit) {
            frame.dispose();
            new UpdateBarangMenu();
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

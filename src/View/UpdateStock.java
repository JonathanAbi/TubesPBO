/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.UpdateStokController;
import Model.Produk;
import Model.UkuranEnum;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author glenn
 */
public class UpdateStock extends JFrame implements ActionListener, KeyListener, MouseListener {

    JFrame frame;
    JComboBox produkCb, ukuranCb;
    JTextField stokAwalTf, stokAkhirTf;
    JButton update;
    JLabel exit;
    int produkIndex, ukuranIndex;
    UpdateStokController stok = new UpdateStokController();
    Produk produk;

    public static void main(String[] args) {
        new UpdateStock();
    }

    public UpdateStock() {
        frame = new JFrame("Update Stok");
        frame.setSize(450, 330);
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
        JLabel namaProdukLb, ukuranLb, stokAwalLb, stokAkhirLb;

        namaProdukLb = new JLabel("Pilih Produk:");
        namaProdukLb.setBounds(15, 10, 150, 27);
        namaProdukLb.setFont(regularF);
        inputArea.add(namaProdukLb);

        String[] produkNameList = stok.getNameList();
        produkCb = new JComboBox(produkNameList);
        produkCb.setSelectedIndex(-1);
        produkCb.setBounds(170, 10, 250, 27);
        inputArea.add(produkCb);

        ukuranLb = new JLabel("Pilih Ukuran:");
        ukuranLb.setBounds(15, 45, 150, 27);
        ukuranLb.setFont(regularF);
        inputArea.add(ukuranLb);

        UkuranEnum[] ukuranE = UkuranEnum.values();
        String[] ukuran = new String[ukuranE.length];
        for (int i = 0; i < ukuranE.length; i++) {
            ukuran[i] = ukuranE[i].getString();
        }
        ukuranCb = new JComboBox(ukuran);
        ukuranCb.setSelectedIndex(-1);
        ukuranCb.setEnabled(false);
        ukuranCb.setBounds(170, 45, 250, 27);
        inputArea.add(ukuranCb);

        stokAwalLb = new JLabel("Stok Awal:");
        stokAwalLb.setBounds(15, 80, 150, 30);
        stokAwalLb.setFont(regularF);
        inputArea.add(stokAwalLb);

        stokAwalTf = new JTextField();
        stokAwalTf.setBounds(170, 80, 250, 27);
        stokAwalTf.setText("-");
        stokAwalTf.setFont(regularF);
        stokAwalTf.setForeground(Color.red);
        stokAwalTf.setEditable(false);
        inputArea.add(stokAwalTf);

        stokAkhirLb = new JLabel("Stok Akhir:");
        stokAkhirLb.setBounds(15, 115, 150, 30);
        stokAkhirLb.setFont(regularF);
        inputArea.add(stokAkhirLb);

        stokAkhirTf = new JTextField();
        stokAkhirTf.setBounds(170, 115, 250, 27);
        stokAkhirTf.setFont(regularF);
        stokAkhirTf.setForeground(Color.blue);
        stokAkhirTf.setEditable(false);
        inputArea.add(stokAkhirTf);

        update = new JButton("UPDATE");
        update.setBounds(15, 150, 200, 50);
        update.setFont(regularF);
        inputArea.add(update);

        exit = new JLabel("<<Kembali ke update menu");
        exit.setBounds(15, 215, 170, 18);
        inputArea.add(exit);

        produkCb.addActionListener(this);
        ukuranCb.addActionListener(this);
        update.addActionListener(this);

        stokAkhirTf.addKeyListener(this);

        exit.addMouseListener(this);

        inputArea.setLayout(null);
        frame.add(inputArea);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == produkCb) {
            stokAkhirTf.setText("");
            stokAkhirTf.setEditable(false);
            produkIndex = produkCb.getSelectedIndex();
            ukuranCb.setEnabled(true);
            ukuranCb.setSelectedIndex(-1);
        } else if (e.getSource() == ukuranCb && ukuranCb.getSelectedIndex() != -1) {
            stokAkhirTf.setText("");
            stokAkhirTf.setEditable(true);
            ukuranIndex = ukuranCb.getSelectedIndex();
            String jumlah = stok.getProdukStock(produkIndex, ukuranIndex) + "";
            stokAwalTf.setText(jumlah);
        } else if (e.getSource() == update) {
            if (stokAkhirTf.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Input tidak boleh kosong!");
            } else {
                int jumlah = Integer.parseInt(stokAkhirTf.getText());
                produk = stok.getProdukByIndex(produkIndex);
                JOptionPane.showMessageDialog(null, stok.updateStokToDB(produk.getId(), ukuranIndex, jumlah));
                frame.dispose();
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
        if (e.getSource() == stokAkhirTf) {
            integerInputCheck(stokAkhirTf);
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

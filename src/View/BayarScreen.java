package View;

import Controller.*;
import Model.*;
import Database.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.*;

public class BayarScreen {

    public BayarScreen(ArrayList<Produk> listProduk, ArrayList<UkuranEnum> listUkuran, ArrayList<Integer> listJumlah) {
        //font
        Font fontButton = new Font("Serif", Font.PLAIN, 14);
        Font font = new Font("Serif", Font.PLAIN, 16);

        //frame
        JFrame frame = new JFrame("Pembayaran");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        //Button back
        JButton back = new JButton("back");
        back.setBounds(0, 0, 100, 50);
        back.setFont(fontButton);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new KeranjangScreen();
            }
        });

        //Panel list barang
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBounds(5, 55, 575, 150);

        //panel list
        JPanel panelList = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panelList.add(new JPanel(), gbc);
        mainPanel.add(new JScrollPane(panelList));
        int jmlhBarang = listProduk.size();
        double[] listTotalHarga = new double[jmlhBarang];
        double totalBayar = 0;
        for (int i = 0; i < jmlhBarang; i++) {
            JPanel tempPanel = new JPanel();
            Produk produk = listProduk.get(i);
            int jumlahProduk = listJumlah.get(i);
            UkuranEnum ukuranProduk = listUkuran.get(i);
            listTotalHarga[i] = produk.getHarga() * jumlahProduk;
            totalBayar += listTotalHarga[i];
            String textBarang = produk.getNama() + " - " + produk.getWarna() + " - " + ukuranProduk.getString() + " - " + jumlahProduk + " (" + listTotalHarga[i] + ")";
            tempPanel.add(new JLabel(textBarang, SwingConstants.LEFT));
            gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panelList.add(tempPanel, gbc, 0);
        }

        //total bayar
        JLabel bayar = new JLabel("Total yang harus dibayar : " + String.valueOf(totalBayar), SwingConstants.RIGHT);
        bayar.setBounds(5, 210, 575, 20);
        bayar.setFont(font);

        //input alamat
        JLabel lblAlamat = new JLabel("Alamat Pengantaran : ");
        lblAlamat.setBounds(50, 240, 200, 20);
        lblAlamat.setFont(font);

        Customer cus = (Customer) SingletonProfile.getInstance().getUser();
        ArrayList<Alamat> listAlamat = cus.getAlamat();
        String[] listNamaAlamat = new String[listAlamat.size()];
        for (int i = 0; i < listAlamat.size(); i++) {
            listNamaAlamat[i] = listAlamat.get(i).getAlamatLengkap() + ", " + listAlamat.get(i).getKota() + " - " + listAlamat.get(i).getKodePos();
        }
        JComboBox alamat = new JComboBox(listNamaAlamat);
        alamat.setBounds(275, 240, 275, 20);
        alamat.setFont(font);
        
        JButton tambahAlamat = new JButton("Tambah Alamat");
        tambahAlamat.setFont(font);
        tambahAlamat.setBounds(275, 280, 275, 30);
        tambahAlamat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                new TambahAlamat(listProduk, listUkuran,listJumlah);
                frame.dispose();
            }
            
        });
        //label metode bayar
        JLabel lblMetodeBayar = new JLabel("Metode Pembayaran : ");
        lblMetodeBayar.setBounds(50, 270, 200, 20);
        lblMetodeBayar.setFont(font);

        //input metode bayar
        JLabel lblNomor = new JLabel("Masukkan nomor telepon yang digunakan : ");
        lblNomor.setBounds(50, 420, 300, 20);
        lblNomor.setFont(font);
        lblNomor.setVisible(false);

        JTextField nomor = new JTextField();
        nomor.setBounds(50, 445, 300, 25);
        nomor.setFont(font);
        nomor.setVisible(false);

        ActionListener showTF = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblNomor.setVisible(true);
                nomor.setVisible(true);
            }
        };

        ActionListener hideTF = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblNomor.setVisible(false);
                nomor.setVisible(false);
            }
        };

        JRadioButton transfer = new JRadioButton("Transfer Bank");
        transfer.setBounds(50, 295, 200, 20);
        transfer.setFont(font);
        transfer.addActionListener(hideTF);

        JRadioButton cod = new JRadioButton("Cash on Delivery");
        cod.setBounds(50, 320, 200, 20);
        cod.setFont(font);
        cod.addActionListener(hideTF);

        JRadioButton ovo = new JRadioButton("OVO");
        ovo.setBounds(50, 345, 200, 20);
        ovo.setFont(font);
        ovo.addActionListener(showTF);

        JRadioButton gopay = new JRadioButton("GoPay");
        gopay.setBounds(50, 370, 200, 20);
        gopay.setFont(font);
        gopay.addActionListener(showTF);

        JRadioButton dana = new JRadioButton("DANA");
        dana.setBounds(50, 395, 200, 20);
        dana.setFont(font);
        dana.addActionListener(showTF);

        ButtonGroup grup = new ButtonGroup();
        grup.add(transfer);
        grup.add(cod);
        grup.add(ovo);
        grup.add(gopay);
        grup.add(dana);

        //Button bayar
        JButton btnBayar = new JButton("bayar");
        btnBayar.setBounds(250, 475, 100, 50);
        btnBayar.setFont(fontButton);
        btnBayar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean valid = true;
                if (!ovo.isSelected() && !gopay.isSelected() && !dana.isSelected() && !cod.isSelected() && !transfer.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Mohon pilih metode pembayaran");
                    valid = false;
                }
                if (ovo.isSelected() || gopay.isSelected() || dana.isSelected()) {
                    if (nomor.getText().length() == 0) {
                        JOptionPane.showMessageDialog(null, "Masukkan nomor telepon yang valid!!");
                        valid = false;
                    }
                }
                if (valid) {
                    int metodeBayar;
                    if (transfer.isSelected()) {
                        metodeBayar = 0;
                    } else if (cod.isSelected()) {
                        metodeBayar = 1;
                    } else if (ovo.isSelected()) {
                        metodeBayar = 2;
                    } else if (gopay.isSelected()) {
                        metodeBayar = 3;
                    } else {
                        metodeBayar = 4;
                    }
                    int index = alamat.getSelectedIndex();
                    Alamat alamatChosen = listAlamat.get(index);
                    BayarController c = new BayarController();
                    boolean success = c.createPesanan(listProduk, listUkuran, listJumlah, metodeBayar, alamatChosen);
                    if (success) {
                        frame.dispose();
                        new Etalase();
                    }
                }
            }
        });

        frame.add(back);
        frame.add(btnBayar);
        frame.add(mainPanel);
        frame.add(bayar);
        frame.add(lblAlamat);
        frame.add(alamat);
        frame.add(lblMetodeBayar);
        frame.add(lblNomor);
        frame.add(transfer);
        frame.add(cod);
        frame.add(ovo);
        frame.add(gopay);
        frame.add(dana);
        frame.add(nomor);
        frame.add(tambahAlamat);
        frame.setVisible(true);
    }
}

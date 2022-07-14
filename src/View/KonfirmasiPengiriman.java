/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.KonfirmasiPengirimanController;
import Model.Pesanan;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author glenn
 */
public class KonfirmasiPengiriman extends JFrame implements ActionListener, MouseListener {

    JFrame frame;
    JButton submit;
    int pesananId;
    JLabel exit;
    KonfirmasiPengirimanController konfirmasi = new KonfirmasiPengirimanController();

    public static void main(String[] args) {
        new KonfirmasiPengiriman();
    }

    KonfirmasiPengiriman() {
        frame = new JFrame("Konfirmasi Pengiriman");
        frame.setSize(420, 380);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font titleF = new Font("Sans Serif", Font.BOLD, 30);
        Font regularF = new Font("Sans Serif", Font.PLAIN, 25);

        JLabel title, idPesanan, nama, produk, jumlah, jenisPembayaran, hargaTotal;
        title = new JLabel("Konfirmasi Pengiriman");
        title.setBounds(0, 0, frame.getSize().width, 35);
        title.setFont(titleF);
        title.setHorizontalAlignment(JLabel.CENTER);
        frame.add(title);

        Pesanan paket = konfirmasi.getPesananTerdepan();
        if (paket != null) {
            pesananId = paket.getId();
            idPesanan = new JLabel("Id Pesanan: " + pesananId);
            idPesanan.setFont(regularF);
            idPesanan.setBounds(15, 45, 300, 27);
            frame.add(idPesanan);

            int customerId = paket.getCustomerId();
            String namaCs = konfirmasi.getNamaCustomer(customerId);
            nama = new JLabel("Nama: " + namaCs);
            nama.setBounds(15, 75, 300, 27);
            nama.setFont(regularF);
            frame.add(nama);

            int produkId = paket.getBarangId();
            String namaProduk = konfirmasi.getNamaProduk(produkId);
            produk = new JLabel("Nama produk: " + namaProduk);
            produk.setBounds(15, 105, 500, 27);
            produk.setFont(regularF);
            frame.add(produk);

            jumlah = new JLabel("Jumlah: " + paket.getJumlah());
            jumlah.setBounds(15, 135, 500, 27);
            jumlah.setFont(regularF);
            frame.add(jumlah);

            String pembayaran = paket.getJenisPembayaran().getString();
            jenisPembayaran = new JLabel("Jenis pembayaran: " + pembayaran);
            jenisPembayaran.setBounds(15, 165, 500, 27);
            jenisPembayaran.setFont(regularF);
            frame.add(jenisPembayaran);

            hargaTotal = new JLabel("Harga total: Rp " + paket.getHargaTotal());
            hargaTotal.setBounds(15, 195, 500, 27);
            hargaTotal.setFont(regularF);
            frame.add(hargaTotal);

            submit = new JButton("Kirim");
            submit.setBounds(15, 235, 200, 50);
            submit.setFont(regularF);
            frame.add(submit);

            submit.addActionListener(this);
        } else {
            idPesanan = new JLabel("Tidak ada pengiriman!");
            idPesanan.setFont(regularF);
            idPesanan.setBounds(15, 45, 300, 27);
            frame.add(idPesanan);
        }

        exit = new JLabel("<<Kembali ke menu admin");
        exit.setBounds(15, 300, 170, 18);
        frame.add(exit);

        exit.addMouseListener(this);

        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            frame.dispose();
            JOptionPane.showMessageDialog(null, konfirmasi.kirimBarang(pesananId));
            new MenuAdmin();
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

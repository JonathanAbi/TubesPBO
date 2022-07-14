package View;

import Controller.TambahAlamatController;
import Model.Produk;
import Model.UkuranEnum;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TambahAlamat {

    public TambahAlamat(ArrayList<Produk> listProduk, ArrayList<UkuranEnum> listUkuran, ArrayList<Integer> listJumlah) {
        TambahAlamatController controller = new TambahAlamatController();
        JFrame frame = new JFrame("Form Tambah Alamat");
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font1 = new Font("Serif", Font.PLAIN, 20);

        JLabel judul = new JLabel("Tambah Alamat");
        judul.setBounds(170, 5, 500, 60);
        judul.setFont(new Font("Serif", Font.BOLD, 35));

        JLabel alamatLabel = new JLabel("Alamat");
        alamatLabel.setBounds(100, 100, 90, 40);
        alamatLabel.setFont(font1);

        JTextField tfAlamat = new JTextField();
        tfAlamat.setBounds(240, 105, 240, 30);
        tfAlamat.setFont(font1);

        JLabel kelurahanLabel = new JLabel("Kelurahan");
        kelurahanLabel.setBounds(100, 140, 90, 40);
        kelurahanLabel.setFont(font1);

        JTextField tfKelurahan = new JTextField();
        tfKelurahan.setBounds(240, 145, 240, 30);
        tfKelurahan.setFont(font1);

        JLabel kecamatanLabel = new JLabel("Kecamatan");
        kecamatanLabel.setBounds(100, 180, 90, 40);
        kecamatanLabel.setFont(font1);

        JTextField tfKecamatan = new JTextField();
        tfKecamatan.setBounds(240, 185, 240, 30);
        tfKecamatan.setFont(font1);

        JLabel kotaLabel = new JLabel("Kota");
        kotaLabel.setBounds(100, 220, 90, 40);
        kotaLabel.setFont(font1);

        JTextField tfKota = new JTextField();
        tfKota.setBounds(240, 225, 240, 30);
        tfKota.setFont(font1);

        JLabel provinsiLabel = new JLabel("Provinsi");
        provinsiLabel.setBounds(100, 260, 90, 40);
        provinsiLabel.setFont(font1);

        JTextField tfProvinsi = new JTextField();
        tfProvinsi.setBounds(240, 265, 240, 30);
        tfProvinsi.setFont(font1);

        JLabel kodePosLabel = new JLabel("Kode Pos");
        kodePosLabel.setBounds(100, 300, 90, 40);
        kodePosLabel.setFont(font1);

        JTextField tfKodePos = new JTextField();
        tfKodePos.setBounds(240, 305, 240, 30);
        tfKodePos.setFont(font1);

        JButton tambah = new JButton("Tambah");
        tambah.setFont(font1);
        tambah.setBounds(310, 345, 170, 50);
        tambah.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (tfAlamat.getText().isEmpty() || tfKelurahan.getText().isEmpty() || tfKecamatan.getText().isEmpty() || tfKota.getText().isEmpty() || tfProvinsi.getText().isEmpty() || tfKodePos.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom wajib diisi!");
                } else {
                    String kondisi = controller.tambahAlamat(tfAlamat.getText(),tfKelurahan.getText(),tfKecamatan.getText(),tfKota.getText(),tfProvinsi.getText(),tfKodePos.getText());
                    JOptionPane.showMessageDialog(null, kondisi);
                    frame.dispose();
                    new BayarScreen(listProduk,listUkuran,listJumlah);
                }
            }

        });

        JButton back = new JButton("Kembali");
        back.setFont(font1);
        back.setBounds(100, 345, 170, 50);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
            }
            
        });
        frame.add(judul);
        frame.add(alamatLabel);
        frame.add(tfAlamat);
        frame.add(kelurahanLabel);
        frame.add(tfKelurahan);
        frame.add(kecamatanLabel);
        frame.add(tfKecamatan);
        frame.add(provinsiLabel);
        frame.add(tfProvinsi);
        frame.add(kotaLabel);
        frame.add(tfKota);
        frame.add(kodePosLabel);
        frame.add(tfKodePos);
        frame.add(tambah);
        frame.add(back);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

package View;

import Controller.RegisterController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Register {

    public Register() {
        RegisterController controller = new RegisterController();
        JFrame frame = new JFrame("Form Registrasi");
        frame.setSize(600, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font1 = new Font("Serif", Font.PLAIN, 20);

        //label judul
        JLabel judul = new JLabel("Register");
        judul.setBounds(225, 5, 500, 60);
        judul.setFont(new Font("Serif", Font.BOLD, 35));

        //label nama
        JLabel namaLabel = new JLabel("Nama");
        namaLabel.setBounds(100, 100, 90, 40);
        namaLabel.setFont(font1);

        //textfield nama
        JTextField tfNama = new JTextField();
        tfNama.setBounds(240, 105, 240, 30);
        tfNama.setFont(font1);

        //label username
        JLabel userNameLabel = new JLabel("Username");
        userNameLabel.setBounds(100, 140, 90, 40);
        userNameLabel.setFont(font1);

        //textfield username
        JTextField tfUserName = new JTextField();
        tfUserName.setBounds(240, 145, 240, 30);
        tfUserName.setFont(font1);

        //label password
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(100, 180, 90, 40);
        passLabel.setFont(font1);

        //password
        JPasswordField pass = new JPasswordField();
        pass.setBounds(240, 185, 240, 30);
        pass.setFont(font1);

        //label telepon
        JLabel teleponLabel = new JLabel("Telepon");
        teleponLabel.setBounds(100, 220, 90, 40);
        teleponLabel.setFont(font1);

        //textfield telepon
        JTextField tfTelepon = new JTextField();
        tfTelepon.setBounds(240, 225, 240, 30);
        tfTelepon.setFont(font1);

        //label alamat
        JLabel alamatLabel = new JLabel("Alamat");
        alamatLabel.setBounds(100, 260, 90, 40);
        alamatLabel.setFont(font1);

        //textfield alamat
        JTextField alamat = new JTextField();
        alamat.setBounds(240, 265, 240, 30);
        alamat.setFont(font1);

        //label kelurahan
        JLabel kelurahanLabel = new JLabel("Kelurahan");
        kelurahanLabel.setBounds(100, 300, 90, 40);
        kelurahanLabel.setFont(font1);

        //textfield kelurahan
        JTextField tfKelurahan = new JTextField();
        tfKelurahan.setBounds(240, 305, 240, 30);
        tfKelurahan.setFont(font1);

        //label kecamatan
        JLabel kecamatanLabel = new JLabel("Kecamatan");
        kecamatanLabel.setBounds(100, 340, 90, 40);
        kecamatanLabel.setFont(font1);

        //textfield kecamatan
        JTextField tfKecamatan = new JTextField();
        tfKecamatan.setBounds(240, 345, 240, 30);
        tfKecamatan.setFont(font1);

        //label kota
        JLabel kotaLabel = new JLabel("Kota");
        kotaLabel.setBounds(100, 380, 90, 40);
        kotaLabel.setFont(font1);

        //textfield kota
        JTextField tfKota = new JTextField();
        tfKota.setBounds(240, 385, 240, 30);
        tfKota.setFont(font1);

        //label provinsi
        JLabel provinsiLabel = new JLabel("Provinsi");
        provinsiLabel.setBounds(100, 420, 90, 40);
        provinsiLabel.setFont(font1);

        //textfield provinsi
        JTextField tfProvinsi = new JTextField();
        tfProvinsi.setBounds(240, 425, 240, 30);
        tfProvinsi.setFont(font1);

        //label kodePos
        JLabel kodePosLabel = new JLabel("Kode Pos");
        kodePosLabel.setBounds(100, 460, 90, 40);
        kodePosLabel.setFont(font1);

        //textfield kodePos
        JTextField tfKodePos = new JTextField();
        tfKodePos.setBounds(240, 465, 240, 30);
        tfKodePos.setFont(font1);

        //button submit
        JButton submit = new JButton("Register");
        submit.setBounds(300, 510, 180, 50);
        submit.setFont(font1);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton back = new JButton("Kembali");
        back.setBounds(100, 510, 180, 50);
        back.setFont(font1);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));

        frame.add(judul);
        frame.add(namaLabel);
        frame.add(tfNama);
        frame.add(userNameLabel);
        frame.add(tfUserName);
        frame.add(passLabel);
        frame.add(pass);
        frame.add(teleponLabel);
        frame.add(tfTelepon);
        frame.add(alamatLabel);
        frame.add(alamat);
        frame.add(kelurahanLabel);
        frame.add(tfKelurahan);
        frame.add(kecamatanLabel);
        frame.add(tfKecamatan);
        frame.add(kotaLabel);
        frame.add(tfKota);
        frame.add(provinsiLabel);
        frame.add(tfProvinsi);
        frame.add(kodePosLabel);
        frame.add(tfKodePos);
        frame.add(submit);
        frame.add(back);
        frame.setLayout(null);
        frame.setVisible(true);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (tfNama.getText().isEmpty() || tfUserName.getText().isEmpty() || pass.getPassword().equals("") || tfTelepon.getText().isEmpty() || alamat.getText().isEmpty() || tfKelurahan.getText().isEmpty() || tfKecamatan.getText().isEmpty() || tfKota.getText().isEmpty() || tfProvinsi.getText().isEmpty() || tfKodePos.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom wajib diisi!");
                } else {
                    String kondisi = controller.register(tfNama.getText(), tfUserName.getText(), pass.getText(), tfTelepon.getText(), alamat.getText(), tfKelurahan.getText(), tfKecamatan.getText(), tfKota.getText(), tfProvinsi.getText(), tfKodePos.getText());
                    JOptionPane.showMessageDialog(null, kondisi);
                    if (kondisi.equals("Berhasil melakukan registrasi")) {
                        frame.dispose();
                        new ChooseLogin();
                    } else if (kondisi.equals("Username sudah digunakan")) {
                        tfUserName.setText("");
                        tfUserName.requestFocus();
                    } else {
                        tfTelepon.setText("");
                        tfTelepon.requestFocus();
                    }
                }
            }
        });
    }
}

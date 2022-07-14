package Model;

import Controller.KeranjangController;
import Model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class PanelKeranjang extends JPanel {

    public boolean chosen=false;
    public int index;
    public Produk produk;
    public UkuranEnum ukuran;
    public int jumlah;

    public PanelKeranjang(int in) {
        index = in;
        //init data
        this.produk = SingletonKeranjang.getInstance().getProdukAt(index);
        this.ukuran = SingletonKeranjang.getInstance().getUkuranAt(index);
        this.jumlah = SingletonKeranjang.getInstance().getJumlahAt(index);

        //font
        Font fontNamaProduk = new Font("Serif", Font.PLAIN, 20);
        Font fontHarga = new Font("Serif", Font.PLAIN, 16);

        double hargaTotal = produk.getHarga() * jumlah;

        //nama barang
        JLabel nama = new JLabel(produk.getNama() + " - " + produk.getWarna() + " - " + ukuran, SwingConstants.LEFT);
        nama.setFont(fontHarga);

        //harga & jumlah
        JLabel deskripsi = new JLabel(String.valueOf(produk.getHarga()) + " x " + jumlah, SwingConstants.LEFT);
        deskripsi.setFont(fontNamaProduk);

        //harga total
        JLabel harga = new JLabel(String.valueOf(hargaTotal), SwingConstants.LEFT);
        harga.setFont(fontNamaProduk);

        //checkbox
        JCheckBox cbChoose = new JCheckBox("Pilih item");
        cbChoose.setFont(fontHarga);
        cbChoose.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (cbChoose.isSelected()) {
                    chosen = true;
                } else {
                    chosen = false;
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setSize(500, 150);
        panel.add(nama);
        panel.add(deskripsi);
        panel.add(harga);

        setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
        setSize(600, 150);
        add(panel);
        add(cbChoose);
    }
}

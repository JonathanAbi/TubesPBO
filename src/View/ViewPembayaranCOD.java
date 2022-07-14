/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Database.DatabaseHandler;
import Model.PengirimanEnum;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author kevin
 */
public class ViewPembayaranCOD {
    
    static DatabaseHandler conn = new DatabaseHandler();
     
    public ViewPembayaranCOD() {
        
        PengirimanEnum kemas = PengirimanEnum.PENGEMASAN;
        PengirimanEnum tunggu = PengirimanEnum.MENUNGGU_KURIR;
        PengirimanEnum antar = PengirimanEnum.DIANTAR;
        PengirimanEnum sampai = PengirimanEnum.SAMPAI;

        String columns[] = {"ID Brg", "Jumlah", "Ukuran", "Warna", "Hrg Sat", "Hrg Tot", "B.Kirim", "J.Bayar",
            "S.Bayar", "S.Kirim"};

        DefaultTableModel model = new DefaultTableModel(null, columns);
        JTable table = new JTable(model);
        table.setShowGrid(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn eventColumn = table.getColumnModel().getColumn(0);
        eventColumn.setPreferredWidth(50);
        TableColumn eventColumn2 = table.getColumnModel().getColumn(1);
        eventColumn2.setPreferredWidth(50);
        TableColumn eventColumn3 = table.getColumnModel().getColumn(2);
        eventColumn3.setPreferredWidth(50);
        TableColumn eventColumn4 = table.getColumnModel().getColumn(3);
        eventColumn4.setPreferredWidth(50);
        TableColumn eventColumn5 = table.getColumnModel().getColumn(4);
        eventColumn5.setPreferredWidth(70);
        TableColumn eventColumn6 = table.getColumnModel().getColumn(5);
        eventColumn6.setPreferredWidth(70);
        TableColumn eventColumn7 = table.getColumnModel().getColumn(6);
        eventColumn7.setPreferredWidth(50);
        TableColumn eventColumn8 = table.getColumnModel().getColumn(7);
        eventColumn8.setWidth(50);
        TableColumn eventColumn9 = table.getColumnModel().getColumn(8);
        eventColumn9.setWidth(50);
        TableColumn eventColumn10 = table.getColumnModel().getColumn(9);
        eventColumn10.setWidth(40);
        JScrollPane pane = new JScrollPane(table);

        conn.connect();
        
        String query = "SELECT * FROM pesanan WHERE status_pembayaran='0' ";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String barang = rs.getString("barang_id");
                String jumlah = rs.getString("jumlah");
                String ukuran = rs.getString("ukuran");
                String warna = rs.getString("warna");
                String hargaS = rs.getString("harga_satuan");
                String hargaT = rs.getString("harga_total");
                String biayaP = rs.getString("biaya_pengiriman");
                String jns_bayar = rs.getString("jenis_pembayaran");

                if (jns_bayar.equals(0)) {
                    jns_bayar = "Transfer Bank";
                } else if (jns_bayar.equals(1)) {
                    jns_bayar = "COD";
                } else if (jns_bayar.equals(2)) {
                    jns_bayar = "OVO";
                } else if (jns_bayar.equals(3)) {
                    jns_bayar = "GOPAY";
                } else if (jns_bayar.equals(4)) {
                    jns_bayar = "DANA";
                }

                String status_bayar = rs.getString("status_pembayaran");

                String status_kirim = rs.getString("status_pengiriman");
                if (status_kirim.equals(kemas.ordinal())) {
                    status_kirim = "Dikemas";
                } else if (status_kirim.equals(tunggu.ordinal())) {
                    status_kirim = "Menunggu Kurir";
                } else if (status_kirim.equals(antar.ordinal())) {
                    status_kirim = "Diantar";
                } else if (status_kirim.equals(sampai.ordinal())) {
                    status_kirim = "Sampai";
                }

                String[] baris = {barang, jumlah, ukuran, warna, hargaS, hargaT, biayaP, jns_bayar, status_bayar, status_kirim};
                model.addRow(baris);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("View COD");
        JPanel panel = new JPanel();

        JButton buttonUpdate = new JButton("BAYAR");
        buttonUpdate.setBounds(110, 460, 100, 40);

        panel.add(pane);
        frame.add(buttonUpdate);
        frame.add(panel);
        frame.add(panel);
        frame.setSize(700, 800);
        frame.setVisible(true);

        buttonUpdate.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {

                new UpdateBayarCOD();

            }
        });
    }
}

package View;

import Controller.ControllerKurir;
import static View.ViewDataKurir.conn;
import java.awt.Color;
import java.awt.Font;
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
public class RiwayatPesananView {

    public RiwayatPesananView() {

        String columns[] = {"Kurir", "Barang", "Berat", "Harga", "Warna", "Baju", "Harga Total",
            "S.Kirim"};
        DefaultTableModel model = new DefaultTableModel(null, columns);
        JTable table = new JTable(model);
        table.setShowGrid(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn eventColumn = table.getColumnModel().getColumn(0);
        eventColumn.setPreferredWidth(50);
        TableColumn eventColumn2 = table.getColumnModel().getColumn(1);
        eventColumn2.setPreferredWidth(100);
        TableColumn eventColumn3 = table.getColumnModel().getColumn(2);
        eventColumn3.setPreferredWidth(50);
        TableColumn eventColumn4 = table.getColumnModel().getColumn(3);
        eventColumn4.setPreferredWidth(50);
        TableColumn eventColumn5 = table.getColumnModel().getColumn(4);
        eventColumn5.setPreferredWidth(50);
        TableColumn eventColumn6 = table.getColumnModel().getColumn(5);
        eventColumn6.setPreferredWidth(50);
        TableColumn eventColumn7 = table.getColumnModel().getColumn(6);
        eventColumn7.setPreferredWidth(70);
        TableColumn eventColumn8 = table.getColumnModel().getColumn(7);
        eventColumn8.setPreferredWidth(50);
        JScrollPane pane = new JScrollPane(table);

        conn.connect();
        String query = "SELECT kurir.kurir_id, barang.nama, barang.berat, barang.harga, pesanan.warna, pesanan.ukuran, pesanan.harga_total, pesanan.status_pengiriman FROM kurir INNER JOIN pesanan ON kurir.kurir_id = pesanan.kurir_id INNER JOIN barang ON barang.barang_id = pesanan.pesanan_id WHERE status_pengiriman='3'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String kurir = rs.getString("kurir_id");
                String barang = rs.getString("nama");
                String berat = rs.getString("berat");
                String harga = rs.getString("harga");
                String warna = rs.getString("warna");
                String baju = rs.getString("ukuran");
                String hrgTotal = rs.getString("harga_total");
                String statusKirim = rs.getString("status_pengiriman");

                String[] baris = {kurir, barang, berat, harga, warna, baju, hrgTotal, statusKirim};
                model.addRow(baris);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Tabel Barang");
        JPanel panel = new JPanel();

        JButton buttonExit = new JButton("BACK");
        buttonExit.setBounds(600, 460, 100, 40);

        panel.add(pane);
        frame.add(buttonExit);
        frame.add(panel);
        frame.add(panel);
        frame.setSize(600, 700);
        frame.setVisible(true);

        buttonExit.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                new MenuKurir();
            }
        });
    }
}

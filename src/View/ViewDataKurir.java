/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Database.DatabaseHandler;
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
public class ViewDataKurir {
    static DatabaseHandler conn = new DatabaseHandler();

    public ViewDataKurir() {

        String columns[] = {"Nama", "Telepon", "Kapasitas Barang", "Total Barang Bawaan"};
        DefaultTableModel model = new DefaultTableModel(null, columns);
        JTable table = new JTable(model);
        table.setShowGrid(true);
        TableColumn eventColumn = table.getColumnModel().getColumn(3);
        eventColumn.setPreferredWidth(100);
        JScrollPane pane = new JScrollPane(table);

        conn.connect();
        String query = "SELECT * FROM kurir";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String nama = rs.getString("nama");
                String telepon = rs.getString("telepon");
                String kapasitas = rs.getString("kapasitas_berat_barang");
                String total = rs.getString("total_berat_barang");

                String[] baris = {nama, telepon, kapasitas, total};
                model.addRow(baris);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Tabel Kurir");
        JPanel panel = new JPanel();

        JButton buttonUpdate = new JButton("UPDATE");
        buttonUpdate.setBounds(60, 440, 100, 40);
        JButton buttonDelete = new JButton("DELETE");
        buttonDelete.setBounds(170, 440, 100, 40);
        JButton buttonExit = new JButton("EXIT");
        buttonExit.setBounds(280, 440, 100, 40);

        panel.add(pane);
        frame.add(buttonUpdate);
        frame.add(buttonDelete);
        frame.add(buttonExit);
        frame.add(panel);
        frame.add(panel);
        frame.setSize(600, 700);
        frame.setVisible(true);
        
        buttonUpdate.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {

                new AddDataKurir();

            }
        });

        buttonDelete.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {

                new AddDataKurir();

            }
        });

        buttonExit.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                System.exit(0);
                buttonExit.addActionListener(this);
            }
        });
    }
}

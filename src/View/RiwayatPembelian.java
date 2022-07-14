package View;

import Controller.EtalasePanelBarangController;
import Controller.RiwayatPembelianController;
import Model.PanelRiwayat;
import Model.Pesanan;
import Model.SingletonKeranjang;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RiwayatPembelian {

    public RiwayatPembelian() {
        EtalasePanelBarangController c = new EtalasePanelBarangController();
        c.getProduk();
        RiwayatPembelianController controller = new RiwayatPembelianController();

        Font fontButton = new Font("Serif", Font.PLAIN, 14);

        //frame
        JFrame frame = new JFrame("Riwayat Pembelian");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
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
                new Profile();
            }
        });

        //Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBounds(5, 55, 575, 590);

        //panel list
        JPanel panelList = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panelList.add(new JPanel(), gbc);

        mainPanel.add(new JScrollPane(panelList));
        ArrayList<Pesanan> listBarang = controller.getRiwayat();
        PanelRiwayat[] riwayatPembelian = new PanelRiwayat[listBarang.size()];
        for (int i = 0; i < listBarang.size(); i++) {
            riwayatPembelian[i] = new PanelRiwayat(listBarang.get(i));
            gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panelList.add(riwayatPembelian[i], gbc, 0);
        }
        frame.add(back);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}

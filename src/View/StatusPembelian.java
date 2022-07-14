package View;

import Controller.EtalasePanelBarangController;
import Controller.RiwayatPembelianController;
import Model.PanelRiwayat;
import Model.PengirimanEnum;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StatusPembelian {
    
    public StatusPembelian(){
        //font
        Font fontButton = new Font("Serif", Font.PLAIN, 14);
        
        //frame
        JFrame frame = new JFrame("Status Pembelian");
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
        
        ArrayList<Pesanan> listPesanan = new ArrayList<>();
        
        //JLabel 1
        JLabel lbl1 = new JLabel("Dalam Pengemasan");
        lbl1.setBounds(5,35,400,20);
        lbl1.setFont(new Font("Serif",Font.PLAIN,16));
        
        //JLabel 1
        JLabel lbl2 = new JLabel("Menunggu Kurir");
        lbl2.setBounds(5,235,400,20);
        lbl2.setFont(new Font("Serif",Font.PLAIN,16));
        
        //JLabel 1
        JLabel lbl3 = new JLabel("Sedang Diantar");
        lbl3.setBounds(5,435,400,20);
        lbl3.setFont(new Font("Serif",Font.PLAIN,16));
        
        //Main Panel
        JPanel mainPanel1 = new JPanel();
        mainPanel1.setLayout(new BorderLayout());
        mainPanel1.setBounds(5, 55, 575, 175);

        //panel list
        JPanel panelList1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panelList1.add(new JPanel(), gbc);
        mainPanel1.add(new JScrollPane(panelList1));
        
        //Main Panel
        JPanel mainPanel2 = new JPanel();
        mainPanel2.setLayout(new BorderLayout());
        mainPanel2.setBounds(5, 255, 575, 175);

        //panel list
        JPanel panelList2 = new JPanel(new GridBagLayout());
        panelList2.add(new JPanel(), gbc);
        mainPanel2.add(new JScrollPane(panelList2));
        
        //Main Panel
        JPanel mainPanel3 = new JPanel();
        mainPanel3.setLayout(new BorderLayout());
        mainPanel3.setBounds(5, 455, 575, 175);

        //panel list
        JPanel panelList3 = new JPanel(new GridBagLayout());
        panelList3.add(new JPanel(), gbc);
        mainPanel3.add(new JScrollPane(panelList3));
        
        for (int i = 0; i < listPesanan.size(); i++) {
            JPanel panel = new PanelRiwayat(listPesanan.get(i));
            gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            if(listPesanan.get(i).getStatusPengiriman() == PengirimanEnum.PENGEMASAN){
                panelList1.add(panel, gbc, 0);
            }
            if(listPesanan.get(i).getStatusPengiriman() == PengirimanEnum.MENUNGGU_KURIR){
                panelList2.add(panel, gbc, 0);
            }
            if(listPesanan.get(i).getStatusPengiriman() == PengirimanEnum.DIANTAR){
                panelList3.add(panel, gbc, 0);
            }
        }
        frame.add(back);
        frame.add(lbl1);
        frame.add(lbl2);
        frame.add(lbl3);
        frame.add(mainPanel1);
        frame.add(mainPanel2);
        frame.add(mainPanel2);
        frame.setVisible(true);
    }
}

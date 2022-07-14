package View;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author kevin
 */
public class MenuKurir {

    public MenuKurir() {
        JFrame frame = new JFrame("Main Kurir");
        frame.setSize(680, 470);
        frame.setLocationRelativeTo(null);
        Font myFont = new Font("Serif", Font.BOLD, 24);
        Font myFont2 = new Font("Serif", Font.BOLD, 18);

        JLabel label = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();

        label.setText("SELAMAT DATANG DI MENU KURIR");
        label.setBounds(100, 60, 500, 30);
        label.setFont(myFont);

        label2.setText("||");
        label2.setBounds(310, 100, 500, 30);
        label2.setFont(myFont);

        label3.setText(":||:");
        label3.setBounds(302, 110, 500, 30);
        label3.setFont(myFont);

        label4.setText("||");
        label4.setBounds(310, 120, 500, 30);
        label4.setFont(myFont);

        label5.setText("SILAHKAN MEMILIH MENU");
        label5.setBounds(200, 160, 300, 30);
        label5.setFont(myFont2);

        JButton btnTerima = new JButton("TERIMA BARANG");
        btnTerima.setBounds(80, 250, 150, 40);
        
        JButton btnPeng = new JButton("KONFIRMASI KIRIM");
        btnPeng.setBounds(240, 250, 150, 40);

        JButton btnCOD = new JButton("KONFIRMASI COD");
        btnCOD.setBounds(400, 250, 150, 40);
        
        JButton btnRiwayat = new JButton("RIWAYAT PENGIRIMAN");
        btnRiwayat.setBounds(130, 300, 200, 40);
        
        JButton btnExit = new JButton("EXIT");
        btnExit.setBounds(340, 300, 150, 40);

        frame.add(label);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(btnTerima);
        frame.add(btnPeng);
        frame.add(btnRiwayat);
        frame.add(btnCOD);
        frame.add(btnExit);
        frame.setLayout(null);
        frame.setVisible(true);

        btnTerima.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                new ViewTerimaPengiriman();
                
            }
        });
        
        btnPeng.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                
                new UpdateKonKirim();
            }
        });

        btnCOD.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                
                new ViewPembayaranCOD();
            }
        });

        btnRiwayat.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                new RiwayatPesananView();
                
            }
        });

        btnExit.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {

                System.exit(0);
                btnExit.addActionListener(this);
            }
        });
    }
}

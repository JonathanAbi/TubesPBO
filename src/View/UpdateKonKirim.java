package View;

import Controller.ControllerPengiriman;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author kevin
 */
public class UpdateKonKirim {

    public UpdateKonKirim() {

        JFrame frame = new JFrame("Menu Pengiriman");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        Font myFont = new Font("Serif", Font.BOLD, 18);

        //enter name label
        JLabel label = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();

        label3.setText("FORM KONFRIMASI KIRIM");
        label3.setBounds(10, 30, 500, 30);
        Font myFont5 = new Font("Arial Black", Font.BOLD, 28);
        label3.setFont(myFont5);
        label3.setForeground(Color.BLUE);
        label3.setOpaque(true);

        label.setText("ID Barang");
        label.setBounds(10, 100, 100, 30);
        label.setFont(myFont);

        label2.setText("Alamat");
        label2.setBounds(10, 150, 100, 30);
        label2.setFont(myFont);

        JTextField id = new JTextField();
        id.setBounds(210, 100, 120, 30);

        JTextArea alamat = new JTextArea();
        alamat.setBounds(210, 150, 150, 80);

        // Absolute Position
        JButton buttonSerahkan = new JButton("SERAHKAN");
        buttonSerahkan.setBounds(10, 250, 100, 40);
        JButton buttonRefresh = new JButton("REFRESH");
        buttonRefresh.setBounds(130, 250, 100, 40);

        frame.add(label);
        frame.add(label2);
        frame.add(label3);
        frame.add(alamat);
        frame.add(id);
        frame.add(buttonRefresh);
        frame.add(buttonSerahkan);
        frame.setLayout(null);
        frame.setVisible(true);

        buttonRefresh.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                id.setText("");

            }
        });

        buttonSerahkan.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                if (id.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom wajib diisi!");
                } else {
                    ControllerPengiriman.konfirmasiKirim(id.getText());
                    new MenuKurir();
                }

            }
        });
    }
}

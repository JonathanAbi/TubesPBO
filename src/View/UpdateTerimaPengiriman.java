package View;

import Controller.ControllerPengiriman;
import Model.PengirimanEnum;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author kevin
 */
public class UpdateTerimaPengiriman {

    public UpdateTerimaPengiriman() {

        JFrame frame = new JFrame("Menu Pengiriman");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        Font myFont = new Font("Serif", Font.BOLD, 18);

        //enter name label
        JLabel label = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();

        label3.setText("FORM TERIMA PENGIRIMAN");
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
        JButton buttonUpdate = new JButton("UPDATE");
        buttonUpdate.setBounds(10, 250, 100, 40);
        JButton buttonRefresh = new JButton("REFRESH");
        buttonRefresh.setBounds(130, 250, 100, 40);

        frame.add(label);
        frame.add(label2);
        frame.add(label3);
        frame.add(id);
        frame.add(alamat);
        frame.add(buttonRefresh);
        frame.add(buttonUpdate);
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

        buttonUpdate.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                 if (id.getText().isEmpty() || alamat.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom wajib diisi!");
                } else {
                    ControllerPengiriman.terimaPengiriman(id.getText());
                    new MenuKurir();
                }

            }
        });
    }

}

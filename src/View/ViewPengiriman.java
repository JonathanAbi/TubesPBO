package View;

import Controller.ControllerKurir;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class ViewPengiriman {

    static JLabel l;
    private JPanel contentPane;
    private JTable table;

    public ViewPengiriman() {

        JFrame frame = new JFrame("Menu Kurir");
        frame.setSize(600, 700);
        frame.setLocationRelativeTo(null);
        Font myFont = new Font("Serif", Font.BOLD, 18);

        //enter name label
        JLabel label = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel label6 = new JLabel();
        JLabel label7 = new JLabel();

        label7.setText("FORM KURIR");
        label7.setBounds(10, 30, 300, 30);
        Font myFont5 = new Font("Arial Black", Font.BOLD, 28);
        label7.setFont(myFont5);
        label7.setForeground(Color.BLUE);
        label7.setOpaque(true);

        label.setText("Nama Kurir");
        label.setBounds(10, 100, 100, 30);
        label.setFont(myFont);
        label.setOpaque(true);
        
        label2.setText("Username");
        label2.setBounds(10, 150, 100, 30);
        label2.setFont(myFont);
        label2.setOpaque(true);
        
        label3.setText("Password");
        label3.setBounds(10, 200, 100, 30);
        label3.setFont(myFont);
        label3.setOpaque(true);
        
        label4.setText("Telepon");
        label4.setBounds(10, 250, 100, 30);
        label4.setFont(myFont);
        label4.setOpaque(true);

        label5.setText("Kapasitas Berat Barang");
        label5.setBounds(10, 300, 200, 30);
        label5.setFont(myFont);
        label5.setOpaque(true);

        label6.setText("Total Berat Barang");
        label6.setBounds(10, 350, 200, 30);
        label6.setFont(myFont);
        label6.setOpaque(true);

        JTextField nama = new JTextField();
        JTextField username = new JTextField();
        JPasswordField pass = new JPasswordField();
        JTextField telepon = new JTextField();
        JTextField kapasitasBarang = new JTextField();
        JTextField totalKapasitas = new JTextField();

        nama.setBounds(210, 100, 200, 30);
        nama.setBackground(Color.WHITE);
        
        username.setBounds(210, 150, 200, 30);
        username.setBackground(Color.WHITE);
        
        pass.setBounds(210, 200, 200, 30);
        pass.setBackground(Color.WHITE);

        telepon.setBounds(210, 250, 200, 30);
        telepon.setBackground(Color.WHITE);

        kapasitasBarang.setBounds(210, 300, 200, 30);
        kapasitasBarang.setBackground(Color.WHITE);

        totalKapasitas.setBounds(210, 350, 200, 30);
        totalKapasitas.setBackground(Color.WHITE);

        // Absolute Position
        JButton buttonSave = new JButton("Save");
        buttonSave.setBounds(10, 410, 100, 40);
        JButton buttonUpdate = new JButton("UPDATE");
        buttonUpdate.setBounds(120, 410, 100, 40);
        JButton buttonRefresh = new JButton("REFRESH");
        buttonRefresh.setBounds(230, 410, 100, 40);
        JButton buttonExit = new JButton("Exit");
        buttonExit.setBounds(340, 410, 100, 40);
        buttonUpdate.setEnabled(true);

        frame.add(label);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(label6);
        frame.add(label7);
        frame.add(nama);
        frame.add(telepon);
        frame.add(username);
        frame.add(pass);
        frame.add(kapasitasBarang);
        frame.add(totalKapasitas);
        frame.add(buttonExit);
        frame.add(buttonSave);
        frame.add(buttonUpdate);
        frame.add(buttonRefresh);
        frame.setLayout(null);
        frame.setVisible(true);

        buttonSave.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                if (nama.getText().isEmpty() || telepon.getText().isEmpty() || kapasitasBarang.getText().isEmpty()
                        || totalKapasitas.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom wajib diisi!");
                } else {
                    ControllerKurir.addKurir(nama.getText(), username.getText(), pass.getText(), telepon.getText(), kapasitasBarang.getText(), totalKapasitas.getText());
                    ControllerKurir.hitungKapasitasBarang();
                }
                
            }
        });

        buttonRefresh.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                nama.setText("");
                telepon.setText("");
                username.setText("");
                pass.setText("");
                kapasitasBarang.setText("");
                totalKapasitas.setText("");

            }
        });

    }
}

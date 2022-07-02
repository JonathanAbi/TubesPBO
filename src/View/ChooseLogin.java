package View;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChooseLogin implements ActionListener{
    JFrame frame = new JFrame("Login");
    public static void main(String[] args) {
        new ChooseLogin();
    }
    public ChooseLogin() {
        frame.setSize(500, 460);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font1 = new Font("Serif", Font.PLAIN, 25);

        //label judul
        JLabel judul = new JLabel("Login Sebagai");
        judul.setBounds(130, 5, 500, 60);
        judul.setFont(new Font("Serif", Font.BOLD, 35));

        //button admin
        JButton buttonAdmin = new JButton("Admin");
        buttonAdmin.setBounds(180, 100, 120, 50);
        buttonAdmin.setFont(font1);
        buttonAdmin.addActionListener(this);
        buttonAdmin.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //button client
        JButton buttonClient = new JButton("Client");
        buttonClient.setBounds(180, 160, 120, 50);
        buttonClient.setFont(font1);
        buttonClient.addActionListener(this);
        buttonClient.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //button kurir
        JButton buttonKurir = new JButton("Kurir");
        buttonKurir.setBounds(180, 220, 120, 50);
        buttonKurir.setFont(font1);
        buttonKurir.addActionListener(this);
        buttonKurir.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton buttonBack = new JButton("Kembali");
        buttonBack.setBounds(180, 280, 120, 50);
        buttonBack.setFont(font1);
        buttonBack.setCursor(new Cursor(Cursor.HAND_CURSOR));

        frame.add(judul);
        frame.add(buttonAdmin);
        frame.add(buttonClient);
        frame.add(buttonKurir);
        frame.add(buttonBack);
        frame.setLayout(null);
        frame.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "Admin": 
                frame.dispose();
                new Login("admin");
                break;
            case "Client":
                frame.dispose();
                new Login("customers");
                break;
            case "Kurir":
                frame.dispose();
                new Login("kurir");
                break;
            case "Kembali":
                break;
            default: 
                break;
        }
    }
}

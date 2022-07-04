package View;

import Controller.EtalaseController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Etalase {
    
    JFrame frame = new JFrame("Etalase");
    JPanel panel1 = new JPanel();
    
    public Etalase(){
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.X_AXIS));
        frame.setVisible(true);
    }
}

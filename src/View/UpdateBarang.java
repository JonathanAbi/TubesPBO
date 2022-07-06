/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.UpdateBarangController;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author glenn
 */
public class UpdateBarang {
    public static void main(String[] args) {
        new UpdateBarang();
    }
    public UpdateBarang() {
        JFrame frame = new JFrame("Update Barang");
        frame.setSize(600, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font fontTitle=new Font("Serif", Font.BOLD, 35);
        
        //title of the menu
        JLabel judul = new JLabel("Menu Update Barang");
        judul.setHorizontalAlignment(JLabel.CENTER);
        judul.setFont(fontTitle);
        frame.add(judul);
        frame.setVisible(true);
    }
}

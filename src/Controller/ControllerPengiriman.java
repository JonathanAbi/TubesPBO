
package Controller;

import static Controller.ControllerKurir.conn;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class ControllerPengiriman {

    public static void terimaPengiriman(String idBarang) {
        conn.connect();
        try {
            String query = "UPDATE pesanan SET status_pengiriman='2' WHERE barang_id='" + idBarang + "'";
            Statement stmt = null;
            stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Status Pengiriman kini diantar oleh kurir");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal !!");
        }
    }
    
     public static void konfirmasiKirim(String idBrg) {
        conn.connect();
        try {
            String query = "UPDATE pesanan SET status_pengiriman='3' WHERE barang_id='" + idBrg + "'";
            Statement stmt = null;
            stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Barang sudah sampai");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal!!");
        }
    }
    
    public static void pembayaranCOD(String idBarang) {
        conn.connect();
        try {
            String query = "UPDATE pesanan SET status_pembayaran='1' WHERE barang_id='" + idBarang + "'";
            Statement stmt = null;
            stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Pembayaran Lunas");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Pembayaran gagal");
        }
    }

    public static void deletePengiriman(String idBarang) {
        conn.connect();

        String query = "DELETE FROM pesanan WHERE barang_id='" + idBarang + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal menghapus data");
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.koneksi;
import model.Barang;
import java.sql.Date;
/**
 *
 * @author Reidytamma
 */
public class Keluar {
    public static boolean prosesTransaksiKeluar(String serialNumber, int jumlahKeluar, Date tanggalKeluar, String keterangan) {
        String sqlInsertTransaksi = "INSERT INTO transaksi (serial_number, jumlah_keluar, tanggal_keluar, keterangan) VALUES (?, ?, ?, ?)";
        String sqlUpdateStok = "UPDATE barang SET stok = stok - ? WHERE serial_number = ? AND stok >= ?";
        
        Connection conn = null;
        try {
            conn = koneksi.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement psInsert = conn.prepareStatement(sqlInsertTransaksi);
            psInsert.setString(1, serialNumber);
            psInsert.setInt(2, jumlahKeluar);
            psInsert.setDate(3, tanggalKeluar);
            psInsert.setString(4, keterangan);
            int rowsInserted = psInsert.executeUpdate();
            PreparedStatement psUpdate = conn.prepareStatement(sqlUpdateStok);
            psUpdate.setInt(1, jumlahKeluar);
            psUpdate.setString(2, serialNumber);
            psUpdate.setInt(3, jumlahKeluar);
            int rowsUpdated = psUpdate.executeUpdate();
            

            if (rowsInserted > 0 && rowsUpdated > 0) {
                conn.commit(); 
                System.out.println("[LOG GUDANG] Transaksi keluar berhasil disimpan & stok barang diperbarui.");
                return true;
            } else {
                conn.rollback(); 
                System.out.println("Gagal: Stok barang tidak mencukupi atau SN salah.");
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("Error database: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback(); 
                } catch (SQLException ex) {
                    System.out.println("Rollback gagal: " + ex.getMessage());
                }
            }
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true); 
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

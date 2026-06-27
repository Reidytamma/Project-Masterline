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
/**
 *
 * @author Reidytamma
 */
public class Masuk {
    public static boolean simpanKeDatabase(Barang barang) {
        if (!OperasiBarang.cekHargaValid(barang.getHarga())) {
            System.out.println("Gagal: Harga tidak boleh minus!");
            return false;
        }

        String sql = "INSERT INTO barang (serial_number, nama_barang, merek, stok, harga, garansi_bulan) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            Connection conn = koneksi.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, barang.getSerialNumber());
            ps.setString(2, barang.getNamaBarang());
            ps.setString(3, barang.getMerek());
            ps.setInt(4, barang.getStok());
            ps.setDouble(5, barang.getHarga());
            ps.setInt(6, 12);
            ps.executeUpdate();
            barang.logAksi(barang.getNamaBarang(), "simpan ke database");
            
            return true;
        } catch (SQLException e) {
            System.out.println("Error database: " + e.getMessage());
            return false;
        }
    }
}

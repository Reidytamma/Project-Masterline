/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package database;

/**
 *
 * @author Reidytamma
 */
public interface OperasiBarang {
    void tambahStok(int jumlah);
    default void logAksi(String namaBarang, String aksi) {
        System.out.println("[LOG GUDANG] Barang " + namaBarang + " telah di-" + aksi);
    }
    static boolean cekHargaValid(double harga) {
        return harga >= 0;
    }
}

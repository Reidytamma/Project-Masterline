/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import database.OperasiBarang;
/**
 *
 * @author Reidytamma
 */
public class BarangGaransiToko extends Barang {
    private final int garansiBulan = 1;

    public BarangGaransiToko(String idBarang, String serialNumber, String namaBarang, String merek, int stok, double harga) {
        super(idBarang, serialNumber, namaBarang, merek, stok, harga);
    }
    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Tipe: Garansi Toko | Durasi: " + garansiBulan + " Bulan (Distributor)");
    }
    public int getGaransiBulan() { 
        return garansiBulan; 
    }
}

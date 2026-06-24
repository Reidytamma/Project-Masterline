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
public class BarangGaransiResmi extends Barang {
    private int garansiBulan;

    public BarangGaransiResmi(String idBarang, String serialNumber, String namaBarang, String merek, int stok, double harga, int garansiBulan) {
        super(idBarang, serialNumber, namaBarang, merek, stok, harga);
        this.garansiBulan = garansiBulan;
    }
    @Override
    public void tampilkanDetail() {
        super.tampilkanDetail();
        System.out.println("Tipe: Garansi Resmi | Durasi: " + garansiBulan + " Bulan");
    }
    public int getGaransiBulan() { 
        return garansiBulan; 
    }
}

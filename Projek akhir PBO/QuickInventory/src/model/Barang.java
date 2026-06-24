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
public abstract class Barang implements OperasiBarang {
    // ENKAPSULASI: Atribut private (Syarat Proyek)
    private String idBarang;
    private String serialNumber;
    private String namaBarang;
    private String merek;
    private int stok;
    private double harga;

    // CONSTRUCTOR 1: Dipanggil saat load data lengkap (Syarat Proyek)
    public Barang(String idBarang, String serialNumber, String namaBarang, String merek, int stok, double harga) {
        this.idBarang = idBarang;
        this.serialNumber = serialNumber;
        this.namaBarang = namaBarang;
        this.merek = merek;
        this.stok = stok;
        this.harga = harga;
    }

    // OVERLOADING CONSTRUCTOR: Jika barang baru masuk belum ada stok/harga (Syarat Proyek)
    public Barang(String idBarang, String namaBarang) {
        this(idBarang, "-", namaBarang, "-", 0, 0.0);
    }

    // POLIMORFISME: Method untuk Overriding nanti
    public void tampilkanDetail() {
        System.out.println("ID: " + idBarang + " | Nama: " + namaBarang + " | Stok: " + stok);
    }

    // Implementasi Interface OperasiBarang
    @Override
    public void tambahStok(int jumlah) {
        if (OperasiBarang.cekHargaValid(jumlah)) { 
            this.stok += jumlah;
            logAksi(this.namaBarang, "tambah stok menjadi " + this.stok);
        }
    }

    // GETTER & SETTER untuk Enkapsulasi (Syarat Proyek)
    public String getIdBarang() { return idBarang; }
    public String getSerialNumber() { return serialNumber; }
    public String getNamaBarang() { return namaBarang; }
    public String getMerek() { return merek; }
    public int getStok() { return stok; }
    public double getHarga() { return harga; }
}

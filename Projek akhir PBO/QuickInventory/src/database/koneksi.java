/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author HP
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi{

    private static final String URL
            = "jdbc:mysql://localhost:3306/quick_inventory";

    private static final String USER
            = "root";

    private static final String PASSWORD
            = "";

    public static Connection getConnection()
            throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver tidak ditemukan");
        }

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}

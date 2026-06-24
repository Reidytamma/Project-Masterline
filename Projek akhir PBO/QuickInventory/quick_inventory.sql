-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 24, 2026 at 09:41 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quick_inventory`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(11) NOT NULL,
  `serial_number` varchar(50) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `merek` varchar(50) DEFAULT NULL,
  `stok` int(11) DEFAULT 0,
  `harga` int(11) DEFAULT 0,
  `garansi_bulan` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `serial_number`, `nama_barang`, `merek`, `stok`, `harga`, `garansi_bulan`) VALUES
(1, 'SN-LOGI-8392X', 'Mouse Wireless M331', 'Logitech', 45, 195000, 12),
(2, 'SN-SAMS-9912A', 'Monitor Gaming 24\"', 'Samsung', 12, 1850000, 24),
(3, 'SN-ASUS-4410M', 'Laptop Asus Vivobook', 'Asus', 7, 8500000, 24),
(4, 'SN-KEYB-7721K', 'Mechanical Keyboard K8', 'Keychron', 20, 1200000, 12),
(5, 'SN-SONY-1029WH', 'Headphone WH-1000XM4', 'Sony', 5, 3499000, 12),
(6, 'SN-SAND-5541U', 'Flashdisk 64GB USB 3.0', 'SanDisk', 120, 85000, 6),
(7, 'SN-ACER-3321N', 'Proyektor X1126AH', 'Acer', 8, 4200000, 12),
(8, 'SN-RODE-9902M', 'Microphone NT-USB', 'Rode', 15, 2600000, 24),
(9, 'SN-SEAG-1102H', 'Harddisk Eksternal 1TB', 'Seagate', 30, 775000, 36),
(10, 'SN-RAZR-6652D', 'Mouse Pad Viper', 'Razer', 50, 250000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `no_transaksi` varchar(30) NOT NULL,
  `tipe` enum('Masuk','Keluar') NOT NULL,
  `id_barang` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `keterangan` varchar(200) DEFAULT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `username`, `password`) VALUES
(1, 'AdminBayu', 'bayusaloko'),
(2, 'AdminTean', 'kevintean'),
(3, 'AdminRei', 'password');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`),
  ADD UNIQUE KEY `serial_number` (`serial_number`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD UNIQUE KEY `no_transaksi` (`no_transaksi`),
  ADD KEY `id_barang` (`id_barang`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

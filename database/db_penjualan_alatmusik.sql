/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  RVNOLDYVX
 * Created: 29 Apr 2025
 */
-- Buat database
CREATE DATABASE IF NOT EXISTS db_penjualan_alatmusik;
USE db_penjualan_alatmusik;

-- Tabel Kategori
CREATE TABLE IF NOT EXISTS kategori (
    id_kategori INT AUTO_INCREMENT PRIMARY KEY,
    nama_kategori VARCHAR(50) NOT NULL,
    deskripsi TEXT
);

-- Tabel Produk (Alat Musik)
CREATE TABLE IF NOT EXISTS produk (
    id_produk INT AUTO_INCREMENT PRIMARY KEY,
    id_kategori INT,
    kode_produk VARCHAR(20) UNIQUE NOT NULL,
    nama_produk VARCHAR(100) NOT NULL,
    harga DECIMAL(12,2) NOT NULL,
    stok INT NOT NULL DEFAULT 0,
    deskripsi TEXT,
    tanggal_masuk DATE,
    FOREIGN KEY (id_kategori) REFERENCES kategori(id_kategori)
);

-- Tabel Pelanggan
CREATE TABLE IF NOT EXISTS pelanggan (
    id_pelanggan INT AUTO_INCREMENT PRIMARY KEY,
    kode_pelanggan VARCHAR(20) UNIQUE NOT NULL,
    nama VARCHAR(100) NOT NULL,
    no_telp VARCHAR(15),
    alamat TEXT,
    tanggal_daftar DATE
);

-- Tabel Pengguna (Admin/Kasir)
CREATE TABLE IF NOT EXISTS pengguna (
    id_pengguna INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    nama_lengkap VARCHAR(100) NOT NULL,
    level ENUM('admin', 'kasir') NOT NULL,
    status BOOLEAN DEFAULT TRUE
);

-- Tabel Penjualan
CREATE TABLE IF NOT EXISTS penjualan (
    id_penjualan INT AUTO_INCREMENT PRIMARY KEY,
    no_faktur VARCHAR(20) UNIQUE NOT NULL,
    id_pelanggan INT,
    id_pengguna INT NOT NULL,
    tanggal_penjualan DATETIME NOT NULL,
    total_harga DECIMAL(12,2) NOT NULL,
    diskon DECIMAL(12,2) DEFAULT 0,
    total_bayar DECIMAL(12,2) NOT NULL,
    status_bayar ENUM('Lunas', 'Belum Lunas') DEFAULT 'Lunas',
    keterangan TEXT,
    FOREIGN KEY (id_pelanggan) REFERENCES pelanggan(id_pelanggan),
    FOREIGN KEY (id_pengguna) REFERENCES pengguna(id_pengguna)
);

-- Tabel Detail Penjualan
CREATE TABLE IF NOT EXISTS detail_penjualan (
    id_detail INT AUTO_INCREMENT PRIMARY KEY,
    id_penjualan INT NOT NULL,
    id_produk INT NOT NULL,
    jumlah INT NOT NULL,
    harga_satuan DECIMAL(12,2) NOT NULL,
    subtotal DECIMAL(12,2) NOT NULL,
    FOREIGN KEY (id_penjualan) REFERENCES penjualan(id_penjualan),
    FOREIGN KEY (id_produk) REFERENCES produk(id_produk)
);

-- Insert Data Awal
-- Kategori
INSERT INTO kategori (nama_kategori, deskripsi) VALUES 
('Alat Musik Petik', 'Gitar, Bass, Ukulele, dll'),
('Alat Musik Pukul', 'Drum, Perkusi, dll'),
('Alat Musik Tiup', 'Terompet, Seruling, Saxophone, dll'),
('Alat Musik Gesek', 'Biola, Cello, dll'),
('Alat Musik Keyboard', 'Piano, Keyboard, dll');

-- Pengguna
INSERT INTO pengguna (username, password, nama_lengkap, level) VALUES
('admin', 'admin123', 'Administrator', 'admin'),
('kasir', 'kasir123', 'Kasir Toko', 'kasir');

-- Produk Contoh
INSERT INTO produk (id_kategori, kode_produk, nama_produk, harga, stok, deskripsi, tanggal_masuk) VALUES
(1, 'P0001', 'Gitar Akustik Yamaha F310', 1200000, 10, 'Gitar akustik pemula dengan kualitas suara yang bagus', '2023-01-15'),
(1, 'P0002', 'Gitar Elektrik Fender Stratocaster', 7500000, 5, 'Gitar elektrik profesional dengan tone yang khas', '2023-01-20'),
(2, 'P0003', 'Drum Set Yamaha Rydeen', 8500000, 3, 'Drum set lengkap untuk pemula dan menengah', '2023-02-05'),
(3, 'P0004', 'Saxophone Alto Yamaha YAS-280', 12000000, 2, 'Saxophone alto dengan suara yang jernih', '2023-02-10'),
(4, 'P0005', 'Biola Cremona SV-175', 3500000, 7, 'Biola untuk pemula dengan kualitas baik', '2023-03-01'),
(5, 'P0006', 'Keyboard Yamaha PSR-E373', 4500000, 8, 'Keyboard 61 keys dengan banyak fitur', '2023-03-15'),
(1, 'P0007', 'Bass Fender Precision', 9500000, 4, 'Bass elektrik dengan suara yang solid', '2023-04-01'),
(2, 'P0008', 'Cajon Meinl Headliner', 1000000, 12, 'Alat perkusi portable dengan suara yang bagus', '2023-04-10'),
(3, 'P0009', 'Harmonika Hohner Special 20', 850000, 15, 'Harmonika klasik dengan kualitas suara profesional', '2023-05-01'),
(5, 'P0010', 'Digital Piano Yamaha P-45', 7200000, 6, 'Piano digital dengan weighted keys', '2023-05-15');

-- Pelanggan Contoh
INSERT INTO pelanggan (kode_pelanggan, nama, no_telp, alamat, tanggal_daftar) VALUES
('C0001', 'Budi Santoso', '081234567890', 'Jl. Merdeka No. 10, Jakarta', '2023-01-10'),
('C0002', 'Siti Rahayu', '087654321098', 'Jl. Pahlawan No. 5, Bandung', '2023-02-15'),
('C0003', 'Anton Wijaya', '089876543210', 'Jl. Diponegoro No. 20, Surabaya', '2023-03-20');

-- Penjualan Contoh (Tanggal sesuaikan dengan kebutuhan)
INSERT INTO penjualan (no_faktur, id_pelanggan, id_pengguna, tanggal_penjualan, total_harga, diskon, total_bayar, status_bayar, keterangan) VALUES
('INV202301100001', 1, 2, '2023-01-10 14:30:00', 1200000, 0, 1200000, 'Lunas', 'Pembelian pertama'),
('INV202302200001', 2, 2, '2023-02-20 10:15:00', 4500000, 200000, 4300000, 'Lunas', 'Diskon member'),
('INV202303150001', 3, 2, '2023-03-15 16:45:00', 12000000, 1000000, 11000000, 'Lunas', 'Promo bulan Maret'),
('INV202304050001', 1, 2, '2023-04-05 09:30:00', 3500000, 0, 3500000, 'Lunas', '');

-- Detail Penjualan Contoh
INSERT INTO detail_penjualan (id_penjualan, id_produk, jumlah, harga_satuan, subtotal) VALUES
(1, 1, 1, 1200000, 1200000),
(2, 6, 1, 4500000, 4500000),
(3, 4, 1, 12000000, 12000000),
(4, 5, 1, 3500000, 3500000);

-- Update stok sesuai penjualan
UPDATE produk SET stok = stok - 1 WHERE id_produk = 1;
UPDATE produk SET stok = stok - 1 WHERE id_produk = 6;
UPDATE produk SET stok = stok - 1 WHERE id_produk = 4;
UPDATE produk SET stok = stok - 1 WHERE id_produk = 5;
-- Dibuat oleh: Partner Coding berdasarkan file db_penjualan_alatmusik.sql
-- Waktu: 13 Juni 2025

-- Perintah untuk membuat database jika belum ada
CREATE DATABASE IF NOT EXISTS db_penjualan_alatmusik;
USE db_penjualan_alatmusik;

-- Membuat Tabel Kategori
CREATE TABLE IF NOT EXISTS kategori (
    id_kategori INT AUTO_INCREMENT PRIMARY KEY,
    nama_kategori VARCHAR(50) NOT NULL,
    deskripsi TEXT
);

-- Membuat Tabel Produk (Alat Musik)
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

-- Membuat Tabel Pelanggan
CREATE TABLE IF NOT EXISTS pelanggan (
    id_pelanggan INT AUTO_INCREMENT PRIMARY KEY,
    kode_pelanggan VARCHAR(20) UNIQUE NOT NULL,
    nama VARCHAR(100) NOT NULL,
    no_telp VARCHAR(15),
    alamat TEXT,
    tanggal_daftar DATE
);

-- Membuat Tabel Pengguna (Admin/Kasir)
CREATE TABLE IF NOT EXISTS pengguna (
    id_pengguna INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    nama_lengkap VARCHAR(100) NOT NULL,
    level ENUM('admin', 'kasir') NOT NULL,
    tanggal_dibuat TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Membuat Tabel Penjualan (Header)
CREATE TABLE IF NOT EXISTS penjualan (
    id_penjualan INT AUTO_INCREMENT PRIMARY KEY,
    no_faktur VARCHAR(20) UNIQUE NOT NULL,
    id_pelanggan INT,
    id_pengguna INT,
    tanggal_penjualan DATETIME NOT NULL,
    total_harga DECIMAL(15,2) NOT NULL,
    diskon DECIMAL(10,2) DEFAULT 0,
    total_bayar DECIMAL(15,2) NOT NULL,
    status_bayar ENUM('Lunas','Belum Lunas') NOT NULL,
    keterangan TEXT,
    FOREIGN KEY (id_pelanggan) REFERENCES pelanggan(id_pelanggan),
    FOREIGN KEY (id_pengguna) REFERENCES pengguna(id_pengguna)
);

-- Membuat Tabel Detail Penjualan
CREATE TABLE IF NOT EXISTS detail_penjualan (
    id_detail_penjualan INT AUTO_INCREMENT PRIMARY KEY,
    id_penjualan INT,
    id_produk INT,
    jumlah INT NOT NULL,
    harga_saat_transaksi DECIMAL(12,2) NOT NULL,
    subtotal DECIMAL(15,2) NOT NULL,
    FOREIGN KEY (id_penjualan) REFERENCES penjualan(id_penjualan),
    FOREIGN KEY (id_produk) REFERENCES produk(id_produk)
);


-- Memasukkan Data Awal (Contoh) --

-- Pengguna
INSERT INTO pengguna (username, password, nama_lengkap, level) VALUES
('admin', 'admin123', 'Administrator', 'admin'),
('kasir', 'kasir123', 'Kasir Toko', 'kasir');

-- Kategori
INSERT INTO kategori (nama_kategori, deskripsi) VALUES
('Gitar', 'Berbagai macam gitar akustik dan elektrik'),
('Keyboard', 'Keyboard dan piano digital'),
('Drum', 'Drum set dan perkusi');

-- Produk Contoh
INSERT INTO produk (id_kategori, kode_produk, nama_produk, harga, stok, deskripsi, tanggal_masuk) VALUES
(1, 'GTR-001', 'Gitar Akustik Yamaha F310', 1200000, 15, 'Gitar akustik populer untuk pemula', '2023-01-01'),
(1, 'GTR-002', 'Gitar Elektrik Ibanez GRG150', 2500000, 10, 'Gitar elektrik dengan tremolo', '2023-01-05'),
(2, 'KEY-001', 'Keyboard Yamaha PSR-E373', 3500000, 8, 'Keyboard arranger dengan 61 tuts', '2023-02-10'),
(3, 'DRM-001', 'Drum Set Tama Imperialstar', 7500000, 5, 'Drum set lengkap dengan cymbal', '2023-03-20');

-- Pelanggan Contoh
INSERT INTO pelanggan (kode_pelanggan, nama, no_telp, alamat, tanggal_daftar) VALUES
('C0001', 'Budi Santoso', '081234567890', 'Jl. Merdeka No. 10, Jakarta', '2023-01-10'),
('C0002', 'Siti Rahayu', '087654321098', 'Jl. Pahlawan No. 5, Bandung', '2023-02-15');

-- Penjualan Contoh
INSERT INTO penjualan (no_faktur, id_pelanggan, id_pengguna, tanggal_penjualan, total_harga, total_bayar, status_bayar) VALUES
('INV202301100001', 1, 2, '2023-01-10 14:30:00', 1200000, 1200000, 'Lunas');

-- Detail Penjualan Contoh
INSERT INTO detail_penjualan (id_penjualan, id_produk, jumlah, harga_saat_transaksi, subtotal) VALUES
(1, 1, 1, 1200000, 1200000);
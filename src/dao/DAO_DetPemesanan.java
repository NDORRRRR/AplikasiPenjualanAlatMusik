/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Model_DetPemesanan;
import model.Model_barang;       // Diperbaiki: 'b' kecil
import model.Model_pemesanan;
import service.Service_DetPemesanan;

public class DAO_DetPemesanan implements Service_DetPemesanan {

    private final Connection conn;

    public DAO_DetPemesanan() {
        conn = Koneksi.getConnection();
    }

    @Override
    public void tambahData(Model_DetPemesanan mod_detpesan) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sumTotal(Model_DetPemesanan mod_detpesan) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void hapusSementara(Model_DetPemesanan mod_detpesan) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Model_DetPemesanan getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Diperbaiki: Nama method disamakan dengan Interface (Service_DetPemesanan)
    @Override
    public List<Model_DetPemesanan> ambilData(String id) { 
        List<Model_DetPemesanan> list = new ArrayList<>();
        // Implementasi logika untuk mengambil data...
        return list; // Kembalikan list kosong untuk sementara agar tidak error
    }

    @Override
    public List<Model_DetPemesanan> pencarian(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
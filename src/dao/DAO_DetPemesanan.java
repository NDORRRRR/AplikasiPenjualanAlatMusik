package dao;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Model_DetPemesanan;
import model.Model_barang;
import service.Service_DetPemesanan;

/**
 *
 * @author RVNOLDYVX (Direvisi oleh Partner Coding)
 */
public class DAO_DetPemesanan implements Service_DetPemesanan {

    private Connection conn;
    
    public DAO_DetPemesanan(){
        conn = Koneksi.getConnection();
    }
            
    @Override
    public void tambahData(Model_DetPemesanan mod_detpesan) {
        // TODO: Implementasikan logika untuk menambah data detail pemesanan
    }

    @Override
    public Model_DetPemesanan getByid(String id) {
        // TODO: Implementasikan logika untuk mengambil data by id
        return null;
    }

    @Override
    public List<Model_DetPemesanan> getData() {
        // TODO: Implementasikan logika untuk mengambil semua data
        return null;
    }

    @Override
    public List<Model_DetPemesanan> pencarian(String id) {
        // TODO: Implementasikan logika untuk pencarian
        return null;
    }
    
    // Implementasi method yang benar untuk mengambil detail pemesanan
    @Override
    public List<Model_DetPemesanan> ambilDetail(String noPemesanan) {
        List<Model_DetPemesanan> list = new ArrayList<>();
        // Query untuk menggabungkan detail pemesanan dengan data barang
        String sql = "SELECT dp.No_Pemesanan, b.Kode_Barang, b.Nama_Barang, b.Harga, dp.Jml_Pemesanan, dp.Subtotal_Pemesanan " +
                     "FROM detail_pemesanan dp " +
                     "INNER JOIN barang b ON b.Kode_Barang = dp.Kode_Barang " +
                     "WHERE dp.No_Pemesanan = ?";
        try {
            if (conn == null) {
                System.err.println("Koneksi ke database gagal.");
                return list;
            }
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, noPemesanan);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Model_DetPemesanan detail = new Model_DetPemesanan();
                Model_barang barang = new Model_barang();
                
                // Set data barang dari hasil query
                barang.setKode_Barang(rs.getString("Kode_Barang"));
                barang.setNama_barang(rs.getString("Nama_Barang"));
                barang.setHarga(rs.getLong("Harga"));
                
                // Set data detail pemesanan
                detail.setMod_barang(barang);
                detail.setJml_pemesanan(rs.getInt("Jml_Pemesanan"));
                detail.setSubtotal_pemesanan(rs.getDouble("Subtotal_Pemesanan"));
                
                list.add(detail);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
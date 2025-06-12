/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;



import java.util.List;
import model.Model_pemesanan;
import service.Service_Pemesanan;
import java.sql.PreparedStatement;
import java.sql.Connection;
import config.Koneksi;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import model.Model_jenis_barang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Model_distributor;
import model.Model_pengguna;
/**
 *
 * @author RVNOLDYVX
 */
public class DAO_Pemesanan implements Service_Pemesanan{
    
    
     private Connection conn;
    
    public DAO_Pemesanan(){
        conn = Koneksi.getConnection();
    }

    @Override
    public void tambahData(Model_pemesanan mod_pesan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void perbaruiData(Model_pemesanan mod_pesan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void hapusData(Model_pemesanan mod_pesan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Model_pemesanan getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_pemesanan> getData() {
    PreparedStatement st = null;
    ResultSet rs = null;
    List list = new ArrayList<>();
    String sql = "SELECT * FROM pemesanan";
    try {
        st = conn.prepareStatement(sql);
        rs = st.executeQuery();
        while (rs.next()) {
            Model_pemesanan psn = new Model_pemesanan();
            Model_distributor dst = new Model_distributor();
            Model_pengguna pgn = new Model_pengguna();
            
            psn.setNo_pesan(rs.getString("no_pesan"));
            psn.setTgl_pesan(rs.getString("tgl_pesan"));
            psn.setTotal_pesan(rs.getLong("total_pesan"));
            dst.setId_distributor(rs.getString("id_distributor"));
            pgn.setId_pengguna(rs.getString("id_pengguna"));
            
            psn.setMod_distributor(dst);
            psn.setMod_pengguna(pgn);
            list.add(psn);
        }
        return list;
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(DAO_Pemesanan.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_Pemesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_Pemesanan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }

    @Override
    public List<Model_pemesanan> pencarian(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String nomor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    

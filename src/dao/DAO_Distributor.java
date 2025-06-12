/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.Connection;
import config.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Model_distributor;
import service.Service_Distributor;


/**
 *
 * @author MSI GAMING
 */
public class DAO_Distributor implements Service_Distributor {

    private Connection conn;
    
    public DAO_Distributor(){
        conn = Koneksi.getConnection();
    }
    
    
    @Override
    public void tambahData(Model_distributor mod_dis) {
    PreparedStatement st = null;
    String sql = "INSERT INTO distributor (id_distributor,nama_distributor,telp_distributor,alamat_distributor) VALUES (?, ?, ?, ?)";
    
    try {
        st = conn.prepareStatement(sql);
        st.setString(1, mod_dis.getId_distributor());
        st.setString(2, mod_dis.getNama_distributor());
        st.setString(3, mod_dis.getTelp_distributor());
        st.setString(4, mod_dis.getAlamat_distributor());
        

        st.executeUpdate();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + ex.getMessage());
        Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
 }

    @Override
    public void perbaruiData(Model_distributor mod_dis) {
        PreparedStatement st = null;
    String sql = "UPDATE distributor SET id_distributor=?, nama_distributor=?, telp_distributor=?, alamat_distributor=? WHERE id_distributor=?";
    try {
        st = conn.prepareStatement(sql);
        
        st.setString(1, mod_dis.getId_distributor());
        st.setString(2, mod_dis.getNama_distributor());
        st.setString(3, mod_dis.getTelp_distributor());
        st.setString(4, mod_dis.getAlamat_distributor());
        st.setString(5, mod_dis.getId_distributor());
        

        st.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }

    @Override
    public void hapusData(Model_distributor mod_dis) {
    PreparedStatement st = null;
    String sql = "DELETE FROM distributor WHERE id_distributor=?";
    try {
        st = conn.prepareStatement(sql);
        st.setString(1, mod_dis.getId_distributor());
        
        st.executeUpdate();
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st!= null) {
            try {
                st.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }

    }

    @Override
    public Model_distributor getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_distributor> getData() {
    PreparedStatement st = null;
    List list = new ArrayList<>();
    ResultSet rs = null;    
    String sql = "SELECT * FROM distributor";
    try {
        st = conn.prepareStatement(sql);
        rs = st.executeQuery();
        while (rs.next()) {
            Model_distributor model = new Model_distributor();
            
            model.setId_distributor(rs.getString("id_distributor"));
            model.setNama_distributor(rs.getString("nama_distributor"));
            model.setTelp_distributor(rs.getString("telp_distributor"));
            model.setAlamat_distributor(rs.getString("alamat_distributor"));

            list.add(model);
        }
        return list;
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }

    @Override
    public List<Model_distributor> pencarian(String id) {
     PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM distributor WHERE id_distributor LIKE '%"+id+"%' OR nama_distributor LIKE '%"+id+"%'OR telp_distributor LIKE '%"+id+"%' OR alamat_distributor LIKE '%"+id+"%'"; 
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
            Model_distributor model = new Model_distributor();
            model.setId_distributor(rs.getString("id_distributor"));
            model.setNama_distributor(rs.getString("nama_distributor"));
            model.setTelp_distributor(rs.getString("telp_distributor"));
            model.setAlamat_distributor(rs.getString("alamat_distributor"));

            list.add(model);
            }
            
               return list;
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } finally {
                if (st != null) {
                    try {
                        st.close();
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

    @Override
    public String nomor() {
    PreparedStatement st = null;
    ResultSet rs = null;
    String urutan = null;

    Date now = new Date();
    SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat noformat = new SimpleDateFormat("yyyyMM");
    String tgl = tanggal.format(now);
    String no = noformat.format(now);

    String sql = "SELECT RIGHT(id_distributor, 3) AS Nomor FROM distributor  WHERE id_distributor LIKE 'DST" + no + "%' ORDER BY id_distributor DESC LIMIT 1";

    try {
        st = conn.prepareStatement(sql);
        rs = st.executeQuery();

        if (rs.next()) {
            int nomor = Integer.parseInt(rs.getString("Nomor"));
            nomor++;
            urutan = "DST" + no + String.format("%03d", nomor);
        } else {
            urutan = "DST" + no + "001";
        }
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    return urutan;
    }
}   
    


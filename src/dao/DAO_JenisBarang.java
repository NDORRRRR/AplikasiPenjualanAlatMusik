/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.Koneksi;
import java.sql.Connection;
import java.util.List;
import model.Model_jenis_barang;
import service.Service_JenisBarang;
import java.sql.PreparedStatement;
import java.sql.Connection;
import config.Koneksi;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import model.Model_jenis_barang;
import service.Service_barang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author MSI GAMING
 */
public class DAO_JenisBarang implements Service_JenisBarang  {

    private Connection conn;
    
    public DAO_JenisBarang(){
        conn = Koneksi.getConnection();
    }
    
    @Override
    public void tambahData(Model_jenis_barang mod_jenis) {
    PreparedStatement st = null;
    String sql = "INSERT INTO jenis_barang (kode_jenis,nama_jenis) VALUES (?, ?)";
    try {
        st = conn.prepareStatement(sql);
        st.setString(1, mod_jenis.getKode_jenis());
        st.setString(2, mod_jenis.getNama_jenis());

        st.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
    }
    @Override
    public void perbaruiData(Model_jenis_barang mod_jenis) {
    PreparedStatement st = null;
    String sql = "UPDATE jenis_barang SET nama_jenis=? WHERE kode_jenis=?";
    try {
        st = conn.prepareStatement(sql);
        st.setString(1, mod_jenis.getNama_jenis());
        st.setString(2, mod_jenis.getKode_jenis());

        st.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }

    @Override
    public void hapusData(Model_jenis_barang mod_jenis) {
    PreparedStatement st = null;
    String sql = "DELETE FROM jenis_barang WHERE kode_jenis=?";
    try {
        st = conn.prepareStatement(sql);
        st.setString(1, mod_jenis.getKode_jenis());
        
        st.executeUpdate();
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st!= null) {
            try {
                st.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }

    }

    @Override
    public Model_jenis_barang getByid(String id) {
            PreparedStatement st = null;
            ResultSet rs = null;
             Model_jenis_barang mokat = null;
            String sql = "SELECT * FROM jenis_barang WHERE kode_jenis=?";
            
            try {
                st = conn.prepareStatement(sql);
                Model_jenis_barang ang = new Model_jenis_barang();
                st.setString(0, ang.getKode_jenis());
                st.setString(1, ang.getNama_jenis());
                
                rs = st.executeQuery();
                while (rs.next()) {
                   mokat = new Model_jenis_barang();
                   mokat.setKode_jenis(rs.getString("kode_jenis"));
                   mokat.setNama_jenis(rs.getString("nama_jenis"));
                               
                }
                return mokat;
            } catch (SQLException ex) {
                Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } finally {
              if (st!= null){
                try {
                   st.close();                   
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                if (rs!= null){
                try {
                   rs.close();                   
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
       }
    }  
    @Override
    public List<Model_jenis_barang> getData() {
    PreparedStatement st = null;
    ResultSet rs = null;
    List list = new ArrayList<>();
    String sql = "SELECT * FROM jenis_barang";
    try {
        st = conn.prepareStatement(sql);
        rs = st.executeQuery();
        while (rs.next()) {
            Model_jenis_barang mokat = new Model_jenis_barang();
            mokat.setKode_jenis(rs.getString("kode_jenis"));
            mokat.setNama_jenis(rs.getString("nama_jenis"));

            list.add(mokat);
        }
        return list;
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }

    @Override
    public List<Model_jenis_barang> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM jenis_barang WHERE kode_jenis LIKE '%"+id+"%' OR nama_jenis LIKE '%"+id+"%'"; 
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_jenis_barang mokat = new Model_jenis_barang();
                mokat.setKode_jenis(rs.getString("kode_jenis"));
                mokat.setNama_jenis(rs.getString("nama_jenis"));
                
                list.add(mokat);
            }
            
               return list;
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } finally {
                if (st != null) {
                    try {
                        st.close();
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String urutan = null;
        String sql = "SELECT RIGHT(kode_jenis,3) AS Nomor FROM jenis_barang ORDER BY Nomor DESC LIMIT 1";
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = String.format("JB%03d", nomor);
            } else {
                urutan = "JB001";
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return urutan;   
        }

    @Override
    public boolean valisasiNamaJenisBarang(Model_jenis_barang mod_jenis) {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean valid = false;
        
        String sql = "SELECT nama_jenis FROM jenis_barang WHERE kode_jenis!='"+mod_jenis.getKode_jenis()+"' AND nama_jenis LIKE BINARY '"
                +mod_jenis.getNama_jenis()+"';";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                JOptionPane.showMessageDialog(null, "Nama Jenis Barang Telah Ada\nSilahkan nama jenis barang yang lain",
                        "PERINGATAN", JOptionPane.WARNING_MESSAGE);
            }else{
                valid =true;
            } 
            } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;   
        }
      }
    
    

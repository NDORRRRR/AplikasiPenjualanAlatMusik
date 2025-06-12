
package dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import config.Koneksi;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.util.ArrayList;
import java.util.List;

import model.Model_barang;
import model.Model_jenis_barang;
import service.Service_barang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;



public class DAO_Barang implements Service_barang {
    
    private Connection conn;
    
    
    public DAO_Barang(){
        conn = Koneksi.getConnection();
    }
    @Override
    public void tambahData(Model_barang mod_bar) {
    PreparedStatement st = null;
    String sql = "INSERT INTO barang (kode_barang, kode_jenis, nama_barang, "
               + "satuan, harga, stok) VALUES (?,?,?,?,?,?)";
    try {
        st = conn.prepareStatement(sql);
        
        st.setString(1, mod_bar.getKode_Barang());
        st.setString(2, mod_bar.getJns_barang().getKode_jenis());
        st.setString(3, mod_bar.getNama_barang());
        st.setString(4, mod_bar.getSatuan());
        st.setLong(5, mod_bar.getHarga());
        st.setInt(6, mod_bar.getStok());
        
        st.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

    

    @Override
    public void perbaruiData(Model_barang mod_bar) {
    PreparedStatement st = null;
    String sql = "UPDATE barang SET"
               + "kode_jenis=?, nama_barang=?, satuan=?, harga=?, stok=?"
               + "WHERE kode_barang='" + mod_bar.getKode_Barang()+ "'";
    try {
        st = conn.prepareStatement(sql);
        
        st.setString(1, mod_bar.getJns_barang().getKode_jenis());
        st.setString(2, mod_bar.getNama_barang());
        st.setString(3, mod_bar.getSatuan());
        st.setLong(4, mod_bar.getHarga());
        st.setInt(5, mod_bar.getStok());
        
        st.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
    

    @Override
    public void hapusData(Model_barang mod_bar) {
    PreparedStatement st = null;
    String sql = "DELETE FROM barang WHERE kode_barang=?";
    
    try {
        st = conn.prepareStatement(sql);
        st.setString(1, mod_bar.getKode_Barang());
        st.executeUpdate();
        
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

    

    @Override
    public Model_barang getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_barang> getDataByID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   @Override
public List<Model_barang> getData() {
    PreparedStatement st = null;
    List<Model_barang> list = new ArrayList<>();
    ResultSet rs = null;    
    String sql = "SELECT bg.kode_barang,bg.kode_jenis,jb.nama_jenis,bg.nama_barang,bg.satuan,bg.harga,bg.stok FROM barang bg INNER JOIN jenis_barang jb ON jb.kode_jenis=bg.kode_jenis";

    try {
        st = conn.prepareStatement(sql);
        rs = st.executeQuery();
        while (rs.next()) {
            Model_barang mobar = new Model_barang();
            Model_jenis_barang jbr = new Model_jenis_barang();

            mobar.setKode_Barang        (rs.getString("kode_barang"));
            jbr.setKode_jenis           (rs.getString("kode_jenis"));
            jbr.setNama_jenis           (rs.getString("nama_jenis"));
            mobar.setNama_barang        (rs.getString("nama_barang"));
            mobar.setSatuan             (rs.getString("satuan"));
            mobar.setHarga              (rs.getLong("harga"));
            mobar.setStok               (rs.getInt("stok"));
            
            mobar.setJns_barang(jbr);

            list.add(mobar);
        }
        return list;
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    } finally {
            if (st!= null){
                try{
                    st.close();
                    } catch (SQLException ex) {
                     java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
              }
           }
            if (rs!=null) {
                try {
                    rs.close();
                     } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }                
            
}
    
    @Override
    public List<Model_barang> pencarian(String id) {
            PreparedStatement st = null;
            ResultSet rs = null;
            List list = new ArrayList<>();
            String sql = "SELECT bg.kode_barang, bg.kode_jenis, jb.nama_jenis, "
                       + "bg.nama_barang, bg.satuan, bg.harga, bg.stok FROM barang bg "
                       + "INNER JOIN jenis_barang jb ON jb.kode_jenis=bg.kode_jenis "
                       + "WHERE kode_barang LIKE '%"+id+"%' OR nama_barang LIKE '%"+id+"%'";
    try {
        st = conn.prepareStatement(sql);
        rs = st.executeQuery();
        while (rs.next()) {
            Model_barang mobar = new Model_barang();
            Model_jenis_barang jb = new Model_jenis_barang();
            
            mobar.setKode_Barang(rs.getString("kode_barang"));
            jb.setKode_jenis(rs.getString("kode_jenis"));
            jb.setNama_jenis(rs.getString("nama_jenis"));           
            mobar.setNama_barang(rs.getString("nama_barang"));
            mobar.setSatuan(rs.getString("satuan"));
            mobar.setHarga(rs.getLong("harga"));
            mobar.setStok(rs.getInt("stok"));
            
            mobar.setJns_barang(jb);
            list.add(mobar);
        }
        return list;
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

    @Override
    public List<Model_barang> pencarian2(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String nomor() {
    PreparedStatement st = null;
    ResultSet rs = null;
    String urutan = null;

    Date now = new Date();
    SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat noformat = new SimpleDateFormat("yyMM");
    String tgl = tanggal.format(now);
    String no = noformat.format(now);

    String sql = "SELECT RIGHT(kode_barang, 3) AS Nomor " +
                 "FROM barang " +
                 "WHERE kode_barang LIKE 'B" + no + "%' " +
                 "ORDER BY kode_barang DESC " +
                 "LIMIT 1";

    try {
        st = conn.prepareStatement(sql);
        rs = st.executeQuery();

        if (rs.next()) {
            int nomor = Integer.parseInt(rs.getString("Nomor"));
            nomor++;
            urutan = "B" + no + String.format("%03d", nomor);
        } else {
            urutan = "B" + no + "001";
        }
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    return urutan;
}

    @Override
    public String nomor2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}


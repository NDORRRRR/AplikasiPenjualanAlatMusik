/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.Koneksi;
import java.util.List;
import model.Model_pengguna;
import service.Service_pengguna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MSI GAMING
 */
public class DAO_pengguna implements Service_pengguna {
        
    private Connection conn;
    
    public DAO_pengguna(){
        conn = Koneksi.getConnection();
    }


    @Override
    public void tambahData(Model_pengguna mod_pengguna) {
    PreparedStatement st = null;
    String sql = "INSERT INTO pengguna(id_pengguna,nama_pengguna,username,password,telp_pengguna,alamat_pengguna,level,gambar) VALUES (?,?,?,?,?,?,?,?)";
    try {
        st = conn.prepareStatement(sql);
      
        st.setString(1, mod_pengguna.getId_pengguna());
        st.setString(2, mod_pengguna.getNama_pengguna());
        st.setString(3, mod_pengguna.getUsername());
        st.setString(4, Encrypt.getmd5java(mod_pengguna.getPassword()));
        st.setString(5, mod_pengguna.getTelp_pengguna());
        st.setString(6, mod_pengguna.getAlamat_pengguna());
        st.setString(7, mod_pengguna.getLevel());
        //st.setString(8, mod_pengguna.getImagepath());
        
        st.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(DAO_pengguna.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_pengguna.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
    }

    @Override
    public void perbaruiData(Model_pengguna mod_pengguna) {
    PreparedStatement st = null;
    String sql = "UPDATE pengguna SET nama_pengguna=?,username=?,telp_pengguna=?,alamat_pengguna=?,level=? WHERE id_pengguna=?";
    try {
        st = conn.prepareStatement(sql);
        st.setString(1, mod_pengguna.getNama_pengguna());
        st.setString(2, mod_pengguna.getUsername());
       // st.setString(3, Encrypt.getmd5java(mod_pengguna.getPassword()));
        st.setString(3, mod_pengguna.getTelp_pengguna());
        st.setString(4, mod_pengguna.getAlamat_pengguna());
        st.setString(5, mod_pengguna.getLevel());
        st.setString(6, mod_pengguna.getId_pengguna());

        st.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(DAO_pengguna.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st!= null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_pengguna.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }


    @Override
    public void hapusData(Model_pengguna mod_pengguna) {
    PreparedStatement st = null;
    String sql = "DELETE FROM pengguna WHERE id_pengguna=?";
    try {
        st = conn.prepareStatement(sql);
        st.setString(1, mod_pengguna.getId_pengguna());
        
        st.executeUpdate();
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(DAO_pengguna.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st!= null) {
            try {
                st.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_pengguna.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }

    }

    @Override
    public Model_pengguna getByid(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Model_pengguna> getData() {
    PreparedStatement st = null;
    ResultSet rs = null;
    List list = new ArrayList<>();
    String sql = "SELECT * FROM pengguna";
    try {
        st = conn.prepareStatement(sql);
        rs = st.executeQuery();
        while (rs.next()) {
            Model_pengguna model = new Model_pengguna();
            model.setId_pengguna(rs.getString("id_pengguna"));
            model.setNama_pengguna(rs.getString("nama_pengguna"));
            model.setUsername(rs.getString("username"));
            model.setTelp_pengguna(rs.getString("telp_pengguna"));
            model.setAlamat_pengguna(rs.getString("alamat_pengguna"));
            model.setLevel(rs.getString("level"));
            

            list.add(model);
        }
        return list;
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(DAO_pengguna.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    } finally {
        if (st!= null) {
            try {
                st.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_pengguna.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rs!= null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_pengguna.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }

    @Override
    public List<Model_pengguna> pencarian(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM pengguna WHERE id_pengguna LIKE '%"+id+"%' OR nama_pennguna LIKE '%"+id+"%'OR username LIKE '%"+id+"%'OR telp_pengguna LIKE '%"+id+"%'"; 
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()) {
                Model_pengguna model = new Model_pengguna();
                model.setId_pengguna(rs.getString("id_pengguna"));
                model.setNama_pengguna(rs.getString("nama_pengguna"));
                model.setUsername(rs.getString("username"));
                model.setTelp_pengguna(rs.getString("telp_pengguna"));
                model.setAlamat_pengguna(rs.getString("alamat_pengguna"));
                model.setLevel(rs.getString("level"));
                
                list.add(model);
            }
            
               return list;
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(DAO_pengguna.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } finally {
                if (st != null) {
                    try {
                        st.close();
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(DAO_pengguna.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(DAO_pengguna.class.getName()).log(Level.SEVERE, null, ex);
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

        String sql = "SELECT RIGHT(id_pengguna, 3) AS Nomor FROM pengguna WHERE id_pengguna LIKE 'USR" + no + "%' ORDER BY id_pengguna DESC LIMIT 1";

        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            if (rs.next()) {
                int nomor = Integer.parseInt(rs.getString("Nomor"));
                nomor++;
                urutan = "USR" + no + String.format("%03d", nomor);
            } else {
                urutan = "USR" + no + "001";
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAO_pengguna.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(DAO_pengguna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return urutan;
        }

    @Override
    public boolean validateOldPassword(String username, String oldPassword) {
    String encryptedOldPassword = Encrypt.getmd5java(oldPassword);
    try {
        String sql = "SELECT * FROM pengguna WHERE username = ? AND password = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, username);
        pstm.setString(2, encryptedOldPassword);
        ResultSet rs = pstm.executeQuery();
        return rs.next();
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
}
    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
    String encryptedOldPassword = Encrypt.getmd5java(oldPassword);
    String encryptedNewPassword = Encrypt.getmd5java(newPassword);
    try {
        String sql = "SELECT * FROM pengguna WHERE username = ? AND password = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, username);
        pstm.setString(2, encryptedOldPassword);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            String sqlUpdate = "UPDATE pengguna SET password = ? WHERE username = ?";
            PreparedStatement pstmUpdate = conn.prepareStatement(sqlUpdate);
            pstmUpdate.setString(1, encryptedNewPassword);
            pstmUpdate.setString(2, username);
            int result = pstmUpdate.executeUpdate();
            return result > 0;
        } else {
            return false;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
}
  
}

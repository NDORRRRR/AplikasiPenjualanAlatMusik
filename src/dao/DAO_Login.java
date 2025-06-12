/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import config.Koneksi;
import javax.swing.JOptionPane;
import main.MenuUtama;
import service.Service_Login;
import view.Form_Login;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model_login;


/**
 *
 * @author MSI GAMING
 */
public class DAO_Login implements Service_Login{
    
    private Connection conn;
    
    public DAO_Login(){
        conn = Koneksi.getConnection();
    }

    @Override
    public void prosesLogin(Model_login mod_Login) {
        PreparedStatement st = null;
        ResultSet rs         = null;
        String Id            = null;
        String Nama          = null;
        String Level2         = null;
        String sql = "SELECT * FROM pengguna WHERE (id_pengguna ='"+mod_Login.getId_user()+"'"
                +"OR username='"+mod_Login.getUsername()+"')"
                +"AND password='"+Encrypt.getmd5java(mod_Login.getPass_user())+"'";
                
                try{
                    st = conn.prepareStatement(sql);
                    rs = st.executeQuery();
                    if(rs.next()){
                    Id      = rs.getString("id_pengguna");
                    Nama    = rs.getString("nama_pengguna");
                    Level2  = rs.getString("level");

                    MenuUtama menu = new MenuUtama(Nama, Level2);
                    menu.setVisible(true);
                    menu.revalidate();

                    Form_Login lg = new Form_Login();
                    lg.tutup(true);
                    }else{
                    JOptionPane.showMessageDialog(null, "Username dan Password salah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                    Form_Login lg = new Form_Login();
                    lg.tutup(false);
                    }  
                }catch(SQLException ex){
                    Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    if(st != null){
                        try{
                            st.close();
                        }catch(SQLException ex){
                            Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
    }
}



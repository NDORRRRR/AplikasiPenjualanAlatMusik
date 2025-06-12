package dao;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Model_login;
import service.Service_Login;

/**
 *
 * @author MSI GAMING (Direvisi oleh Partner Coding)
 */
public class DAO_Login implements Service_Login {

    private Connection conn;

    public DAO_Login() {
        conn = Koneksi.getConnection();
    }

    @Override
    public Model_login prosesLogin(Model_login mod_login) {
        Model_login model = null;
        String sql = "SELECT * FROM pengguna WHERE username=? AND password=?";
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            if (conn == null) {
                System.err.println("Koneksi ke database gagal.");
                return null;
            }

            st = conn.prepareStatement(sql);
            st.setString(1, mod_login.getUsername());
            String encryptedPassword = Encrypt.getmd5java(mod_login.getPass_user());
            st.setString(2, encryptedPassword);
            rs = st.executeQuery();

            if (rs.next()) {
                model = new Model_login();
                model.setId_user(rs.getString("id_pengguna"));
                model.setUsername(rs.getString("username"));
                model.setNama_user(rs.getString("nama_lengkap"));
                model.setLevel(rs.getString("level"));
                return model;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (SQLException e) { e.printStackTrace(); }
        }
        return null;
    }
}
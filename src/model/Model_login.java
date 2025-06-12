package model;

/**
 *
 * @author MSI GAMING (Direvisi oleh Partner Coding)
 * Kelas ini adalah POJO (Plain Old Java Object) untuk data pengguna.
 * Juga digunakan untuk menyimpan data sesi pengguna yang sedang login (static).
 */
public class Model_login {

    // Variabel untuk menyimpan data sesi pengguna yang sedang login
    private static String id_user_static;
    private static String username_static;
    private static String nama_user_static;
    private static String level_static;
    
    // Variabel untuk proses login
    private String id_user;
    private String username;
    private String nama_user;
    private String pass_user;
    private String level;
    
    // Getter dan Setter untuk data sesi (static)
    public static String getId_user_static() {
        return id_user_static;
    }

    public static void setId_user_static(String id_user_static) {
        Model_login.id_user_static = id_user_static;
    }

    public static String getUsername_static() {
        return username_static;
    }

    public static void setUsername_static(String username_static) {
        Model_login.username_static = username_static;
    }

    public static String getNama_user_static() {
        return nama_user_static;
    }

    public static void setNama_user_static(String nama_user_static) {
        Model_login.nama_user_static = nama_user_static;
    }

    public static String getLevel_static() {
        return level_static;
    }

    public static void setLevel_static(String level_static) {
        Model_login.level_static = level_static;
    }
    
    // Getter dan Setter untuk proses login (non-static)
    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getNama_user() {
        return nama_user;
    }
    
    public void setNama_user(String nama_user) {
        this.nama_user = nama_user;
    }

    public String getPass_user() {
        return pass_user;
    }
    
    public void setPass_user(String pass_user) {
        this.pass_user = pass_user;
    }
    
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
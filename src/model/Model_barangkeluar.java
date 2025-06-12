
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSI GAMING
 */
public class Model_barangkeluar { 

    private String no_keluar;
    private String tgl_keluar;
    private Long total_keluar;
    private Model_pengguna modpengguna;
    
    public String getNo_keluar() {
        return no_keluar;
    }

    public void setNo_keluar(String no_keluar) {
        this.no_keluar = no_keluar;
    }

    public String getTgl_keluar() {
        return tgl_keluar;
    }

    public void setTgl_keluar(String tgl_keluar) {
        this.tgl_keluar = tgl_keluar;
    }

    public Long getTotal_keluar() {
        return total_keluar;
    }

    public void setTotal_keluar(Long total_keluar) {
        this.total_keluar = total_keluar;
    }

    public Model_pengguna getModpengguna() {
        return modpengguna;
    }

    public void setModpengguna(Model_pengguna modpengguna) {
        this.modpengguna = modpengguna;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSI GAMING
 */
public class Model_pemesanan {

    private String no_pesan;
    private String tgl_pesan;
    private Long total_pesan;
    private Model_distributor mod_pesan;
    private Model_pengguna mod_pengguna;

    public String getNo_pesan() {
        return no_pesan;
    }

    public void setNo_pesan(String no_pesan) {
        this.no_pesan = no_pesan;
    }

    public String getTgl_pesan() {
        return tgl_pesan;
    }

    public void setTgl_pesan(String tgl_pesan) {
        this.tgl_pesan = tgl_pesan;
    }

    public Long getTotal_pesan() {
        return total_pesan;
    }

    public void setTotal_pesan(Long total_pesan) {
        this.total_pesan = total_pesan;
    }

    public Model_distributor getMod_pesan() {
        return mod_pesan;
    }

    public void setMod_pesan(Model_distributor mod_pesan) {
        this.mod_pesan = mod_pesan;
    }

    public Model_pengguna getMod_pengguna() {
        return mod_pengguna;
    }

    public void setMod_pengguna(Model_pengguna mod_pengguna) {
        this.mod_pengguna = mod_pengguna;
    }

    
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author MSI GAMING
 */
public class Model_DetPemesanan {
    
    private Model_pemesanan mod_pesan;
    private Model_barang mod_barang;
    private Long  jml_pesan;
    private Long subTotal;
    private String status;

    public Model_pemesanan getMod_pesan() {
        return mod_pesan;
    }

    public void setMod_pesan(Model_pemesanan mod_pesan) {
        this.mod_pesan = mod_pesan;
    }

    public Model_barang getMod_barang() {
        return mod_barang;
    }

    public void setMod_barang(Model_barang mod_barang) {
        this.mod_barang = mod_barang;
    }

    public Long getJml_pesan() {
        return jml_pesan;
    }

    public void setJml_pesan(Long jml_pesan) {
        this.jml_pesan = jml_pesan;
    }

    public Long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Long subTotal) {
        this.subTotal = subTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}

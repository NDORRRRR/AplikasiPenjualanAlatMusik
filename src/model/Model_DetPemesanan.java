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
    
    private Model_pemesanan modpesan;
    private Model_barang modbarang;
    private Long  jml_pesan;
    private Long subTotalpesan;
    private String status;

    public Model_pemesanan getModpesan() {
        return modpesan;
    }

    public void setModpesan(Model_pemesanan modpesan) {
        this.modpesan = modpesan;
    }

    public Model_barang getModbarang() {
        return modbarang;
    }

    public void setModbarang(Model_barang modbarang) {
        this.modbarang = modbarang;
    }

    public Long getJml_pesan() {
        return jml_pesan;
    }

    public void setJml_pesan(Long jml_pesan) {
        this.jml_pesan = jml_pesan;
    }

    public Long getSubTotalpesan() {
        return subTotalpesan;
    }

    public void setSubTotalpesan(Long subTotalpesan) {
        this.subTotalpesan = subTotalpesan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSI GAMING
 */
public class Model_DetBarangKeluar {
    private Model_barangkeluar mod_keluar;
    private Model_barang modBarang;
    private Integer jml_keluar;
    private Long subtotal_keluar;

    public Model_barangkeluar getMod_keluar() {
        return mod_keluar;
    }

    public void setMod_keluar(Model_barangkeluar mod_keluar) {
        this.mod_keluar = mod_keluar;
    }

    public Model_barang getModBarang() {
        return modBarang;
    }

    public void setModBarang(Model_barang modBarang) {
        this.modBarang = modBarang;
    }

    public Integer getJml_keluar() {
        return jml_keluar;
    }

    public void setJml_keluar(Integer jml_keluar) {
        this.jml_keluar = jml_keluar;
    }

    public Long getSubtotal_keluar() {
        return subtotal_keluar;
    }

    public void setSubtotal_keluar(Long subtotal_keluar) {
        this.subtotal_keluar = subtotal_keluar;
    }


    
}

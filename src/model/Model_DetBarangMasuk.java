/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MSI GAMING
 */
public class Model_DetBarangMasuk {

    
    private Model_barangmasuk modmasuk;
    private Model_barang mobar;
    private Integer jml_masuk;
    private Long subtotalmasuk;

    public Model_barangmasuk getModmasuk() {
        return modmasuk;
    }

    public void setModmasuk(Model_barangmasuk modmasuk) {
        this.modmasuk = modmasuk;
    }

    public Model_barang getMobar() {
        return mobar;
    }

    public void setMobar(Model_barang mobar) {
        this.mobar = mobar;
    }

    public Integer getJml_masuk() {
        return jml_masuk;
    }

    public void setJml_masuk(Integer jml_masuk) {
        this.jml_masuk = jml_masuk;
    }

    public Long getSubtotalmasuk() {
        return subtotalmasuk;
    }

    public void setSubtotalmasuk(Long subtotalmasuk) {
        this.subtotalmasuk = subtotalmasuk;
    }

   
}

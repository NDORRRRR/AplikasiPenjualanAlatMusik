/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Model_barangmasuk;

/**
 *
 * @author MSI GAMING
 */
public interface Service_barangmasuk {
    void tambahData (Model_barangmasuk mod_masuk);
    void perbaruiStatus (String kode_barang);
    
    Model_barangmasuk getByid (String id);
    List<Model_barangmasuk> ambilData();
    List<Model_barangmasuk> pencarian(String id);
    String nomor();
    
}

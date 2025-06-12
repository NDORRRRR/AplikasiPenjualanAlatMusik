/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Model_barangkeluar;

/**
 *
 * @author MSI GAMING
 */
public interface Service_barangKeluar {
    void tambahData (Model_barangkeluar mod_keluar);
    
    Model_barangkeluar getByid (String id);
    List<Model_barangkeluar> ambilData();
    List<Model_barangkeluar> pencarian(String id);
    String nomor();
    
}

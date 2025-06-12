/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Model_semBarangkeluar;

/**
 *
 * @author MSI GAMING
 */
public interface Service_SemBarangKeluar {
    
    void tambahData (Model_semBarangkeluar mod_keluar);
    void perbaruiData (Model_semBarangkeluar mod_keluar);
    void hapusData (Model_semBarangkeluar mod_keluar);
    
    Model_semBarangkeluar getByid (String id);
    
    List<Model_semBarangkeluar> ambilData();
}

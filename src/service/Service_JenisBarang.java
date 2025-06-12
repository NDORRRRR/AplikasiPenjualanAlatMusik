/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Model_jenis_barang;

/**
 *
 * @author MSI GAMING
 */
public interface Service_JenisBarang {
    void tambahData   (Model_jenis_barang mod_jenis);
    void perbaruiData (Model_jenis_barang mod_jenis);
    void hapusData    (Model_jenis_barang mod_jenis);
    
    Model_jenis_barang getByid (String id);
    
    List<Model_jenis_barang> getData();
    List<Model_jenis_barang> pencarian(String id);
    
    String nomor();
    
    boolean valisasiNamaJenisBarang(Model_jenis_barang mod_jenis);    
}

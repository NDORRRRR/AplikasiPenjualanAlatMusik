/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Model_barang;


public interface Service_barang {
    void tambahData (Model_barang mod_bar);
    void perbaruiData (Model_barang mod_bar);
    void hapusData (Model_barang mod_bar);
    
    Model_barang getByid (String id);
    
    List<Model_barang> getDataByID();
    List<Model_barang> getData();
    
    List<Model_barang> pencarian(String id);
    List<Model_barang> pencarian2(String id);
    
    
    String nomor();
    String nomor2();
}

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
public interface Service_SemBarangMasuk {
    void tambahData (Model_semBarangkeluar mod_sem);
   
    
    Model_semBarangkeluar getByid (String id);
    
    List<Model_semBarangkeluar> getData();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Model_distributor;

/**
 *
 * @author MSI GAMING
 */
public interface Service_Distributor {
    void tambahData     (Model_distributor mod_dis);
    void perbaruiData   (Model_distributor mod_dis);
    void hapusData      (Model_distributor mod_dis);
    
    Model_distributor getByid (String id);
    
    List<Model_distributor> getData();
    List<Model_distributor> pencarian(String id);
    
    String nomor();
}

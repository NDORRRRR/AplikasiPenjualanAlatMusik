/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Model_pemesanan;

/**
 *
 * @author MSI GAMING
 */
public interface Service_Pemesanan {
    void tambahData     (Model_pemesanan mod_pesan);
    void perbaruiData (Model_pemesanan mod_pesan);
    void hapusData    (Model_pemesanan mod_pesan);
    
    Model_pemesanan get (String id);
    List<Model_pemesanan> getData();
    List<Model_pemesanan> pencarian (String id);
    String nomor();
    
}

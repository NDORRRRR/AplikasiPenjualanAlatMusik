/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;
import java.util.List;
import model.Model_semPemesanan;
/**
 *
 * @author MSI GAMING
 */
public interface Service_SemPemesanan {
    void tambahData (Model_semPemesanan mod_pesan);
    void perbaruiData (Model_semPemesanan mod_pesan);
    void hapusData (Model_semPemesanan mod_pesan);
    
    Model_semPemesanan getByid (String id);
    List<Model_semPemesanan> ambilData();
    
    
}

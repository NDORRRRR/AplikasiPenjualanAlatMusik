package service;

import java.util.List;
import model.Model_DetPemesanan;

/**
 *
 * @author RVNOLDYVX (Direvisi oleh Partner Coding)
 */
public interface Service_DetPemesanan {
    void tambahData (Model_DetPemesanan mod_detpesan);
    
    Model_DetPemesanan getByid (String id);
    List<Model_DetPemesanan> getData();
    List<Model_DetPemesanan> pencarian(String id);
    
    // Deklarasi method yang hilang telah ditambahkan
    List<Model_DetPemesanan> ambilDetail(String noPemesanan);
}
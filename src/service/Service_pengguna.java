/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.Model_pengguna;


/**
 *
 * @author MSI GAMING
 */
public interface Service_pengguna {
     void tambahData      (Model_pengguna mod_pengguna);
     void perbaruiData    (Model_pengguna mod_pengguna);
     void hapusData       (Model_pengguna mod_pengguna);
     
     Model_pengguna getByid (String id);
     
     List<Model_pengguna> getData();
     List<Model_pengguna> pencarian(String id);
     
     String nomor();    
     boolean validateOldPassword(String username, String oldPassword);
     boolean changePassword(String username, String oldPassword, String newPassword);
     
}

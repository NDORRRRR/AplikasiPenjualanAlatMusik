package service;

import model.Model_login;

/**
 *
 * @author MSI GAMING (Direvisi oleh Partner Coding)
 */
public interface Service_Login {
    // Tipe data kembalian diubah dari 'void' menjadi 'Model_login'
    Model_login prosesLogin (Model_login mod_login);
}
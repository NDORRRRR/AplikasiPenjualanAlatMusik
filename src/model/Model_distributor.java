package model;

/**
 *
 * @author RVNOLDYVX (Direvisi oleh Partner Coding)
 * Kelas ini adalah POJO (Plain Old Java Object) untuk merepresentasikan data distributor.
 */
public class Model_distributor {

    private String id_distributor;
    private String nama_distributor;
    private String telp_distributor;
    private String alamat_distributor;

    public String getId_distributor() {
        return id_distributor;
    }

    public void setId_distributor(String id_distributor) {
        this.id_distributor = id_distributor;
    }

    public String getNama_distributor() {
        return nama_distributor;
    }

    public void setNama_distributor(String nama_distributor) {
        this.nama_distributor = nama_distributor;
    }

    public String getTelp_distributor() {
        return telp_distributor;
    }

    public void setTelp_distributor(String telp_distributor) {
        this.telp_distributor = telp_distributor;
    }

    public String getAlamat_distributor() {
        return alamat_distributor;
    }

    public void setAlamat_distributor(String alamat_distributor) {
        this.alamat_distributor = alamat_distributor;
    }
}


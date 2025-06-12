package model;

import java.util.Date;

/**
 *
 * @author RVNOLDYVX (Direvisi oleh Partner Coding)
 */
public class Model_pemesanan {

    private String no_pemesanan;
    private Date tgl_pemesanan;
    private Double total_pemesanan;
    private Model_distributor mod_distributor;
    private Model_pengguna mod_pengguna;

    // Getter yang sudah ada
    public String getNo_Pemesanan() {
        return no_pemesanan;
    }

    public Date getTgl_Pemesanan() {
        return tgl_pemesanan;
    }

    public Double getTotal_Pemesanan() {
        return total_pemesanan;
    }

    public Model_distributor getMod_distributor() {
        return mod_distributor;
    }
    
    public Model_pengguna getMod_pengguna(){
        return mod_pengguna;
    }
    
    // Setter yang hilang telah ditambahkan
    public void setNo_pemesanan(String no_pemesanan) {
        this.no_pemesanan = no_pemesanan;
    }

    public void setTgl_pemesanan(Date tgl_pemesanan) {
        this.tgl_pemesanan = tgl_pemesanan;
    }

    public void setTotal_pemesanan(Double total_pemesanan) {
        this.total_pemesanan = total_pemesanan;
    }

    public void setMod_distributor(Model_distributor mod_distributor) {
        this.mod_distributor = mod_distributor;
    }

    public void setMod_pengguna(Model_pengguna mod_pengguna) {
        this.mod_pengguna = mod_pengguna;
    }
}
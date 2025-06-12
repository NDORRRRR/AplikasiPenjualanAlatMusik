package model;

/**
 *
 * @author RVNOLDYVX (Direvisi oleh Partner Coding)
 * Kelas ini adalah POJO untuk merepresentasikan data detail dari sebuah pemesanan.
 */
public class Model_DetPemesanan {

    private Model_pemesanan mod_pesan;
    private Model_barang mod_barang;
    private Integer jml_pemesanan;
    private Double subtotal_pemesanan;

    public Model_pemesanan getMod_pesan() {
        return mod_pesan;
    }

    public void setMod_pesan(Model_pemesanan mod_pesan) {
        this.mod_pesan = mod_pesan;
    }

    public Model_barang getMod_barang() {
        return mod_barang;
    }

    public void setMod_barang(Model_barang mod_barang) {
        this.mod_barang = mod_barang;
    }

    public Integer getJml_pemesanan() {
        return jml_pemesanan;
    }

    public void setJml_pemesanan(Integer jml_pemesanan) {
        this.jml_pemesanan = jml_pemesanan;
    }

    public Double getSubtotal_pemesanan() {
        return subtotal_pemesanan;
    }

    public void setSubtotal_pemesanan(Double subtotal_pemesanan) {
        this.subtotal_pemesanan = subtotal_pemesanan;
    }
}
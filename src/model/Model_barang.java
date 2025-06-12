

package model;
        
    public class Model_barang {
        
          
    private String kode_Barang;
    private Model_jenis_barang jns_barang;
    private String nama_barang;
    private String satuan;
    private Long harga;
    private Integer stok;

    public String getKode_Barang() {
        return kode_Barang;
    }

    public void setKode_Barang(String kode_Barang) {
        this.kode_Barang = kode_Barang;
    }

    public Model_jenis_barang getJns_barang() {
        return jns_barang;
    }

    public void setJns_barang(Model_jenis_barang jns_barang) {
        this.jns_barang = jns_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }
    }

   
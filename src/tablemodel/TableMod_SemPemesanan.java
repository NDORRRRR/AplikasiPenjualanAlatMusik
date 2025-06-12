package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Model_semPemesanan;

/**
 *
 * @author RVNOLDYVX (Direvisi oleh Partner Coding)
 */
public class TableMod_SemPemesanan extends AbstractTableModel {

    private List<Model_semPemesanan> list = new ArrayList<>();
    private final String[] columnNames = {"Kode Barang", "Nama Barang", "Harga", "Jumlah", "Subtotal"};

    public void tambahData(Model_semPemesanan mod_sem) {
        list.add(mod_sem);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
        System.out.println("Data berhasil ditambahkan ke tabel sementara");
    }

    public void perbaruiData(int row, Model_semPemesanan mod_sem) {
        list.set(row, mod_sem);
        fireTableDataChanged();
    }

    public void hapusData(int index) {
        list.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public void clear() {
        list.clear();
        fireTableDataChanged();
    }
    
    public List<Model_semPemesanan> getData(){
        return list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Model_semPemesanan model = list.get(rowIndex);
        switch (columnIndex) {
            case 0: return model.getMod_barang().getKode_Barang();
            case 1: return model.getMod_barang().getNama_barang();
            case 2: return model.getMod_barang().getHarga();
            // PERBAIKAN: Menggunakan nama method yang benar dengan garis bawah (_)
            case 3: return model.getMod_detpesan().getJml_pemesanan(); // getJml_pemesanan() bukan getJml_pesan()
            case 4: return model.getMod_detpesan().getSubtotal_pemesanan(); // getSubtotal_pemesanan() bukan getSubTotalpesan()
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
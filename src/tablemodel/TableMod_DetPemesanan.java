package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Model_DetPemesanan;

/**
 *
 * @author RVNOLDYVX (Direvisi oleh Partner Coding)
 */
public class TableMod_DetPemesanan extends AbstractTableModel {

    private List<Model_DetPemesanan> list = new ArrayList<>();
    private final String[] columnNames = {"No Pemesanan", "Kode Barang", "Nama Barang", "Harga", "Jumlah", "Subtotal"};

    public void setData(List<Model_DetPemesanan> list) {
        this.list.clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    
    public void tambahData(Model_DetPemesanan mod_detpesan){
        list.add(mod_detpesan);
        fireTableRowsInserted(list.size()-1, list.size()-1);
    }
    
    public void perbaruiData(int row, Model_DetPemesanan mod_detpesan){
        list.set(row, mod_detpesan);
        fireTableDataChanged();
    }
    
    public void hapusData(int index){
        list.remove(index);
        fireTableRowsDeleted(index, index);
    }
    
    public void clear(){
        list.clear();
        fireTableDataChanged();
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
        Model_DetPemesanan model = list.get(rowIndex);
        switch (columnIndex) {
            // PERBAIKAN: Menggunakan nama method yang benar dengan garis bawah (_)
            case 0: return model.getMod_pesan().getNo_Pemesanan(); // getMod_pesan() bukan getModpesan()
            case 1: return model.getMod_barang().getKode_Barang(); // getMod_barang() bukan getModbarang()
            case 2: return model.getMod_barang().getNama_barang();
            case 3: return model.getMod_barang().getHarga();
            case 4: return model.getJml_pemesanan(); // getJml_pemesanan() bukan getJml_pesan()
            case 5: return model.getSubtotal_pemesanan(); // getSubtotal_pemesanan() bukan getSubTotalpesan()
            // case 6: Dihapus karena tidak ada method getStatus()
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
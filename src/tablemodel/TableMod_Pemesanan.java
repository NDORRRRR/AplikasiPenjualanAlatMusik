package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Model_pemesanan;

/**
 *
 * @author RVNOLDYVX (Direvisi oleh Partner Coding)
 */
public class TableMod_Pemesanan extends AbstractTableModel {
    
    private List<Model_pemesanan> list = new ArrayList<>();
    private final String[] columnNames = {"No Pemesanan", "Tanggal", "Total", "ID Distributor", "Nama Distributor"};

    public void setData(List<Model_pemesanan> list) {
        this.list.clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }

    public Model_pemesanan getData(int rowIndex) {
        return list.get(rowIndex);
    }
    
    public void hapusData(int rowIndex) {
        list.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
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
        Model_pemesanan model = list.get(rowIndex);
        switch (columnIndex) {
            // Perbaikan Typo: getNo_pesan -> getNo_Pemesanan, dll.
            case 0: return model.getNo_Pemesanan();
            case 1: return model.getTgl_Pemesanan();
            case 2: return model.getTotal_Pemesanan();
            case 3: return model.getMod_distributor().getId_distributor();
            case 4: return model.getMod_distributor().getNama_distributor();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
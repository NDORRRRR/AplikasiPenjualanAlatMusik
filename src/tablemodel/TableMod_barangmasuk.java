/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_barangmasuk;

/**
 *
 * @author MSI GAMING
 */

    public class TableMod_barangmasuk extends AbstractTableModel{
    
    private List<Model_barangmasuk> list = new ArrayList<>();
    
    public void tambahData(Model_barangmasuk mod_masuk){
      list.add(mod_masuk);
      fireTableRowsInserted(list.size() -1, list.size() -1);
      JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, Model_barangmasuk  mod_masuk){
      list.add(row, mod_masuk);
      fireTableDataChanged();
      JOptionPane.showMessageDialog(null, "Data berhasil diperbarui");
    }
    public void hapusData (int index) {
      list.remove(index);
      fireTableRowsDeleted(index, index);
      JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
    } 
    public void clear(){
      list.clear();
      fireTableDataChanged();
    }
    
    public void setData(List<Model_barangmasuk> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData (int index, Model_barangmasuk mod_keluar) {
        list.set(index, mod_keluar);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_barangmasuk getData (int index){
        return list.get(index);
    }
    
    
    @Override
    public int getRowCount() {
       
    return list.size();
       
    }

    @Override
    public int getColumnCount() {       
        return 5;   
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {      
        switch (columnIndex){
            
          case 0: return list.get(rowIndex).getNo_masuk();
          case 1: return list.get(rowIndex).getTgl_masuk();
          case 2: return list.get(rowIndex).getTotal_masuk();
          case 3: return list.get(rowIndex).getMod_distributor().getId_distributor();
          case 4: return list.get(rowIndex).getMode_pengguna().getId_pengguna();
          
          
          
          
          default: return null;
        }       
     }   
    public String getColumnName(int column) {
        switch (column){
            case 0: return "No. Masuk"; 
            case 1: return "Tanggal Masuk"; 
            case 2: return "Total Masuk"; 
            case 3: return "ID distributor"; 
            case 4: return "ID pengguna"; 
            
            default: return null;
    }
    
    }
}





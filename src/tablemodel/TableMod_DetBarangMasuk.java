/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_DetBarangMasuk;


    
    public class TableMod_DetBarangMasuk extends AbstractTableModel{
    
    private List<Model_DetBarangMasuk> list = new ArrayList<>();
    
    public void tambahData(Model_DetBarangMasuk mod_detmasuk){
      list.add(mod_detmasuk);
      fireTableRowsInserted(list.size() -1, list.size() -1);
      JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, Model_DetBarangMasuk  mod_detmasuk){
      list.add(row, mod_detmasuk);
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
    
    public void setData(List<Model_DetBarangMasuk> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData (int index, Model_DetBarangMasuk mod_keluar) {
        list.set(index, mod_keluar);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_DetBarangMasuk getData (int index){
        return list.get(index);
    }
    
    
    @Override
    public int getRowCount() {
       
    return list.size();
       
    }

    @Override
    public int getColumnCount() {       
        return 6;   
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {      
        switch (columnIndex){
            
          case 0: return list.get(rowIndex).getModmasuk().getNo_masuk();
          case 1: return list.get(rowIndex).getMobar().getKode_Barang();
          case 2: return list.get(rowIndex).getMobar().getNama_barang();
          case 3: return list.get(rowIndex).getMobar().getHarga();
          case 4: return list.get(rowIndex).getJml_masuk();
          case 5: return list.get(rowIndex).getSubtotalmasuk();
          
          
          
          default: return null;
        }       
     }   
    public String getColumnName(int column) {
        switch (column){
            case 0: return "No. Masuk"; 
            case 1: return "Tanggal Masuk"; 
            case 2: return "Total"; 
            case 3: return "Nama Barang"; 
            case 4: return "Jumlah"; 
            case 5: return "Subtotal"; 
            
            default: return null;
    }
    
    }
}



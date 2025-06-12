/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import model.Model_pengguna;

/**
 *
 * @author MSI GAMING
 */
public class TableMod_Pengguna extends AbstractTableModel {
    
    private List<Model_pengguna> list = new ArrayList<>();
    
    public void tambahData(Model_pengguna mod_pengguna){
      list.add(mod_pengguna);
      fireTableRowsInserted(list.size() -1, list.size() -1);
      JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }
    
    public void perbaruiData(int row, Model_pengguna mod_pengguna ){
      list.add(row, mod_pengguna);
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
    
    public void setData(List<Model_pengguna> list) {
        clear();
        this.list.addAll(list);
        fireTableDataChanged();
    }
    public void setData (int index, Model_pengguna mod_pengguna) {
        list.set(index, mod_pengguna);
        fireTableRowsUpdated(index, index);
    }
    
    public Model_pengguna getData (int index){
        return list.get(index);
    }
    
    
    @Override
    public int getRowCount() {
       
    return list.size();
       
    }
    private final String[] columnNames = {"No", "ID", "nama pengguna", "username", "telp_pengguna", "alamat_pengguna", "level"};
    @Override
    public int getColumnCount() {       
        return columnNames.length;   
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {      
        if (columnIndex == 0){
            return "   " + (rowIndex + 1);
        } else { 
        
        switch (columnIndex - 1){
            
          case 0: return list.get(rowIndex).getId_pengguna();
          case 1: return list.get(rowIndex).getNama_pengguna();
          case 2: return list.get(rowIndex).getUsername();
          case 3: return list.get(rowIndex).getTelp_pengguna();
          case 4: return list.get(rowIndex).getAlamat_pengguna();
          case 5: return list.get(rowIndex).getLevel();
          default: return null;
        }       
     }  
  }
   @Override
    public String getColumnName(int column){
        if(column == 0){
            return "  " + columnNames[column];
        } else{
        return columnNames[column];
    }
  }
    
}
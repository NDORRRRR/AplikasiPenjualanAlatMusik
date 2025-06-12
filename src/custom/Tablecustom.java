/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Tablecustom extends JTable {

    public Tablecustom() {
        // --- Mengatur Tampilan Tabel ---
        
        // 1. Mengatur tampilan header tabel
        getTableHeader().setDefaultRenderer(new TableHeaderCustom());
        getTableHeader().setReorderingAllowed(false);

        // 2. Mengatur tampilan sel/baris tabel
        setDefaultRenderer(Object.class, new TableCellCustom());

        // 3. Properti dasar lainnya
        setRowHeight(35); // Membuat baris lebih tinggi agar tidak terlalu rapat
        setGridColor(new Color(230, 230, 230)); // Warna garis grid
        setShowHorizontalLines(true); // Hanya tampilkan garis horizontal
        setShowVerticalLines(false); // Sembunyikan garis vertikal
    }

    /**
     * Kelas private untuk mendesain Header Tabel.
     */
    private static class TableHeaderCustom extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            // Mengatur warna latar belakang header
            com.setBackground(new Color(0, 51, 102)); // Biru tua
            
            // Mengatur warna teks header
            com.setForeground(Color.WHITE);
            
            // Mengatur font header menjadi tebal
            com.setFont(com.getFont().deriveFont(Font.BOLD, 12f));
            
            // Mengatur alignment header ke tengah
            setHorizontalAlignment(CENTER);
            
            return com;
        }
    }

    /**
     * Kelas private untuk mendesain Sel/Baris Tabel.
     */
    private static class TableCellCustom extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Mengatur warna baris selang-seling (Zebra-Striping)
            if (!isSelected) {
                if (row % 2 == 0) { // Baris genap
                    com.setBackground(Color.WHITE);
                } else { // Baris ganjil
                    com.setBackground(new Color(245, 245, 245)); // Abu-abu sangat muda
                }
                // Pastikan warna teks kembali normal saat tidak dipilih
                com.setForeground(Color.BLACK); 
            } else {
                // Mengatur warna saat baris dipilih
                com.setBackground(new Color(51, 153, 255)); // Biru muda
                
                // --- INI BAGIAN YANG DIPERBAIKI ---
                com.setForeground(Color.WHITE); // <- Kode yang tidak lengkap sudah diperbaiki
            }
            
            // Mengatur alignment sel ke tengah
            setHorizontalAlignment(CENTER);
            
            return com;
        }
    }
}
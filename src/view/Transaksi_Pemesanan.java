package view;

import dao.DAO_DetPemesanan;
import dao.DAO_Pemesanan;
import java.util.List;
import javax.swing.JOptionPane;
import model.Model_DetPemesanan;
import model.Model_distributor;
import model.Model_pemesanan;
import service.Service_DetPemesanan;
import service.Service_Pemesanan;
import tablemodel.TableMod_DetPemesanan;
import tablemodel.TableMod_Pemesanan;

/**
 *
 * @author RVNOLDYVX (Direvisi total oleh Partner Coding)
 */
public class Transaksi_Pemesanan extends javax.swing.JPanel {

    private final Service_Pemesanan servis_psn;
    private final Service_DetPemesanan servis_det;
    private final TableMod_Pemesanan tblModel_psn;
    private final TableMod_DetPemesanan tblModel_det;

    public Transaksi_Pemesanan() {
        initComponents();

        servis_psn = new DAO_Pemesanan();
        servis_det = new DAO_DetPemesanan();
        tblModel_psn = new TableMod_Pemesanan();
        tblModel_det = new TableMod_DetPemesanan();

        tablecustom2.setModel(tblModel_psn);
        tablecustom1.setModel(tblModel_det);

        loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        tampilData = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablecustom1 = new custom.Tablecustom();
        jLabel2 = new javax.swing.JLabel();
        bt_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        t_cari = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablecustom2 = new custom.Tablecustom();
        jLabel10 = new javax.swing.JLabel();
        tambahData = new javax.swing.JPanel();
        L_databarang2 = new javax.swing.JLabel();
        bt_simpan = new javax.swing.JButton();
        btn_batal_tambah = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pn_pemesanan = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        t_noPesan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        t_tanggal = new javax.swing.JTextField();
        pn_distributor = new javax.swing.JPanel();
        t_idDistributor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        t_namaDistributor = new javax.swing.JTextField();
        btn_distributor = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pn_barang = new javax.swing.JPanel();
        t_kodeBarang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btn_cariBarang = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        t_namaBarang = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        t_harga = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        t_jumlah = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        t_subtotal = new javax.swing.JTextField();
        btn_tambahKeKeranjang = new javax.swing.JButton();
        btn_hapusDariKeranjang = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_keranjang = new custom.Tablecustom();
        jLabel15 = new javax.swing.JLabel();
        t_totalPemesanan = new javax.swing.JTextField();

        setLayout(new java.awt.CardLayout());

        mainPanel.setLayout(new java.awt.CardLayout());

        tampilData.setBackground(new java.awt.Color(255, 255, 255));

        tablecustom1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablecustom1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36));
        jLabel2.setText("Data Pemesanan Barang");

        bt_tambah.setText("TAMBAH");
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });

        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_batal.setText("BATAL");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        t_cari.setFont(new java.awt.Font("Segoe UI", 2, 12));
        t_cari.setText("Pencarian...");
        t_cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_cariMouseClicked(evt);
            }
        });
        t_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_cariKeyReleased(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_brg/pencarian 2.png")));

        tablecustom2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablecustom2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablecustom2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablecustom2);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel10.setText("Detail Pemesanan");

        javax.swing.GroupLayout tampilDataLayout = new javax.swing.GroupLayout(tampilData);
        tampilData.setLayout(tampilDataLayout);
        tampilDataLayout.setHorizontalGroup(
            tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tampilDataLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addComponent(bt_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                        .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(tampilDataLayout.createSequentialGroup()
                        .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        tampilDataLayout.setVerticalGroup(
            tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tampilDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tampilDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bt_tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_cari)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addContainerGap())
        );

        mainPanel.add(tampilData, "card2");
        
        L_databarang2.setFont(new java.awt.Font("Segoe UI", 0, 36));
        L_databarang2.setText("Tambah Pemesanan Barang");
        
        mainPanel.add(tambahData, "card3");

        add(mainPanel, "card2");
    }// </editor-fold>                        

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {                                          
        mainPanel.removeAll();
        mainPanel.add(tambahData);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        resetForm();
        t_noPesan.setText(servis_psn.nomor());
    }                                         

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {                                          
        hapusData();
    }                                         

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {                                          
        tampilPanel();
        loadData();
    }                                         

    private void t_cariMouseClicked(java.awt.event.MouseEvent evt) {                                    
        t_cari.setText("");
    }                                   

    private void t_cariKeyReleased(java.awt.event.KeyEvent evt) {                                   
        pencarian();
    }                                  

    private void tablecustom2MouseClicked(java.awt.event.MouseEvent evt) {                                          
        int selectedRow = tablecustom2.getSelectedRow();
        if (selectedRow != -1) {
            String noPemesanan = tablecustom2.getValueAt(selectedRow, 0).toString();
            List<Model_DetPemesanan> detailList = servis_det.ambilDetail(noPemesanan);
            tblModel_det.setData(detailList);
            
            btn_hapus.setVisible(true);
            btn_batal.setVisible(true);
        }
    }                                         
    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel L_databarang2;
    private javax.swing.JButton bt_simpan;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_batal_tambah;
    private javax.swing.JButton btn_cariBarang;
    private javax.swing.JButton btn_distributor;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_hapusDariKeranjang;
    private javax.swing.JButton btn_tambahKeKeranjang;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel pn_barang;
    private javax.swing.JPanel pn_distributor;
    private javax.swing.JPanel pn_pemesanan;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTextField t_harga;
    private javax.swing.JTextField t_idDistributor;
    private javax.swing.JTextField t_jumlah;
    private javax.swing.JTextField t_kodeBarang;
    private javax.swing.JTextField t_namaBarang;
    private javax.swing.JTextField t_namaDistributor;
    private javax.swing.JTextField t_noPesan;
    private javax.swing.JTextField t_subtotal;
    private javax.swing.JTextField t_tanggal;
    private javax.swing.JTextField t_totalPemesanan;
    private javax.swing.JPanel tambahData;
    private javax.swing.JPanel tampilData;
    private custom.Tablecustom tablecustom1;
    private custom.Tablecustom tablecustom2;
    private custom.Tablecustom tbl_keranjang;
    // End of variables declaration                   

    private void loadData() {
        btn_hapus.setVisible(false);
        btn_batal.setVisible(false);
        List<Model_pemesanan> list = servis_psn.getData();
        tblModel_psn.setData(list);
    }
    
    private void hapusData() {
        int selectedRow = tablecustom2.getSelectedRow();
        if (selectedRow != -1) {
            Model_pemesanan pemesanan = tblModel_psn.getData(tablecustom2.convertRowIndexToModel(selectedRow));
            if (JOptionPane.showConfirmDialog(this, "Yakin data akan dihapus?", "Konfirmasi", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                servis_psn.hapusData(pemesanan);
                tblModel_psn.hapusData(selectedRow);
                loadData();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih dahulu data yang akan dihapus.");
        }
    }

    private void resetForm() {
        t_noPesan.setText("");
        t_tanggal.setText("");
        t_idDistributor.setText("");
        t_namaDistributor.setText("");
        t_kodeBarang.setText("");
        t_namaBarang.setText("");
        t_harga.setText("");
        t_jumlah.setText("");
        t_subtotal.setText("");
        t_totalPemesanan.setText("");
    }
    
    private void tampilPanel() {
        mainPanel.removeAll();
        mainPanel.add(tampilData);
        mainPanel.repaint();
        mainPanel.revalidate();
    }
    
    private void pencarian() {
        List<Model_pemesanan> list = servis_psn.pencarian(t_cari.getText());
        tblModel_psn.setData(list);
    }
}
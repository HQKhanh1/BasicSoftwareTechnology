/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.view;

import DTTT.controller.ChuyenManHinh;
import DTTT.dao.DBConnect;
import DTTT.dao.KTTK;
import DTTT.model.ThongTinPhong;
import DTTT.model.ThongTinTin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class CapNhatMenu extends javax.swing.JPanel {

    Vector<String> maTin = new Vector<>();
    public CapNhatMenu() {
        initComponents();
            this.setVisible(true);
        lay_Tin();
    }

    private void lay_Tin(){
        Connection conn = DBConnect.getConnection();
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setNumRows(0);
        String sql = "SELECT * FROM Thong_Tin_Tin where TaiKhoan = ?";
        Vector<String> vt;
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, KTTK.getTtk());
            ResultSet rs = ps.executeQuery(); 
            while(rs.next()){
                vt = new Vector<>();
                maTin.add(rs.getString("MaTin"));
                vt.add(rs.getString("TieuDe"));
                vt.add(rs.getString("ThongTinDiaChi"));
                vt.add(rs.getString("NgayDang"));
                dtm.addRow(vt);
            }
            jTable1.setModel(dtm);
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
  private List<ThongTinTin> lay_TinList(){
        Connection conn = DBConnect.getConnection();
        
        
        String sql = "SELECT * FROM Thong_Tin_Tin where TaiKhoan = ?";
        List<ThongTinTin> list = new ArrayList<>();
//        Vector<String> vt;
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, KTTK.getTtk());
            ResultSet rs = ps.executeQuery(); 
            while(rs.next()){
                ThongTinTin ttt = new ThongTinTin();

//                ttt.setMaTin(rs.getString("MaTin"));
                ttt.setTieuDe(rs.getString("TieuDe"));
                ttt.setMaTin(rs.getString("SDTTin"));
                ttt.setTieuDe(rs.getString("NgayDang"));
                ttt.setMaTin(rs.getString("AnNinh"));
                ttt.setTieuDe(rs.getString("ThongTinDiaChi"));

                list.add(ttt);
            }
            ps.close();
            rs.close();
            conn.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfTimKiem = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbtThemTinMoi = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbtXuatFile = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(960, 640));

        jtfTimKiem.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Tìm kiếm");

        jbtThemTinMoi.setBackground(new java.awt.Color(76, 175, 80));
        jbtThemTinMoi.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtThemTinMoi.setForeground(new java.awt.Color(255, 255, 255));
        jbtThemTinMoi.setText("Thêm tin mới");
        jbtThemTinMoi.setBorder(null);
        jbtThemTinMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtThemTinMoiMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tiêu đề", "Địa chỉ", "Ngày đăng "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setEditingColumn(0);
        jTable1.setEditingRow(0);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(140);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbtXuatFile.setBackground(new java.awt.Color(76, 175, 80));
        jbtXuatFile.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jbtXuatFile.setForeground(new java.awt.Color(255, 255, 255));
        jbtXuatFile.setText("Xuất file");
        jbtXuatFile.setBorder(null);
        jbtXuatFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtXuatFileMouseClicked(evt);
            }
        });
        jbtXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtXuatFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtThemTinMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtThemTinMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int chon = jTable1.getSelectedRow();
        ChuyenManHinh cmh = new ChuyenManHinh(this);
        try {
            CapNhat cn = new CapNhat(KTTK.getTtk(),0);
            cn.setTin(maTin.get(chon));
            cmh.setView(cn);
        } catch (SQLException ex) {
            Logger.getLogger(CapNhatMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jbtThemTinMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtThemTinMoiMouseClicked
        ChuyenManHinh cmh = new ChuyenManHinh(this);
        try {
            cmh.setView(new CapNhat(KTTK.getTtk(),1));
        } catch (SQLException ex) {
            Logger.getLogger(CapNhatMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtThemTinMoiMouseClicked

    private void jbtXuatFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtXuatFileMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtXuatFileMouseClicked

    private void jbtXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtXuatFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtXuatFileActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbtThemTinMoi;
    private javax.swing.JButton jbtXuatFile;
    private javax.swing.JTextField jtfTimKiem;
    // End of variables declaration//GEN-END:variables

}

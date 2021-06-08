/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.view;

import DTTT.controller.ChuyenManHinh;
import DTTT.dao.DBConnect;
import DTTT.dao.KTTK;
import DTTT.model.ChuanHoa;
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
import DTTT.dao.DatLicHenImpl;
import java.text.SimpleDateFormat;
/**
 *
 * @author Admin
 */
public class HienThiLichHen extends javax.swing.JPanel {
    public HienThiLichHen() {
        initComponents();
            this.setVisible(true);
    }
    
    private void showLichHen() throws SQLException{
        jTblLichHen.removeAll();
        String[] arr = {"MaLicHen","Ma Tin","Tên người hẹn","SĐT người hẹn", "Địa chỉ hẹn", "Thời gian hẹn"};
        DefaultTableModel model = new DefaultTableModel(arr,0);
        String tenNguoiHen = "";
        String sdtNguoiHen = "";
        String diaChiNguoiHen = "";
        String thoiGianHen = "";
        String queryLichHen = "select * from Lich_Hen";
        Connection cnn = DBConnect.getConnection();
        PreparedStatement psLichHen = cnn.prepareStatement(queryLichHen);
        ResultSet rsLichHen = psLichHen.executeQuery();
        int dem = 0;
        while(rsLichHen.next()){
            System.out.println("Dem Lich: " + dem);
            String maTinLichHenTam = ChuanHoa.xoaKhoangTrang(rsLichHen.getString("MaTin"));
            int check = DatLicHenImpl.checkTaiKhoanTrongMaTin(maTinLichHenTam);
            if( check == 1){
                Vector vt = new Vector();
                        tenNguoiHen = DatLicHenImpl.layTenTaiKhoan(rsLichHen.getString("TaiKhoan"));
                        sdtNguoiHen = DatLicHenImpl.laySDTTaiKhoan(rsLichHen.getString("TaiKhoan"));
                        diaChiNguoiHen = rsLichHen.getString("MoTa") + " " + DatLicHenImpl.layDiaChiHen(rsLichHen.getString("MaXa"));
                        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                        thoiGianHen = formatter1.format(rsLichHen.getDate("ThoiGianHen"));
                        vt.add(rsLichHen.getString("MaLichHen"));
                        vt.add(rsLichHen.getString("MaTin"));
                        vt.add(tenNguoiHen);
                        vt.add(sdtNguoiHen);
                        vt.add(diaChiNguoiHen);
                        vt.add(thoiGianHen);
                        model.addRow(vt);
            }
        }
        jTblLichHen.setModel(model);
    }
    private void showLichHenCuaBan() throws SQLException{
        jTblLichHen.removeAll();
        String[] arr = {"MaLicHen","Ma Tin","Tên người đã hẹn","SĐT người đã hẹn", "Địa chỉ hẹn", "Thời gian hẹn"};
        DefaultTableModel model = new DefaultTableModel(arr,0);
        String tenNguoiHen = "";
        String sdtNguoiHen = "";
        String diaChiNguoiHen = "";
        String thoiGianHen = "";
        String queryLichHen = "select * from Lich_Hen";
        String queryTin = "select * from Thong_Tin_Tin";
        Connection cnn = DBConnect.getConnection();
        PreparedStatement psLichHen = cnn.prepareStatement(queryLichHen);
        PreparedStatement psTin = cnn.prepareStatement(queryTin);
        ResultSet rsLichHen = psLichHen.executeQuery();
        ResultSet rsTin = psTin.executeQuery();
        int dem = 0;
        while(rsLichHen.next()){
            String maTinLichHenTam = ChuanHoa.xoaKhoangTrang(rsLichHen.getString("MaTin"));
            String taiKhoanTam =ChuanHoa.xoaKhoangTrang(rsLichHen.getString("TaiKhoan"));
            String taiKhoanDangNhap = ChuanHoa.xoaKhoangTrang(KTTK.getTtk());
            if(taiKhoanDangNhap.equals(taiKhoanTam)){
                String taiKhoanTin = DatLicHenImpl.checkLayTaiKhoanTrongMaTin(maTinLichHenTam);
                        Vector vt = new Vector();
                        tenNguoiHen = DatLicHenImpl.layTenTaiKhoan(taiKhoanTin);
                        sdtNguoiHen = DatLicHenImpl.laySDTTaiKhoan(taiKhoanTin);
                        diaChiNguoiHen = rsLichHen.getString("MoTa") + " " + DatLicHenImpl.layDiaChiHen(rsLichHen.getString("MaXa"));
                        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                        thoiGianHen = formatter1.format(rsLichHen.getDate("ThoiGianHen"));
                        vt.add(rsLichHen.getString("MaLichHen"));
                        vt.add(rsLichHen.getString("MaTin"));
                        vt.add(tenNguoiHen);
                        vt.add(sdtNguoiHen);
                        vt.add(diaChiNguoiHen);
                        vt.add(thoiGianHen);
                        model.addRow(vt);
            }
        }
        jTblLichHen.setModel(model);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblLichHen = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(960, 640));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jTblLichHen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTblLichHen.setShowGrid(false);
        jScrollPane1.setViewportView(jTblLichHen);

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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jButton1.setBackground(new java.awt.Color(0, 51, 153));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Lịch bạn đã hẹn");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));

        jButton2.setBackground(new java.awt.Color(0, 51, 153));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Lịch người dùng hẹn bạn");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            showLichHenCuaBan();
        } catch (SQLException ex) {
            Logger.getLogger(HienThiLichHen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            showLichHen();
        } catch (SQLException ex) {
            Logger.getLogger(HienThiLichHen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblLichHen;
    // End of variables declaration//GEN-END:variables

}

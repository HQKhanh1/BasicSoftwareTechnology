/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.view;

import DTTT.dao.DBConnect;
import DTTT.dao.KTTK;
import DTTT.dao.DatLicHenImpl;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */

public class DatLichHen extends javax.swing.JDialog {

    /**
     * Creates new form DatLichHen
     */
    public DatLichHen() {
        initComponents();
    }
    public DatLichHen(String MaTinTin) throws SQLException {
        initComponents();
         showTinhTP();
         
        
        jcbbTinhTP.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== jcbbTinhTP){
                    tinh = (String) jcbbTinhTP.getSelectedItem();
                    try {
                        jcbbQuanHuyen.removeAllItems();
                        showQuanHuyen(getIDTinh(tinh));
                    } catch (SQLException ex) {
                        Logger.getLogger(CapNhat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
       
        jcbbQuanHuyen.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== jcbbQuanHuyen){
                    huyen = (String) jcbbQuanHuyen.getSelectedItem();
                    try {
                        jcbbXPTT.removeAllItems();
                        showXPTT(getIDHuyen(huyen));
                    } catch (SQLException ex) {
                        Logger.getLogger(CapNhat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });     
        
        jcbbXPTT.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== jcbbXPTT){
                    xptt = (String) jcbbXPTT.getSelectedItem();
                    try {
                        idXa = getIDXa(xptt);
                    } catch (SQLException ex) {
                        Logger.getLogger(CapNhat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        jbtnXacNhan.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String maLichHen = "", maTin = "", taiKhoan = "", maXa = "", moTa = "",thoiGianHentxt;
                java.sql.Date thoiGianHen;
                java.util.Date date;
                long millis=System.currentTimeMillis();  
                java.sql.Date dateNow=new java.sql.Date(millis);
                maTin =MaTinTin;
                try {
                    SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                    thoiGianHentxt = formatter1.format(jDate_LichHen.getDate());
                    date = formatter1.parse(thoiGianHentxt);
                    thoiGianHen = new java.sql.Date(date.getTime());
                    if(KTTK.getTtk().length()!=0){
                        taiKhoan = KTTK.getTtk();
                        if(DatLicHenImpl.checkTaiKhoanTrongMaTin(MaTinTin) == 1){
                            JOptionPane.showMessageDialog(rootPane, "Bạn đang đặt lịch hẹn với tin mình đã đăng!");
                        }else if(DatLicHenImpl.laySoPhong(maTin) <= 0){
                            JOptionPane.showMessageDialog(rootPane, "Tin bạn đang xem không còn phòng!\n Vui lòng liên hệ trực tiếp đến người đăng tin qua số điện thoại!");
                        }
                        else if(!thoiGianHen.after(dateNow)){
                            JOptionPane.showMessageDialog(rootPane, "Thời gian hẹn không phù hợp! Mời bạn chọn lại!");
                        }else if(jcbbTinhTP.getSelectedItem() != null && jcbbQuanHuyen.getSelectedItem() != null && jcbbXPTT.getSelectedItem() != null){
                           maXa = getIDXa(jcbbXPTT.getSelectedItem().toString());
                            moTa = jtxtMoTa.getText();
                            maLichHen = DTTT.dao.DatLicHenImpl.layMalichHen();
                            DTTT.model.DatLichHen lichhen = new DTTT.model.DatLichHen(maLichHen, maTin, taiKhoan, maXa, moTa, thoiGianHen);
                            int check =  JOptionPane.showConfirmDialog(rootPane,  
                                            "Bạn có chắc chắn thêm hay không?", 
                                            "Xác nhận", 
                                            JOptionPane.YES_NO_OPTION);
                            if(check == JOptionPane.YES_OPTION){
                                DTTT.dao.DatLicHenImpl.themLichHen(lichhen);
                                DatLicHenImpl.truSoPhong(maTin);
                                JOptionPane.showMessageDialog(rootPane, "Đặt lịch hẹn thành công!");
                                Container frame = jbtnXacNhan.getParent();
                                do{
                                    frame = frame.getParent(); 
                                }while (!(frame instanceof DatLichHen));  
                                ((DatLichHen) frame).dispose();         
                            } 
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn địa điểm hẹn");
                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Bạn chưa đăng nhập! Vui lòng đăng nhập để sử dụng chức năng này!");
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(DatLichHen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(DatLichHen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        });
    }
    
    public String getIDTinh(String name) throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM TinhThanhPho";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            if(rs.getString("TenTP").trim().equals(name)){
                idTinh = rs.getString("MaTP");
            }
        }
        return idTinh;
    }
    String tinh="",huyen="",xptt="",idXa="",idHuyen="",idTinh="";
    public void showTinhTP() throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT TenTP FROM TinhThanhPho";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            jcbbTinhTP.addItem(rs.getString("TenTP"));
        }
    }
    public void showQuanHuyen(String id) throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM QuanHuyen where MaTP = '" + id + "'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            jcbbQuanHuyen.addItem(rs.getString("TenQH"));
        }
    }
    public String getIDHuyen(String name) throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM QuanHuyen";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            if(rs.getString("TenQH").trim().equals(name)){
                idHuyen = rs.getString("MaQH");
            }
        }
        return idHuyen;
    }
    public void showXPTT(String id) throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM XaPhuongThiTran where MaQH = '" + id + "'";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            jcbbXPTT.addItem(rs.getString("TenXa"));
        }
    }
    public String getIDXa(String name) throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM XaPhuongThiTran";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            if(rs.getString("TenXa").trim().equals(name)){
                idXa = rs.getString("MaXa");
            }
        }
        return idXa;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtbnQuayLai = new javax.swing.JButton();
        jbtnXacNhan = new javax.swing.JButton();
        jDate_LichHen = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcbbTinhTP = new javax.swing.JComboBox<>();
        jcbbQuanHuyen = new javax.swing.JComboBox<>();
        jcbbXPTT = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtMoTa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 102, 204));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐẶT LỊCH HẸN");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setDoubleBuffered(false);
        jPanel3.setEnabled(false);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        jLabel3.setBackground(new java.awt.Color(204, 204, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Thời gian hẹn");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Ngày hẹn:");
        jLabel4.setOpaque(true);

        jtbnQuayLai.setBackground(new java.awt.Color(255, 255, 255));
        jtbnQuayLai.setText("Quay lại");
        jtbnQuayLai.setBorder(null);
        jtbnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnQuayLaiActionPerformed(evt);
            }
        });

        jbtnXacNhan.setBackground(new java.awt.Color(255, 255, 255));
        jbtnXacNhan.setText("Xác nhận");
        jbtnXacNhan.setBorder(null);
        jbtnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXacNhanActionPerformed(evt);
            }
        });

        jDate_LichHen.setDateFormatString("dd/MM/yyyy");
        jDate_LichHen.setName("jDate_LichHen"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDate_LichHen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jtbnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(jbtnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDate_LichHen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtbnQuayLai, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jbtnXacNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 255));

        jLabel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Địa điểm hẹn");
        jLabel2.setOpaque(true);

        jLabel5.setText("Tỉnh/Thanh phố:");

        jLabel6.setText("Xã/Phường/TT:");

        jLabel7.setText("Quận/Huyện:");

        jLabel8.setText("Chi tiết địa chỉ(số nhà tên đường..v.v.v)");

        jtxtMoTa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtMoTaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbbQuanHuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbbTinhTP, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jcbbXPTT, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jtxtMoTa)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbbTinhTP))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbbQuanHuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbbXPTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtMoTaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtMoTaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtMoTaActionPerformed

    private void jtbnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbnQuayLaiActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jtbnQuayLaiActionPerformed

    private void jbtnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXacNhanActionPerformed
        
    }//GEN-LAST:event_jbtnXacNhanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDate_LichHen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbtnXacNhan;
    private javax.swing.JComboBox<String> jcbbQuanHuyen;
    private javax.swing.JComboBox<String> jcbbTinhTP;
    private javax.swing.JComboBox<String> jcbbXPTT;
    private javax.swing.JButton jtbnQuayLai;
    private javax.swing.JTextField jtxtMoTa;
    // End of variables declaration//GEN-END:variables
}

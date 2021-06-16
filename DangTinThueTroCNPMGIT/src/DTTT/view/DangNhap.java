package DTTT.view;
import DTTT.dao.KiemTraDN;
import DTTT.controller.ChuyenManHinh;
import DTTT.dao.KTTK;
import DTTT.view.ThemTKJDialog;
import DTTT.view.theme;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DangNhap extends javax.swing.JPanel {

    public DangNhap() {
        initComponents();
            this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jpnTaiKhoan = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtfTTK = new javax.swing.JTextField();
        jpnMatKhau = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jpwMK = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbtDangNhap = new javax.swing.JButton();
        jbtThemTK = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1060, 564));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setPreferredSize(new java.awt.Dimension(1060, 564));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jPanel3.setBackground(new java.awt.Color(248, 248, 255));

        jpnTaiKhoan.setBackground(new java.awt.Color(242, 242, 242));
        jpnTaiKhoan.setPreferredSize(new java.awt.Dimension(634, 60));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Tên tài khoản:");

        jtfTTK.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jtfTTK.setBorder(null);
        jtfTTK.setPreferredSize(new java.awt.Dimension(468, 37));

        javax.swing.GroupLayout jpnTaiKhoanLayout = new javax.swing.GroupLayout(jpnTaiKhoan);
        jpnTaiKhoan.setLayout(jpnTaiKhoanLayout);
        jpnTaiKhoanLayout.setHorizontalGroup(
            jpnTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTaiKhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfTTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnTaiKhoanLayout.setVerticalGroup(
            jpnTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTaiKhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfTTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jpnMatKhau.setBackground(new java.awt.Color(242, 242, 242));
        jpnMatKhau.setPreferredSize(new java.awt.Dimension(634, 60));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Mật khẩu:");
        jLabel5.setPreferredSize(new java.awt.Dimension(142, 37));

        jpwMK.setBorder(null);
        jpwMK.setPreferredSize(new java.awt.Dimension(468, 37));

        javax.swing.GroupLayout jpnMatKhauLayout = new javax.swing.GroupLayout(jpnMatKhau);
        jpnMatKhau.setLayout(jpnMatKhauLayout);
        jpnMatKhauLayout.setHorizontalGroup(
            jpnMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMatKhauLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpwMK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnMatKhauLayout.setVerticalGroup(
            jpnMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMatKhauLayout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(jpnMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpwMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 54, 128));
        jPanel2.setPreferredSize(new java.awt.Dimension(634, 70));

        jLabel1.setBackground(new java.awt.Color(0, 54, 128));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG NHẬP");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbtDangNhap.setBackground(new java.awt.Color(255, 255, 255));
        jbtDangNhap.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jbtDangNhap.setText("Đăng Nhập");
        jbtDangNhap.setPreferredSize(new java.awt.Dimension(140, 50));
        jbtDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtDangNhapMouseClicked(evt);
            }
        });
        jbtDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDangNhapActionPerformed(evt);
            }
        });

        jbtThemTK.setBackground(new java.awt.Color(255, 255, 255));
        jbtThemTK.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jbtThemTK.setText("Đăng Ký");
        jbtThemTK.setMaximumSize(new java.awt.Dimension(127, 31));
        jbtThemTK.setMinimumSize(new java.awt.Dimension(127, 31));
        jbtThemTK.setPreferredSize(new java.awt.Dimension(140, 50));
        jbtThemTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtThemTKMouseClicked(evt);
            }
        });
        jbtThemTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtThemTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jbtDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(354, 354, 354)
                            .addComponent(jbtThemTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jpnMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpnTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 339, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(8, 8, 8)
                    .addComponent(jpnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                    .addComponent(jpnMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtThemTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(203, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void jbtDangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtDangNhapMouseClicked
        try {
            KiemTraDN dn = null;
            String mk = new String(jpwMK.getPassword());
            int i=dn.DangNhapTK(jtfTTK.getText(),mk);
            if(i==1){
                jpwMK.setText("");
            }
            else if(i==2){
                ChuyenManHinh cmh = new ChuyenManHinh(jPanel1);
                cmh.setView(new TrangChinh());
                KTTK.setTtk(jtfTTK.getText()); 
            }
            else if(i==3){
                jtfTTK.setText("");
                jpwMK.setText("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jbtDangNhapMouseClicked

    private void jbtThemTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtThemTKMouseClicked

        ThemTKJDialog themTK = new ThemTKJDialog(null, true);
        themTK.setTitle("Thêm tài khoản");
        themTK.setResizable(true);
        themTK.setLocationRelativeTo(null);
        themTK.setVisible(true);
        if(themTK.kq == 1){
            ChuyenManHinh cmh = new ChuyenManHinh(jPanel1);
            cmh.setView(new theme());
            KTTK.setTtk(themTK.ttk);
        }
    }//GEN-LAST:event_jbtThemTKMouseClicked

    private void jbtDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDangNhapActionPerformed
        // TODO add your handling code here:
        try {
            KiemTraDN dn = null;
            String mk = new String(jpwMK.getPassword());
            int i=dn.DangNhapTK(jtfTTK.getText(),mk);
            if(i==1){
                jpwMK.setText("");
            }
            else if(i==2){
                ChuyenManHinh cmh = new ChuyenManHinh(jPanel1);
                cmh.setView(new TrangChinh());
                KTTK.setTtk(jtfTTK.getText()); 
//                MainScreen.jlbTaiKhoan.setText(KTTK.setTtk());
                
            }
            else if(i==3){
                jtfTTK.setText("");
                jpwMK.setText("");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
        
    }//GEN-LAST:event_jbtDangNhapActionPerformed

    private void jbtThemTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtThemTKActionPerformed
        // TODO add your handling code here:
        ThemTKJDialog themTK = new ThemTKJDialog(null, true);
        themTK.setTitle("Thêm tài khoản");
        themTK.setResizable(true);
        themTK.setLocationRelativeTo(null);
        themTK.setVisible(true);
        if(themTK.kq == 1){
            ChuyenManHinh cmh = new ChuyenManHinh(jPanel1);
            cmh.setView(new theme());
            KTTK.setTtk(themTK.ttk);
        }
    }//GEN-LAST:event_jbtThemTKActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbtDangNhap;
    private javax.swing.JButton jbtThemTK;
    private javax.swing.JPanel jpnMatKhau;
    private javax.swing.JPanel jpnTaiKhoan;
    private javax.swing.JPasswordField jpwMK;
    private javax.swing.JTextField jtfTTK;
    // End of variables declaration//GEN-END:variables


}

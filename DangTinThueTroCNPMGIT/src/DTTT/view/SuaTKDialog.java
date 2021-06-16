package DTTT.view;

import DTTT.dao.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DTTT.dao.KTTK;
import DTTT.model.ChuanHoa;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SuaTKDialog extends javax.swing.JDialog {

  
    public SuaTKDialog(java.awt.Frame parent, boolean modal){
        super(parent, modal);
        initComponents();
        
        try {
            hienThiTT();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void hienThiTT() throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM Tai_Khoan WHERE TaiKhoan = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, KTTK.getTtk());
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            jlbTTK.setText(rs.getString("TaiKhoan"));
            jtfHoTen.setText(rs.getString("HoTen"));
            jtfSDT.setText(rs.getString("SDT"));
            jtfMK.setText(rs.getString("MatKhau").trim());
        }
        rs.close();
        ps.close();
    }
    
    
    public boolean ktTT(){
        if(jtfHoTen.getText().length() == 0 || jtfSDT.getText().length() == 0 || jtfMK.getText().length() ==0){
            if(jtfHoTen.getText().length() == 0){
                JOptionPane.showMessageDialog(null,"Không để trống mục 'Họ tên'!");
            }
            else if(jtfSDT.getText().length() == 0){
                JOptionPane.showMessageDialog(null,"Không để trống mục 'Số điện thoại'!");
            }
            else if (!ChuanHoa.ChuanHoaSDT(jtfSDT.getText())) {
                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!");
                jtfSDT.setText("");
            }
            else if(jtfMK.getText().length() == 0){
                JOptionPane.showMessageDialog(null,"Không để trống mục 'Mật khẩu'!");
            }
            return false;
        }
        else 
            return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfHoTen = new javax.swing.JTextField();
        jtfMK = new javax.swing.JTextField();
        jtfSDT = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jbtQuayLai = new javax.swing.JButton();
        jbtLuu = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jlbTTK = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Họ tên:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Số điện thoại:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Mật khẩu:");

        jtfHoTen.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jtfHoTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfHoTenKeyTyped(evt);
            }
        });

        jtfMK.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jtfMK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfMKKeyTyped(evt);
            }
        });

        jtfSDT.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jtfSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfSDTKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(jtfSDT)
                    .addComponent(jtfMK))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfMK, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        jbtQuayLai.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jbtQuayLai.setForeground(new java.awt.Color(102, 102, 255));
        jbtQuayLai.setText("Quay lại");
        jbtQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtQuayLaiActionPerformed(evt);
            }
        });

        jbtLuu.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jbtLuu.setForeground(new java.awt.Color(102, 102, 255));
        jbtLuu.setText("Lưu thay đổi");
        jbtLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLuuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jbtQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(jbtLuu)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        jlbTTK.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jlbTTK.setForeground(new java.awt.Color(153, 0, 204));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Tài khoản:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jlbTTK, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jlbTTK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jLabel4.setBackground(new java.awt.Color(255, 204, 204));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DTTT/images/CS.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLuuActionPerformed
        if(ktTT() == true){
            try {
                Connection conn = DBConnect.getConnection();
                String sql = "UPDATE Tai_Khoan SET HoTen = ?, SDT = ?, MatKhau = ?  WHERE TaiKhoan = ?";
                PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
                ps.setString(1, jtfHoTen.getText());
                ps.setString(2, jtfSDT.getText());
                ps.setString(3, jtfMK.getText());
                ps.setString(4, KTTK.getTtk());
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(SuaTKDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null,"Đã lưu thay đổi!");
            this.dispose();
        }
    }//GEN-LAST:event_jbtLuuActionPerformed

    private void jtfMKKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfMKKeyTyped
        if(jtfMK.getText().length() >= 10){
            JOptionPane.showMessageDialog(null, "Mật khẩu tối đa 10 kí tự!");
            evt.consume();
        }
    }//GEN-LAST:event_jtfMKKeyTyped

    private void jtfSDTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSDTKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
        if(jtfSDT.getText().length() >= 10){
            evt.consume();
        }
    }//GEN-LAST:event_jtfSDTKeyTyped

    private void jtfHoTenKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfHoTenKeyTyped
        char c = evt.getKeyChar();
        if (c != ' ') {
            if (!Character.isLetter(c)) {
                evt.consume();
            }
        }

        if (jtfHoTen.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_jtfHoTenKeyTyped

    private void jbtQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtQuayLaiActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtQuayLaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbtLuu;
    private javax.swing.JButton jbtQuayLai;
    private javax.swing.JLabel jlbTTK;
    private javax.swing.JTextField jtfHoTen;
    private javax.swing.JTextField jtfMK;
    private javax.swing.JTextField jtfSDT;
    // End of variables declaration//GEN-END:variables
}

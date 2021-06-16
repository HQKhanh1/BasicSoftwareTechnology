package DTTT.view;


import DTTT.model.Anh;
import DTTT.model.ChuanHoa;
import DTTT.model.ThongTinPhong;
import DTTT.service.AnhService;
import DTTT.service.AnhServiceImpl;
import DTTT.service.ThongTinPhongService;
import DTTT.service.ThongTinPhongServiceImpl;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 *
 * @author Admin
 */


public class HinhPhong extends javax.swing.JFrame {

    byte[] hinh;
    List<byte[]> ds;
    int soLuong,dem;

     public HinhPhong(List<byte[]> dsHinhanh) {
//         System.out.println(dsHinhanh);// hình bị null ở đây
        this.ds = dsHinhanh;
        soLuong = dsHinhanh.size()-1;
        if(!ds.isEmpty()){
            this.hinh = ds.get(0);
            dem = 0;
        }
        else 
            dem = soLuong;
    
        initComponents();
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        hienThiHinh(hinh);

    }
    
    public void hienThiHinh(byte[] hinh){
        if(hinh != null ){
            ImageIcon img = new ImageIcon(new ImageIcon(hinh).getImage().getScaledInstance(jlbHinhPhong.getWidth(), jlbHinhPhong.getHeight(), Image.SCALE_SMOOTH));
            jlbHinhPhong.setIcon(img);
            hienThiSL();
        }
        else
            jlbHinhPhong.setIcon(null);
    }
    private void hienThiSL(){
        if(soLuong>=0){
            String s = String.valueOf(dem+1) + "/" + String.valueOf(soLuong+1);
            jlbSL.setText(s);
        }
    }

     public List<byte[]> layDSHinh(){
        return ds;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Lui = new javax.swing.JButton();
        jlbHinhPhong = new javax.swing.JLabel();
        jlbSL = new javax.swing.JLabel();
        Tien = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Lui.setBackground(new java.awt.Color(255, 255, 255));
        Lui.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        Lui.setText("<");
        Lui.setBorder(null);
        Lui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LuiMouseClicked(evt);
            }
        });

        jlbHinhPhong.setBackground(new java.awt.Color(255, 255, 255));
        jlbHinhPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbHinhPhongMouseClicked(evt);
            }
        });

        jlbSL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbSL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Tien.setBackground(new java.awt.Color(255, 255, 255));
        Tien.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        Tien.setText(">");
        Tien.setBorder(null);
        Tien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TienMouseClicked(evt);
            }
        });
        Tien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Lui)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbHinhPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tien))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jlbSL, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(342, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlbHinhPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(Lui, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(Tien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbSL, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LuiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LuiMouseClicked
        if(soLuong>=0){
            dem--;
            if(dem<0)
                dem = soLuong;
            if(!ds.isEmpty())
                hienThiHinh(ds.get(dem));
        }
        
        
    }//GEN-LAST:event_LuiMouseClicked

    private void TienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TienMouseClicked
        
        if(soLuong>=0){
            dem++;
           if(dem>soLuong)
                dem = 0;
           if(!ds.isEmpty())
                hienThiHinh(ds.get(dem));
        }


    }//GEN-LAST:event_TienMouseClicked
   
    private void jlbHinhPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbHinhPhongMouseClicked
        this.dispose();
    }//GEN-LAST:event_jlbHinhPhongMouseClicked

    private void TienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TienActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Lui;
    private javax.swing.JButton Tien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlbHinhPhong;
    private javax.swing.JLabel jlbSL;
    // End of variables declaration//GEN-END:variables


}

package DTTT.view;

import DTTT.dao.DBConnect;
import DTTT.dao.ThongTinDB;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Admin
 */
public class Hinh extends javax.swing.JFrame {

    byte[] hinh;
    List<byte[]> ds;
    int soLuong,dem;

     public Hinh(List<byte[]> dsHinh) {
         System.out.println(dsHinh);
        this.ds = dsHinh;
        soLuong = dsHinh.size()-1;
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
    
    private void hienThiHinh(byte[] hinh){
        if(hinh != null ){
            ImageIcon img = new ImageIcon(new ImageIcon(hinh).getImage().getScaledInstance(jlbHinh.getWidth(), jlbHinh.getHeight(), Image.SCALE_SMOOTH));
            jlbHinh.setIcon(img);
            hienThiSL();
        }
        else
            jlbHinh.setIcon(null);
    }
    private void hienThiSL(){
        if(soLuong>=0){
            String s = String.valueOf(dem+1) + "/" + String.valueOf(soLuong+1);
            jlbSL.setText(s);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lui = new javax.swing.JButton();
        Tien = new javax.swing.JButton();
        jlbHinh = new javax.swing.JLabel();
        jlbSL = new javax.swing.JLabel();
        jbtThem = new javax.swing.JButton();
        jbtXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Lui.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Lui.setText("<");
        Lui.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LuiMouseClicked(evt);
            }
        });

        Tien.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Tien.setText(">");
        Tien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TienMouseClicked(evt);
            }
        });

        jlbHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbHinhMouseClicked(evt);
            }
        });

        jlbSL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbSL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jbtThem.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtThem.setText("Thêm hình");
        jbtThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtThemMouseClicked(evt);
            }
        });

        jbtXoa.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtXoa.setText("Xóa hình");
        jbtXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtXoaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Lui)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Tien))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jbtXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbSL, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165)
                .addComponent(jbtThem)
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lui)
                    .addComponent(Tien))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlbHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbSL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtXoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtThem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
    public List<byte[]> layDSHinh(){
        return ds;
    }
    private void jlbHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbHinhMouseClicked
        this.dispose();
    }//GEN-LAST:event_jlbHinhMouseClicked

    private void jbtXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtXoaMouseClicked
        if(soLuong>=0){
            int kq = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa hình ảnh này?","",JOptionPane.YES_NO_OPTION);
            if(kq == JOptionPane.YES_OPTION){
                if(soLuong>=0)
                    ds.remove(dem);
                soLuong--;
            
                if(soLuong<0){
                    jlbHinh.setIcon(null);
                    jlbSL.setText("");
                }
                
                dem--;
                if(dem<0)
                    dem = soLuong;
                if(soLuong>=0 && dem>=0)
                    hienThiHinh(ds.get(dem));
            
            }
            
        }
    }//GEN-LAST:event_jbtXoaMouseClicked

    private void jbtThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtThemMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and JPG images", "png", "jpg");
        chooser.addChoosableFileFilter(filter);
        int returnValue = chooser.showOpenDialog(this);
        if(returnValue==JFileChooser.APPROVE_OPTION){
            File f = chooser.getSelectedFile();
            String filename = f.getAbsolutePath();
            try{
                File image = new File(filename);
                FileInputStream fis = new FileInputStream(image);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for(int i; (i = fis.read(buf)) != -1;){
                    bos.write(buf, 0, i);
                }   
                hinh = bos.toByteArray();
            }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
            ds.add(hinh);soLuong++;dem=soLuong;
            hienThiHinh(hinh);
        }
    }//GEN-LAST:event_jbtThemMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Lui;
    private javax.swing.JButton Tien;
    private javax.swing.JButton jbtThem;
    private javax.swing.JButton jbtXoa;
    private javax.swing.JLabel jlbHinh;
    private javax.swing.JLabel jlbSL;
    // End of variables declaration//GEN-END:variables
}

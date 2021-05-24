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
//    private AnhService anhService = new AnhServiceImpl();
//    private ThongTinPhongService thongTinPhongService = new ThongTinPhongServiceImpl();
//    int hinhIndex = 0;
//    ThongTinPhong phong = null;
    byte[] hinh;
    List<byte[]> ds;
    int soLuong,dem;
//    List<Anh> listAnh = anhService.getList();
//    List<ThongTinPhong> listPhong = thongTinPhongService.getList();
//    Anh anh = null;
    
    
//     public HinhPhong(byte[] Hinh){
//     
//        initComponents();
//        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//        this.setResizable(false);
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);
//        hienThiHinh(Hinh);
//         
//     }
     
     
//     public HinhPhong(List<Anh> listAnh, String MaTinTin){
////        this.anhService = new AnhServiceImpl();
////        this.thongTinPhongService = new ThongTinPhongServiceImpl();
//        initComponents();
//        
//        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//        this.setResizable(false);
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);
//        String MaTinAnh = null;
//        
//         for (int i = 0; i < listAnh.size(); i++) { 
//             MaTinAnh = ChuanHoa.chuanHoaMa(listAnh.get(i).getMaTin());
//             
//                 if(MaTinAnh.equals(MaTinTin)){
//                     hinhIndex = i;
//                 }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
//         }
//            hinh = listAnh.get(hinhIndex).getHinhAnh();
//            
//        hienThiHinh(hinh);
//         
//     }
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
            System.out.println("hienthiHinh");
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

        Lui = new javax.swing.JButton();
        Tien = new javax.swing.JButton();
        jlbHinhPhong = new javax.swing.JLabel();
        jlbSL = new javax.swing.JLabel();

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
        Tien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TienActionPerformed(evt);
            }
        });

        jlbHinhPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbHinhPhongMouseClicked(evt);
            }
        });

        jlbSL.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbSL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Lui)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbHinhPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Tien))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(84, 364, Short.MAX_VALUE)
                .addComponent(jlbSL, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(365, 365, 365))
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
                .addComponent(jlbHinhPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jlbSL, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
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
//             hienThiHinh(listAnh.get(hinhIndex-1).getHinhAnh());
        
        
    }//GEN-LAST:event_LuiMouseClicked

    private void TienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TienMouseClicked
        
        if(soLuong>=0){
            dem++;
           if(dem>soLuong)
                dem = 0;
           if(!ds.isEmpty())
                hienThiHinh(ds.get(dem));
        }

//                hienThiHinh(listAnh.get(hinhIndex+2).getHinhAnh());
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
    private javax.swing.JLabel jlbHinhPhong;
    private javax.swing.JLabel jlbSL;
    // End of variables declaration//GEN-END:variables


}

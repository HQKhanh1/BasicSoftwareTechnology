package DTTT.view;
import DTTT.bean.DanhMuc;
import DTTT.controller.ChuyenManHinh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; 
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainScreen extends javax.swing.JFrame {

    /**
     * Creates new form MainScreen
     */
    public MainScreen() throws IOException { 
        initComponents();       
        this.setVisible(true);
        this.setBounds(0,0,1520,800);
        setTitle("DỊCH VỤ ĐĂNG TIN PHÒNG TRỌ!");
        ChuyenManHinh controller = new ChuyenManHinh(jpnView);
        controller.setView();
        
        List<DanhMuc> listItem=new ArrayList<>();
        
        listItem.add(new DanhMuc("CapNhat",CapNhat_Panel,CapNhat_Label));
        listItem.add(new DanhMuc("DangNhap",DangNhap_Panel,DangNhap_Label));
        listItem.add(new DanhMuc("TrangChinh",TrangChinh_Panel,TrangChinh_Label));
        
        controller.setEvent(listItem);
    }
    public final void initUI() {
        setSize(1920, 1080);
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnMenu = new javax.swing.JPanel();
        DatLichHen_Panel = new javax.swing.JPanel();
        iconTK = new javax.swing.JLabel();
        TrangChinh_Panel = new javax.swing.JPanel();
        TrangChinh_Label = new javax.swing.JLabel();
        DangNhap_Panel = new javax.swing.JPanel();
        DangNhap_Label = new javax.swing.JLabel();
        CapNhat_Panel = new javax.swing.JPanel();
        CapNhat_Label = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 53, 128));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 720));

        jLabel1.setBackground(new java.awt.Color(0, 53, 128));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DTTT/images/baseline_store_mall_directory_white_24dp.png"))); // NOI18N
        jLabel1.setText("Phần mềm đăng tin phòng trọ");
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(1060, 56));

        jpnMenu.setBackground(new java.awt.Color(0, 53, 128));
        jpnMenu.setPreferredSize(new java.awt.Dimension(1080, 667));

        DatLichHen_Panel.setBackground(new java.awt.Color(0, 54, 128));
        DatLichHen_Panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DatLichHen_Panel.setPreferredSize(new java.awt.Dimension(1060, 80));

        iconTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DTTT/images/baseline_manage_accounts_black_24dp.png"))); // NOI18N

        TrangChinh_Panel.setBackground(new java.awt.Color(0, 54, 128));
        TrangChinh_Panel.setPreferredSize(new java.awt.Dimension(182, 80));

        TrangChinh_Label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TrangChinh_Label.setForeground(new java.awt.Color(255, 255, 255));
        TrangChinh_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TrangChinh_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DTTT/images/baseline_home_white_24dp.png"))); // NOI18N
        TrangChinh_Label.setText("Trang Chủ");
        TrangChinh_Label.setPreferredSize(new java.awt.Dimension(182, 80));

        javax.swing.GroupLayout TrangChinh_PanelLayout = new javax.swing.GroupLayout(TrangChinh_Panel);
        TrangChinh_Panel.setLayout(TrangChinh_PanelLayout);
        TrangChinh_PanelLayout.setHorizontalGroup(
            TrangChinh_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrangChinh_PanelLayout.createSequentialGroup()
                .addComponent(TrangChinh_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        TrangChinh_PanelLayout.setVerticalGroup(
            TrangChinh_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TrangChinh_PanelLayout.createSequentialGroup()
                .addComponent(TrangChinh_Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        DangNhap_Panel.setBackground(new java.awt.Color(0, 54, 128));
        DangNhap_Panel.setPreferredSize(new java.awt.Dimension(279, 80));

        DangNhap_Label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        DangNhap_Label.setForeground(new java.awt.Color(255, 255, 255));
        DangNhap_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DangNhap_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DTTT/images/baseline_switch_account_white_24dp.png"))); // NOI18N
        DangNhap_Label.setText("Đăng Nhập/Đăng Xuất");
        DangNhap_Label.setPreferredSize(new java.awt.Dimension(279, 80));

        javax.swing.GroupLayout DangNhap_PanelLayout = new javax.swing.GroupLayout(DangNhap_Panel);
        DangNhap_Panel.setLayout(DangNhap_PanelLayout);
        DangNhap_PanelLayout.setHorizontalGroup(
            DangNhap_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DangNhap_Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        DangNhap_PanelLayout.setVerticalGroup(
            DangNhap_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DangNhap_Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        CapNhat_Panel.setBackground(new java.awt.Color(0, 54, 128));
        CapNhat_Panel.setPreferredSize(new java.awt.Dimension(244, 80));

        CapNhat_Label.setBackground(new java.awt.Color(0, 102, 102));
        CapNhat_Label.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        CapNhat_Label.setForeground(new java.awt.Color(255, 255, 255));
        CapNhat_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CapNhat_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/DTTT/images/baseline_brightness_high_white_24dp.png"))); // NOI18N
        CapNhat_Label.setText("Cập nhật thông tin");
        CapNhat_Label.setPreferredSize(new java.awt.Dimension(244, 80));

        javax.swing.GroupLayout CapNhat_PanelLayout = new javax.swing.GroupLayout(CapNhat_Panel);
        CapNhat_Panel.setLayout(CapNhat_PanelLayout);
        CapNhat_PanelLayout.setHorizontalGroup(
            CapNhat_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CapNhat_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CapNhat_Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CapNhat_PanelLayout.setVerticalGroup(
            CapNhat_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CapNhat_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CapNhat_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout DatLichHen_PanelLayout = new javax.swing.GroupLayout(DatLichHen_Panel);
        DatLichHen_Panel.setLayout(DatLichHen_PanelLayout);
        DatLichHen_PanelLayout.setHorizontalGroup(
            DatLichHen_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatLichHen_PanelLayout.createSequentialGroup()
                .addComponent(iconTK, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addGap(177, 177, 177)
                .addComponent(CapNhat_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TrangChinh_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DangNhap_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        DatLichHen_PanelLayout.setVerticalGroup(
            DatLichHen_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CapNhat_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DatLichHen_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(TrangChinh_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(DangNhap_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(iconTK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnView.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DatLichHen_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jpnView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(DatLichHen_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CapNhat_Label;
    private javax.swing.JPanel CapNhat_Panel;
    private javax.swing.JLabel DangNhap_Label;
    private javax.swing.JPanel DangNhap_Panel;
    private javax.swing.JPanel DatLichHen_Panel;
    private javax.swing.JLabel TrangChinh_Label;
    private javax.swing.JPanel TrangChinh_Panel;
    private javax.swing.JLabel iconTK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}

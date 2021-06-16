/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.view;

import DTTT.controller.ChuyenManHinh;
import DTTT.dao.DBConnect;
import DTTT.dao.DatLicHenImpl;
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
import DTTT.model.Anh;
import DTTT.model.LoaiPhong;
import DTTT.model.QuanHuyen;
import DTTT.model.ThanhPho;
import DTTT.model.XaPhuong;
import DTTT.service.AnhService;
import DTTT.service.ThanhPhoService;
import DTTT.service.ThongTinPhongService;
import DTTT.service.ThongTinTinService;
import DTTT.utility.ClassTableModel;
import DTTT.utility.MultiLineTableCellRenderer;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author Admin
 */
public class HienThiLichHen extends javax.swing.JPanel {
    ThongTinPhong tinphong = new ThongTinPhong();
    PhongJDialog_LichHen jdialog;
    LoaiPhong lp = new LoaiPhong();
    // nhan lich hen check = -1 ----- nhan lich nguoi hen check = 1
    int check_buton = 0;
    public HienThiLichHen() throws SQLException {
        
        initComponents();
        // các thao tác với bảng 
        
        jTblLichHen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // getClickCoung = 2 => nhấp đúp vào
                if (e.getClickCount() == 2 && jTblLichHen.getSelectedRow() != -1) {
                    
                    try {
                                
                        
                        // Lấy mã lịch hẹn ở hàng được chọn và ở cột 0
                        int selectedRowIndex = jTblLichHen.getSelectedRow();
                        String MaLichHen = ((String)jTblLichHen.getValueAt(selectedRowIndex, 0)) ;
                        selectedRowIndex = jTblLichHen.convertRowIndexToModel(selectedRowIndex);
                        String maTinTin = DatLicHenImpl.layMaTinTrongMaLichHen(MaLichHen);
                        //lấy tiêu đề ở theo ma lich hen
                        String TieuDe = DatLicHenImpl.layTieuDeTrongTin(maTinTin);
                        
                        int loaiPhongIndex = 0;
                        int phongIndex = 0;
                        tinphong = DatLicHenImpl.themPhong(maTinTin);
                        String maLoaiPhong = DatLicHenImpl.layMaLoaiPhong(maTinTin);
                        lp = DatLicHenImpl.themLoaiPhong(maLoaiPhong);

                        Object[] options = {"Xóa lịch hẹn này","Hiển thị thông tin phòng", "Quay lại"};
			int n = JOptionPane.showOptionDialog(jPanel1,"",
                                "Lựa chọn của bạn",
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                options,
                                options[2]);
                        if(n == JOptionPane.YES_OPTION){
                            if(check_buton == -1){
                                int xoa = JOptionPane.showConfirmDialog(jPanel1, "Bạn có chắn chắn xóa không?", null, 0);
                                if(xoa == JOptionPane.YES_OPTION){
                                    DatLicHenImpl.xoaLichHen(MaLichHen);

                                    DefaultTableModel model = new DefaultTableModel();
                                    model = (DefaultTableModel) jTblLichHen.getModel();   
                                    int array[] = jTblLichHen.getSelectedRows();
                                    for (int i = 0; i < array.length; i++) {
                                        model.removeRow(array[i]);
                                    }   
                                }else if(xoa == JOptionPane.NO_OPTION){

                                }
                            }else if(check_buton == 1){
                                JOptionPane.showMessageDialog(jPanel1, "Không thể xóa lịch hẹn người dùng hẹn bạn!");
                            }
                        }
                        if(n == JOptionPane.NO_OPTION){
                            jdialog = new PhongJDialog_LichHen(tinphong,lp);
                            // set thông số cho jdialog
                                jdialog.setTitle(TieuDe);
                                jdialog.setVisible(false);
                                jdialog.setBounds(90, 90, 800, 490);
                                jdialog.setLocationRelativeTo(null);
                                jdialog.setVisible(true);
                        }
                        if(n == JOptionPane.CANCEL_OPTION){

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(HienThiLichHen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        jbtnLichBanHen.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    // TODO add your handling code here:
                    jbtnLichBanHen.setVisible(true);
                    showLichHenCuaBan();
                    check_buton = -1;
                } catch (SQLException ex) {
                    Logger.getLogger(HienThiLichHen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jbtnLichNguoiHenBan.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
            // TODO add your handling code here:
                    jbtnLichNguoiHenBan.setVisible(true);   
                    showLichHen();
                    check_buton = 1;
                } catch (SQLException ex) {
                    Logger.getLogger(HienThiLichHen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public HienThiLichHen(int check) throws SQLException{
        initComponents();
        if(check == -1){
            jbtnLichBanHen.setVisible(true);
            showLichHenCuaBan();
        }
        if(check == 1){
            jbtnLichNguoiHenBan.setVisible(true);   
            showLichHen();
        }
    }
    private void showLichHen() throws SQLException{
        jTblLichHen.removeAll();
        String[] arr = {"Mã lịch hẹn","Tên người hẹn","SĐT người hẹn", "Địa chỉ hẹn", "Thời gian hẹn"};
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
                        vt.add(tenNguoiHen);
                        vt.add(sdtNguoiHen);
                        vt.add(diaChiNguoiHen);
                        vt.add(thoiGianHen);
                        model.addRow(vt);
            }
        }
        jTblLichHen.setModel(model);
        jTblLichHen.setEnabled(true);
        //Thiết kế table
        jTblLichHen.setOpaque(true);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer testRenderer = new DefaultTableCellRenderer();
        
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        testRenderer.setHorizontalAlignment(JLabel.HEIGHT);

        MultiLineTableCellRenderer renderer = new MultiLineTableCellRenderer();
        jTblLichHen.setDefaultRenderer(String[].class, renderer);
        //Cột mã lịch hẹn
        jTblLichHen.getColumn("Mã lịch hẹn").setCellRenderer(centerRenderer);
        jTblLichHen.getColumnModel().getColumn(0).setMaxWidth(150);
        jTblLichHen.getColumnModel().getColumn(0).setMinWidth(150);
        //Cột Tên người đã hẹn
        jTblLichHen.getColumn("Tên người hẹn").setCellRenderer(centerRenderer);
        jTblLichHen.getColumnModel().getColumn(1).setMaxWidth(400);
        jTblLichHen.getColumnModel().getColumn(1).setMinWidth(400);
        //Cột số điện thoại
        jTblLichHen.getColumn("SĐT người hẹn").setCellRenderer(centerRenderer);
        jTblLichHen.getColumnModel().getColumn(2).setMaxWidth(150);
        jTblLichHen.getColumnModel().getColumn(2).setMinWidth(150);
        //Cột Địa chỉ hẹn
        jTblLichHen.getColumn("Địa chỉ hẹn").setCellRenderer(centerRenderer);
        jTblLichHen.getColumnModel().getColumn(3).setMaxWidth(650);
        jTblLichHen.getColumnModel().getColumn(3).setMinWidth(650);
        //Cột thời gian
        jTblLichHen.getColumn("Thời gian hẹn").setCellRenderer(centerRenderer);
    }
    private void showLichHenCuaBan() throws SQLException{
        jTblLichHen.removeAll();
        String[] arr = {"Mã lịch hẹn","Tên người đã hẹn","SĐT người đã hẹn", "Địa chỉ hẹn", "Thời gian hẹn"};
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
                        vt.add(tenNguoiHen);
                        vt.add(sdtNguoiHen);
                        vt.add(diaChiNguoiHen);
                        vt.add(thoiGianHen);
                        model.addRow(vt);
            }
        }
        jTblLichHen.setModel(model);
        jTblLichHen.setEnabled(true);
        //thiet ke table
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer testRenderer = new DefaultTableCellRenderer();
        
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        testRenderer.setHorizontalAlignment(JLabel.HEIGHT);

        MultiLineTableCellRenderer renderer = new MultiLineTableCellRenderer();
        jTblLichHen.setDefaultRenderer(String[].class, renderer);
        
        //Cột mã lịch hẹn
        jTblLichHen.getColumn("Mã lịch hẹn").setCellRenderer(centerRenderer);
        jTblLichHen.getColumnModel().getColumn(0).setMaxWidth(150);
        jTblLichHen.getColumnModel().getColumn(0).setMinWidth(150);
        //Cột Tên người đã hẹn
        jTblLichHen.getColumn("Tên người đã hẹn").setCellRenderer(centerRenderer);
        jTblLichHen.getColumnModel().getColumn(1).setMaxWidth(400);
        jTblLichHen.getColumnModel().getColumn(1).setMinWidth(400);
        //Cột số điện thoại
        jTblLichHen.getColumn("SĐT người đã hẹn").setCellRenderer(centerRenderer);
        jTblLichHen.getColumnModel().getColumn(2).setMaxWidth(150);
        jTblLichHen.getColumnModel().getColumn(2).setMinWidth(150);
        //Cột Địa chỉ hẹn
        jTblLichHen.getColumn("Địa chỉ hẹn").setCellRenderer(centerRenderer);
        jTblLichHen.getColumnModel().getColumn(3).setMaxWidth(650);
        jTblLichHen.getColumnModel().getColumn(3).setMinWidth(650);
        //Cột thời gian
        jTblLichHen.getColumn("Thời gian hẹn").setCellRenderer(centerRenderer);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblLichHen = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jbtnLichBanHen = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jbtnLichNguoiHenBan = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(960, 640));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jTblLichHen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                " ", "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblLichHen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTblLichHen.setDoubleBuffered(true);
        jTblLichHen.setDragEnabled(true);
        jTblLichHen.setFocusable(false);
        jTblLichHen.setGridColor(new java.awt.Color(51, 51, 51));
        jTblLichHen.setOpaque(false);
        jTblLichHen.setRowHeight(24);
        jTblLichHen.setRowMargin(2);
        jTblLichHen.setShowGrid(true);
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

        jbtnLichBanHen.setBackground(new java.awt.Color(0, 51, 153));
        jbtnLichBanHen.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnLichBanHen.setForeground(new java.awt.Color(255, 255, 255));
        jbtnLichBanHen.setText("Lịch bạn đã hẹn");
        jbtnLichBanHen.setBorder(null);
        jbtnLichBanHen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jbtnLichBanHenFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jbtnLichBanHenFocusLost(evt);
            }
        });
        jbtnLichBanHen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtnLichBanHenMousePressed(evt);
            }
        });
        jbtnLichBanHen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLichBanHenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnLichBanHen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnLichBanHen, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));

        jbtnLichNguoiHenBan.setBackground(new java.awt.Color(0, 51, 153));
        jbtnLichNguoiHenBan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jbtnLichNguoiHenBan.setForeground(new java.awt.Color(255, 255, 255));
        jbtnLichNguoiHenBan.setText("Lịch người dùng hẹn bạn");
        jbtnLichNguoiHenBan.setBorder(null);
        jbtnLichNguoiHenBan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jbtnLichNguoiHenBanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jbtnLichNguoiHenBanFocusLost(evt);
            }
        });
        jbtnLichNguoiHenBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtnLichNguoiHenBanMousePressed(evt);
            }
        });
        jbtnLichNguoiHenBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLichNguoiHenBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnLichNguoiHenBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnLichNguoiHenBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jbtnLichBanHenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLichBanHenActionPerformed
       
    }//GEN-LAST:event_jbtnLichBanHenActionPerformed

    private void jbtnLichNguoiHenBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLichNguoiHenBanActionPerformed
        
    }//GEN-LAST:event_jbtnLichNguoiHenBanActionPerformed

    private void jbtnLichBanHenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnLichBanHenMousePressed
        // TODO add your handling code here: 
        
    }//GEN-LAST:event_jbtnLichBanHenMousePressed

    private void jbtnLichNguoiHenBanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnLichNguoiHenBanMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jbtnLichNguoiHenBanMousePressed

    private void jbtnLichBanHenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jbtnLichBanHenFocusGained
        // TODO add your handling code here:
        System.setProperty ( "mauXam" , "0X999999" );
        System.setProperty ( "mauDen" , "0X000000" );
        jbtnLichBanHen.setOpaque(true);
        jbtnLichBanHen.setBackground(Color.getColor("mauXam"));
        jbtnLichBanHen.setForeground(Color.getColor("mauDen"));
    }//GEN-LAST:event_jbtnLichBanHenFocusGained

    private void jbtnLichBanHenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jbtnLichBanHenFocusLost
        // TODO add your handling code here:
        System.setProperty ( "mauXanh" , "0x003399" );
        System.setProperty ( "mauTrang" , "0XFFFFFF" );
        jbtnLichBanHen.setOpaque(true);
        jbtnLichBanHen.setBackground(Color.getColor("mauXanh"));
        jbtnLichBanHen.setForeground(Color.getColor("mauTrang"));
    }//GEN-LAST:event_jbtnLichBanHenFocusLost

    private void jbtnLichNguoiHenBanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jbtnLichNguoiHenBanFocusGained
        // TODO add your handling code here:
        System.setProperty ( "mauXam" , "0X999999" );
        System.setProperty ( "mauDen" , "0X000000" );
        jbtnLichNguoiHenBan.setOpaque(true);
        jbtnLichNguoiHenBan.setBackground(Color.getColor("mauXam"));
        jbtnLichNguoiHenBan.setForeground(Color.getColor("mauDen"));
    }//GEN-LAST:event_jbtnLichNguoiHenBanFocusGained

    private void jbtnLichNguoiHenBanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jbtnLichNguoiHenBanFocusLost
        // TODO add your handling code here:
        System.setProperty ( "mauXanh" , "0x003399" );
        System.setProperty ( "mauTrang" , "0XFFFFFF" );
        jbtnLichNguoiHenBan.setOpaque(true);
        jbtnLichNguoiHenBan.setBackground(Color.getColor("mauXanh"));
        jbtnLichNguoiHenBan.setForeground(Color.getColor("mauTrang"));
    }//GEN-LAST:event_jbtnLichNguoiHenBanFocusLost
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblLichHen;
    private javax.swing.JButton jbtnLichBanHen;
    private javax.swing.JButton jbtnLichNguoiHenBan;
    // End of variables declaration//GEN-END:variables

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.controller;

/**
 *
 * @author Snorlax
 */
import DTTT.dao.KTTK;
import DTTT.model.Anh;
import DTTT.model.ChuanHoa;
import DTTT.model.LoaiPhong;
import DTTT.model.MultiLineTableCellRenderer;
import DTTT.model.QuanHuyen;
import DTTT.model.ThanhPho;
import DTTT.model.ThongTinPhong;
import DTTT.model.ThongTinTin;
import DTTT.model.XaPhuong;
import DTTT.service.AnhService;
import DTTT.service.AnhServiceImpl;
import DTTT.service.ThanhPhoService;
import DTTT.service.ThanhPhoServiceImpl;
import DTTT.service.ThongTinPhongService;
import DTTT.service.ThongTinPhongServiceImpl;
import DTTT.service.ThongTinTinService;
import DTTT.service.ThongTinTinServiceImpl;
import DTTT.utility.ClassTableModel;
import DTTT.view.CapNhat;
import DTTT.view.CapNhatMenu;
import DTTT.view.PhongJDialog;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author TVD
 */
public class TinNhaTroController {
    String MaTinTin;
    ThongTinPhong tinphong = new ThongTinPhong();
    LoaiPhong lp = new LoaiPhong();
    Anh anh = new Anh();
    //Nút này chưa xài tới
    private JPanel jpnView;
//    private JButton btnAdd;
    private JTextField jtfSearch;
    private JLabel jlbAnh;
    
    PhongJDialog jdialog = new PhongJDialog(tinphong, lp);
//    PhongJDialog jdialog = new PhongJDialog(tinphong, lp);
//    PhongJFrame frame = new PhongJFrame(tinphong);
    private ClassTableModel classTableModel = null;
    
    private final String[] COLUMNS = {"Mã tin","Ảnh", "Tiêu đề",
        "Trạng thái", "SĐT", "Ngày đăng", "An ninh", "Phường\\xã", "Thông tin địa chỉ"};
    
    
    private ThongTinTinService thongTinService = null;
    private AnhService anhService = null;
    private TableRowSorter<TableModel> rowSorter = null;
    private ThongTinPhongService thongTinPhongService = null;
    private ThanhPhoService thanhPhoService = null;
//    private List<String> dsMaHinh = null;
    ThongTinTin tin = null;
    public TinNhaTroController(JPanel jpnView, JTextField jtfSearch) {
        this.jpnView = jpnView;
//        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.thongTinPhongService = new ThongTinPhongServiceImpl();
        this.classTableModel = new ClassTableModel();
        this.anhService = new AnhServiceImpl();
        this.thongTinService = new ThongTinTinServiceImpl();
//        this.xaPhuongService = new XaPhuongServiceImpl();
        this.thanhPhoService = new ThanhPhoServiceImpl();
    }

//    public TinNhaTroController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
//        this.jpnView = jpnView;
////        this.btnAdd = btnAdd;
////        this.jtfSearch = jtfSearch;
//
//        this.classTableModel = new ClassTableModel();
//
//        this.hocVienService = new ThongTinTinServiceImpl();
//    }
    
    
    
    public void setDataToTable() throws IOException {
        
        List<ThongTinTin> listItem = thongTinService.getList();
        List<Anh> listAnh = anhService.getList();
        List<ThongTinPhong> listPhong = thongTinPhongService.getList();
        List<XaPhuong> listXP = thanhPhoService.getXPList();
        List<ThanhPho> listTP = thanhPhoService.getTPList();
        List<QuanHuyen> listQH = thanhPhoService.getQHList();
        List<LoaiPhong> listLP = thongTinPhongService.getLPList();
        
        DefaultTableModel model = classTableModel.setTableThongTinTin(listLP ,listPhong,listQH ,listTP,listXP, listAnh, listItem, COLUMNS);
        
        JTable table = new JTable(model);
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    String MaTinTin = ChuanHoa.chuanHoaMa((String)table.getValueAt(selectedRowIndex, 0)) ;
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    String TieuDe = model.getValueAt(selectedRowIndex, 2).toString();
                    
                    int loaiPhongIndex = 0;
                    int phongIndex = 0;
                    String MaTinPhong = null;
                    String TenPhong = null;
                    

                    for (int i = 0; i < listItem.size(); i++) {

                        for( int j = 0; j < listPhong.size(); j++){
                            tinphong = listPhong.get(j);    
                            MaTinPhong = ChuanHoa.chuanHoaMa(tinphong.getMaTin());
                            if (MaTinTin.equals(MaTinPhong)){
                                phongIndex = j;
                            }         
                        }
                         
                                tinphong = listPhong.get(phongIndex); 
                                    
                        for( int k = 0; k < listLP.size(); k++  ){
                                lp = listLP.get(k);
                                if (tinphong.getMaLoaiPhong().equals(lp.getMaLoaiPhong())){
                                    loaiPhongIndex = k;
                                }   
                        } 
                        
                        lp = listLP.get(loaiPhongIndex);
                        
                        jdialog.setTinPhong(tinphong, lp); 
                        
                    }
                    
                    jdialog.setTitle(TieuDe);
                    jdialog.setVisible(false);
                    jdialog.setBounds(90, 90, 800, 490);
                    jdialog.setLocationRelativeTo(null);
                    jdialog.setVisible(true);

                    
//                    }
                }
            }
           
        
            
            
        });


        //Thiết kế 
        table.setFont(new Font("Arial",0,16) {
        });
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(200);
        table.setShowVerticalLines(true);
        table.setBackground(new Color(224, 236, 255));
        table.setSelectionBackground(new Color(255, 196, 125));
        table.setGridColor(new Color(230, 200, 29));
        
        table.validate();
        table.repaint();
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer testRenderer = new DefaultTableCellRenderer();
        
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        testRenderer.setHorizontalAlignment(JLabel.HEIGHT);

        
        
        //Cột mã tin
        table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.getColumn("Mã tin").setCellRenderer(rightRenderer);
        


    MultiLineTableCellRenderer renderer = new MultiLineTableCellRenderer();
//    table.setDefaultRenderer(String[].class, renderer);

 
    
//        //Cột hình ảnh
        table.getColumnModel().getColumn(1).setMaxWidth(200);
        table.getColumnModel().getColumn(1).setMinWidth(200);
//        
//        //Cột tiêu đề
//        table.getColumnModel().getColumn(2).setMaxWidth(80);
//        table.getColumn("Tiêu đề").setCellRenderer(centerRenderer);
//        
//
//        
//        //Cột trạng thái
//        table.getColumnModel().getColumn(4).setMaxWidth(70);
//        table.getColumn("Trạng thái").setCellRenderer(centerRenderer);
////
//        //Cột SĐT
//        table.getColumnModel().getColumn(4).setMaxWidth(100);
//        table.getColumnModel().getColumn(4).setMinWidth(90); 
//        table.getColumn("SĐT").setCellRenderer(centerRenderer);
////
//        
//        
////
//        //Cột ngày đăng
//        table.getColumnModel().getColumn(6).setMaxWidth(90);
//        table.getColumn("Ngày đăng").setCellRenderer(centerRenderer);
//        //Cột an ninh
//        
//        table.getColumnModel().getColumn(7).setMaxWidth(50);
//        table.getColumn("An ninh").setCellRenderer(rightRenderer);
//        
//        
////
////        //Cột diện tích
////        table.getColumn("Phường\\xã").setCellRenderer(centerRenderer);
////        table.getColumnModel().getColumn(9).setPreferredWidth(80);
////        
//
//        //Cột thông tin địa chỉ
//        table.getColumnModel().getColumn(9).setMaxWidth(160);
//        table.getColumnModel().getColumn(9).setMinWidth(160);
//        
//        //Cột tài khoản
//        table.getColumn("Tài khoản");
//        table.getColumnModel().getColumn(9).setMaxWidth(80);
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1800, 400));
        jpnView.removeAll();
        jpnView.setLayout(new CardLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();

    }
    
}

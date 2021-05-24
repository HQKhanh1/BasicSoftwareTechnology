package DTTT.controller;

import DTTT.view.theme;
import DTTT.bean.DanhMuc;
import DTTT.dao.KTTK;
import DTTT.view.CapNhatMenu;
import DTTT.view.DangNhap;
import DTTT.view.DatLichHen;
import DTTT.view.TK;
import DTTT.view.TrangChinh;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;




public class ChuyenManHinh {
    
    public ChuyenManHinh(){
        
    }
    
    private JPanel root,root1,node1;
    private String chon="theme";
    private List<DanhMuc> listItem=null;
    
    public ChuyenManHinh(JPanel jpnRoot){
        this.root = jpnRoot;
    }
    
    public void setView() {
       
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new theme());
        root.validate();
        root.repaint();
    }
    
    public void setView(JPanel jpn){

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(jpn, BorderLayout.CENTER);
        root.validate();
        root.repaint();
    }
    
    
    public void setEvent(List<DanhMuc> listItem){
        this.listItem=listItem;
        for(DanhMuc item:listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getLoai(), item.getJpn(), item.getJlb()));
        }
    }
    
    class LabelEvent implements MouseListener{
        
        private JPanel node;
        private JFrame jfr;
        private String loai;
        private JPanel jpnItem;
        private JLabel jlbItem;
        int thu;

        public LabelEvent(String loai, JPanel jpnItem, JLabel jlbItem) {
            this.loai = loai;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
      
        @Override
        public void mouseClicked(MouseEvent e) {
            switch(loai){
                case "TrangChinh":
                {
                    try {
                        node = new TrangChinh();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                }thu=1;
                break;
                

                case "CapNhat":
                    if(KTTK.getTtk().length()!=0){
                        node = new CapNhatMenu();
                        thu=1;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Bạn cần đăng nhập tài khoản cho chức năng này!");
                        thu=0;
                    }
                break;                
                case "DangNhap":                    
                    if(KTTK.getTtk().length()!=0){
                        int kq = JOptionPane.showConfirmDialog(null,"Bạn có muốn đăng xuất tài khoản '" + KTTK.getTtk() + "' không?","",JOptionPane.YES_NO_OPTION);
                        if(kq == JOptionPane.YES_OPTION){
                            KTTK.setTtk("");
                            node = new DangNhap();thu=1;
                            
                        }
                        else if(kq == JOptionPane.NO_OPTION)
                            thu=0;
                    }
                    else{
                        node = new DangNhap();thu=1;
                    }
                    node1 = new TK(KTTK.getTtk());                    
                   
                break;
               
                default: break;
            }
            if(thu==1){
                setView(node);
            }
            else{
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.validate();
               
            }
            setChangeBackground(loai);
        }


        @Override
        public void mousePressed(MouseEvent e) {
            chon=loai;
            jpnItem.setBackground(new Color(15,65,134));
            jlbItem.setBackground(new Color(15,65,134));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(15,65,134));
            jlbItem.setBackground(new Color(15,65,134));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!chon.equalsIgnoreCase(loai)){
                jpnItem.setBackground(new Color(0,54,128));
                jlbItem.setBackground(new Color(0,54,128));
            }
        }
        
    }
    
    private void setChangeBackground(String loai){
        for(DanhMuc item:listItem){
            if(item.getLoai().equalsIgnoreCase(loai)){
                item.getJpn().setBackground(new Color(15,65,134));
                item.getJlb().setBackground(new Color(15,65,134));
            }
            else{
                item.getJpn().setBackground(new Color(0,54,128));
                item.getJlb().setBackground(new Color(0,54,128));
            }
        }
    }
   
}

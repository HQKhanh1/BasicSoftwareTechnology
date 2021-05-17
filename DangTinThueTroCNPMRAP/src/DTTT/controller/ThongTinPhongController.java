/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.controller;

import DTTT.model.Anh;
import DTTT.model.LoaiPhong;
import DTTT.model.ThongTinPhong;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
/**
 *
 * @author Snorlax
 */
public class ThongTinPhongController {
    List<Anh> listAnh = null;
    byte[] HinhAnh;
//    List<LoaiPhong> listLP = null;
    private JTextField jtfGiaPhong,jtfMaTin,
            jtfDienTich,jtfSoPhong,jtfDieuHoa,jtfLoaiPhong;
    private JTextArea jtaMoTa;
    private JLabel jlbHinhAnh;
    private ThongTinPhong tinphong = null;
    private LoaiPhong lp = null;
    private String TenPhong;
    
  
    
    public ThongTinPhongController(JTextField jtfMaTin,JTextField jtfDienTich,JTextField jtfGiaPhong, JTextField jtfSoPhong, JTextField jtfDieuHoa, JTextField jtfLoaiPhong, JTextArea jtaMoTa,JLabel jlbHinhAnh) {
        
        this.jtfDienTich = jtfDienTich;
        this.jtfGiaPhong = jtfGiaPhong;
        this.jtfSoPhong = jtfSoPhong;
        this.jtfDieuHoa = jtfDieuHoa;
        this.jtfLoaiPhong = jtfLoaiPhong;
        this.jtaMoTa = jtaMoTa;
        this.jtfMaTin = jtfMaTin;
        this.jlbHinhAnh = jlbHinhAnh;
    }
    
    public ThongTinPhongController(JTextField jtfMaTin,JTextField jtfDienTich,JTextField jtfGiaPhong, JTextField jtfSoPhong, JTextField jtfDieuHoa, JTextField jtfLoaiPhong, JTextArea jtaMoTa) {
        this.jtfDienTich = jtfDienTich;
        this.jtfGiaPhong = jtfGiaPhong;
        this.jtfSoPhong = jtfSoPhong;
        this.jtfDieuHoa = jtfDieuHoa;
        this.jtfLoaiPhong = jtfLoaiPhong;
        this.jtaMoTa = jtaMoTa;
        this.jtfMaTin = jtfMaTin;
        
    }

    public void setView(LoaiPhong lp){
        this.lp = lp;
        jtfLoaiPhong.setText(lp.getTenLoaiPhong());
    }
    
    public void setTenPhong(String TenPhong){
        this.lp = lp;
        this.jtfLoaiPhong = jtfLoaiPhong;        
    }
    
   public void setView(ThongTinPhong tinphong){
        
        this.tinphong = tinphong;
        jtfDienTich.setText(tinphong.getDienTich());
        jtfGiaPhong.setText(tinphong.getGiaPhong());
        jtfSoPhong.setText(Integer.toString(tinphong.getSoPhong()));
        jtfDieuHoa.setText(tinphong.getDieuHoa());
        jtfLoaiPhong.setText(lp.getTenLoaiPhong());
        jtaMoTa.setText(tinphong.getMoTa());
        jtfMaTin.setText(tinphong.getMaTin());

    }
    
    public void setView(ThongTinPhong tinphong, LoaiPhong lp){
        
        this.tinphong = tinphong;
        jtfDienTich.setText(tinphong.getDienTich());
        jtfGiaPhong.setText(tinphong.getGiaPhong());
        jtfSoPhong.setText(Integer.toString(tinphong.getSoPhong()));
        jtfDieuHoa.setText(tinphong.getDieuHoa());
        jtfLoaiPhong.setText(lp.getTenLoaiPhong());
        jtaMoTa.setText(tinphong.getMoTa());
        jtfMaTin.setText(tinphong.getMaTin());
    }
    
    public void setView(ThongTinPhong tinphong, LoaiPhong lp, String MaTinTin){
        jtfMaTin.setText(tinphong.getMaTin());
        this.tinphong = tinphong;
        jtfDienTich.setText(tinphong.getDienTich());
        jtfGiaPhong.setText(tinphong.getGiaPhong());
        jtfSoPhong.setText(Integer.toString(tinphong.getSoPhong()));
        jtfDieuHoa.setText(tinphong.getDieuHoa());
        jtfLoaiPhong.setText(lp.getTenLoaiPhong());
        jtaMoTa.setText(tinphong.getMoTa());
        tinphong.getMaTin();
    }

    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }


}

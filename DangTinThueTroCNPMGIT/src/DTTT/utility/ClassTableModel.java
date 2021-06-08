
package DTTT.utility;

/**
 *
 * @author Snorlax
 */
import DTTT.dao.DBConnect;
import DTTT.model.ThongTinTin;
import DTTT.model.Anh;
import DTTT.model.ChuanHoa;
import DTTT.model.LoaiPhong;
import DTTT.model.QuanHuyen;
import DTTT.model.ThanhPho;
import DTTT.model.ThongTinPhong;
import DTTT.model.XaPhuong;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;




public class ClassTableModel {
    
    
    Anh hinhAnh = new Anh(); 
    String TenXa = null;
    String TenQH = null;
    String TenTP = null;
    XaPhuong xa = null;
    QuanHuyen qh = null;
    ThanhPho tp = null;
    String LoaiTP = null;
    String LoaiXa = null;
    String LoaiQH = null;
    String MaXa ="";
    String MaQH ="";
    String MaTP ="";
    int GiaPhong = 0;
    public DefaultTableModel setTableThongTinTin(List<LoaiPhong> listLP ,List<ThongTinPhong> listPhong,List<QuanHuyen> listQH,List<ThanhPho> listTP 
            ,List<XaPhuong> listXP,List<Anh> listAnh ,List<ThongTinTin> listItem
            , String[] listColumn) throws IOException, SQLException {
        
        int columns = listColumn.length;
        
        DefaultTableModel dtm = new DefaultTableModel() { 
            
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                
                if(columnIndex==1){
                    return ImageIcon.class; 
                }
                if(columnIndex == 4){
                    return String[].class;
                }
                else{
                    return Object.class;
                }
            }
        };

        
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;   
        
        for (int i = 0; i < listItem.size(); i++) {   
            
            ThongTinTin tin = listItem.get(i);  
            obj = new Object[columns];
            //Cột 1 hình ảnh
            Anh anh = null;
            String MaTinTin = ChuanHoa.chuanHoaMa(tin.getMaTin());
            ImageIcon icon = null;
            byte[] HinhAnh = null;
<<<<<<< HEAD
          
=======
            
//            String [] cars = { "Honda", "BMW", "Ford", "Mazda" };
>>>>>>> 4cc4a4b37526423418ca6f20d502249c8d954521
            for ( int p = 0; p < listAnh.size(); p++){
                anh = listAnh.get(p);
                String  MaTinAnh = ChuanHoa.chuanHoaMa(anh.getMaTin());
                if(MaTinTin.equals(MaTinAnh)){
                    
                    HinhAnh = anh.getHinhAnh();
                    break;
                }
            }
<<<<<<< HEAD
=======
            icon = new ImageIcon(new ImageIcon(HinhAnh).getImage().getScaledInstance(300, 200, Image.SCALE_AREA_AVERAGING));

            obj[1] = icon;

              //cột 9 Phường\xã
            String MaXaTin = ChuanHoa.chuanHoaMa(listItem.get(i).getMaXa());
           
>>>>>>> 4cc4a4b37526423418ca6f20d502249c8d954521
            
            icon = new ImageIcon(new ImageIcon(HinhAnh).getImage().getScaledInstance(300, 200, Image.SCALE_AREA_AVERAGING));

<<<<<<< HEAD
            obj[1] = icon;
            
              //cột 9 Phường\xã
//            String MaXaTin = ChuanHoa.chuanHoaMa(listItem.get(i).getMaXa());           
//            for (int j = 0; j < listXP.size(); j++) {
//                xa = listXP.get(j);
//                String MaXaXa = ChuanHoa.chuanHoaMa(xa.getMaXa());
//               
//                if ((MaXaXa.equals(MaXaTin))){
//                    TenXa = listXP.get(j).getTenXa();
//                    LoaiXa = listXP.get(j).getLoai();
//                    break;
//                }
//            }
//                 for(int k = 0; k < listQH.size(); k++){
//                    qh = listQH.get(k);
//                    String MaQHQuan = ChuanHoa.chuanHoaMa(qh.getMaQH());
//                    String MaQHXa = ChuanHoa.chuanHoaMa(xa.getMaQH());
//                    
//                    if(MaQHXa.equals(MaQHQuan)){
//                        TenQH = listQH.get(k).getTenQH();
//                        LoaiQuan = listQH.get(k).getLoai();
//                        break;
//                    }
//
//                }    
//                    for(int h = 0; h < listTP.size(); h++){
//                        tp = listTP.get(h);
//                        String MaTPQH = ChuanHoa.chuanHoaMa(qh.getMaTP());
//                        String MaTP = ChuanHoa.chuanHoaMa(tp.getMaTP());
//                        
//                        if(MaTPQH.equals(MaTP)){
//                            TenTP = listTP.get(h).getTenTP();
//                            LoaiTP = listTP.get(h).getLoai();
//                            break;
//                        }       
//                    }         
//            obj[3] = "  "+tin.getThongTinDiaChi()+", "+ shortenXa(LoaiXa)+ TenXa + ", " +shortenQuan(LoaiQuan)+TenQH + ", " + shortenTP(LoaiTP)+ TenTP;
            
            getIDXa(MaTinTin);
            getIDHuyen(MaXa);
            getIDTP(MaQH);
            GiaPhong = setGiaPhong(MaTinTin);
            LoaiXa = setLoaiXa(MaXa);
            LoaiTP = setLoaiTP(MaTP);
            LoaiQH = setLoaiQH(MaQH);
            
            obj[3] ="  "+tin.getThongTinDiaChi()+", "+shortenXa(LoaiXa)+setTenXa(MaXa)+", "+shortenQuan(LoaiQH)+setTenQH(MaQH)+", "+shortenTP(LoaiTP)+setTenTP(MaTP);
            String [] mutualColumn = {"","","  SĐT : "+tin.getSDTTin(),"  Ngày đăng : "+tin.getNgayDang().toString(),"  Tình trạng an ninh : "+tin.getAnNinh()};   
            obj[0] = tin.getMaTin().trim();
            obj[2] = "  "+tin.getTieuDe();         
//            obj[5] = tin.isTrangThai()== true ? "Còn" : "Hết";
            DecimalFormat formatter = new DecimalFormat("###,###,###,###,###");
//            obj[5] = formatter.format(GiaPhong) + " VNĐ";
            obj[5] = GiaPhong + " VNĐ";
            obj[4] = mutualColumn;

=======
                }    
                    for(int h = 0; h < listTP.size(); h++){
                        tp = listTP.get(h);
                        String MaTPQH = ChuanHoa.chuanHoaMa(qh.getMaTP());
                        String MaTP = ChuanHoa.chuanHoaMa(tp.getMaTP());
                        
                        if(MaTPQH.equals(MaTP)){
                            TenTP = listTP.get(h).getTenTP();
                            LoaiTP = listTP.get(h).getLoai();
                            break;
                        }       
                    }
                    
            obj[3] = tin.getThongTinDiaChi()+", "+ shortenXa(LoaiXa)+ TenXa + ", " +shortenQuan(LoaiQuan)+TenQH + ", " + shortenTP(LoaiTP)+ TenTP;
            
            
            String [] mutualColumn = {"","","","SĐT : "+tin.getSDTTin(),"Ngày đăng : "+tin.getNgayDang().toString(),"Tình trạng an ninh : "+tin.getAnNinh()};
            
            obj[0] = tin.getMaTin().trim();
            
            
            obj[2] = tin.getTieuDe();         
            obj[5] = tin.isTrangThai()== true ? "Còn" : "Hết";
            
            obj[4] = mutualColumn;
                    
>>>>>>> 4cc4a4b37526423418ca6f20d502249c8d954521
            dtm.addRow(obj);
        }
        return dtm;
    }
    
    
    
    public String shortenXa(String LoaiXa){
        
        LoaiXa = ChuanHoa.chuanHoaMa(LoaiXa);
        
        if(LoaiXa.equals("Phường")){
            LoaiXa = "P.";
        }
        if(LoaiXa.equals("Thị Trấn")){
            LoaiXa = "TT.";
        }
        if(LoaiXa.equals("Xã")){
            LoaiXa = "Xã ";
        }
        else{
            LoaiXa = LoaiXa;
        }
        
        return LoaiXa;
        
    }
    
    public String shortenQuan(String LoaiQuan){
        
        if(LoaiQuan.equals("Quận")){
            LoaiQuan = "Q.";
        }
        if(LoaiQuan.equals("Thành Phố")){
            LoaiQuan = "TP.";
        }
        if(LoaiQuan.equals("Thị Xã")){
            LoaiQuan = "TX.";
        }
        if(LoaiQuan.equals("Huyện")){
            LoaiQuan = "H.";
        }
        else{
            LoaiQuan = LoaiQuan;
        }
        
        return LoaiQuan;
        
    }
    
    public String shortenTP(String LoaiTP){ 
        if(LoaiTP.equals("Thành Phố")){
            LoaiTP = "TP.";
        }
        if(LoaiTP.trim().equals("Tỉnh")){
            LoaiTP = "Tỉnh ";
        }
        return LoaiTP;
    }
    

<<<<<<< HEAD
    public String getIDXa(String MaTin) throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT MaXa FROM Thong_Tin_Tin WHERE MaTin=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaTin);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){    
                MaXa = rs.getString("MaXa");
        }
        return MaXa;
    }
    
    public String setTenXa(String MaXa) throws SQLException{
        Connection conn = DBConnect.getConnection();
        
        String sql = "SELECT TenXa FROM XaPhuongThiTran WHERE MaXa =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaXa);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){    
                TenXa = rs.getString("TenXa");
        }
        return TenXa;
    }
    public String setLoaiXa(String MaXa) throws SQLException{
        Connection conn = DBConnect.getConnection();
        
        String sql = "SELECT Loai FROM XaPhuongThiTran WHERE MaXa = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaXa);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){    
                LoaiXa = rs.getString("Loai");
        }
        return LoaiXa;
    }
    public String getIDHuyen(String MaXa) throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT MaQH FROM XaPhuongThiTran WHERE MaXa=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaXa);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){    
            MaQH = rs.getString("MaQH");
        }
        return MaQH;
    }
    
    public String setTenQH(String MaQH) throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT TenQH FROM QuanHuyen WHERE MaQH =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaQH);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){    
                TenQH = rs.getString("TenQH");
        }
        return TenQH;
    }
    public String setLoaiQH(String MaQH) throws SQLException{
        Connection conn = DBConnect.getConnection();
        
        String sql = "SELECT Loai FROM QuanHuyen WHERE MaQH = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaQH);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){    
                LoaiQH = rs.getString("Loai");
        }
        return LoaiQH;
    }
    public String getIDTP(String MaQH) throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT MaTP FROM QuanHuyen WHERE MaQH=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaQH);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){    
            MaTP = rs.getString("MaTP");
        }
        return MaTP;
    }
    public String setTenTP(String MaTP) throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT TenTP FROM TinhThanhPho WHERE MaTP =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaTP);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){    
                TenTP = rs.getString("TenTP");
        }
        return TenTP;
    }
    public String setLoaiTP(String MaTP) throws SQLException{
        Connection conn = DBConnect.getConnection();
        
        String sql = "SELECT Loai FROM TinhThanhPho WHERE MaTP = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaTP);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){    
                LoaiTP = rs.getString("Loai");
        }
        return LoaiTP;
    }
    public int setGiaPhong(String MaTin) throws SQLException{
        Connection cons = DBConnect.getConnection();
        
        String sql  = "SELECT GiaPhong FROM Thong_Tin_Phong WHERE MaTin = ?";
        PreparedStatement ps = cons.prepareStatement(sql);
        ps.setString(1,MaTin);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){    
                GiaPhong = rs.getInt("GiaPhong");
        }
        return GiaPhong;
    }
}

            
=======
    public String shortenXa(String LoaiXa){
        
        LoaiXa = ChuanHoa.chuanHoaMa(LoaiXa);
        
        if(LoaiXa.equals("Phường")){
            LoaiXa = "P.";
        }
        if(LoaiXa.equals("Thị Trấn")){
            LoaiXa = "TT.";
        }
        else{
            LoaiXa = LoaiXa;
        }
        
        return LoaiXa;
        
    }
    
    public String shortenQuan(String LoaiQuan){
        
//        LoaiQuan = ChuanHoa.chuanHoaMa(LoaiQuan);
        
        if(LoaiQuan.equals("Quận")){
            LoaiQuan = "Q.";
        }
        if(LoaiQuan.equals("Thành Phố")){
            LoaiQuan = "TP.";
        }
        if(LoaiQuan.equals("Thị Xã")){
            LoaiQuan = "TX.";
        }
        if(LoaiQuan.equals("Huyện")){
            LoaiQuan = "H.";
        }
        else{
            LoaiQuan = LoaiQuan;
        }
        
        return LoaiQuan;
        
    }
    
    public String shortenTP(String LoaiTP){
        
        if(LoaiTP.equals("Thành Phố")){
            LoaiTP = "TP.";
        }
        if(LoaiTP.equals("Tỉnh")){
            LoaiTP = "Tỉnh ";
        }
       
        return LoaiTP;
        
    }
}

>>>>>>> 4cc4a4b37526423418ca6f20d502249c8d954521

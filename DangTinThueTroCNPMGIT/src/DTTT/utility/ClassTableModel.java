
package DTTT.utility;

/**
 *
 * @author Snorlax
 */
import DTTT.dao.DBConnect;
import DTTT.dao.TinDAO;
import DTTT.dao.TinDAOImpl;
import DTTT.model.ThongTinTin;
import DTTT.model.Anh;
import DTTT.model.ChuanHoa;
import DTTT.model.LoaiPhong;
import DTTT.model.QuanHuyen;
import DTTT.model.ThanhPho;
import DTTT.model.ThongTinPhong;
import DTTT.model.XaPhuong;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import static com.sun.tools.javac.code.TypeAnnotationPosition.field;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;




public class ClassTableModel {
    
    Date sysDate = Date.from(Instant.now());
    Anh hinhAnh = new Anh(); 
    String TenXa = null;
    String TenQH = null;
    String TenTP = null;
    String LoaiTP = null;
    String LoaiXa = null;
    String LoaiQH = null;
    String MaXa ="";
    String MaQH ="";
    String MaTP ="";
    String GiaPhong =null;
    Anh anh = null;      
    ImageIcon icon = null;
    byte[] HinhAnh = null;
    String  MaTinAnh = null;
    
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
                
                if(columnIndex == 1){
                    return ImageIcon.class; 
                }
                if(columnIndex == 4){
                    return String[].class;
                }
                else{
                    return String.class;
                }
            }
        };

        
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;   
        ThongTinTin tin;
        Date tinDate;
        String MaTinTin;
        
        
        for (int i = 0; i < listItem.size(); i++) {   
               
            tin = listItem.get(i); 
            
            MaTinTin = ChuanHoa.chuanHoaMa(tin.getMaTin());
            tinDate = tin.getNgayDang();
            
            if( tinDate.getYear() - 2 == sysDate.getYear() ){
                TinDAOImpl.setTrangThai(MaTinTin);
            }
            
            
            
            obj = new Object[columns];
            
            for ( int p = 0; p < listAnh.size(); p++){
                anh = listAnh.get(p);
                MaTinAnh = anh.getMaTin().trim();
                if(MaTinTin.equals(MaTinAnh)){
                    HinhAnh = anh.getHinhAnh();
                    break;
                }
            }
            
            icon = new ImageIcon(new ImageIcon(HinhAnh).getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH));

            obj[1] = icon;
            
            MaXa = TinDAOImpl.getIDXa(MaTinTin);
            
            MaQH = TinDAOImpl.getIDHuyen(MaXa);
            MaTP = TinDAOImpl.getIDTP(MaQH);
            GiaPhong = TinDAOImpl.setGiaPhong(MaTinTin);
            LoaiXa = TinDAOImpl.setLoaiXa(MaXa);
            LoaiTP = TinDAOImpl.setLoaiTP(MaTP);
            LoaiQH = TinDAOImpl.setLoaiQH(MaQH);
            
            
            
            obj[3] ="  "+tin.getThongTinDiaChi()+", "+shortenXa(LoaiXa)+TinDAOImpl.setTenXa(MaXa)
                    +", "+shortenQuan(LoaiQH)+TinDAOImpl.setTenQH(MaQH)+", "
                    +shortenTP(LoaiTP)+TinDAOImpl.setTenTP(MaTP);
            
            String [] mutualColumn = {"","","  SĐT : "+tin.getSDTTin(),"  Ngày đăng : "
                    +tin.getNgayDang().toString(),"  Tình trạng an ninh : "+tin.getAnNinh()};   
            
            obj[0] = tin.getMaTin().trim();
            obj[2] = "  "+tin.getTieuDe();         
            obj[5] = GiaPhong.trim() + " VNĐ";
            obj[4] = mutualColumn;
            
            dtm.addRow(obj);
        }
        return dtm;
    }
    
    
    
    public String shortenXa(String LoaiXa){
        
        LoaiXa = LoaiXa.trim();
        
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
        
        LoaiQuan = LoaiQuan.trim();
        
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
        
        LoaiTP = LoaiTP.trim();
        
        if(LoaiTP.equals("Thành Phố")){
            LoaiTP = "TP.";
        }
        if(LoaiTP.trim().equals("Tỉnh")){
            LoaiTP = "Tỉnh ";
        }
        return LoaiTP;
    }
    
}

            
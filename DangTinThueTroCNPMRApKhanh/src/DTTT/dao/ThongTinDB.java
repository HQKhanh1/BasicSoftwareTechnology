package DTTT.dao;


import DTTT.model.Anh;
import DTTT.model.ThongTinPhong;
import DTTT.model.ThongTinTin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

   
public class ThongTinDB {
    
    
    public static void ThemThongTin(ThongTinTin ttt, ThongTinPhong ttp, Anh hinhAnh, String ttk) throws SQLException{
            
        String maTin = layMaTin(); 
         
        Connection conn = DBConnect.getConnection();
        String sql = "INSERT INTO Thong_Tin_Tin(MaTin,TieuDe,SDTTin,NgayDang,AnNinh,MaXa,ThongTinDiaChi,TrangThai,TaiKhoan) VALUES (?,?,?,?,?,?,?,?,?)";
        String sql1 = "INSERT INTO Thong_Tin_Phong(MaTin,MaLoaiPhong,TenPhong,SoPhong,DienTich,GiaPhong,DieuHoa,MoTa) VALUES (?,?,?,?,?,?,?,?)";
        String sql2 = "INSERT INTO Hinh_Anh VALUES(?,?,?)";
        
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
        ps.setString(1, maTin);
        ps.setString(2, ttt.getTieuDe());
        ps.setString(3, ttt.getSDTTin());
        ps.setDate(4, ttt.getNgayDang());
        ps.setString(5, ttt.getAnNinh());
        ps.setString(6, ttt.getMaXa());
        ps.setString(7, ttt.getThongTinDiaChi());
        ps.setInt(8, 1);
        ps.setString(9, ttk);
        ps.executeUpdate();
        ps.close();
        
        PreparedStatement ps1 = (PreparedStatement) conn.prepareStatement(sql1);
             
             ps1.setString(1, maTin);
             ps1.setString(2, ttp.getMaLoaiPhong());
             ps1.setString(3, ttp.getTenLoaiPhong());
             ps1.setInt(4, ttp.getSoPhong());
             ps1.setString(5, ttp.getDienTich());
             ps1.setString(6, ttp.getGiaPhong());
             ps1.setString(7, ttp.getDieuHoa());
             ps1.setString(8, ttp.getMoTa());
             
             ps1.executeUpdate();
         
         ps1.close();
         
        PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(sql2);
        for(int i=0;i<hinhAnh.getDsha().size();i++){
                ps2.setString(1, layMaHinh());
                ps2.setBytes(2, hinhAnh.getDsha().get(i));
                ps2.setString(3, maTin);
                ps2.executeUpdate();
        }
        ps2.close();
        conn.close();
        
    }
    
    public static String layMaTin() throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM Thong_Tin_Tin ";
        int thu=1,test=1;
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        do{
            test=1;
            while(rs.next()){
                if(rs.getInt("MaTin")==thu){
                    test=0;
                    break;
                }
            }
            thu++;
        }
        while(test==0);
        return String.valueOf(thu-1).trim();
    }
    
    public static String layMaHinh() throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM Hinh_Anh ";
        int thu=1,test=1;
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        do{
            test=1;
            while(rs.next()){
                if(rs.getInt("MaHinhAnh")==thu){
                    test=0;
                    break;
                }
            }
            thu++;
            rs.close();rs =ps.executeQuery();
        }
        while(test==0);
        return String.valueOf(thu-1).trim();
    }
}
package DTTT.dao;


import DTTT.model.Anh;
import DTTT.model.TaiKhoan;
import DTTT.model.ThongTinTin;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class TinDAOImpl implements TinDAO{
    
    @Override
    public List<ThongTinTin> getList() {
        PreparedStatement ps = null;
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM Thong_Tin_Tin WHERE TrangThai ='" + "True" + "'";
            
            List<ThongTinTin> list = new ArrayList<>();
            ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ThongTinTin tin = new ThongTinTin();
                
                tin.setMaTin(rs.getString("MaTin"));
                tin.setTieuDe(rs.getString("TieuDe"));
                tin.setSDTTin(rs.getString("SDTTin"));
                tin.setNgayDang(rs.getDate("NgayDang"));
                tin.setAnNinh(rs.getString("AnNinh"));
                tin.setMaXa(rs.getString("MaXa"));
                tin.setThongTinDiaChi(rs.getString("ThongTinDiaChi"));
                tin.setTrangThai(rs.getBoolean("TrangThai"));
                
                
                
                list.add(tin);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return null;
    }
    public static void setTrangThai(String MaTin) throws SQLException,SQLServerException{
        
        Connection conn = DBConnect.getConnection();
        String sql = "UPDATE Thong_Tin_Tin SET TrangThai = 0 WHERE MaTin = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaTin);
        int rs = ps.executeUpdate();
        conn.close();
        
    }
    
    public static void deleteEmptyrRoom() throws SQLException,SQLServerException{
        
        Connection conn = DBConnect.getConnection();
        String sql = "WITH c as\n"
                + "(SELECT Thong_Tin_Tin.MaTin,Thong_Tin_Phong.SoPhong,Thong_Tin_Tin.TrangThai\n"
                + "FROM Thong_Tin_Phong, Thong_Tin_Tin\n"
                + "Where Thong_Tin_Phong.MaTin = Thong_Tin_Tin.MaTin)\n"
                + "UPDATE c\n"
                + "SET TrangThai = 0\n"
                + "WHERE SoPhong = 0";
        PreparedStatement ps = conn.prepareStatement(sql);
        int rs = ps.executeUpdate();
        conn.close();
        
    }
    
    public static String getIDXa(String MaTin) throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT MaXa FROM Thong_Tin_Tin WHERE MaTin=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaTin);
        ResultSet rs = ps.executeQuery();
        String MaXa = null;
        while(rs.next()){    
                MaXa = rs.getString("MaXa");
        }
        return MaXa;
    }
    public static String setTenXa(String MaXa) throws SQLException{
        Connection conn = DBConnect.getConnection();
        
        String sql = "SELECT TenXa FROM XaPhuongThiTran WHERE MaXa = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaXa);
        ResultSet rs=ps.executeQuery();
        String TenXa = null;
        while(rs.next()){    
                TenXa = rs.getString("TenXa");
        }
        return TenXa;
    }
    
    public static String setLoaiXa(String MaXa) throws SQLException{
        Connection conn = DBConnect.getConnection();
        
        String sql = "SELECT Loai FROM XaPhuongThiTran WHERE MaXa = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaXa);
        ResultSet rs=ps.executeQuery();
        String LoaiXa = null;
        while(rs.next()){    
                LoaiXa = rs.getString("Loai");
        }
        return LoaiXa;
    }
    public static String getIDHuyen(String MaXa) throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT MaQH FROM XaPhuongThiTran WHERE MaXa=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaXa);
        ResultSet rs=ps.executeQuery();
        String MaQH = null;
        while(rs.next()){    
            MaQH = rs.getString("MaQH");
        }
        return MaQH;
    }
    
    public static String setTenQH(String MaQH) throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT TenQH FROM QuanHuyen WHERE MaQH =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaQH);
        ResultSet rs=ps.executeQuery();
        String TenQH = null;
        while(rs.next()){    
                TenQH = rs.getString("TenQH");
        }
        return TenQH;
    }
    public static String setLoaiQH(String MaQH) throws SQLException{
        Connection conn = DBConnect.getConnection();
        
        String sql = "SELECT Loai FROM QuanHuyen WHERE MaQH = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaQH);
        ResultSet rs=ps.executeQuery();
        String LoaiQH = null;
        while(rs.next()){    
                LoaiQH = rs.getString("Loai");
        }
        return LoaiQH;
    }
    
    public static String getIDTP(String MaQH) throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT MaTP FROM QuanHuyen WHERE MaQH=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaQH);
        ResultSet rs=ps.executeQuery();
        String MaTP = null;
        while(rs.next()){    
            MaTP = rs.getString("MaTP");
        }
        return MaTP;
    }
    public static String setTenTP(String MaTP) throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT TenTP FROM TinhThanhPho WHERE MaTP =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaTP);
        ResultSet rs=ps.executeQuery();
        String TenTP = null;
        while(rs.next()){    
                TenTP = rs.getString("TenTP");
        }
        return TenTP;
    }
    public static String setLoaiTP(String MaTP) throws SQLException{
        Connection conn = DBConnect.getConnection();
        
        String sql = "SELECT Loai FROM TinhThanhPho WHERE MaTP = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,MaTP);
        ResultSet rs=ps.executeQuery();
        String LoaiTP = null;
        while(rs.next()){    
                LoaiTP = rs.getString("Loai");
        }
        return LoaiTP;
    }
    
    public static String setGiaPhong(String MaTin) throws SQLException{
        Connection cons = DBConnect.getConnection();
        
        String sql  = "SELECT GiaPhong FROM Thong_Tin_Phong WHERE MaTin = ?";
        PreparedStatement ps = cons.prepareStatement(sql);
        ps.setString(1,MaTin);
        ResultSet rs = ps.executeQuery();
        String GiaPhong = null;
        while(rs.next()){    
                GiaPhong = rs.getString("GiaPhong");
        }
        return GiaPhong;
    }
    
//    WITH c as
//(SELECT Thong_Tin_Tin.MaTin,Thong_Tin_Phong.SoPhong,Thong_Tin_Tin.TrangThai
//FROM Thong_Tin_Phong, Thong_Tin_Tin
//Where Thong_Tin_Phong.MaTin = Thong_Tin_Tin.MaTin)
//SELECT TrangThai, MaTin
//FROM c
//WHERE SoPhong = 0
    
}




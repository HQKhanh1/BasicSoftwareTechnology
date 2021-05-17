package DTTT.dao;
import DTTT.model.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaiKhoanDB{
    
    public static TaiKhoan login(String tenDN, String mk){
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM Tai_Khoan Where TaiKhoan = ? and MatKhau =?";
        TaiKhoan taiKhoan = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenDN);
            ps.setString(2, mk);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                taiKhoan = new TaiKhoan();
                taiKhoan.setTenTK(rs.getString(1));
                taiKhoan.setMk(rs.getString(2));
            }  
            ps.close();
            conn.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taiKhoan;
    }
    
    public static void  themTaiKhoan(TaiKhoan tk){
      
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "INSERT INTO Tai_Khoan(TaiKhoan, MatKhau, SDT, HoTen) VALUES(?,?,?,?)";
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            
            ps.setString(1,tk.getTenTK());
            ps.setString(2,tk.getMk());
            ps.setString(3,tk.getSdt());
            ps.setString(4,tk.getHoTen());
            
            ps.executeUpdate();
            System.out.println("Đã thêm tài khoản");
            
            ps.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static int kTTKTonTai(String tenTK) throws SQLException{
        
        int thu=0; 
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM Tai_Khoan";
        PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            if(rs.getString("TaiKhoan").trim().equals(tenTK)){
                thu = 1;
            }
        }
        ps.close();conn.close();
        return thu;
    }
}

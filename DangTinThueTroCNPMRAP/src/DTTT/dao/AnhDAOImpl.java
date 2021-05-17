package DTTT.dao;


import DTTT.model.Anh;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnhDAOImpl implements AnhDAO{

    public List<Anh> getList() {
        PreparedStatement ps = null;
        try {
            
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM Hinh_Anh";
            List<Anh> alist = new ArrayList<>();
            
            ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Anh anh = new Anh();
//                anh.setDsMaHinh((List<String>) rs.getArray("MaHinhAnh"));
//                anh.setDsha((List<byte[]>) rs.getArray("HinhAnh"));

                anh.setMaHinhAnh(rs.getString("MaHinhAnh"));
                anh.setHinhAnh(rs.getBytes("HinhAnh"));
                anh.setMaLoaiPhong(rs.getString("MaTin"));
                
                alist.add(anh);
            }
            ps.close();
            rs.close();
            cons.close();
            return alist;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return null;
    }
}
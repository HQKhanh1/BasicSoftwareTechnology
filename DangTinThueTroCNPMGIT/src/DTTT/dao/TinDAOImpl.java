package DTTT.dao;


import DTTT.model.TaiKhoan;
import DTTT.model.ThongTinTin;
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
            String sql = "SELECT * FROM Thong_Tin_Tin";
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
}



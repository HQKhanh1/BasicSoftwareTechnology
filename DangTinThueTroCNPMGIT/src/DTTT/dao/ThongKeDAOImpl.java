package DTTT.dao;

import DTTT.bean.LoaiPhongBean;
import DTTT.bean.TinBean;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ThongKeDAOImpl implements ThongKeDAO{

    @Override
    public List<TinBean> getListByTin() {
        
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT NgayDang, COUNT(*) as so_luong FROM Thong_Tin_Tin GROUP BY NgayDang;";
        List<TinBean> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TinBean tinBean = new TinBean();
                tinBean.setNgayDangTin(rs.getDate("NgayDang"));
                tinBean.setSoLuongTin(rs.getInt("so_luong"));
                list.add(tinBean);
             }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }

    @Override
    public List<LoaiPhongBean> getListByLoaiPhong() {
       
        Connection cons = DBConnect.getConnection();
        String sql ="WITH c as (SELECT Thong_Tin_Phong.MaLoaiPhong, LoaiPhong.TenLoaiPhong FROM Thong_Tin_Phong, LoaiPhong" +
" WHERE Thong_Tin_Phong.MaLoaiPhong=LoaiPhong.MaLoaiPhong) SELECT c.TenLoaiPhong, count(*)  as so_luong" +
" FROM c GROUP BY c.TenLoaiPhong";
        List<LoaiPhongBean> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiPhongBean loaiPhongBean = new LoaiPhongBean();
                loaiPhongBean.setTenLoaiPhong(rs.getString("TenLoaiPhong"));
                loaiPhongBean.setSoLuongPhong(rs.getInt("so_luong"));
                list.add(loaiPhongBean);
             }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
    
}

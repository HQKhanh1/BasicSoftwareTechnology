package DTTT.dao;


import DTTT.model.QuanHuyen;
import DTTT.model.ThanhPho;
import DTTT.model.XaPhuong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ThanhPhoDAOImpl implements ThanhPhoDAO{

    @Override
    public List<ThanhPho> getTPList() {
        PreparedStatement ps = null;
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM TinhThanhPho";
            List<ThanhPho> listTP = new ArrayList<>();
            ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ThanhPho tp = new ThanhPho();
                
                tp.setLoai(rs.getString("Loai"));
                tp.setMaTP(rs.getString("MaTP"));
                tp.setTenTP(rs.getString("TenTP"));
//                tp.setTaiKhoan((TaiKhoan) rs.getObject("TaiKhoan"));
                listTP.add(tp);
            }
            ps.close();
            rs.close();
            cons.close();
            return listTP;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return null;
    }

    @Override
    public List<QuanHuyen> getQHList() {
        PreparedStatement ps = null;
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM QuanHuyen";
            List<QuanHuyen> listQH = new ArrayList<>();
            ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                QuanHuyen qh = new QuanHuyen();
                
                qh.setLoai(rs.getString("Loai"));
                qh.setMaQH(rs.getString("MaQH"));
                qh.setTenQH(rs.getString("TenQH"));
                qh.setMaTP(rs.getString("MaTP"));
                
                listQH.add(qh);
            }
            ps.close();
            rs.close();
            cons.close();
            return listQH;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return 
                null;    
    }

    @Override
    public List<XaPhuong> getXPList() {
            PreparedStatement ps = null;
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM XaPhuongThiTran";
            List<XaPhuong> listXP = new ArrayList<>();
            ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                XaPhuong xp = new XaPhuong();
                
                xp.setLoai(rs.getString("Loai"));
                xp.setMaXa(rs.getString("MaXa"));
                xp.setTenXa(rs.getString("TenXa"));
                xp.setMaQH(rs.getString("MaQH"));
//                tp.setTaiKhoan((TaiKhoan) rs.getObject("TaiKhoan"));
                listXP.add(xp);
            }
            ps.close();
            rs.close();
            cons.close();
            return listXP;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return 
                null;        }
}



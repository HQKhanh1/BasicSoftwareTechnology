/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.dao;

import DTTT.model.LoaiPhong;
import DTTT.model.ThongTinPhong;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Snorlax
 */
public class PhongDAOImpl implements PhongDAO{

    @Override
    public List<ThongTinPhong> getList() {
PreparedStatement ps = null;
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM Thong_Tin_Phong";
            List<ThongTinPhong> list = new ArrayList<>();
            ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ThongTinPhong tinphong = new ThongTinPhong();
                
                tinphong.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                tinphong.setMaTin(rs.getString("MaTin"));
                tinphong.setGiaPhong(rs.getString("GiaPhong"));
                tinphong.setSoPhong(rs.getInt("SoPhong"));
                tinphong.setDieuHoa(rs.getString("DieuHoa"));
                tinphong.setMoTa(rs.getString("MoTa"));
                tinphong.setTenLoaiPhong(rs.getString("MaLoaiPhong"));
                tinphong.setDienTich(rs.getString("DienTich"));

                list.add(tinphong);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return null;    }

    @Override
    public List<LoaiPhong> getLPList() {
    PreparedStatement ps = null;
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM LoaiPhong";
            List<LoaiPhong> list = new ArrayList<>();
            ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LoaiPhong lp = new LoaiPhong();
                
                lp.setMaLoaiPhong(rs.getString("MaLoaiPhong"));
                lp.setTenLoaiPhong(rs.getString("TenLoaiPhong"));

                list.add(lp);
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

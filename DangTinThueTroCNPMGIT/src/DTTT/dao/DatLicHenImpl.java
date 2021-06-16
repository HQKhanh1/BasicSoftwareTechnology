package DTTT.dao;
import DTTT.dao.DBConnect;
import DTTT.model.ChuanHoa;
import DTTT.model.DatLichHen;
import DTTT.model.ThongTinPhong;
import DTTT.model.LoaiPhong;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;
import java.text.SimpleDateFormat;
/**
 *
 * @author huynhkhanh
 */
public class DatLicHenImpl {
    
    public static void  themLichHen(DatLichHen lichHen){
      
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "INSERT INTO dbo.[Lich_Hen](MaLichHen,MaTin, TaiKhoan, ThoiGianHen, MaXa, MoTa) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            
            ps.setString(1,lichHen.getMaLichHen());
            ps.setString(2,lichHen.getMaTin());
            ps.setString(3,lichHen.getTaiKhoan());
            ps.setDate(4,lichHen.getThoiGianHen());
            ps.setString(5,lichHen.getMaXa());
            ps.setString(6, lichHen.getMoTa());
            
            ps.executeUpdate();
            System.out.println("Đã thêm lichhen");
            
            ps.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String layMalichHen() throws SQLException{
        Connection conn = DBConnect.getConnection();
        String sql = "SELECT * FROM Lich_Hen ";
        int test=1;
        String thu = "";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        do{
            test=1;
            thu =DTTT.model.ChuanHoa.taoMaLichHen();
            while(rs.next()){
                if(rs.getString("MaLichHen").equals(thu)){
                    test=0;
                    break;
                }
            }
        }while(test == 0);
        return thu;
    }
    public static String layTaiKhoan(String MaLichHen){
        String tk = null;
        MaLichHen = ChuanHoa.xoaKhoangTrang(MaLichHen);
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "select * from Lich_Hen";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery(); 
            while(rs.next()){
                String maTam = ChuanHoa.xoaKhoangTrang(rs.getString("MaLichHen"));
                String TKTam = ChuanHoa.xoaKhoangTrang(rs.getString("TaiKhoan"));
                if (maTam.equals(MaLichHen)) {
                    tk = TKTam;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tk;
    }
    public static String layTenTaiKhoan(String taiKhoan){
        String tk = null;
        taiKhoan = ChuanHoa.xoaKhoangTrang(taiKhoan);
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "select * from Tai_Khoan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery(); 
            while(rs.next()){
                String TKTam = ChuanHoa.xoaKhoangTrang(rs.getString("TaiKhoan"));
                if (TKTam.equals(taiKhoan)) {
                    tk = ChuanHoa.xoaKhoangTrang(rs.getString("HoTen"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tk;
    }
    public static String laySDTTaiKhoan(String taiKhoan){
        String sDT = null;
        taiKhoan = ChuanHoa.xoaKhoangTrang(taiKhoan);
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "select * from Tai_Khoan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery(); 
            while(rs.next()){
                String TKTam = ChuanHoa.xoaKhoangTrang(rs.getString("TaiKhoan"));
                if (TKTam.equals(taiKhoan)) {
                    sDT = ChuanHoa.xoaKhoangTrang(rs.getString("SDT"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sDT;
    }
    public static String getTaiKhoanTrongMaTin(String maTin){
        String tk = null;
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "select * from Thong_Tin_Tin";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery(); 
            while(rs.next()){
                String maTinTam = ChuanHoa.xoaKhoangTrang(rs.getString("MaTin"));
                if (maTinTam.equals(maTin)) {
                    tk = ChuanHoa.xoaKhoangTrang(rs.getString("TaiKhoan"));
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tk;
    }
    public static String getHoTenTaiKhoanTrongMaTin(String maTin){
        String tk = null;
        String tenTK = null;
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "select * from Thong_Tin_Tin";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery(); 
            while(rs.next()){
                String TKTam = ChuanHoa.xoaKhoangTrang(rs.getString("MaTin"));
                if (TKTam.equals(maTin)) {
                    tk = ChuanHoa.xoaKhoangTrang(rs.getString("TaiKhoan"));
                    tenTK = layTenTaiKhoan(tk);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenTK;
    }
    public static String getSDTTaiKhoanTrongMaTin(String maTin){
        String tk = null;
        String sDT = null;
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "select * from Thong_Tin_Tin";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery(); 
            while(rs.next()){
                String TKTam = ChuanHoa.xoaKhoangTrang(rs.getString("MaTin"));
                if (TKTam.equals(maTin)) {
                    tk = ChuanHoa.xoaKhoangTrang(rs.getString("TaiKhoan"));
                    sDT = laySDTTaiKhoan(tk);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sDT;
    }
    public static int checkTaiKhoanTrongMaTin(String maTinLicHen) throws SQLException{
        maTinLicHen = ChuanHoa.xoaKhoangTrang(maTinLicHen);
        String queryTin = "select * from Thong_Tin_Tin";
        Connection cnn = DBConnect.getConnection();
        PreparedStatement psTin = cnn.prepareStatement(queryTin);
        ResultSet rsTin = psTin.executeQuery();
        while(rsTin.next()){
                String maTinTam = ChuanHoa.xoaKhoangTrang(rsTin.getString("MaTin"));
                String taiKhoanTam = ChuanHoa.xoaKhoangTrang(rsTin.getString("TaiKhoan"));
                
                if(maTinLicHen.equals(maTinTam) && KTTK.getTtk().equals(taiKhoanTam)){
                    
                        return 1;
                }
            }
        return 0;
    }
    public static String checkLayTaiKhoanTrongMaTin(String maTinLicHen) throws SQLException{
        maTinLicHen = ChuanHoa.xoaKhoangTrang(maTinLicHen);
        String taiKhoan = null;
        String queryTin = "select * from Thong_Tin_Tin";
        Connection cnn = DBConnect.getConnection();
        PreparedStatement psTin = cnn.prepareStatement(queryTin);
        ResultSet rsTin = psTin.executeQuery();
        while(rsTin.next()){
                String maTinTam = ChuanHoa.xoaKhoangTrang(rsTin.getString("MaTin"));
                String taiKhoanTam = ChuanHoa.xoaKhoangTrang(rsTin.getString("TaiKhoan"));
                
                if(maTinLicHen.equals(maTinTam)){
                    
                      taiKhoan = ChuanHoa.xoaKhoangTrang(rsTin.getString("TaiKhoan"));
                }
            }
        return taiKhoan;
    }
    public static String layDiaChiHen(String maXa) throws SQLException{
        maXa = ChuanHoa.xoaKhoangTrang(maXa);
        String diaChi = null;
        String queryXa = "select * from XaPhuongThiTran"; // cau truy van in ten xa va lay ma quan huyen khi co ma xa
        String queryHuyen = "select * from QuanHuyen"; //cau truy van in ten quan huyen va lay ma tinh khi co ma quan Huyen
        String queryTinh = "select * from TinhThanhPho"; // cau truy van in ten tinh thanh pho
        Connection cnn = DBConnect.getConnection();
        PreparedStatement psXa = cnn.prepareStatement(queryXa);
        PreparedStatement psHuyen = cnn.prepareStatement(queryHuyen);
        PreparedStatement psTinh = cnn.prepareStatement(queryTinh);
        ResultSet rsXa = psXa.executeQuery();
        ResultSet rsHuyen = psHuyen.executeQuery();
        ResultSet rsTinh = psTinh.executeQuery();
        while(rsXa.next()){
            String maXaTam = ChuanHoa.xoaKhoangTrang(rsXa.getString("MaXa"));
            if(maXa.equals(maXaTam)){
                diaChi = rsXa.getString("Loai") + " " + rsXa.getString("TenXa");
                String maQH = ChuanHoa.xoaKhoangTrang(rsXa.getString("MaQH"));
                while(rsHuyen.next()){
                    String maHuyenTam = ChuanHoa.xoaKhoangTrang(rsHuyen.getString("MaQH"));
                    if(maQH.equals(maHuyenTam)){
                        diaChi = diaChi + " " +rsHuyen.getString("Loai") + " " + rsHuyen.getString("TenQH");
                        String maTinh = ChuanHoa.xoaKhoangTrang(rsHuyen.getString("MaTP"));
                        while(rsTinh.next()){
                            String maTinhTam = ChuanHoa.xoaKhoangTrang(rsTinh.getString("MaTP"));
                            if(maTinh.equals(maTinhTam)){
                                diaChi = diaChi + " " + rsTinh.getString("Loai") + " " + rsTinh.getString("TenTP");
                            }
                        }
                    }
                }
            }
        }
        return diaChi;
    }
    public static int laySoPhong(String maTin) throws SQLException{
        int soPhong = 0;
        String queryPhong = "select * from Thong_Tin_Phong";
        Connection cnn = DBConnect.getConnection();
        PreparedStatement psTin = cnn.prepareStatement(queryPhong);
        ResultSet rsTin = psTin.executeQuery();
        while(rsTin.next()){
                String maTinTam = ChuanHoa.xoaKhoangTrang(rsTin.getString("MaTin"));
                if(maTin.equals(maTinTam)){
                    String soPhongChu = ChuanHoa.xoaKhoangTrang(rsTin.getString("SoPhong"));
                    int soPhongTam = Integer.parseInt(soPhongChu);
                    soPhong = soPhongTam;
                }
            }
        return soPhong;
    }
    public static void truSoPhong(String maTin) throws SQLException{
        maTin = ChuanHoa.xoaKhoangTrang(maTin);

        int soPhong = laySoPhong(maTin) - 1;
        String queryPhong = "UPDATE Thong_Tin_Phong\n" +
                            "SET soPhong = ? "+
                            "WHERE maTin = ?;";
        Connection cnn = DBConnect.getConnection();
        PreparedStatement psTin = cnn.prepareStatement(queryPhong);
        psTin.setInt(1, soPhong);
        psTin.setString(2, maTin);
        int rs = psTin.executeUpdate();
    }
    public static String layMaTinTrongMaLichHen(String maLichHen) throws SQLException{
        String maTin = null;
        String queryPhong = "select * from Lich_Hen";
        Connection cnn = DBConnect.getConnection();
        PreparedStatement psTin = cnn.prepareStatement(queryPhong);
        ResultSet rsTin = psTin.executeQuery();
        while(rsTin.next()){
                String maLichHenTam = rsTin.getString("MaLichHen");
                if(maLichHen.equals(maLichHenTam)){
                    maTin = ChuanHoa.xoaKhoangTrang(rsTin.getString("MaTin"));
                }
            }
        return maTin;
    }
    public static String layTieuDeTrongTin(String maTin) throws SQLException{
        String tieuDe = null;
        String queryPhong = "select * from Thong_Tin_Tin";
        Connection cnn = DBConnect.getConnection();
        PreparedStatement psTin = cnn.prepareStatement(queryPhong);
        ResultSet rsTin = psTin.executeQuery();
        while(rsTin.next()){
                String maTinTam = ChuanHoa.xoaKhoangTrang(rsTin.getString("MaTin"));
                if(maTin.equals(maTinTam)){
                    tieuDe = rsTin.getString("TieuDe");
                }
            }
        return tieuDe;
    }
    public static String layLoaiPhong(String maLoaiPhong) throws SQLException{
        String tenLoaiPhong = null;
        String queryPhong = "select * from LoaiPhong";
        Connection cnn = DBConnect.getConnection();
        PreparedStatement psTin = cnn.prepareStatement(queryPhong);
        ResultSet rsTin = psTin.executeQuery();
        while(rsTin.next()){
                String maLoaiPhongTam = ChuanHoa.xoaKhoangTrang(rsTin.getString("MaLoaiPhong"));
                if(maLoaiPhong.equals(maLoaiPhongTam)){
                    
                    tenLoaiPhong = rsTin.getString("TenLoaiPhong");
                }
            }
        return tenLoaiPhong;
    }
    public static String layMaLoaiPhong (String maTin) throws SQLException{
        String maLoaiPhong = null;
        String queryPhong = "select * from Thong_Tin_Phong";
        Connection cnn = DBConnect.getConnection();
        PreparedStatement psTin = cnn.prepareStatement(queryPhong);
        ResultSet rsTin = psTin.executeQuery();
        while(rsTin.next()){
                String maLTinTam = ChuanHoa.xoaKhoangTrang(rsTin.getString("MaTin"));
                if(maTin.equals(maLTinTam)){
                    maLoaiPhong = ChuanHoa.xoaKhoangTrang(rsTin.getString("MaLoaiPhong"));
                }
            }
        return maLoaiPhong;
    }
    public static LoaiPhong themLoaiPhong(String maLoaiPhong) throws SQLException{
        LoaiPhong lp = new LoaiPhong();
        String tenLoaiPhong = null;
        String queryPhong = "select * from LoaiPhong";
        Connection cnn = DBConnect.getConnection();
        PreparedStatement psTin = cnn.prepareStatement(queryPhong);
        ResultSet rsTin = psTin.executeQuery();
        while(rsTin.next()){
                String maLoaiPhongTam = ChuanHoa.xoaKhoangTrang(rsTin.getString("MaLoaiPhong"));
                if(maLoaiPhong.equals(maLoaiPhongTam)){
                    
                    tenLoaiPhong = rsTin.getString("TenLoaiPhong");
                    lp = new LoaiPhong(maLoaiPhong, tenLoaiPhong);
                }
            }
        return lp;
    }
    public static ThongTinPhong themPhong(String maTin) throws SQLException{
        ThongTinPhong tinphong = new ThongTinPhong();
        String MaTinPhong = maTin;
        String TenPhong = null;
        String maLoaiPhong = null;
        int soPhong = 0;
        String tenLoaiPhong = null;
        String dienTich = null;
        String giaPhong = null;
        String dieuHoa = null;
        String moTa = null;
        String queryPhong = "select * from Thong_Tin_Phong";
        Connection cnn = DBConnect.getConnection();
        PreparedStatement psTin = cnn.prepareStatement(queryPhong);
        ResultSet rsTin = psTin.executeQuery();
        while(rsTin.next()){
                String maTinTam = ChuanHoa.xoaKhoangTrang(rsTin.getString("MaTin"));
                if(maTin.equals(maTinTam)){
                    TenPhong = rsTin.getString("TenPhong");
                    maLoaiPhong = rsTin.getString("MaLoaiPhong");
                    tenLoaiPhong = layLoaiPhong(maLoaiPhong);
                    soPhong = rsTin.getInt("SoPhong");
                    dienTich = rsTin.getString("DienTich");
                    giaPhong = rsTin.getString("GiaPhong");
                    dieuHoa = rsTin.getString("DieuHoa");
                    moTa = rsTin.getString("MoTa");
                    tinphong = new ThongTinPhong(maTin, giaPhong, soPhong, dieuHoa, moTa, 
                            tenLoaiPhong, dienTich, maLoaiPhong);
                    break;
                }
            }
        return tinphong;
    }
    public static void xoaLichHen(String maLichHen) throws SQLException{
        String queryPhong = "delete from Lich_Hen where MaLichHen=?;";
        Connection cnn = DBConnect.getConnection();
        PreparedStatement ps = cnn.prepareStatement(queryPhong);
        ps.setString(1, maLichHen);
        ps.executeUpdate();
        
    }
    public static boolean checkTrungTaiKhoanMaTinLichHen(String taiKhoan, String maTin) throws SQLException{
        boolean check = false;
        taiKhoan = ChuanHoa.xoaKhoangTrang(taiKhoan);
        maTin = ChuanHoa.xoaKhoangTrang(maTin);
        Connection conn = DBConnect.getConnection();
            String sql = "select * from Lich_Hen";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery(); 
            while(rs.next()){
                String maTinTam = ChuanHoa.xoaKhoangTrang(rs.getString("MaTin"));
                String TKTam = ChuanHoa.xoaKhoangTrang(rs.getString("TaiKhoan"));
                if(taiKhoan.equals(TKTam) && maTin.equals(maTinTam)){
                    check = true;
                }
            }
        return check;
    }
    public static void main(String[] args) throws SQLException {
        System.out.println("check: " + checkTrungTaiKhoanMaTinLichHen("1", "5"));
    }
    
}

package DTTT.dao;
import DTTT.dao.DBConnect;
import DTTT.model.ChuanHoa;
import DTTT.model.DatLichHen;
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
    public static void main(String[] args) throws SQLException {
        System.out.println("MaLichHen: " + layMalichHen());
    }
//    public static String lay
//    public static void main(String[] args) throws ParseException {
//        ///// ====================TEST HAM THEM LICH HEN===================
//        String maLichHen, maTin, taiKhoan, thoiGianHentxt;
//        java.sql.Date thoiGianHen;
//        java.util.Date date;
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Nhap ma Lich Hen: ");
//        maLichHen = sc.nextLine();
//        System.out.println("Nhap ma Tin: ");
//        maTin = sc.nextLine();
//        System.out.println("Nhap tai khoan: ");
//        taiKhoan = sc.nextLine();
//        System.out.println("Nhap thoi gian(dd/MM/yyyy): ");
//        thoiGianHentxt = sc.nextLine();
//        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
//        date = formatter1.parse(thoiGianHentxt);
//        thoiGianHen = new java.sql.Date(date.getTime());  
//        DatLichHen dl = new DatLichHen(maLichHen, maTin, taiKhoan, thoiGianHen);
//        System.out.println("=====================================");
//        System.out.println("Ma Lich Hen: "+ dl.getMaLichHen());
//        System.out.println("Ma Tin: "+ dl.getMaTin());
//        System.out.println("Tai Khoan: "+ dl.getTaiKhoan());
//        System.out.println("Thoi Gian Hen: "+ dl.getThoiGianHen());
//        themLichHen(dl);
////  ============================= TEST HÀM LAY TAKHOAN =========================
////            Scanner sr = new Scanner(System.in);
////            String maLichHen = sr.nextLine();
////            String tk;
////            tk = layTaiKhoan(maLichHen);
////            System.out.println("Tai Khoan: " + tk);
//            
//    }
    
}

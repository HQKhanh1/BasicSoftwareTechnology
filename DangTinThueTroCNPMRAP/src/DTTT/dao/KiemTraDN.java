 package DTTT.dao;

import DTTT.model.TaiKhoan;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KiemTraDN {
    
    public static int DangNhapTK(String tenDN, String mk) throws SQLException{
        int thu=-1;
        if(tenDN.length()==0 || mk.length()==0){
            JOptionPane.showMessageDialog(null,"Vui lòng điền đầy đủ thông tin!");
            thu=0;
        }
        else{
           
            if(TaiKhoanDB.kTTKTonTai(tenDN)==1){
                TaiKhoan tk = TaiKhoanDB.login(tenDN, mk);
                if(tk == null){
                    JOptionPane.showMessageDialog(null, "Mật khẩu không chính xác!");
                    thu=1;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
                    thu=2; 
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Tài khoản "+"'"+tenDN+"'"+" không tồn tại!");
                thu=3;
            }
             
        }
        return thu;
    }
}

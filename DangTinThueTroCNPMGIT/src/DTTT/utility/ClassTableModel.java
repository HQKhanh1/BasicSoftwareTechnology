
package DTTT.utility;

/**
 *
 * @author Snorlax
 */
import DTTT.model.ThongTinTin;
import DTTT.model.Anh;
import DTTT.model.ChuanHoa;
import DTTT.model.LoaiPhong;
import DTTT.model.QuanHuyen;
import DTTT.model.ThanhPho;
import DTTT.model.ThongTinPhong;
import DTTT.model.XaPhuong;
import java.awt.Image;
import java.io.IOException;
import java.util.List;
import javax.print.DocFlavor;
import javax.print.DocFlavor.STRING;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;




public class ClassTableModel {
    
    
   
    
    public DefaultTableModel setTableThongTinTin(List<LoaiPhong> listLP ,List<ThongTinPhong> listPhong,List<QuanHuyen> listQH,List<ThanhPho> listTP 
            ,List<XaPhuong> listXP,List<Anh> listAnh ,List<ThongTinTin> listItem
            , String[] listColumn) throws IOException {
        
        int columns = listColumn.length;
        
        DefaultTableModel dtm = new DefaultTableModel() { 
            
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                
                if(columnIndex==1){
                    return ImageIcon.class; 
                }
                if(columnIndex == 6){
                    return String[].class;
                }
                else{
                    return Object.class;
                }
            }
        };

        
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;   
        
        for (int i = 0; i < listItem.size(); i++) {   
            
            ThongTinTin tin = listItem.get(i);  
            obj = new Object[columns];
            //Cột 1 hình ảnh
            Anh anh = null;
            String MaTinTin = ChuanHoa.chuanHoaMa(tin.getMaTin());
            ImageIcon icon = null;
            byte[] HinhAnh = null;
            String [] cars = { "Honda", "BMW", "Ford", "Mazda" };
            for ( int p = 0; p < listAnh.size(); p++){
                anh = listAnh.get(p);
                String  MaTinAnh = ChuanHoa.chuanHoaMa(anh.getMaTin());
                if(MaTinTin.equals(MaTinAnh)){
                    
                    HinhAnh = anh.getHinhAnh();
                    break;
                }
            }
            icon = new ImageIcon(new ImageIcon(HinhAnh).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

            obj[1] = icon;

              //cột 9 Phường\xã
            String MaXaTin = ChuanHoa.chuanHoaMa(listItem.get(i).getMaXa());
           
            
            String TenXa = null;
            String TenQH = null;
            String TenTP = null;
            XaPhuong xa = null;
            QuanHuyen qh = null;
            ThanhPho tp = null;
            String LoaiTP = null;
            String LoaiXa = null;
            String LoaiQuan = null;
            for (int j = 0; j < listXP.size(); j++) {
                xa = listXP.get(j);
                String MaXaXa = ChuanHoa.chuanHoaMa(xa.getMaXa());
               
                if ((MaXaXa.equals(MaXaTin))){
                    TenXa = listXP.get(j).getTenXa();
                    LoaiXa = listXP.get(j).getLoai();
                    break;
                }
            }
                 for(int k = 0; k < listQH.size(); k++){
                    qh = listQH.get(k);
                    String MaQHQuan = ChuanHoa.chuanHoaMa(qh.getMaQH());
                    String MaQHXa = ChuanHoa.chuanHoaMa(xa.getMaQH());
                    
                    if(MaQHXa.equals(MaQHQuan)){
                        TenQH = listQH.get(k).getTenQH();
                        LoaiQuan = listQH.get(k).getLoai();
                        break;
                    }

                }    
                    for(int h = 0; h < listTP.size(); h++){
                        tp = listTP.get(h);
                        String MaTPQH = ChuanHoa.chuanHoaMa(qh.getMaTP());
                        String MaTP = ChuanHoa.chuanHoaMa(tp.getMaTP());
                        
                        if(MaTPQH.equals(MaTP)){
                            TenTP = listTP.get(h).getTenTP();
                            LoaiTP = listTP.get(h).getLoai();
                            break;
                        }       
                    }
                    
            obj[7] = LoaiXa +" "+ TenXa + ", " + LoaiQuan+ " " +TenQH + ", " + LoaiTP +" "+ TenTP;
            
            
            
            obj[0] = tin.getMaTin();
            
            obj[2] = tin.getTieuDe();         
            obj[3] = tin.isTrangThai()== true ? "Còn" : "Hết";
            obj[4] = tin.getSDTTin();
            
            obj[5] = tin.getNgayDang();
            
            obj[6] = tin.getAnNinh();
//            obj[6] = cars;
            System.out.println(cars.getClass());
            obj[8] = tin.getThongTinDiaChi();
           
            
            dtm.addRow(obj);
        }
        return dtm;
    }

}

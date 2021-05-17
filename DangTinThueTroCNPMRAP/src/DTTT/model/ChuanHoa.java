/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.model;

/**
 *
 * @author Admin
 */
public class ChuanHoa {
    public static String ChuanHoaHoTen(String hoTen){
        String a = hoTen;
        
        if(!a.equals("")){
            a = a.trim();
            a = a.toLowerCase();
            a = a.replaceAll("\\s+", " ");
            String[] temp = a.split(" ");
            a = "";
            for (String temp1 : temp) {
            a += Character.toUpperCase(temp1.charAt(0)) + temp1.substring(1) + " ";
            }
        }
        return a;
    }
    
    public static boolean ChuanHoaSDT(String sdt){
        String a = "0[1-9][0-9]{8}";
        return sdt.matches(a);
    }
    
    public static boolean ktSo(String str){
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    
    public static String chuanHoaMa(String st) {
    st=st.trim().toLowerCase();
    st = st.replaceAll("\\s+", " ");
    String[] temp= st.split(" ");
            // sau khi tách xong, gán xâu st thành sâu rỗng
    st="";
    for(int i=0;i<temp.length;i++) {
        st+=String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
//        if(i<temp.length-1) // nếu tempt[i] không phải từ cuối cùng
//            st+=" ";   // cộng thêm một khoảng trắng
    }
    return st;
    }
}

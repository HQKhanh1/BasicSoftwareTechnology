package DTTT.model;

import java.util.ArrayList;
import java.util.List;


public class Anh {
    
    List<byte[]> dsha = new ArrayList();
    List<String> dsMaHinh = new ArrayList();
    String MaHinhAnh;
    String MaTin;
    byte[] HinhAnh;

    public Anh() {
    }

    
    
    public Anh(String Tin) {
        this.MaTin = MaTin;
    }

    public String getMaTin() {
        return MaTin;
    }

    public void setMaLoaiPhong(String MaTin) {
        this.MaTin = MaTin;
    }

    public String getMaHinhAnh() {
        return MaHinhAnh;
    }

    public void setMaHinhAnh(String MaHinhAnh) {
        this.MaHinhAnh = MaHinhAnh;
    }

    public byte[] getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(byte[] HinhAnh) {
        this.HinhAnh = HinhAnh;
    }
        

    public List<String> getDsMaHinh() {
        return dsMaHinh;
    }

    public void setDsMaHinh(List<String> dsMaHinh) {
        this.dsMaHinh = dsMaHinh;
    }
//    
    public void themID(String id){
        dsMaHinh.add(id);
    }
    
    public void xoaID(int i){
        dsMaHinh.remove(i);
    }

    public List<byte[]> getDsha() {
        return dsha;
    }

    public void setDsha(List<byte[]> dsha) {
        this.dsha = dsha;
    }
    
    public void themHinh(byte[] hinhAnh){
        dsha.add(hinhAnh);
    }
    public void xoaHinh(int i){
        dsha.remove(i);
    }

    public Anh(String MaHinhAnh, String MaTin, byte[] HinhAnh) {
        this.MaHinhAnh = MaHinhAnh;
        this.MaTin = MaTin;
        this.HinhAnh = HinhAnh;
    }
}

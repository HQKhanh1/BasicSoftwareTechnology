/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.model;
import java.sql.Date;

/**
 *
 * @author huynhkhanh
 */
public class DatLichHen {
    String maLichHen, maTin, taiKhoan, maXa, moTa;
    Date thoiGianHen;
    public DatLichHen(String maLichHen, String maTin,String taiKhoan, String maXa, String mota, Date thoiGianHen){
        this.maLichHen = maLichHen;
        this.maTin = maTin;
        this.taiKhoan = taiKhoan;
        this.maXa = maXa;
        this.moTa = mota;
        this.thoiGianHen = thoiGianHen;
    }
    public DatLichHen(){
        
    }
    public String getMaLichHen(){
        return maLichHen;
    }
    
    public void setMaLichHen(String maLichHen){
        this.maLichHen = maLichHen;
    }
    
    public String getMaTin(){
        return maTin;
    }
    
    public void setMaTin(String maTin){
        this.maTin = maTin;
    }
    
    public String getTaiKhoan(){
        return taiKhoan;
    }
    
    public void setTaiKhoan(String taiKhoan){
        this.taiKhoan = taiKhoan;
    }
    
    public String getMaXa(){
        return maXa;
    }
    
    public void setMaXa(String maXa){
        this.maXa = maXa;
    }
    
    public String getMoTa(){
        return moTa;
    }
    
    public void setMoTa(String moTa){
        this.moTa = moTa;
    }
    
    public Date getThoiGianHen(){
        return thoiGianHen;
    }
    
    public void setThoiGianHen(Date thoiGianHen){
        this.thoiGianHen = thoiGianHen;
    }
}

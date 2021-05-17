/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.model;

/**
 *
 * @author Snorlax
 */
public class QuanHuyen {
    
    String MaQH, TenQH, Loai, MaTP;

    public QuanHuyen(String MaQH, String TenQH, String Loai, String MaTP) {
        this.MaQH = MaQH;
        this.TenQH = TenQH;
        this.Loai = Loai;
        this.MaTP = MaTP;
    }

    public QuanHuyen() {
    }

    public String getMaQH() {
        return MaQH;
    }

    public void setMaQH(String MaQH) {
        this.MaQH = MaQH;
    }

    public String getTenQH() {
        return TenQH;
    }

    public void setTenQH(String TenQH) {
        this.TenQH = TenQH;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public String getMaTP() {
        return MaTP;
    }

    public void setMaTP(String MaTP) {
        this.MaTP = MaTP;
    }
    
    
    
}

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
public class XaPhuong {
    
    String MaXa, TenXa, Loai, MaQH;

    public XaPhuong(String MaXa, String TenXa, String Loai, String MaQH) {
        this.MaXa = MaXa;
        this.TenXa = TenXa;
        this.Loai = Loai;
        this.MaQH = MaQH;
    }

    public XaPhuong() {
    }

    public String getMaXa() {
        return MaXa;
    }

    public void setMaXa(String MaXa) {
        this.MaXa = MaXa;
    }

    public String getTenXa() {
        return TenXa;
    }

    public void setTenXa(String TenXa) {
        this.TenXa = TenXa;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public String getMaQH() {
        return MaQH;
    }

    public void setMaQH(String MaQH) {
        this.MaQH = MaQH;
    }
    
    
    
}

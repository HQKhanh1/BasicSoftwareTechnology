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
public class ThanhPho {
    
    String MaTP, TenTP, Loai;

    public ThanhPho(String MaTP, String TenTP, String Loai) {
        this.MaTP = MaTP;
        this.TenTP = TenTP;
        this.Loai = Loai;
    }

    public ThanhPho() {
    }

    public String getMaTP() {
        return MaTP;
    }

    public void setMaTP(String MaTP) {
        this.MaTP = MaTP;
    }

    public String getTenTP() {
        return TenTP;
    }

    public void setTenTP(String TenTP) {
        this.TenTP = TenTP;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }
    
    
    
    
    
}

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
public class ThongTinPhong {
    
    String MaTin;
    String GiaPhong;
    int SoPhong;
    String DieuHoa;
    String MoTa;
    String TenLoaiPhong;
    String DienTich;
    String MaLoaiPhong;
    
    public ThongTinPhong(){
    }

    public ThongTinPhong(String MaTin, String GiaPhong, int SoPhong, 
            String DieuHoa, String MoTa, String TenLoaiPhong, String DienTich, String MaLoaiPhong) {
        this.MaTin = MaTin;
        this.GiaPhong = GiaPhong;
        this.SoPhong = SoPhong;
        this.DieuHoa = DieuHoa;
        this.MoTa = MoTa;
        this.TenLoaiPhong = TenLoaiPhong;
        this.DienTich = DienTich;
        this.MaLoaiPhong = MaLoaiPhong;
    }

    public String getMaLoaiPhong() {
        return MaLoaiPhong;
    }

    public void setMaLoaiPhong(String MaLoaiPhong) {
        this.MaLoaiPhong = MaLoaiPhong;
    }
    
    public ThongTinPhong(String GiaPhong) {
        this.GiaPhong = GiaPhong;
    }

    public String getDienTich() {
        return DienTich;
    }

    public void setDienTich(String DienTich) {
        this.DienTich = DienTich;
    }
    

    public String getMaTin() {
        return MaTin;
    }

    public void setMaTin(String MaTin) {
        this.MaTin = MaTin;
    }

    public String getGiaPhong() {
        return GiaPhong;
    }

    public void setGiaPhong(String GiaPhong) {
        this.GiaPhong = GiaPhong;
    }

    public int getSoPhong() {
        return SoPhong;
    }

    public void setSoPhong(int SoPhong) {
        this.SoPhong = SoPhong;
    }

    public String getDieuHoa() {
        return DieuHoa;
    }

    public void setDieuHoa(String DieuHoa) {
        this.DieuHoa = DieuHoa;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getTenLoaiPhong() {
        return TenLoaiPhong;
    }

    public void setTenLoaiPhong(String TenLoaiPhong) {
        this.TenLoaiPhong = TenLoaiPhong;
    }

   
    
    
    
}

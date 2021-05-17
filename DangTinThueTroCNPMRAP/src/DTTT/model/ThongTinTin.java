package DTTT.model;

import java.sql.Date;


public class ThongTinTin {

    private String MaTin;
    private String TieuDe;
    private String SDTTin;
    private float DienTich;
    private Date NgayDang;
    private String AnNinh;
    private String MaXa;
    private String ThongTinDiaChi;
    private boolean TrangThai;
    private TaiKhoan taiKhoan;
    private String MaHinhAnh;
    private String MaLoaiPhong;

    public ThongTinTin(String MaTin, String TieuDe, String SDTTin, float DienTich, Date NgayDang, String AnNinh, String MaXa, String ThongTinDiaChi, boolean TrangThai, TaiKhoan taiKhoan, String MaHinhAnh, String MaLoaiPhong) {
        this.MaTin = MaTin;
        this.TieuDe = TieuDe;
        this.SDTTin = SDTTin;
        this.DienTich = DienTich;
        this.NgayDang = NgayDang;
        this.AnNinh = AnNinh;
        this.MaXa = MaXa;
        this.ThongTinDiaChi = ThongTinDiaChi;
        this.TrangThai = TrangThai;
        this.taiKhoan = taiKhoan;
        this.MaHinhAnh = MaHinhAnh;
        this.MaLoaiPhong = MaLoaiPhong;
    }

    public String getMaLoaiPhong() {
        return MaLoaiPhong;
    }

    public void setMaLoaiPhong(String MaLoaiPhong) {
        this.MaLoaiPhong = MaLoaiPhong;
    }

    public ThongTinTin(){  
    }

    public String getMaTin() {
        return MaTin;
    }

    public void setMaTin(String MaTin) {
        this.MaTin = MaTin;
    }

    public String getTieuDe() {
        return TieuDe;
    }

    public void setTieuDe(String TieuDe) {
        this.TieuDe = TieuDe;
    }


    public String getSDTTin() {
        return SDTTin;
    }

    public void setSDTTin(String SDTTin) {
        this.SDTTin = SDTTin;
    }

    public float getDienTich() {
        return DienTich;
    }

    public void setDienTich(float DienTich) {
        this.DienTich = DienTich;
    }

    public Date getNgayDang() {
        return NgayDang;
    }

    public void setNgayDang(Date NgayDang) {
        this.NgayDang = NgayDang;
    }

    public String getAnNinh() {
        return AnNinh;
    }

    public void setAnNinh(String AnNinh) {
        this.AnNinh = AnNinh;
    }

    public String getMaXa() {
        return MaXa;
    }

    public void setMaXa(String MaXa) {
        this.MaXa = MaXa;
    }

    public String getThongTinDiaChi() {
        return ThongTinDiaChi;
    }

    public void setThongTinDiaChi(String ThongTinDiaChi) {
        this.ThongTinDiaChi = ThongTinDiaChi;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMaHinhAnh() {
        return MaHinhAnh;
    }

    public void setMaHinhAnh(String MaHinhAnh) {
        this.MaHinhAnh = MaHinhAnh;
    }
    
    
  
}

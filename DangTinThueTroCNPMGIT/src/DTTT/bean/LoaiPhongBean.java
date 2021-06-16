/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.bean;

/**
 *
 * @author Snorlax
 */
public class LoaiPhongBean {
    
    private String tenLoaiPhong;
    private int soLuongPhong;

    public LoaiPhongBean(String tenLoaiPhong, int soLuongPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
        this.soLuongPhong = soLuongPhong;
    }

    public LoaiPhongBean() {
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public int getSoLuongPhong() {
        return soLuongPhong;
    }

    public void setSoLuongPhong(int soLuongPhong) {
        this.soLuongPhong = soLuongPhong;
    }
    
    
    
}

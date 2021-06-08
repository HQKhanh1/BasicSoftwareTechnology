/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.bean;

import java.util.Date;

/**
 *
 * @author Snorlax
 */
public class TinBean {
    
    private Date ngayDangTin;
    private int soLuongTin;

    public TinBean() {
    }

    public TinBean(Date ngayDangTin, int soLuongTin) {
        this.ngayDangTin = ngayDangTin;
        this.soLuongTin = soLuongTin;
    }

    public Date getNgayDangTin() {
        return ngayDangTin;
    }

    public void setNgayDangTin(Date ngayDangTin) {
        this.ngayDangTin = ngayDangTin;
    }

    public int getSoLuongTin() {
        return soLuongTin;
    }

    public void setSoLuongTin(int soLuongTin) {
        this.soLuongTin = soLuongTin;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.dao;

import DTTT.model.Anh;
import DTTT.model.LoaiPhong;
import DTTT.model.ThongTinPhong;
import java.util.List;

/**
 *
 * @author Snorlax
 */
public interface PhongDAO {
    
    public List<ThongTinPhong> getList();
    public List<LoaiPhong> getLPList();
//    public int createOrUpdate(ThongTinTin tin);
    
}

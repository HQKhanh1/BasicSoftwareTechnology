/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.dao;

import DTTT.bean.LoaiPhongBean;
import DTTT.bean.TinBean;
import java.util.List;

/**
 *
 * @author Snorlax
 */
public interface ThongKeDAO {
    
    public List<TinBean> getListByTin();
    public List<LoaiPhongBean> getListByLoaiPhong();
    
}

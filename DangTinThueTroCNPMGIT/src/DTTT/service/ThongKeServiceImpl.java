/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.service;

import DTTT.bean.LoaiPhongBean;
import DTTT.bean.TinBean;
import DTTT.dao.ThongKeDAO;
import DTTT.dao.ThongKeDAOImpl;
import java.util.List;

/**
 *
 * @author Snorlax
 */
public class ThongKeServiceImpl implements  ThongKeService{
    
    private ThongKeDAO thongKeDAO = null;

    public ThongKeServiceImpl() {
        this.thongKeDAO = new ThongKeDAOImpl();
    }

    @Override
    public List<TinBean> getListByTin() {
       return thongKeDAO.getListByTin();
    }

    @Override
    public List<LoaiPhongBean> getListByLoaiPhong() {
        return thongKeDAO.getListByLoaiPhong();
    }
    
}

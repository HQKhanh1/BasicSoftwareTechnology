/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.service;

import DTTT.dao.TinDAO;
import DTTT.dao.TinDAOImpl;
import DTTT.model.Anh;
import DTTT.model.ThongTinTin;
import java.util.List;

public class ThongTinTinServiceImpl implements ThongTinTinService {

    private final TinDAOImpl tinDAO;
    
    public ThongTinTinServiceImpl() {
        this.tinDAO = new TinDAOImpl();
    }

     @Override
    public List<ThongTinTin> getList() {
        return tinDAO.getList();
    }

//    @Override
//    public int createOrUpdate(ThongTinTin tin) {
//        return 0;
//    }
}
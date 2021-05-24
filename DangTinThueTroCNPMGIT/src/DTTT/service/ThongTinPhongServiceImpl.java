/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.service;

import DTTT.dao.AnhDAOImpl;
import DTTT.dao.PhongDAOImpl;
import DTTT.model.Anh;
import DTTT.model.LoaiPhong;
import DTTT.model.ThongTinPhong;
import java.util.List;

/**
 *
 * @author Snorlax
 */
public class ThongTinPhongServiceImpl implements ThongTinPhongService{
    
    private final PhongDAOImpl phongDAO;
    
    public ThongTinPhongServiceImpl() {
        this.phongDAO = new PhongDAOImpl();
    }

     @Override
    public List<ThongTinPhong> getList() {
        return phongDAO.getList();
    }

    @Override
    public List<LoaiPhong> getLPList() {
        return phongDAO.getLPList();
    }
}

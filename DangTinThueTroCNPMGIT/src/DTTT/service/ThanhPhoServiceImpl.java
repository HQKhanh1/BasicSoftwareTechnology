/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.service;

import DTTT.dao.ThanhPhoDAOImpl;
import DTTT.model.QuanHuyen;
import DTTT.model.ThanhPho;
import DTTT.model.XaPhuong;
import java.util.List;

/**
 *
 * @author Snorlax
 */
public class ThanhPhoServiceImpl implements ThanhPhoService{
    
    private final ThanhPhoDAOImpl thanhPhoDAO;
    
    
    public ThanhPhoServiceImpl(){
        this.thanhPhoDAO = new ThanhPhoDAOImpl();
    }

    @Override
    public List<ThanhPho> getTPList() {
            return thanhPhoDAO.getTPList();
    }

    @Override
    public List<QuanHuyen> getQHList() {
            return thanhPhoDAO.getQHList();
    }

    @Override
    public List<XaPhuong> getXPList() {
            return thanhPhoDAO.getXPList();
    }

   
}

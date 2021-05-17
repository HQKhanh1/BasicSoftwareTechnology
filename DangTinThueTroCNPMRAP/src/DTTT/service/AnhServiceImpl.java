/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.service;

import DTTT.dao.AnhDAOImpl;
import DTTT.model.Anh;
import java.util.List;

/**
 *
 * @author Snorlax
 */
public class AnhServiceImpl implements AnhService{
    
    private final AnhDAOImpl anhDAO;
    
    public AnhServiceImpl() {
        this.anhDAO = new AnhDAOImpl();
    }

     @Override
    public List<Anh> getList() {
        return anhDAO.getList();
    }
}

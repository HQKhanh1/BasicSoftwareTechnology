/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.service;

import DTTT.model.Anh;
import DTTT.model.QuanHuyen;
import DTTT.model.ThanhPho;
import DTTT.model.XaPhuong;
import java.util.List;

/**
 *
 * @author Snorlax
 */
public interface ThanhPhoService {
    
    public List<XaPhuong> getXPList();
    public List<ThanhPho> getTPList();
    public List<QuanHuyen> getQHList();
    
}

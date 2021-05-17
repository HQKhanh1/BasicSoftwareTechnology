package DTTT.dao;

import DTTT.model.QuanHuyen;
import DTTT.model.ThanhPho;
import DTTT.model.XaPhuong;
import java.util.List;

/**
 *
 * @author Snorlax
 */
public interface ThanhPhoDAO {
    
    public List<ThanhPho> getTPList();
    public List<QuanHuyen> getQHList();
    public List<XaPhuong> getXPList();
    
}

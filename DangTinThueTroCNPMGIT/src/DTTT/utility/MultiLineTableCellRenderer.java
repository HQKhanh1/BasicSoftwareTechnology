/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.utility;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import static java.awt.Font.BOLD;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Snorlax
 */

// Tạo hàng trong JTable gồm nhiều hàng nhỏ
public class MultiLineTableCellRenderer extends JList<String> implements TableCellRenderer {
        
        
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        
        this.setLayoutOrientation(HORIZONTAL_WRAP);
       
<<<<<<< HEAD
        this.setFont(new Font("Arial",Font.PLAIN,18));
=======
        this.setFont(new Font("Arial",Font.PLAIN,16));
>>>>>>> 4cc4a4b37526423418ca6f20d502249c8d954521
        
        //make multi line where the cell value is String[]
        if (value instanceof String[]) {
            setListData((String[]) value);
        }

        //cell backgroud color when selected
        if (isSelected) {
            setBackground(new Color(255, 196, 125));
//            setFont();
        } else {
            setBackground(new Color(224, 236, 255));
        }

        return this;
    }

    

   
}

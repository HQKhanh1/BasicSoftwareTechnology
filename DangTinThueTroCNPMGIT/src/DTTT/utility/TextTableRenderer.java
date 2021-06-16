/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTTT.utility;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Snorlax
 */
public class TextTableRenderer extends JTextArea implements TableCellRenderer {

    public TextTableRenderer() {
        setOpaque(true);
        setLineWrap(true);
//        setWrapStyleWord(true);
        setFont(new Font("Arial",Font.PLAIN,18));
        
    }

    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row,
            int column) {

        if (isSelected) {
            setForeground(new Color(45, 45,45));
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(new Color(45, 45,45));
            setBackground(table.getBackground());
        }

        setText((value == null)
                ? ""
                :"                                                                    "
                        + "                                                                    "
                        + "                                                                    "
                        + "                                                                    "
                        + "                                                                  "
                        + "                                                                  "                                          
                        +value.toString());
        return this;
    }
}

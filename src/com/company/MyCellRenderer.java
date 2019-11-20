package com.company;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MyCellRenderer implements TableCellRenderer {

    private TableCellRenderer tcr;

    public MyCellRenderer (TableCellRenderer tcr) {
        this.tcr = tcr;
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component comp = this.tcr.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if ((row & 1) == 0) { // Ligne paire
            comp.setBackground(new Color(204, 242, 255));
        } else { // Ligne impaire
            comp.setBackground(new Color(128, 223, 255));
        }
        return comp;
    }
}

package de.dapole.gui.util;

import javax.swing.*;
import java.awt.*;

public class MyListCellThing extends JLabel implements ListCellRenderer {

    public MyListCellThing() {
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        // Assumes the stuff in the list has a pretty toString
        setText(value.toString());

        // based on the index you set the color.  This produces the every other effect.
        if (index % 2 == 0) setBackground(UIManager.getColor("text"));
        else setBackground(UIManager.getColor("text").darker());

        return this;
    }
}

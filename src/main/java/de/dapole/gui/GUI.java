package de.dapole.gui;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class GUI extends JPanel {
    private GUIManager manager;

    public GUI(GUIManager manager){
        this.manager = manager;
    }
}

package de.dapole.gui;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class GUI extends JPanel {
    private GUIManager guiManager;

    public GUI(GUIManager guiManager){

        this.guiManager = guiManager;
        this.setMinimumSize(new Dimension(300, 300));
    }
}

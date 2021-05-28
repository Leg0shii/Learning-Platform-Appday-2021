package de.dapole.gui;

import org.kordamp.ikonli.carbonicons.CarbonIcons;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;

public class HomeworkGUI extends GUI{
    private JButton ownButton;
    private JButton sendHelpButton;
    private JButton getHelpButton;
    private JPanel mainPanel;

    public HomeworkGUI(GUIManager guiManager) {
        super(guiManager);
        this.setLayout(new GridLayout(1,1));
        this.add(mainPanel);

        setupGUI();
        setupListeners();
    }

    private void setupGUI(){
        ownButton.setText("eigene Hilfegesuche");
        sendHelpButton.setText("Jemandem helfen");
        getHelpButton.setText("Hilfe bekommen");
    }

    private void setupListeners(){
        getHelpButton.addActionListener(e -> getHelpFunction());

    }

    private void getHelpFunction() {
        getGuiManager().switchToNewHomeWorkGUI();
    }

}

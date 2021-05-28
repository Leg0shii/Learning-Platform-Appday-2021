package de.dapole.gui;

import org.kordamp.ikonli.carbonicons.CarbonIcons;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;

public class Hausaufgaben extends GUI{
    private JButton homeButton;
    private JButton ownButton;
    private JButton sendHelpButton;
    private JButton getHelpButton;
    private JPanel mainPanel;

    public Hausaufgaben(GUIManager guiManager) {
        super(guiManager);
        this.setLayout(new GridLayout(1,1));
        this.add(mainPanel);

        setupGUI();
        setupListeners();
    }

    private void setupGUI(){
        homeButton.setText("Home");
        ownButton.setText("eigene Hilfegesuche");
        sendHelpButton.setText("Jemandem helfen");
        getHelpButton.setText("Hilfe bekommen");
    }

    private void setupListeners(){

    }

}

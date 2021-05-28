package de.dapole.gui;

import javax.swing.*;
import java.awt.*;

public class OverviewGUI extends GUI{
    private JButton profileButton;
    private JButton leaderboardButton;
    private JButton lerngroupButton;
    private JButton homeworkButton;
    private JLabel uebersichtLabel;
    private JPanel subPanel;
    private JPanel mainPanel;

    public OverviewGUI(GUIManager guiManager) {
        super(guiManager);
        this.setLayout(new GridLayout(1, 1));
        add(mainPanel);

        setupGUI();
        setupListeners();
    }

    private void setupListeners() {
        homeworkButton.addActionListener(e -> gotoHausaufgaben());
        profileButton.addActionListener(e -> profileFunction());
    }

    private void profileFunction() {
        getGuiManager().switchToProfileGUI();
    }

    private void gotoHausaufgaben() {
        getGuiManager().switchToHausaufgaben();
    }

    private void setupGUI() {
        this.uebersichtLabel.setText("UEBERSICHT");
        this.profileButton.setText("Profil");
        this.leaderboardButton.setText("Leaderboard");
        this.lerngroupButton.setText("Lerngruppe");
        this.homeworkButton.setText("Hilfegesuche");
    }
}

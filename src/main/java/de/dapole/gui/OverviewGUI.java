package de.dapole.gui;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class OverviewGUI extends GUI{
    private JButton profileButton;
    private JButton leaderboardButton;
    private JMenuBar homeworkButton;
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
        profileButton.addActionListener(e -> profileFunction());
    }

    private void profileFunction() {
        getGuiManager().switchToProfileGUI();
    }

    private void setupGUI() {
        this.uebersichtLabel.setFont(getFont().deriveFont(Font.BOLD,20));
        this.uebersichtLabel.setText("Übersicht");
        this.profileButton.setText("Profil");
        this.leaderboardButton.setText("Leaderboard");
        JMenu menu = new JMenu("Hilfegesuche");
        JMenuItem item = new JMenuItem();
        menu.add(new HomeworkGUI(getGuiManager()));
        this.homeworkButton.add(menu);
    }
}

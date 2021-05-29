package de.dapole.gui;

import de.dapole.util.user.User;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        leaderboardButton.addActionListener(e -> leaderboardFunction());
    }

    private void leaderboardFunction() { getGuiManager().switchToLeaderboardGUI(getGuiManager().getTutorlearn()); }

    private void profileFunction() { getGuiManager().switchToProfileGUI();   }

    private void setupGUI() {
        this.uebersichtLabel.setFont(getFont().deriveFont(Font.BOLD,20));
        User user = getGuiManager().getThisUser();
        String s = user.getPrename() + " " + user.getSurname();
        this.uebersichtLabel.setText("Übersicht von " + s);
        this.profileButton.setText("Profil");
        this.leaderboardButton.setText("Leaderboard");
        JMenu menu = new JMenu("Hilfegesuche");
        menu.add(new HomeworkGUI(getGuiManager()));
        this.homeworkButton.add(menu);
    }
}

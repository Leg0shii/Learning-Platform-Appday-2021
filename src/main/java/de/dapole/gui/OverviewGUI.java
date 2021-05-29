package de.dapole.gui;

import de.dapole.util.user.User;
import lombok.Getter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    private JSlider expSlider;
    private JButton expButton;
    private JLabel expLabel;
    User user;

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
        expButton.addActionListener(e -> expFunction());
    }

    private void expFunction() { ///give learning EXP to user
        getGuiManager().getUserManager().updateEXP(user.getUserid(), expSlider.getValue(), 1);
        getGuiManager().switchToProfileGUI();
         }

    private void leaderboardFunction() { getGuiManager().switchToLeaderboardGUI(getGuiManager().getTutorlearn()); }

    private void profileFunction() { getGuiManager().switchToProfileGUI();   }

    private void setupGUI() {
        this.uebersichtLabel.setFont(getFont().deriveFont(Font.BOLD,20));
        user = getGuiManager().getThisUser();
        String s = user.getPrename() + " " + user.getSurname();
        this.uebersichtLabel.setText("Übersicht von " + s);
        this.profileButton.setText("Profil");
        this.leaderboardButton.setText("Leaderboard");
        JMenu menu = new JMenu("Hilfegesuche");
        menu.add(new HomeworkGUI(getGuiManager()));
        this.homeworkButton.add(menu);
        this.expLabel.setText("wie viele Stunden hast du gerlernt? (nicht betrügen und nicht doppelt klicken)");
        this.expSlider.setMinimum(10);
        this.expSlider.setMaximum(120);
        this.expSlider.setValue(60);
        expSlider.addChangeListener(e -> expButton.setText("Adde " + ((JSlider)e.getSource()).getValue() + " Minuten zu deiner Learnminuten Balance"));
        this.expButton.setText("Adde " + expSlider.getValue() + " Minuten zu deiner Learnminuten Balance");

    }
}

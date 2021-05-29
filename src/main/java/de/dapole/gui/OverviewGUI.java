package de.dapole.gui;

import de.dapole.gui.homework.HomeworkGUI;
import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;

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
        try {
            wait(2);
        }catch(Exception ignored){

        }
            getGuiManager().switchToProfileGUI();
         }

    private void leaderboardFunction() { getGuiManager().switchToLeaderboardGUI(getGuiManager().getTutorlearn()); }

    private void profileFunction() { getGuiManager().switchToProfileGUI();   }

    private void setupGUI() {
        this.profileButton.putClientProperty("JButton.buttonType", "square");
        this.leaderboardButton.putClientProperty("JButton.buttonType", "square");
        this.homeworkButton.setLayout(new GridLayout(1,1));
        this.uebersichtLabel.setFont(getFont().deriveFont(Font.BOLD,20));
        user = getGuiManager().getThisUser();
        String s = user.getPrename() + " " + user.getSurname();
        this.uebersichtLabel.setText("Übersicht von " + s);
        if (user.getTrustworthy() >= 6){
            this.uebersichtLabel.setText(this.uebersichtLabel.getText()+ " \u2713");
        }
        this.profileButton.setText("Profil");
        this.leaderboardButton.setText("Leaderboard");
        JMenu menu = new JMenu("Hilfe");
        menu.setHorizontalAlignment(SwingConstants.CENTER);
        menu.add(new HomeworkGUI(getGuiManager()));
        this.homeworkButton.add(menu);
        this.expLabel.setText("<html> Wie viele Minuten hast du gelernt?<br>(betrüge dich nicht selbst)</html>");
        this.expSlider.setMinimum(10);
        this.expSlider.setMaximum(120);
        this.expSlider.setValue(60);
        expSlider.addChangeListener(e -> expButton.setText("<html>Adde " + ((JSlider)e.getSource()).getValue() + " Minuten <br>zu deiner Learnminuten Balance</html>"));
        this.expButton.setText("Adde " + expSlider.getValue() + " Minuten zu deiner Learnminuten Balance");

    }
}

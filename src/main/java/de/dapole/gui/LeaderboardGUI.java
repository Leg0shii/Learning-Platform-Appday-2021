package de.dapole.gui;

import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LeaderboardGUI extends GUI{
    private JPanel mainPanel;
    private JLabel leaderboardLabel;
    private JButton backButton;
    private JScrollPane leaderboardScrollPane;
    User user;

    public LeaderboardGUI(GUIManager guiManager) {
        super(guiManager);this.setLayout(new GridLayout(1, 1));
        add(mainPanel);

        setupGUI();
        setupListeners();
    }

    private void setupListeners() {
        backButton.addActionListener(e -> backFunction());
    }

    private void backFunction() {
        getGuiManager().switchToOverviewGUI();
    }

    private void setupGUI() {
        this.backButton.setText("Home");
        this.leaderboardLabel.setText("Tutor Leaderboard");
        //Tutor level == 0 // learning level == 1
        User[] leaderboard = getGuiManager().getDbManager().getTop10(0);


        String s;
        //ArrayList<String> list1 = new ArrayList<>();
        String[] list1 = new String[10];
        int i = 0;
        for(User u : leaderboard){
            try {
                s =  u.getPrename() + " " + u.getSurname() + " " + u.getLevelTutor();
            }catch(Exception e){
                s = "irgendwas du loster boy";
            }
           list1[i++] = s;
        }
        JList<String> list2 = new JList<>(list1);

        leaderboardScrollPane.setViewportView(list2);


        this.user = getGuiManager().getThisUser();
        int userid = user.getUserid();



    }
}

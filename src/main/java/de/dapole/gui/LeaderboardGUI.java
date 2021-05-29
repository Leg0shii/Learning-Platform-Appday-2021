package de.dapole.gui;

import de.dapole.gui.util.MyListCellThing;
import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;

public class LeaderboardGUI extends GUI{
    private JPanel mainPanel;
    private JLabel leaderboardLabel;
    private JButton backButton;
    private JScrollPane leaderboardScrollPane;
    private JButton switchButton;
    User user;
    int tutorlearn;

    public LeaderboardGUI(GUIManager guiManager, int tutorlearn) {
        super(guiManager);this.setLayout(new GridLayout(1, 1));
        add(mainPanel);
        this.tutorlearn = tutorlearn;
        setupGUI();
        setupListeners();
    }

    private void setupListeners() {

        backButton.addActionListener(e -> backFunction());
        switchButton.addActionListener(e -> switchFunction());
    }

    private void switchFunction() { getGuiManager().switchToLeaderboardGUI(1-tutorlearn); }

    private void backFunction() { getGuiManager().switchToOverviewGUI();  }

    private void setupGUI() {

        this.backButton.setText("Home");
        String tutorlearnString;
        if(tutorlearn == 0){
            tutorlearnString = "[  Tutor   ]";
        }else{
            tutorlearnString = "[ Learning ]";
        }
        this.switchButton.setText(tutorlearnString);
        this.leaderboardLabel.setText("Leaderboard");
        //Tutor level == 0 // learning level == 1
        User[] leaderboard = getGuiManager().getDbManager().getTop10(tutorlearn);

        String s;
        //ArrayList<String> list1 = new ArrayList<>();
        String[] list1 = new String[10];
        int i = 0;
        for(User u : leaderboard){
            try {
                if(tutorlearn == 0){
                    s =  u.getPrename() + " " + u.getSurname() + " " + u.getLevelTutor();
                }else{
                    s =  u.getPrename() + " " + u.getSurname() + " " + u.getLevelLearning();
                }
            }catch(Exception e){
                s = "irgendwas du loster boy";
            }
           list1[i++] = s;
        }
        JList<String> list2 = new JList<>(list1);
        list2.setCellRenderer(new MyListCellThing());
        leaderboardScrollPane.setViewportView(list2);
    }
}

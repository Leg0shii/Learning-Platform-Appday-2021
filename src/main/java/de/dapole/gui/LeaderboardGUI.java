package de.dapole.gui;

import de.dapole.gui.util.MyListCellThing;
import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;

public class LeaderboardGUI extends GUI {
    private JPanel mainPanel;
    private JLabel headerLabel;
    private JButton backButton;
    private JButton switchButton;
    private JPanel subPanel;
    User user;
    int tutorlearn;

    public LeaderboardGUI(GUIManager guiManager, int tutorlearn) {
        super(guiManager);
        this.setLayout(new GridLayout(1, 1));
        add(mainPanel);
        this.tutorlearn = tutorlearn;
        setupGUI();
        setupListeners();
    }

    private void setupListeners() {

        backButton.addActionListener(e -> backFunction());
        switchButton.addActionListener(e -> switchFunction());
    }

    private void switchFunction() {
        getGuiManager().switchToLeaderboardGUI(1 - tutorlearn);
    }

    private void backFunction() {
        getGuiManager().switchToOverviewGUI();
    }

    private void setupGUI() {

        subPanel.setLayout(new GridLayout(1, 3));
        this.backButton.setText("Zurück");
        this.switchButton.setText("Umschalten");
        this.headerLabel.setFont(getFont().deriveFont(Font.BOLD, 20));
        if (tutorlearn == 0) {
            this.headerLabel.setText("Tutor Leaderboard");
        }
        {
            this.headerLabel.setText("Learning Leaderboard");
        }

        new Thread(() -> {
            //Tutor level == 0 // learning level == 1
            User[] leaderboard = getGuiManager().getDbManager().getTop10(tutorlearn);

            String s;
            //ArrayList<String> list1 = new ArrayList<>();
            String[] list1 = new String[11];
            list1[0] = "NAME  ";
            int i = 1;
            for (User u : leaderboard) {
                try {
                    s = u.getPrename() + " " + u.getSurname();
                    if (u.getTrustworthy() >= 6) {
                        s += " \u2713";
                    }
                    s += "  ";
                } catch (Exception e) {
                    s = "irgendwas du loster boy";
                    e.printStackTrace();
                }
                list1[i++] = s;
            }
            i = 1;
            String[] list2 = new String[11];
            list2[0] = "  LEVEL";
            for (User u : leaderboard) {
                try {
                    if (tutorlearn == 0) {
                        s = "  " + String.valueOf(u.getLevelTutor());
                    } else {
                        s = "  " + String.valueOf(u.getLevelLearning());
                    }
                } catch (Exception e) {
                    s = "irgendwas du loster boy";
                }
                list2[i++] = s;
            }
            i = 1;
            String[] list3 = new String[11];
            list3[0] = "RANG";
            for (User u : leaderboard) {
                try {
                    s = String.valueOf(i);
                } catch (Exception e) {
                    s = "irgendwas du loster boy";
                }
                list3[i++] = s;
            }
            JList<String> list11 = new JList<>(list1);
            JList<String> list21 = new JList<>(list2);
            JList<String> list31 = new JList<>(list3);
            MyListCellThing renderer1 = new MyListCellThing();
            renderer1.setHorizontalAlignment(SwingConstants.RIGHT);
            MyListCellThing renderer2 = new MyListCellThing();
            renderer2.setHorizontalAlignment(SwingConstants.LEFT);
            MyListCellThing renderer3 = new MyListCellThing();
            renderer3.setHorizontalAlignment(SwingConstants.CENTER);
            list11.setCellRenderer(renderer1);
            list21.setCellRenderer(renderer2);
            list31.setCellRenderer(renderer3);
            subPanel.add(list31);
            subPanel.add(list11);
            subPanel.add(list21);
        }).start();
    }
}

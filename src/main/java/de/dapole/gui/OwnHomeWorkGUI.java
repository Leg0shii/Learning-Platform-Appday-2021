package de.dapole.gui;

import de.dapole.util.homework.Homework;
import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OwnHomeWorkGUI extends GUI{
    private JButton backButton;
    private JPanel ownHomeWorksPanel;
    private JPanel mainPanel;
    User user;

    public OwnHomeWorkGUI(GUIManager guiManager) {
        super(guiManager);
        this.setLayout(new GridLayout(1, 1));
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
        this.user = getGuiManager().getThisUser();
        int userid = user.getUserid();
        ArrayList<Homework> hwl = getGuiManager().getHomeworkManager().getAllMyHomeworks(userid);

        for( Homework hw : hwl){

        }




    }
}

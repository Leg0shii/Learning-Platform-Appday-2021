package de.dapole.gui;

import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class QuestionGUI extends GUI{
    private JPanel mainPanel;
    private JPanel subPanel;
    private JButton yesButton;
    private JButton noButton;
    private JLabel questionLabel;
    private User user;
    private ArrayList<String> questions;

    public QuestionGUI(GUIManager guiManager, User user) {
        super(guiManager);
        this.user = user;
        this.setLayout(new GridLayout(1, 1));
        add(mainPanel);

        setupGUI();
        setupListeners();
    }

    private void setupGUI() {

    }

    private void setupListeners(){

    }
}

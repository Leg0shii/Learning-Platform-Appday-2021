package de.dapole.gui;

import javax.swing.*;

public class GUIManager extends JFrame {
    LoginSignupGUI loginSignupGUI;

    public GUIManager (){
        super("Appday 2021");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        setupGUI();

        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void setupGUI(){
        loginSignupGUI = new LoginSignupGUI(this);
        this.add(loginSignupGUI);
    }
}

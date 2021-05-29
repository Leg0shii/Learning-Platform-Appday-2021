package de.dapole.gui;

import javax.swing.*;
import java.awt.*;

public class OwnHomeWorkGUI extends GUI{
    private JButton backButton;
    private JPanel ownHomeWorksPanel;
    private JPanel mainPanel;

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
        getGuiManager().getThisUser();




    }
}

package de.dapole.gui.loginsignup;

import de.dapole.gui.GUI;
import de.dapole.gui.GUIManager;

import javax.swing.*;
import java.awt.*;

public class NoticeGUI extends GUI {
    private JButton toOverviewButton;
    private JLabel noticeLabel;
    private JPanel mainPanel;

    public NoticeGUI(GUIManager guiManager) {
        super(guiManager);
        this.setLayout(new GridLayout(1, 1));
        this.add(mainPanel);

        setupGUI();
        setupListeners();
    }

    private void setupListeners() {
        toOverviewButton.addActionListener(e -> toOverviewfunction());
    }

    private void toOverviewfunction() {
        getGuiManager().switchToOverviewGUI();
    }

    private void setupGUI() {
        this.toOverviewButton.setText("Weiter");
        this.noticeLabel.setText("You have been signed in! Congratulations!");
    }
}

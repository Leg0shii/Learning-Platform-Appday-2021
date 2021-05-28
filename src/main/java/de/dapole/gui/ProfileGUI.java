package de.dapole.gui;

import de.dapole.util.user.User;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class ProfileGUI extends GUI {
    private JPanel mainPanel;
    private JLabel firstnameLabel;
    private JLabel surnameLabel;
    private JButton backButton;
    private JPanel levelPanel;
    private JPanel attributesPanel;
    private JPanel avatarPanel;
    private JPanel tutorLevelPanel;
    private JPanel learnLevelPanel;
    private User user;
    private BufferedImage image;

    public ProfileGUI(GUIManager guiManager) {
        super(guiManager);
        this.setLayout(new GridLayout(1, 1));
        add(mainPanel);
        this.user = getGuiManager().getThisUser();

        setupGUI();
        setupListeners();
    }

    private void setupGUI() {
        avatarPanel.setLayout(new GridLayout(1,1));
        this.firstnameLabel.setText(user.getPrename());
        this.surnameLabel.setText(user.getSurname());
        this.backButton.setText("Zurück");
        switch (user.getCumulatedLevel()) {
            case 0, 1 -> {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../../avatar0.png")));
                JLabel label = new JLabel(icon);
                avatarPanel.add(label);
            }
            case 2, 3 -> {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../../avatar1.png")));
                JLabel label = new JLabel(icon);
                avatarPanel.add(label);
            }
            case 4,5 -> {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../../avatar2.png")));
                JLabel label = new JLabel(icon);
                avatarPanel.add(label);
            }
            default -> {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../../avatar3.png")));
                JLabel label = new JLabel(icon);
                avatarPanel.add(label);
            }
        }
    }

    private void setupListeners() {
        backButton.addActionListener(e -> homefunction());
    }

    private void homefunction() {
        getGuiManager().switchToOverviewGUI();
    }
}

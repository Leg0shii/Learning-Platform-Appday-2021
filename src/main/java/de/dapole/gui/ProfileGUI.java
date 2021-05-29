package de.dapole.gui;

import de.dapole.gui.util.Drawable;
import de.dapole.util.Leveling;
import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
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
    private JLabel tutorLabel;
    private JLabel learningLabel;
    private User user;
    private BufferedImage image;

    public ProfileGUI(GUIManager guiManager) {
        super(guiManager);
        this.setLayout(new GridLayout(1, 1));
        add(mainPanel);
        this.user = getGuiManager().getThisUser();
        user = getGuiManager().getUserManager().retrieveUser(user.getUserid());
        setupGUI();
        setupListeners();
    }

    private void setupGUI() {
        avatarPanel.setLayout(new GridLayout(1,1));
        this.firstnameLabel.setFont(getFont().deriveFont(Font.BOLD,20));
        this.firstnameLabel.setText(user.getPrename());
        this.surnameLabel.setFont(getFont().deriveFont(Font.BOLD,20));
        this.surnameLabel.setText(user.getSurname());
        if (user.isTrustworthy()){
            this.surnameLabel.setText(this.surnameLabel.getText()+ " \u2713");
        }
        this.tutorLabel.setText("Tutor");
        this.learningLabel.setText("Learning");
        this.backButton.setText("Zurück");
        this.tutorLabel.setFont(getFont().deriveFont(Font.BOLD, 15));
        this.learningLabel.setFont(getFont().deriveFont(Font.BOLD, 15));

        updateGUI();
    }

    public void updateGUI(){
        updateAvatar();
        updateEXP();
    }

    private void updateAvatar(){
        avatarPanel.removeAll();
        switch (user.getCumulatedLevel()) {
            case 0 -> {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../../avatar0.png")));
                JLabel label = new JLabel(icon);
                avatarPanel.add(label);
            }
            case 1 -> {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../../avatar0_5.png")));
                JLabel label = new JLabel(icon);
                avatarPanel.add(label);
            }
            case 2 -> {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../../avatar1.png")));
                JLabel label = new JLabel(icon);
                avatarPanel.add(label);
            }
            case 3 -> {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../../avatar2.png")));
                JLabel label = new JLabel(icon);
                avatarPanel.add(label);
            }
            case 4 -> {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../../avatar3.png")));
                JLabel label = new JLabel(icon);
                avatarPanel.add(label);
            }
            case 5 -> {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../../avatar4.png")));
                JLabel label = new JLabel(icon);
                avatarPanel.add(label);
            }
            case 6 -> {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../../avatar5.png")));
                JLabel label = new JLabel(icon);
                avatarPanel.add(label);
            }
            default -> {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("../../../avatar6.png")));
                JLabel label = new JLabel(icon);
                avatarPanel.add(label);
            }
        }
    }

    private void updateEXP(){
        int width = 100;
        int height = 220;

        this.tutorLevelPanel.setLayout(new GridLayout(1,1));
        this.tutorLevelPanel.setPreferredSize(new Dimension(width, height));
        Drawable d = new Drawable(0, 0, width - 2* 10,height - 2*10, user.getExpTutor(), user.getLevelTutor());
        this.tutorLevelPanel.add(d);
        this.tutorLevelPanel.repaint();

        this.learnLevelPanel.setLayout(new GridLayout(1,1));
        this.learnLevelPanel.setPreferredSize(new Dimension(width, height));
        Drawable e = new Drawable(17, 0, width - 2* 10,height - 2*10, user.getExpLearning(), user.getLevelLearning());
        this.learnLevelPanel.add(e);
        this.learnLevelPanel.repaint();
    }

    private void setupListeners() {
        backButton.addActionListener(e -> homefunction());
    }

    private void homefunction() {
        getGuiManager().switchToOverviewGUI();
    }
}



package de.dapole.gui.loginsignup;

import de.dapole.gui.GUI;
import de.dapole.gui.GUIManager;
import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;

public class TimeChooserGUI extends GUI {
    private JPanel mainPanel;
    private JPanel subPanel;
    private JCheckBox moCheckBox;
    private JCheckBox tuCheckBox;
    private JCheckBox weCheckBox;
    private JCheckBox thCheckBox;
    private JCheckBox frCheckBox;
    private JCheckBox saCheckBox;
    private JCheckBox suCheckBox;
    private JButton okayButton;
    private JLabel moLabel;
    private JLabel headerLabel;
    private JLabel tuLabel;
    private JLabel weLabel;
    private JLabel thLabel;
    private JLabel frLabel;
    private JLabel saLabel;
    private JLabel suLabel;
    private JButton backButton;
    private final User user;

    public TimeChooserGUI(GUIManager guiManager, User user) {
        super(guiManager);
        this.user = user;
        this.setLayout(new GridLayout(1, 1));
        add(mainPanel);

        setupGUI();
        setupListeners();
    }

    private void setupGUI(){
        this.headerLabel.setText("Wann hast du Zeit?");
        this.moLabel.setText("Mon");
        this.tuLabel.setText("Die");
        this.weLabel.setText("Mit");
        this.thLabel.setText("Do");
        this.frLabel.setText("Fr");
        this.saLabel.setText("Sa");
        this.suLabel.setText("So");
        this.okayButton.setText("Okay");
        backButton.setText("Zurück");
    }

    private void setupListeners() {
        okayButton.addActionListener(e -> okayFunction());
        backButton.addActionListener(e -> backFunction());
    }

    private void backFunction() {
        getGuiManager().switchToUniChooserGUI(user);
    }

    private void okayFunction() {
        user.setTime(buildTimeString());
        getGuiManager().switchToQuestionGUI(user);
    }

    private String buildTimeString(){
        StringBuilder builder = new StringBuilder();
        if (moCheckBox.isSelected()){
            builder.append(0).append(";");
        }
        if (tuCheckBox.isSelected()){
            builder.append(1).append(";");
        }
        if (weCheckBox.isSelected()){
            builder.append(2).append(";");
        }
        if (thCheckBox.isSelected()){
            builder.append(3).append(";");
        }
        if (frCheckBox.isSelected()){
            builder.append(4).append(";");
        }
        if (saCheckBox.isSelected()){
            builder.append(5).append(";");
        }
        if (suCheckBox.isSelected()){
            builder.append(6).append(";");
        }
        return new String(builder);
    }
}

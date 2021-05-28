package de.dapole.gui;

import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;

public class UniChooserGUI extends GUI{
    private JPanel mainPanel;
    private JComboBox<String> collegeComboBox;
    private JComboBox<String> moduleComboBox;
    private JButton okayButton;
    private JLabel collegeLabel;
    private JLabel moduleLabel;
    private JPanel subPanel;
    private final User user;

    public UniChooserGUI(GUIManager guiManager, User user) {
        super(guiManager);
        this.user = user;
        this.setLayout(new GridLayout(1, 1));
        add(mainPanel);

        setupGUI();
        setupListeners();
    }

    private void setupGUI(){
        collegeLabel.setText("Wähle deine Universität aus");
        collegeComboBox.addItem("Universität Rostock");
        moduleLabel.setText("Wähle deinen Studiengang aus");
        moduleComboBox.addItem("Informatik");
        okayButton.setText("Okay");
    }

    private void setupListeners() {
        okayButton.addActionListener(e -> okayFunction());
    }

    private void okayFunction() {
        String college = (String) collegeComboBox.getSelectedItem();
        String module = (String) moduleComboBox.getSelectedItem();

        user.setUni(college);
        user.setModule(module);

        getGuiManager().switchToTimeChooserGUI(user);
    }
}

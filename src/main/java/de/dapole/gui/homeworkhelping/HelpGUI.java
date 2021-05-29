package de.dapole.gui.homeworkhelping;

import de.dapole.gui.GUI;
import de.dapole.gui.GUIManager;
import de.dapole.util.homework.Homework;

import javax.swing.*;
import java.awt.*;

public class HelpGUI extends GUI {
    private JPanel mainPanel;
    private JButton confirmButton;
    private JButton cancelButton;
    private JLabel headerLabel;
    private Homework homework;

    public HelpGUI(GUIManager guiManager, Homework homework) {
        super(guiManager);
        this.setLayout(new GridLayout(1,1));
        this.add(mainPanel);
        this.homework = homework;

        setupGUI();
        setupListeners();
    }

    private void setupListeners() {
        confirmButton.addActionListener(e -> confirmFunction());
        cancelButton.addActionListener(e -> cancelFunction());
    }

    private void cancelFunction() {
        getParent().setVisible(false);
    }

    private void confirmFunction() {
        homework.getHelperids().add(getGuiManager().thisUser.getUserid());
        getGuiManager().getDbManager().addHomework(homework);
        getParent().setVisible(false);
    }

    private void setupGUI() {
        headerLabel.setText("Hilfe anbieten? User " + homework.getUserid() + " wird in der Lage sein, dich zu kontaktieren");
        confirmButton.setText("Bestätigen");
        cancelButton.setText("Abbrechen");
    }
}

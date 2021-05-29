package de.dapole.gui.homework;

import de.dapole.gui.GUI;
import de.dapole.gui.GUIManager;
import de.dapole.gui.homeworkhelping.HelperGUI;
import de.dapole.util.homework.Homework;
import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OwnHomeWorkGUI extends GUI {
    private JButton backButton;
    private JPanel mainPanel;
    private JMenuBar homeworkBar;
    private JLabel headerLabel;
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
        this.backButton.setText("Zurück");
        this.headerLabel.setFont(getFont().deriveFont(Font.BOLD, 20));
        this.headerLabel.setText("Meine Gesuche");

        homeworkBar.setLayout(new GridLayout(-1, 1));

        updateGUI();
    }

    public void updateGUI(){
        this.homeworkBar.removeAll();
        this.user = getGuiManager().getThisUser();
        int userid = user.getUserid();
        ArrayList<Homework> hwl = getGuiManager().getHomeworkManager().getAllMyHomeworks(userid);
        for (Homework hw : hwl) {
            if (hw.getDone() == 0) {
                JMenu menu = new JMenu("<html>Gesuch zu Bereich: " + hw.getModule() + "<br>Genau: " + hw.getTitle().substring(0, 15) + "...</html>");
                menu.add(new HelperGUI(getGuiManager(), hw));
                homeworkBar.add(new JSeparator());
                homeworkBar.add(menu);
            }
        }
    }
}

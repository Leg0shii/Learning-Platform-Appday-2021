package de.dapole.gui.homeworkhelping;

import de.dapole.gui.GUIManager;
import de.dapole.util.homework.Homework;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Getter
@Setter
public class HelpButtons extends JMenuBar {
    private GUIManager guiManager;
    private ArrayList<String> filter;

    public HelpButtons(GUIManager guiManager, ArrayList<String> filter) {
        this.guiManager = guiManager;
        this.filter = filter;
        this.setLayout(new GridLayout(-1, 1));

        setupGUI();
    }

    private void setupGUI() {
        for (Homework homework : getGuiManager().getHomeworkManager().getAllHomeworks()) {
            if (filter.contains(homework.getModule())) {
                if (homework.getDone() == 0) {
                    JMenu menu = new JMenu("<html>Von: " + getGuiManager().getUserManager().retrieveUser(homework.getUserid()).getPrename() + " " + getGuiManager().getUserManager().retrieveUser(homework.getUserid()).getSurname() + "<br>Bereich: " + homework.getModule() + "<br> Genau: " + homework.getTitle().substring(0, 15) + "...</html>");
                    menu.add(new HelpGUI(guiManager, homework));
                    this.add(new JSeparator());
                    if (homework.getHelperids().contains(getGuiManager().thisUser.getUserid())) {
                        menu.setBackground(menu.getBackground().darker());
                    }
                    this.add(menu);
                }
            }
        }
        this.add(new JSeparator());
    }
}

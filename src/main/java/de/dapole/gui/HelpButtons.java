package de.dapole.gui;

import de.dapole.util.homework.Homework;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;

@Getter
@Setter
public class HelpButtons extends JMenuBar {
    private GUIManager guiManager;
    private ArrayList<String> filter;

    public HelpButtons(GUIManager guiManager, ArrayList<String> filter) {
        this.guiManager = guiManager;
        this.filter = filter;
        this.setLayout(new SpringLayout());

        setupGUI();
    }

    private void setupGUI() {
        int counter = 0;
        for (Homework homework : getGuiManager().getHomeworkManager().getAllHomeworks()) {
            if (filter.contains(homework.getModule())) {
                JMenu menu = new JMenu("<html>Bereich: " + homework.getModule() + "<br> Genau: "+homework.getTitle().substring(0,15)+"...</html>");
                menu.add(new HelpGUI(guiManager, homework));
                this.add(menu);
                counter++;
            }
        }
        if ((counter%3 == 1)){
            this.add(new JLabel(""));
            counter++;
        }
        if (counter%3 == 2){
            this.add(new JLabel(""));
            this.add(new JLabel(""));
            counter+=2;
        }
        SpringUtilities.makeCompactGrid(this,3,counter/3,5,5,5,5);
    }
}

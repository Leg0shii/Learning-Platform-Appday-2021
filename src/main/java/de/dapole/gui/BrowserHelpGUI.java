package de.dapole.gui;

import de.dapole.util.homework.Homework;

import javax.swing.*;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.util.ArrayList;

public class BrowserHelpGUI extends GUI{
    private JTabbedPane tabPanel;
    private JPanel mainPanel;
    private JPanel filterPanel;
    private JPanel helpPanel;
    private ArrayList<String> filterList;
    private ArrayList<JCheckBox> filterCheckBoxes;

    public BrowserHelpGUI(GUIManager guiManager) {
        super(guiManager);
        this.setLayout(new GridLayout(1,1));
        this.add(mainPanel);
        filterCheckBoxes = new ArrayList<>();
        filterList = new ArrayList<>();

        setupGUI();
        setupListeners();
    }

    private void setupListeners() {
        tabPanel.addChangeListener(e -> {
            updateFilter();
            updateHelpButtons();
        });
    }

    private void setupGUI() {
        filterPanel.setLayout(new SpringLayout());
        helpPanel.setLayout(new GridLayout(1,1));
        updateGUI();
        updateFilter();
        addFilterCheckBoxes();
        updateHelpButtons();
    }

    private void updateHelpButtons() {
        helpPanel.removeAll();
        helpPanel.add(new HelpButtons(getGuiManager(), filterList));
    }

    private void updateGUI(){
        filterCheckBoxes = new ArrayList<>();
        filterList = new ArrayList<>();
        for (String module : getGuiManager().getModuleInfo().getQuestions(getGuiManager().getThisUser().getModule())){
            JCheckBox checkBox = new JCheckBox(module);
            checkBox.setSelected(true);
            filterCheckBoxes.add(checkBox);
        }
    }

    private void updateFilter(){
        filterList = new ArrayList<>();
        for (JCheckBox checkBox : filterCheckBoxes){
            if (checkBox.isSelected()){
                filterList.add(checkBox.getText());
            }
        }
    }

    private void addFilterCheckBoxes(){
        int counter = 0;
        for (JCheckBox checkBox : filterCheckBoxes){
            filterPanel.add(checkBox);
            counter++;
        }
        if (counter % 3 == 1){
            filterPanel.add(new JLabel(""));
            counter++;
        }
        if (counter % 3 == 2){
            filterPanel.add(new JLabel(""));
            counter++;
            filterPanel.add(new JLabel(""));
            counter++;
        }
        SpringUtilities.makeCompactGrid(filterPanel,3,counter/3,5,5,5,5);
    }
}

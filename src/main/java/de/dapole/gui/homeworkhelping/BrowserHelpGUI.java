package de.dapole.gui.homeworkhelping;

import de.dapole.gui.GUI;
import de.dapole.gui.GUIManager;
import de.dapole.gui.util.SpringUtilities;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Getter
@Setter
public class BrowserHelpGUI extends GUI {
    private JTabbedPane tabPanel;
    private JPanel mainPanel;
    private JPanel filterPanel;
    private JScrollPane helpPanel;
    private JButton backButton;
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
        backButton.addActionListener(e -> {
            backFunction();
        });
    }

    private void backFunction() {
        getGuiManager().switchToOverviewGUI();
    }

    private void setupGUI() {
        filterPanel.setLayout(new SpringLayout());
        updateGUI();
        updateFilter();
        addFilterCheckBoxes();
        backButton.setText("Zurück");
    }

    private void updateHelpButtons() {
        helpPanel.getViewport().removeAll();
        JPanel panel = new JPanel();
        HelpButtons buttons = new HelpButtons(getGuiManager(), filterList);
        panel.add(buttons);
        helpPanel.setViewportView(panel);
        helpPanel.revalidate();
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
        SpringUtilities.makeCompactGrid(filterPanel,counter/3,3,5,5,5,5);
    }
}

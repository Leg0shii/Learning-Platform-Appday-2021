package de.dapole.gui.homework;

import de.dapole.gui.GUI;
import de.dapole.gui.GUIManager;
import de.dapole.util.user.User;
import org.kordamp.ikonli.carbonicons.CarbonIcons;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;

public class HomeworkGUI extends GUI {
    private JButton ownButton;
    private JButton sendHelpButton;
    private JButton getHelpButton;
    private JPanel mainPanel;

    public HomeworkGUI(GUIManager guiManager) {
        super(guiManager);
        this.setLayout(new GridLayout(1,1));
        add(mainPanel);

        setupGUI();
        setupListeners();
    }

    private void setupGUI(){
        User user = getGuiManager().getThisUser();
        if(user.getSearching()<=0){
            ownButton.setText("eigene Hilfegesuche");
            ownButton.setVisible(false);
        }

        ownButton.setText("eigene Hilfegesuche");
        sendHelpButton.setText("Jemandem helfen");
        getHelpButton.setText("Hilfe bekommen");
    }

    private void setupListeners(){
        getHelpButton.addActionListener(e -> getHelpFunction());
        sendHelpButton.addActionListener(e -> sendHelpFunction());
        ownButton.addActionListener(e -> ownFunction());
    }

    private void ownFunction() {
        getParent().setVisible(false);
        getGuiManager().switchToOwnHomeWorkGUI();
    }

    private void sendHelpFunction() {
        getParent().setVisible(false);
        getGuiManager().switchToBrowseHelpGUI();
    }

    private void getHelpFunction() {
        getParent().setVisible(false);
        getGuiManager().switchToNewHomeWorkGUI();
    }

}

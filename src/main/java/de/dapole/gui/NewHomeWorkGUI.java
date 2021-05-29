package de.dapole.gui;

import de.dapole.util.homework.Homework;
import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NewHomeWorkGUI extends GUI {

    int MAXHOMEWORK = 5;

    private JLabel quoteLabel;
    private JTextArea exactTextArea;
    private JButton sendButton;
    private JTextPane infoTextPane;
    private JPanel mainPanel;
    private JButton backButton;
    private JComboBox<String> themeComboBox;
    String theme = "Thema?";
    String exact = "Was genau fehlt?";
    User user;

    public NewHomeWorkGUI(GUIManager guiManager) {
        super(guiManager);
        this.setLayout(new GridLayout(1,1));
        this.add(mainPanel);

        setupGUI();
        setupListeners();
    }

    private void setupGUI(){

        quoteLabel.setFont(getFont().deriveFont(Font.BOLD,14));

        themeComboBox.addItem(theme);
        initComboBox();

        quoteLabel.setFont(getFont().deriveFont(Font.BOLD,20));
        quoteLabel.setText("Jeder braucht mal Hilfe");
        exactTextArea.setText(exact);
        infoTextPane.setText("Du kannst 5 Hilfegesuche gleichzeitig stellen. Hilfegesuche werden nach 5 Tagen automatisch entfernt. Schreibe dein Thema und Anliegen möglichst minimal, aber dennoch detailliert hier auf.");
        sendButton.setText("Abschicken");

        this.user = getGuiManager().getThisUser();
        backButton.setText("Home");
    }

    private void setupListeners(){
        sendButton.addActionListener(e -> sendfunction());
        backButton.addActionListener(e -> backFunction());
    }

    private void initComboBox(){
        for (String theme : getGuiManager().getModuleInfo().getQuestions(getGuiManager().getThisUser().getModule())){
            themeComboBox.addItem(theme);
        }
    }

    private void backFunction() {
        getGuiManager().switchToOverviewGUI();
    }

    private void sendfunction() {

        if(user.getSearching()<=MAXHOMEWORK){
            String theme1 = (String) themeComboBox.getSelectedItem();
            String exact1 = exactTextArea.getText();

            if( !exact1.equals(exact) && !theme1.equals(theme) && theme1.length() >= 5 && exact1.length() >= 15){
                Homework homework = new Homework(user.getUserid(), new ArrayList<>(), theme1, exact1, 0, 0);
                getGuiManager().getDbManager().addHomework(homework);
                user.setSearching(user.getSearching()+1);
                getGuiManager().getDbManager().addStudent(user);
                getGuiManager().switchToOverviewGUI();
            } else {
                JOptionPane.showMessageDialog(this, "!! Too short !!");
            }
        }
    }

}

package de.dapole.gui;

import de.dapole.util.homework.Homework;
import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NewHomeWorkGUI extends GUI {
    private JLabel quoteLabel;
    private JTextField themeTextField;
    private JTextArea exactTextArea;
    private JButton sendButton;
    private JTextPane infoTextPane;
    private JPanel mainPanel;
    String theme = "Thema?";
    String exact = "Was genau fehlt?";

    public NewHomeWorkGUI(GUIManager guiManager) {
        super(guiManager);
        this.setLayout(new GridLayout(1,1));
        this.add(mainPanel);

        setupGUI();
        setupListeners();
    }

    private void setupGUI(){



        quoteLabel.setFont(getFont().deriveFont(Font.BOLD,14));
        quoteLabel.setText("Jeder braucht mal Hilfe");
        exactTextArea.setText(exact);
        themeTextField.setText(theme);
        infoTextPane.setText("Du kannst 5 Hilfegesuche gleichzeitig stellen. Hilfegesuche werden nach 5 Tagen automatisch entfernt.");
        sendButton.setText("Abschicken");
    }

    private void setupListeners(){
        sendButton.addActionListener(e -> sendfunction());
    }

    private void sendfunction() {

        String theme1 = themeTextField.getText();
        String exact1 = exactTextArea.getText();
        User user = getGuiManager().getThisUser();

        Homework homework = new Homework(user.getUserid(), new ArrayList<>(), theme1, exact1, 0, 0);
        getGuiManager().getDbManager().addHomework(homework);
        getGuiManager().switchToOverviewGUI();
    }

}

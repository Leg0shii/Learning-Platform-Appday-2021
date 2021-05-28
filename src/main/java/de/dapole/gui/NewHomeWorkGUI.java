package de.dapole.gui;

import de.dapole.util.HomeworkClass;
import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;

public class NewHomeWorkGUI extends GUI {
    private JLabel quoteLabel;
    private JTextField themeTextField;
    private JTextArea exactTextArea;
    private JButton sendButton;
    private JTextPane infoTextPane;
    private JPanel mainPanel;
    String theme = "Thema?";
    String exact = "Was genau fehlt?";
    HomeworkClass hwc;

    public NewHomeWorkGUI(GUIManager guiManager) {
        super(guiManager);
        this.setLayout(new GridLayout(1,1));
        this.add(mainPanel);

        setupGUI();
        setupListeners();
    }

    private void setupGUI(){



        quoteLabel.setText("Jeder brauch mal Hilfe");
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

        if(!theme1.equals(this.theme) && !exact1.equals(exact)){
            hwc = new HomeworkClass(user, theme1, exact1);
            getGuiManager().switchToUebersichtGUI();
        }

    }

}

package de.dapole.gui.loginsignup;

import de.dapole.gui.GUI;
import de.dapole.gui.GUIManager;
import de.dapole.util.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Getter
@Setter
public class PlatformSpecifierGUI extends GUI {
    private JPanel mainPanel;
    private JTextField discordTextField;
    private JLabel headerLabel;
    private JLabel discordLabel;
    private JPanel subPanel;
    private JButton okayButton;
    private JTextField whatsappTextField;
    private JTextField telegramTextField;
    private JLabel whatsappLabel;
    private JLabel telegramLabel;
    private JButton backButton;
    private final User user;

    public PlatformSpecifierGUI(GUIManager guiManager, ArrayList<String> platforms, User user) {
        super(guiManager);
        this.setLayout(new GridLayout(1, 1));
        add(mainPanel);
        this.user = user;

        setupGUI(platforms);
        setupListeners();
    }

    private void setupGUI(ArrayList<String> p) {
        headerLabel.setText("Setze deine Nutzerkürzel");
        for (String s : p){
            switch (s){
                case "Discord" -> discordLabel.setText(s);
                case "WhatsApp" -> whatsappLabel.setText(s);
                case "Telegram" -> telegramLabel.setText(s);
            }
        }
        if (discordLabel.getText().equals("")){
            subPanel.remove(discordLabel);
            subPanel.remove(discordTextField);
        }
        if (whatsappLabel.getText().equals("")){
            subPanel.remove(whatsappLabel);
            subPanel.remove(whatsappTextField);
        }
        if (telegramLabel.getText().equals("")){
            subPanel.remove(telegramLabel);
            subPanel.remove(telegramTextField);
        }
        okayButton.setText("Okay");
        backButton.setText("Zurück");
    }

    private void setupListeners() {
        okayButton.addActionListener(e -> {
            okayFunction();
        });
        backButton.addActionListener(e -> backFunction());
    }

    private void backFunction() {
        getGuiManager().switchToPlatformChooserGUI(user);
    }

    private void okayFunction() {
        String discord = "";
        String whatsapp = "";
        String telegram = "";
        for (Component component : subPanel.getComponents()){
            if (!component.getClass().getSimpleName().equals("JLabel")){
                continue;
            }
            JLabel label = (JLabel) component;
            switch (label.getText()){
                case "Discord" -> {
                    JTextField textField = (JTextField) label.getLabelFor();
                    discord = textField.getText();
                }
                case "WhatsApp" -> {
                    JTextField textField = (JTextField) label.getLabelFor();
                    whatsapp = textField.getText();
                }
                case "Telegram" -> {
                    JTextField textField = (JTextField) label.getLabelFor();
                    telegram = textField.getText();
                }
            }
        }
        user.setDiscord(discord);
        user.setWhatsapp(whatsapp);
        user.setTelegram(telegram);

        getGuiManager().switchToUniChooserGUI(user);
    }
}

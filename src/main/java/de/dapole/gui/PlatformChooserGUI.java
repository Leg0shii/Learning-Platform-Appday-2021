package de.dapole.gui;

import org.kordamp.ikonli.bootstrapicons.BootstrapIcons;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;

public class PlatformChooserGUI extends GUI{
    private JPanel mainPanel;
    private JRadioButton whatsappRadioButton;
    private JRadioButton discordRadioButton;
    private JRadioButton telegramRadioButton;
    private JButton confirmButton;
    private JLabel headerLabel;
    private JPanel subPanel;
    private JLabel discordLabel;
    private JLabel whatsappLabel;
    private JLabel telegramLabel;

    public PlatformChooserGUI(GUIManager guiManager) {
        super(guiManager);
        this.setLayout(new GridLayout(1,1));
        this.add(mainPanel);

        setupGUI();
        setupListeners();
    }

    private void setupGUI() {
        headerLabel.setFont(getFont().deriveFont(Font.BOLD,20));
        headerLabel.setText("Bevorzugte Plattform");

        FontIcon discordIcon = new FontIcon();
        discordIcon.setIkon(BootstrapIcons.DISCORD);
        discordIcon.setIconSize(25);
        discordLabel.setText("Discord");
        discordLabel.setIcon(discordIcon);

        FontIcon whatsappIcon = new FontIcon();
        whatsappIcon.setIkon(BootstrapIcons.WHATSAPP);
        whatsappIcon.setIconSize(25);
        whatsappLabel.setText("Whatsapp");
        whatsappLabel.setIcon(whatsappIcon);

        FontIcon telegramIcon = new FontIcon();
        telegramIcon.setIkon(BootstrapIcons.TELEGRAM);
        telegramIcon.setIconSize(25);
        telegramLabel.setText("Telegram");
        telegramLabel.setIcon(telegramIcon);

        confirmButton.setText("Okay");
    }

    private void setupListeners(){
        confirmButton.addActionListener(e -> confirmFunction());
    }

    private void confirmFunction() {

    }
}

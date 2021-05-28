package de.dapole.gui.loginsignup;

import de.dapole.gui.GUI;
import de.dapole.gui.GUIManager;
import de.dapole.util.user.User;
import org.kordamp.ikonli.bootstrapicons.BootstrapIcons;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlatformChooserGUI extends GUI {
    private JPanel mainPanel;
    private JButton confirmButton;
    private JLabel headerLabel;
    private JPanel subPanel;
    private JLabel discordLabel;
    private JLabel whatsappLabel;
    private JLabel telegramLabel;
    private JCheckBox whatsappCheckBox;
    private JCheckBox discordCheckBox;
    private JCheckBox telegramCheckBox;
    private User user;

    public PlatformChooserGUI(GUIManager guiManager, User user) {
        super(guiManager);
        this.setLayout(new GridLayout(1, 1));
        add(mainPanel);
        this.user = user;

        setupGUI();
        setupListeners();
    }

    private void setupGUI() {
        headerLabel.setFont(getFont().deriveFont(Font.BOLD, 20));
        headerLabel.setText("Bevorzugte Plattform");

        FontIcon discordIcon = new FontIcon();
        discordIcon.setIkon(BootstrapIcons.DISCORD);
        discordIcon.setIconSize(25);
        discordLabel.setText("Discord");
        discordLabel.setIcon(discordIcon);

        FontIcon whatsappIcon = new FontIcon();
        whatsappIcon.setIkon(BootstrapIcons.WHATSAPP);
        whatsappIcon.setIconSize(25);
        whatsappLabel.setText("WhatsApp");
        whatsappLabel.setIcon(whatsappIcon);

        FontIcon telegramIcon = new FontIcon();
        telegramIcon.setIkon(BootstrapIcons.TELEGRAM);
        telegramIcon.setIconSize(25);
        telegramLabel.setText("Telegram");
        telegramLabel.setIcon(telegramIcon);

        confirmButton.setText("Okay");
    }

    private void setupListeners() {
        confirmButton.addActionListener(e -> confirmFunction());
    }

    private void confirmFunction() {
        getGuiManager().switchToPlatformSpecifierGUI(getPlatforms(), user);
    }

    private ArrayList<String> getPlatforms() {
        ArrayList<String> list = new ArrayList<>();
        if (discordCheckBox.isSelected()) {
            list.add("Discord");
        }
        if (whatsappCheckBox.isSelected()) {
            list.add("WhatsApp");
        }
        if (telegramCheckBox.isSelected()) {
            list.add("Telegram");
        }
        return list;
    }
}

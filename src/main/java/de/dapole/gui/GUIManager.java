package de.dapole.gui;

import de.dapole.database.DBManager;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.net.URL;

@Getter
@Setter
public class GUIManager extends JFrame {
    private LoginSignupGUI loginSignupGUI;
    private PlatformChooserGUI platformChooserGUI;
    private DBManager dbManager;

    public GUIManager (){
        super("DaPoLe Appday 2021");
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        URL iconURL = getClass().getResource("../../../DaPole.png");
        assert iconURL != null;
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        setupGUI();

        this.dbManager = new DBManager();

        switchToLoginSignupGUI();
    }

    private void setupGUI(){
        loginSignupGUI = new LoginSignupGUI(this);
        platformChooserGUI = new PlatformChooserGUI(this);
    }

    public void switchToLoginSignupGUI(){

        this.setContentPane(loginSignupGUI);
        this.revalidate();
    }

    public void switchToPlatformChooserGUI(){

        this.setContentPane(platformChooserGUI);
        this.revalidate();
    }
}

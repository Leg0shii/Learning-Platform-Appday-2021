package de.dapole.gui;

import de.dapole.database.DBManager;
import de.dapole.util.user.User;
import de.dapole.util.user.UserManager;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;

@Getter
@Setter
public class GUIManager extends JFrame {
    private LoginSignupGUI loginSignupGUI;
    private PlatformChooserGUI platformChooserGUI;
    private PlatformSpecifierGUI platformSpecifierGUI;
    private Hausaufgaben hausaufgabenGUI;
    private OverviewGUI uebersichtGUI;
    private UniChooserGUI uniChooserGUI;
    private TimeChooserGUI timeChooserGUI;
    private final DBManager dbManager;
    private final UserManager userManager;

    public GUIManager (DBManager dbManager, UserManager userManager){
        super("DaPoLe Appday 2021");
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.dbManager = dbManager;
        this.userManager = userManager;

        URL iconURL = getClass().getResource("../../../DaPole.png");
        assert iconURL != null;
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        setupGUI();

        switchToLoginSignupGUI();
    }

    private void setupGUI(){
        loginSignupGUI = new LoginSignupGUI(this);
    }

    public void switchToLoginSignupGUI(){

        this.setContentPane(loginSignupGUI);
        this.revalidate();
    }

    public void switchToPlatformChooserGUI(User user){
        platformChooserGUI = new PlatformChooserGUI(this, user);
        this.setContentPane(platformChooserGUI);
        this.revalidate();
    }

    public void switchToHausaufgaben(){
        hausaufgabenGUI = new Hausaufgaben(this);
        this.setContentPane(hausaufgabenGUI);
        this.revalidate();
    }

    public void switchToUebersichtGUI(){
        uebersichtGUI = new OverviewGUI(this);
        this.setContentPane(uebersichtGUI);
        this.revalidate();
    }

    public void switchToPlatformSpecifierGUI(ArrayList<String> p, User user){
        platformSpecifierGUI = new PlatformSpecifierGUI(this, p, user);
        this.setContentPane(platformSpecifierGUI);
        this.revalidate();
    }

    public void switchToUniChooserGUI(User user){
        uniChooserGUI = new UniChooserGUI(this, user);
        this.setContentPane(uniChooserGUI);
        this.revalidate();
    }

    public void switchToTimeChooserGUI(User user){
        timeChooserGUI = new TimeChooserGUI(this, user);
        this.setContentPane(timeChooserGUI);
        this.revalidate();
    }
}

package de.dapole.gui.loginsignup;

import de.dapole.Application;
import de.dapole.gui.GUI;
import de.dapole.gui.GUIManager;
import de.dapole.util.TrustScore;
import de.dapole.util.user.User;
import de.dapole.util.user.UserManager;
import lombok.Getter;
import lombok.Setter;
import org.kordamp.ikonli.carbonicons.CarbonIcons;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class LoginSignupGUI extends GUI {
    private JPanel loginPanel;
    private JPanel signupPanel;
    private JTabbedPane tabPanel;
    private JPanel mainPanel;
    private JPasswordField loginPasswordField;
    private JButton loginButton;
    private JPanel loginSubPanel;
    private JLabel loginEmailLabel;
    private JLabel loginPasswordLabel;
    private JPasswordField signupPasswordOriginField;
    private JPasswordField signupPasswordCheckField;
    private JTextField signupFirstnameTextField;
    private JTextField signupSurnameTextField;
    private JButton signupButton;
    private JPanel signupSubPanel;
    private JLabel signupSurnameLabel;
    private JLabel signupFirstnameLabel;
    private JLabel signupEmailLabel;
    private JLabel signupPasswordOriginLabel;
    private JLabel signupPasswordCheckLabel;
    private JTextField loginEmailTextField;
    private JTextField signupEmailTextField;
    private JLabel signupErrorLabel;
    private JLabel loginErrorLabel;


    public LoginSignupGUI(GUIManager guiManager) {
        //jede GUI hat aehnlichen Konstruktor
        super(guiManager);
        this.setLayout(new GridLayout(1, 1));
        this.add(mainPanel);

        setupGUI();
        setupListeners();
    }

    private void setupGUI() {
        FontIcon loginIcon = new FontIcon();
        loginIcon.setIkon(CarbonIcons.LOGIN);
        loginIcon.setIconSize(25);
        tabPanel.addTab("Login", loginIcon, loginPanel);
        FontIcon signupIcon = new FontIcon();
        signupIcon.setIkon(CarbonIcons.SAVE);
        signupIcon.setIconSize(25);
        tabPanel.addTab("Signup", signupIcon, signupPanel);

        loginButton.setFont(getFont().deriveFont(Font.BOLD));
        signupButton.setFont(getFont().deriveFont(Font.BOLD));

        loginEmailLabel.setText("E-Mail");
        loginPasswordLabel.setText("Passwort");
        loginButton.setText("Login");

        signupSurnameLabel.setText("Name");
        signupFirstnameLabel.setText("Vorname");
        signupEmailLabel.setText("E-Mail");
        signupPasswordOriginLabel.setText("Passwort");
        signupPasswordCheckLabel.setText("<html> Passwort <br> wiederholen </html>");
        signupButton.setText("Signup");
    }

    private void setupListeners() {
        loginButton.addActionListener(e -> loginFunction());
        signupButton.addActionListener(e -> signupFunction());
    }

    private void signupFunction() {
        String surname = signupSurnameTextField.getText();
        String firstname = signupFirstnameTextField.getText();
        String email = signupEmailTextField.getText();
        String passwordOrigin = new String(signupPasswordOriginField.getPassword());
        String passwordCheck = new String(signupPasswordCheckField.getPassword());

        signupErrorLabel.setText("");

        if (!passwordOrigin.equals(passwordCheck)) {
            signupErrorLabel.setText("Passwörter stimmen nicht überein!");
            return;
        }

        User user = new User();
        TrustScore trustScore = new TrustScore();

        user.setSurname(surname);
        if(trustScore.isFullname(surname) && trustScore.isFullname(firstname)) {
            user.setTrustworthy(user.getTrustworthy()+2);
        } else {
            signupErrorLabel.setText("Bitte gib einen korrekten Namen an!");
            return;
        }
        user.setPrename(firstname);
        user.setEmail(email);
        if(trustScore.validate(email)) {
            user.setTrustworthy(user.getTrustworthy() + 1);
        } else {
            signupErrorLabel.setText("Bitte gib eine korrekte Email an!");
            return;
        }
        if(passwordOrigin.length() >= 4) {
            user.setPassword(passwordOrigin);
        } else {
            signupErrorLabel.setText("Bitte gib ein Passwort länger als Vier ein!");
            return;
        }

        // TODO: Check if email already registered
        if (getGuiManager().getUserManager().checkEmailInUse(email)) {
            signupErrorLabel.setText("Email schon vergeben!");
            return;
        }

        getGuiManager().setThisUser(user);
        getGuiManager().switchToPlatformChooserGUI(user);
    }

    private void loginFunction() {
        String email = loginEmailTextField.getText();
        String password = new String(loginPasswordField.getPassword());
        UserManager userManager = getGuiManager().getUserManager();

        User user = userManager.retrieveUser(userManager.getIDFromEmail(email));
        Application.getApplication().user = user;
        // TODO: Switch to Overview
        if (user.getPassword() != null) {
            if (user.getPassword().equals(password)) {
                getGuiManager().setThisUser(user);
                getGuiManager().switchToOverviewGUI();
            }
        } else {
            loginErrorLabel.setText("Falsche Anmeldedaten");
        }

    }
}

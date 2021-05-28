package de.dapole.gui;

import lombok.Getter;
import lombok.Setter;
import org.kordamp.ikonli.carbonicons.CarbonIcons;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class LoginSignupGUI extends GUI{
    private JPanel loginPanel;
    private JPanel signupPanel;
    private JTabbedPane tabPanel;
    private JPanel mainPanel;
    private JTextField loginSurnameTextField;
    private JTextField loginFirstnameTextField;
    private JPasswordField loginPasswordField;
    private JFormattedTextField loginEmailFormattedTextField;
    private JButton loginButton;
    private JPanel loginSubPanel;
    private JLabel loginSurnameLabel;
    private JLabel loginFirstnameLabel;
    private JLabel loginEmailLabel;
    private JLabel loginPasswordLabel;
    private JPasswordField signupPasswordOriginField;
    private JPasswordField signupPasswordCheckField;
    private JFormattedTextField signupEmailFormattedTextField;
    private JTextField signupFirstnameTextField;
    private JTextField signupSurnameTextField;
    private JButton signupButton;
    private JPanel signupSubPanel;
    private JLabel signupSurnameLabel;
    private JLabel signupFirstnameLabel;
    private JLabel signupEmailLabel;
    private JLabel signupPasswordOriginLabel;
    private JLabel signupPasswordCheckLabel;

    public LoginSignupGUI(GUIManager manager){
        super(manager);
        this.setLayout(new GridLayout(1,1));
        this.add(mainPanel);

        setupGUI();
    }

    private void setupGUI(){
        FontIcon loginIcon = new FontIcon();
        loginIcon.setIkon(CarbonIcons.LOGIN);
        loginIcon.setIconSize(25);
        tabPanel.addTab("Login", loginIcon, loginPanel);
        FontIcon signupIcon = new FontIcon();
        signupIcon.setIkon(CarbonIcons.SAVE);
        signupIcon.setIconSize(25);
        tabPanel.addTab("Signup", signupIcon, signupPanel);

        loginSurnameLabel.setText("Name");
        loginFirstnameLabel.setText("Vorname");
        loginEmailLabel.setText("E-Mail");
        loginPasswordLabel.setText("Passwort");
        loginButton.setText("Login");

        signupSurnameLabel.setText("Name");
        signupFirstnameLabel.setText("Vorname");
        signupEmailLabel.setText("E-Mail");
        signupPasswordOriginLabel.setText("Passwort");
        signupPasswordCheckLabel.setText("<html> Passwort <br> wiederholen </html>");
        signupButton.setText("Login");
    }
}

package de.dapole.gui;

import de.dapole.database.DBManager;
import de.dapole.gui.loginsignup.*;
import de.dapole.util.ModuleInfo;
import de.dapole.util.homework.HomeworkManager;
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
    private HomeworkGUI hausaufgabenGUI;
    private NoticeGUI noticeGUI;
    private OverviewGUI overviewGUI;
    private UniChooserGUI uniChooserGUI;
    private TimeChooserGUI timeChooserGUI;
    private QuestionGUI questionGUI;
    private ProfileGUI profileGUI;
    private LeaderboardGUI leaderboardGUI;
    private NewHomeWorkGUI newHomeWorkGUI;
    private OwnHomeWorkGUI ownHomeWorkGUI;
    private BrowserHelpGUI browserHelpGUI;
    private final DBManager dbManager;
    private final UserManager userManager;
    private final HomeworkManager homeworkManager;
    private final ModuleInfo moduleInfo;
    public User thisUser;
    public int tutorlearn = 0;

    //this is where the magic happens. Window manager der das Umschalten zwischen verschiedenen Punkten ermoeglicht.
    public GUIManager (DBManager dbManager, UserManager userManager, HomeworkManager homeworkManager, ModuleInfo moduleInfo){
        super("DaPoLe Appday 2021");
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.dbManager = dbManager;
        this.userManager = userManager;
        this.homeworkManager = homeworkManager;
        this.moduleInfo = moduleInfo;

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

    //switchTo[Platzhalter]GUI wird in den GUIs zum Wechsel aufgerufen

    public void switchToPlatformChooserGUI(User user){
        platformChooserGUI = new PlatformChooserGUI(this, user);
        this.setContentPane(platformChooserGUI);
        this.revalidate();
    }

    public void switchToHausaufgaben(){
        hausaufgabenGUI = new HomeworkGUI(this);
        this.setContentPane(hausaufgabenGUI);
        this.revalidate();
    }
    public void switchToNoticeGUI(){
        noticeGUI = new NoticeGUI(this);
        this.setContentPane(noticeGUI);
        this.revalidate();
    }
    public void switchToOverviewGUI(){
        overviewGUI = new OverviewGUI(this);
        this.setContentPane(overviewGUI);
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

    public void switchToQuestionGUI(User user){
        questionGUI = new QuestionGUI(this,user);
        this.setContentPane(questionGUI);
        this.revalidate();
    }

    public void switchToNewHomeWorkGUI() {
        newHomeWorkGUI = new NewHomeWorkGUI(this);
        this.setContentPane(newHomeWorkGUI);
        this.revalidate();
    }

    public void switchToProfileGUI() {
        thisUser = getUserManager().retrieveUser(thisUser.getUserid());
        profileGUI = new ProfileGUI(this);
        this.setContentPane(profileGUI);
        this.revalidate();
    }

    public void switchToLeaderboardGUI(int tutorlearn) {
        leaderboardGUI = new LeaderboardGUI(this, tutorlearn);
        this.setContentPane(leaderboardGUI);
        this.revalidate();
    }

    public void switchToBrowseHelpGUI() {
        browserHelpGUI = new BrowserHelpGUI(this);
        this.setContentPane(browserHelpGUI);
        this.revalidate();
    }

    public void switchToOwnHomeWorkGUI() {
        ownHomeWorkGUI = new OwnHomeWorkGUI(this);
        this.setContentPane(ownHomeWorkGUI);
        this.revalidate();
    }
}

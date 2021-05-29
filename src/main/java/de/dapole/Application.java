package de.dapole;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import de.dapole.database.AsyncMySQL;
import de.dapole.database.DBManager;
import de.dapole.gui.GUIManager;
import de.dapole.util.ModuleInfo;
import de.dapole.util.group.GroupManager;
import de.dapole.util.homework.HomeworkManager;
import de.dapole.util.user.User;
import de.dapole.util.user.UserManager;

import javax.swing.*;
import java.awt.*;

public class Application {

    private DBManager dbManager;
    private AsyncMySQL mySQL;

    private UserManager userManager;
    private HomeworkManager homeworkManager;
    private GroupManager groupManager;
    private ModuleInfo moduleInfo;

    public static Application application;
    public User user;

    public void onStart() {

        application = this;

        FlatArcOrangeIJTheme.setup();
        UIManager.put( "Button.arc", 999 );
        UIManager.put( "Component.arc", 999 );
        UIManager.put( "ProgressBar.arc", 999 );
        UIManager.put( "TextComponent.arc", 999 );
        UIManager.put( "TabbedPane.selectedBackground", Color.white );
        UIManager.put( "TabbedPane.showTabSeparators", true );
        UIManager.put("Button.endBackground", UIManager.getLookAndFeelDefaults().getColor("Button.hoverBorderColor"));
        UIManager.put("Button.default.startBackground", UIManager.getLookAndFeelDefaults().getColor("Button.hoverBorderColor"));
        UIManager.put("MenuBar.background", UIManager.getLookAndFeelDefaults().getColor("Button.hoverBorderColor").brighter().brighter());
        UIManager.put("MenuBar.hoverBackground", UIManager.getLookAndFeelDefaults().getColor("Button.hoverBorderColor").brighter());

        dbManager = new DBManager();
        mySQL = dbManager.initTables();

        userManager = new UserManager(mySQL);
        homeworkManager = new HomeworkManager(mySQL);
        groupManager = new GroupManager(mySQL);
        moduleInfo = new ModuleInfo(mySQL);
        dbManager.setUsermg(userManager);

        new GUIManager(dbManager, userManager, homeworkManager, moduleInfo);
    }

    public static Application getApplication() {
        return application;
    }
}

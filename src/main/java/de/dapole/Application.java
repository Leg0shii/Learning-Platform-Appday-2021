package de.dapole;

import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import de.dapole.database.AsyncMySQL;
import de.dapole.database.DBManager;
import de.dapole.gui.GUIManager;
import de.dapole.util.group.Group;
import de.dapole.util.group.GroupManager;
import de.dapole.util.homework.HomeworkManager;
import de.dapole.util.user.User;
import de.dapole.util.user.UserManager;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Set;

public class Application {

    private DBManager dbManager;
    private AsyncMySQL mySQL;

    private UserManager userManager;
    private HomeworkManager homeworkManager;
    private GroupManager groupManager;

    public void onStart() {

        FlatArcIJTheme.setup();
        UIManager.put( "Button.arc", 999 );
        UIManager.put( "Component.arc", 999 );
        UIManager.put( "ProgressBar.arc", 999 );
        UIManager.put( "TextComponent.arc", 999 );
        UIManager.put( "TabbedPane.selectedBackground", Color.white );
        UIManager.put( "TabbedPane.showTabSeparators", true );
        UIManager.put("Button.endBackground", UIManager.getLookAndFeelDefaults().getColor("Button.hoverBorderColor"));
        UIManager.put("Button.default.startBackground", UIManager.getLookAndFeelDefaults().getColor("Button.hoverBorderColor"));

        dbManager = new DBManager(userManager);
        mySQL = dbManager.initTables();

        userManager = new UserManager(mySQL);
        homeworkManager = new HomeworkManager(mySQL);
        groupManager = new GroupManager(mySQL);

        new GUIManager(dbManager, userManager);
    }
}

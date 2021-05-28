package de.dapole;

import com.formdev.flatlaf.intellijthemes.FlatSolarizedDarkIJTheme;
import de.dapole.database.AsyncMySQL;
import de.dapole.database.DBManager;
import de.dapole.gui.GUIManager;
import de.dapole.util.group.Group;
import de.dapole.util.group.GroupManager;
import de.dapole.util.homework.HomeworkManager;
import de.dapole.util.user.User;
import de.dapole.util.user.UserManager;

public class Application {
    public static void main(String[] args) {
        FlatSolarizedDarkIJTheme.setup();

        DBManager dbManager = new DBManager();
        AsyncMySQL mySQL = dbManager.initTables();

        UserManager userManager = new UserManager(mySQL);
        HomeworkManager homeworkManager = new HomeworkManager(mySQL);
        GroupManager groupManager = new GroupManager(mySQL);

        new GUIManager();
    }
}

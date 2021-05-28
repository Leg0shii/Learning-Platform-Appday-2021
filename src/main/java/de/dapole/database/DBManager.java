package de.dapole.database;

import de.dapole.util.group.Group;
import de.dapole.util.homework.Homework;
import de.dapole.util.user.User;

import java.sql.SQLException;

public class DBManager {

    private AsyncMySQL mySQL;

    private void connectToDB() {

        try {
            this.mySQL = new AsyncMySQL("5.196.174.213", 3306, "root", "qexGGHZfFzWyKYE", "appdaydb");
            System.out.println("Successfully connected to database!");
        } catch (SQLException | ClassNotFoundException throwables) { throwables.printStackTrace(); }

    }

    public AsyncMySQL initTables() {

        connectToDB();

        // modules
        // mathe1;mathe2;mathe3 ...
        mySQL.update("CREATE TABLE IF NOT EXISTS unidb (uniid INT AUTO_INCREMENT, uniname VARCHAR(255), modulname VARCHAR(255), modules VARCHAR(500), PRIMARY KEY(uniid));");

        // mathe1:0;mathe2:1; ...
        // zeit: 0;3;4;5;6
        mySQL.update("CREATE TABLE IF NOT EXISTS users (userid INT AUTO_INCREMENT" +
            ", prename VARCHAR(255), surname VARCHAR(255), email VARCHAR(255), upassword VARCHAR(255), whatsapp VARCHAR(255)" +
            ", discord VARCHAR(255), telegram VARCHAR(255), uni VARCHAR(255), modulename VARCHAR(255), utime VARCHAR(255)" +
            ", levelpublic INT, moduleinfo VARCHAR(255), exptutor DOUBLE(12,4), explearning DOUBLE(12,4), leveltutor INT, levellearning INT, searching INT, PRIMARY KEY(userid));");

        // type : 0 - brauche hilfe, type : 1 - biete hilfe
        // done : 0 - false, done : 1 - true
        mySQL.update("CREATE TABLE IF NOT EXISTS hwrequest (hwid INT AUTO_INCREMENT, modulename VARCHAR(255), title VARCHAR(255), type INT, done INT, PRIMARY KEY(hwid));");

        mySQL.update("CREATE TABLE IF NOT EXISTS groups (groupid INT AUTO_INCREMENT, participants VARCHAR(255), PRIMARY KEY(groupid));");

        return mySQL;
    }

    public void addUniDatabase(String uniname, String submodules) {

        mySQL.update("INSERT INTO unidb (uniname, modules) VALUES ('" + uniname + "', '" + submodules + "');");
    }

    public void addStudent(User user) {

        mySQL.update("INSERT INTO users (prename, surname, email, upassword, whatsapp, discord, telegram, uni, modulename, utime, levelpublic, moduleinfo, exptutor, explearning, leveltutor, levellearning, searching) VALUES " +
            "('" + user.getPrename() + "', '" + user.getSurname() + "', '" + user.getEmail() + "', '" + user.getPassword() + "','" + user.getWhatsapp() + "' , '" + user.getDiscord() + "'," +
            "'" + user.getTelegram() + "', '" + user.getUni() + "', '" + user.getModule() + "', '" + user.getTime() + "', " + user.getLevelpublic() + ", '" + user.getModuleInfo() + "'," +
            "" + user.getExpTutor() + ", " + user.getExpLearning() + "," + user.getLevelTutor() + "," + user.getLevelLearning() + ", " + user.getSearching() + ");");
    }

    public void addHomework(Homework homework) {

        mySQL.update("INSERT INTO hwrequest (modulename, title, type, done) VALUES ('" + homework.getModule() + "', '"
            + homework.getTitle() + "', '" + homework.getType() + "', " + homework.getDone() + ");");
    }

    public void addGroup(Group group) {

        mySQL.update("INSERT INTO groups (participants) VALUES ('" + group.getParticipants() + "');");
    }

    public void setHomeworkDone(int hwid) {

        mySQL.update("UPDATE hwrequest SET done = 1 WHERE hwid = " + hwid + ";");
    }

    public void setSearchingDone(int userid) {

        mySQL.update("UPDATE users SET searching = 1 WHERE userid = " + userid + ";");
    }

}


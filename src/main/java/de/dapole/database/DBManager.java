package de.dapole.database;

import de.dapole.util.User;

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
        mySQL.update("CREATE TABLE IF NOT EXISTS unidb (uniid INT, uniname VARCHAR(255), modulname VARCHAR(255), modules VARCHAR(500), PRIMARY KEY(uniid)");

        // mathe1:0;mathe2:1; ...
        // zeit: 0;3;4;5;6
        mySQL.update("CREATE TABLE IF NOT EXISTS users (userid INT AUTO_INCREMENT" +
            ", vorname VARCHAR(255), nachname VARCHAR(255), email VARCHAR(255), passwort VARCHAR(255), whatsapp VARCHAR(255)" +
            ", discord VARCHAR(255), telegram VARCHAR(255), uni VARCHAR(255), modulname VARCHAR(255), zeit VARCHAR(255)" +
            ", leveloeffentlich INT, studienganginfo VARCHAR(500), PRIMARY KEY(userid);");

        return mySQL;
    }

    public void addUniDatabase(String uniname, String submodules) {

        mySQL.update("INSERT INTO unidb (uniname, modules) VALUES ('" + uniname + "', '" + submodules + "');");
    }

    public void addStudent(User user) {

        mySQL.update("INSERT INTO users (vorname, nachname, email, passwort, whatsapp, discord, telegram, uni, modulname, zeit, leveloeffentlich, studenganginfo) VALUES " +
            "('" + user.getPrename() + "', '" + user.getSurname() + "', '" + user.getEmail() + "', '" + user.getPassword() + "','" + user.getWhatsapp() + "' , '" + user.getDiscord() + "'," +
            "'" + user.getTelegram() + "', '" + user.getUni() + "', '" + user.getModule() + "', '" + user.getTime() + "', " + user.getLevelpublic() + ", '" + user.getModuleInfo() + "');");
    }

}


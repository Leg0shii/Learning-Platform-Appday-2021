package de.dapole.util.homework;

import de.dapole.database.AsyncMySQL;
import lombok.RequiredArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@RequiredArgsConstructor
public class HomeworkManager {

    private final AsyncMySQL mySQL;

    //alle Homeworks aus der Datenbank holen
    public ArrayList<Homework> getAllHomeworks() {

        ArrayList<Homework> homeworkList = new ArrayList<>();
        ResultSet resultSet = mySQL.query("SELECT hwid FROM hwrequest;");
        try {
            while (resultSet.next()) homeworkList.add(retrieveHomework(resultSet.getInt("hwid")));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return homeworkList;
    }

    //alle eigenen Hilfeanfragen aus der Datenbank bekommen
    public ArrayList<Homework> getAllMyHomeworks(int userid) {

        ArrayList<Homework> homeworkList = new ArrayList<>();
        ResultSet resultSet = mySQL.query("SELECT hwid FROM hwrequest where userid = " + userid + ";");
        try {
            while (resultSet.next()) homeworkList.add(retrieveHomework(resultSet.getInt("hwid")));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return homeworkList;
    }

    //bestimmte Hilfeanfrage aus Datenbank holen
    public Homework retrieveHomework(int hwid) {

        ResultSet resultSet = mySQL.query("SELECT * FROM hwrequest where hwid = " + hwid + ";");
        Homework homework = new Homework();

        try {
            if (resultSet.next()) {

                homework.setHwid(Integer.parseInt(resultSet.getString("hwid")));
                homework.setModule(resultSet.getString("modulename"));
                homework.setTitle(resultSet.getString("title"));
                homework.setType(resultSet.getInt("type"));
                homework.setDone(resultSet.getInt("done"));
                homework.setUserid(resultSet.getInt("userid"));
                homework.setHelperids(getHelperIds(resultSet.getString("helperids")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return homework;
    }

    //hilfsbereite Studierende extrahieren
    public ArrayList<Integer> getHelperIds(String helpers) {

        String[] hs = helpers.split(";");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String h : hs) {
            if (!h.equals("")) {
                arrayList.add(Integer.parseInt(h));
            }
        }
        return arrayList;
    }

}

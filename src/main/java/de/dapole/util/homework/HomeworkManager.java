package de.dapole.util.homework;

import de.dapole.database.AsyncMySQL;
import lombok.RequiredArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@RequiredArgsConstructor
public class HomeworkManager {

    private final AsyncMySQL mySQL;

    public ArrayList<Homework> getAllHomeworks() {

        ArrayList<Homework> homeworkList = new ArrayList<>();
        ResultSet resultSet = mySQL.query("SELECT hwid FROM hwrequest;");
        try {
            while (resultSet.next()) homeworkList.add(retrieveHomework(resultSet.getInt("hwid")));
        } catch (SQLException e) { e.printStackTrace(); }

        return homeworkList;
    }

    public Homework retrieveHomework(int hwid) {

        ResultSet resultSet = mySQL.query("SELECT * FROM hwrequest where hwid = " + hwid + ";");
        Homework homework = new Homework();

        try {
            if(resultSet.next()) {

                homework.setModule(resultSet.getString("modulename"));
                homework.setTitle(resultSet.getString("title"));
                homework.setType(resultSet.getInt("type"));
                homework.setDone(resultSet.getInt("done"));
                homework.setUserid(resultSet.getInt("userid"));
                homework.setHelperids(getHelperIds(resultSet.getString("helperids")));
            }
        } catch (SQLException e) { e.printStackTrace(); }

        return homework;
    }

    public ArrayList<Integer> getHelperIds(String helpers) {

        String[] hs = helpers.split(";");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(String h : hs) arrayList.add(Integer.parseInt(h));
        return arrayList;
    }

}

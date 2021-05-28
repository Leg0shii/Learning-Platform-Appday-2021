package de.dapole.util.homework;

import de.dapole.database.AsyncMySQL;
import lombok.RequiredArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
public class HomeworkManager {

    private final AsyncMySQL mySQL;

    public Homework retrieveHomework(int hwid) {

        ResultSet resultSet = mySQL.query("SELECT * FROM hwrequest where hwid = " + hwid + ";");
        Homework homework = new Homework();

        try {
            if(resultSet.next()) {

                homework.setModule(resultSet.getString("modulename"));
                homework.setTitle(resultSet.getString("title"));
                homework.setType(resultSet.getInt("type"));
                homework.setDone(resultSet.getInt("done"));
            }
        } catch (SQLException e) { e.printStackTrace(); }

        return homework;
    }
}

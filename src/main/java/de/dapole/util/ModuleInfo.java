package de.dapole.util;

import de.dapole.database.AsyncMySQL;
import lombok.RequiredArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

@RequiredArgsConstructor
public class ModuleInfo {

    private final AsyncMySQL mySQL;

    public Stack<String> getQuestions(String modulename) {

        Stack<String> arrayList = new Stack<>();
        ResultSet resultSet = mySQL.query("SELECT modules FROM unidb WHERE modulname = '" + modulename + "';");
        try {
            if (resultSet.next()) {
                String[] modules = resultSet.getString("modules").split(";");
                arrayList.addAll(Arrays.asList(modules));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrayList;
    }

    public String setAnswersToQuestions(ArrayList<String> modules, ArrayList<Integer> answers) {

        int length = modules.size();
        String query = "";

        for (int i = 0; i < length; i++) {
            query = modules.get(i) + ":" + answers.get(i) + ";" + query;
        }

        return query;
    }

}

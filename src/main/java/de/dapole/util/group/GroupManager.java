package de.dapole.util.group;

import de.dapole.database.AsyncMySQL;
import lombok.RequiredArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
public class GroupManager {

    private final AsyncMySQL mySQL;

    public Group retrieveGroups(int groupid) {

        ResultSet resultSet = mySQL.query("SELECT * FROM groups where groupid = " + groupid + ";");
       Group group = new Group();

        try {
            if(resultSet.next()) {

                group.setParticipants(resultSet.getString("participants"));
            }
        } catch (SQLException e) { e.printStackTrace(); }

        return group;
    }

}

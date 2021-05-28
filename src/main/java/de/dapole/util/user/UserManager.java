package de.dapole.util.user;

import de.dapole.database.AsyncMySQL;
import lombok.RequiredArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
public class UserManager {

    private final AsyncMySQL mySQL;

    public User retrieveUser(int userid) {

        ResultSet resultSet = mySQL.query("SELECT * FROM users where userid = " + userid + ";");
        User user = new User();

        try {
            if(resultSet.next()) {

                user.setPrename(resultSet.getString("prename"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setWhatsapp(resultSet.getString("whatsapp"));
                user.setDiscord(resultSet.getString("discord"));
                user.setTelegram(resultSet.getString("telegram"));
                user.setUni(resultSet.getString("uni"));
                user.setModule(resultSet.getString("modulename"));
                user.setTime(resultSet.getString("time"));
                user.setLevelpublic(resultSet.getInt("levelpublic"));
                user.setModuleInfo(resultSet.getString("moduleinfo"));
                user.setExpTutor(resultSet.getFloat("exptutor"));
                user.setExpLearning(resultSet.getFloat("explearning"));
                user.setLevelLearning(resultSet.getInt("levellearning"));
                user.setLevelTutor(resultSet.getInt("leveltutor"));
                user.setSearching(resultSet.getInt("searching"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return user;
    }

}

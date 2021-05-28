package de.dapole.util.user;

import de.dapole.database.AsyncMySQL;
import lombok.RequiredArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@RequiredArgsConstructor
public class UserManager {

    private final AsyncMySQL mySQL;

    public User retrieveUser(String email) {

        ResultSet resultSet = mySQL.query("SELECT * FROM users where email = " + email + ";");
        User user = new User();

        try {
            if(resultSet.next()) {

                user.setPrename(resultSet.getString("prename"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("upassword"));
                user.setWhatsapp(resultSet.getString("whatsapp"));
                user.setDiscord(resultSet.getString("discord"));
                user.setTelegram(resultSet.getString("telegram"));
                user.setUni(resultSet.getString("uni"));
                user.setModule(resultSet.getString("modulename"));
                user.setTime(resultSet.getString("utime"));
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

    public boolean checkEmailInUse(String email) {

        ResultSet resultSet = mySQL.query("SELECT * FROM users where email = " + email + ";");
        try { return resultSet.next(); }
        catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

}

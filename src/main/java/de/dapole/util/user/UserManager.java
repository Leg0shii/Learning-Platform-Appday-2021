package de.dapole.util.user;

import de.dapole.database.AsyncMySQL;
import de.dapole.util.Leveling;
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
                user.setTrustworthy(resultSet.getInt("trustworthy"));
                user.setUserid(resultSet.getInt("userid"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return user;
    }

    public boolean checkEmailInUse(String email) {

        ResultSet resultSet = mySQL.query("SELECT * FROM users where email = '" + email + "';");
        try { return resultSet.next(); }
        catch (SQLException e) { e.printStackTrace(); }
        return false;
    }

    public void updateEXP(int userid, int gainedEXP, int type) {

        if(type == 0) { // tutor
            ResultSet resultSet = mySQL.query("SELECT exptutor, leveltutor FROM users WHERE userid = " + userid + ";");
            try {
                if(resultSet.next()) {
                    float currentEXP = resultSet.getFloat("exptutor");
                    int leveltutor = resultSet.getInt("leveltutor");
                    if(currentEXP + gainedEXP >= Leveling.calcNextLevelEXP(leveltutor)) {
                        // levelup
                        float over = (currentEXP + gainedEXP - Leveling.calcNextLevelEXP(leveltutor));
                        mySQL.update("UPDATE users SET exptutor = " + over + ", leveltutor = " + (leveltutor + 1) + " WHERE userid = " + userid + ";");
                    } else {
                        // add gainedEXP
                        mySQL.update("UPDATE users SET exptutor = " + (currentEXP + gainedEXP) + " WHERE userid = " + userid + ";");
                    }
                }
            } catch (SQLException e) { e.printStackTrace(); }
        } else if(type == 1) { // learning
            ResultSet resultSet = mySQL.query("SELECT explearning, levellearning FROM users WHERE userid = " + userid + ";");
            try {
                if(resultSet.next()) {
                    float currentEXP = resultSet.getFloat("explearning");
                    int leveltutor = resultSet.getInt("levellearning");
                    if(currentEXP + gainedEXP >= Leveling.calcNextLevelEXP(leveltutor)) {
                        // levelup
                        float over = (currentEXP + gainedEXP - Leveling.calcNextLevelEXP(leveltutor));
                        mySQL.update("UPDATE users SET explearning = " + over + ", levellearning = " + (leveltutor + 1) + " WHERE userid = " + userid + ";");
                    } else {
                        // add gainedEXP
                        mySQL.update("UPDATE users SET explearning = " + (currentEXP + gainedEXP) + " WHERE userid = " + userid + ";");
                    }
                }
            } catch (SQLException e) { e.printStackTrace(); }

        }

    }

    public int getIDFromEmail(String email) {

        int userid = -1;
        ResultSet resultSet = mySQL.query("SELECT userid FROM users WHERE email = '" + email + "';");
        try {
            if(resultSet.next()) {
                userid = resultSet.getInt("userid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userid;
    }
}

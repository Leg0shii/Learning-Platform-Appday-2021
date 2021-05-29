package de.dapole.util.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int userid;

    private String prename;
    private String surname;
    private String uni;
    private String module;
    private String email;
    private String password;

    private String whatsapp;
    private String telegram;
    private String discord;

    private int searching;

    private float expTutor;
    private int levelTutor;
    private float expLearning;
    private int levelLearning;
    private int trustworthy;

    private String moduleInfo;
    private String time;
    private int levelpublic;

                                                //ist das nicht effektiv 2*x / 2 = x ???
    public int getCumulatedLevel(){
        return (levelLearning + levelLearning)/2;
    }

    public boolean isTrustworthy() {
        return trustworthy >= 6;
    }

}

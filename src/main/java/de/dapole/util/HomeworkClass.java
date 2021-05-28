package de.dapole.util;

import de.dapole.util.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter

public class HomeworkClass {

    User questioner;
    String theme;
    String exact;

    ArrayList<User> answerer;

    public HomeworkClass(User questioner, String theme, String exact){
        this.questioner = questioner;
        this.theme = theme;
        this.exact = exact;
    }

    public void addAnswerer(User answerer){
        this.answerer.add(answerer);
    }

}

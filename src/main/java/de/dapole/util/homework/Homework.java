package de.dapole.util.homework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Homework {

    private int userid;
    private ArrayList<Integer> helperids;
    private String module;
    private String title;
    private int type;
    private int done;

}

package de.dapole.util.homework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Homework {

    private String module;
    private String title;
    private int type;
    private int done;

}

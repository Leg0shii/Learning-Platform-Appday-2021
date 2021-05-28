package de.dapole.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String prename;
    private String surname;
    private String uni;
    private String module;
    private String email;
    private String password;

    private String whatsapp;
    private String telegram;
    private String discord;

    private String time;
    private int levelpublic;

}

package de.dapole;

import com.formdev.flatlaf.intellijthemes.FlatSolarizedDarkIJTheme;

public class Application {
    public static void main(String[] args) {
        FlatSolarizedDarkIJTheme.setup();


        new GUIManager();
    }
}

package de.dapole;

import com.formdev.flatlaf.intellijthemes.FlatSolarizedDarkIJTheme;
import de.dapole.gui.GUIManager;

public class Application {
    public static void main(String[] args) {
        FlatSolarizedDarkIJTheme.setup();


        new GUIManager();
    }
}

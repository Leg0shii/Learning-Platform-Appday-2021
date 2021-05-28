import com.formdev.flatlaf.intellijthemes.FlatSolarizedDarkIJTheme;
import gui.GUIManager;

public class Application {
    public static void main(String[] args) {
        FlatSolarizedDarkIJTheme.setup();


        new GUIManager();
    }
}

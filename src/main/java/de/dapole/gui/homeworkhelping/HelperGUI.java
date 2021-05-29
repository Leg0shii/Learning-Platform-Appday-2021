package de.dapole.gui.homeworkhelping;

import de.dapole.gui.GUI;
import de.dapole.gui.GUIManager;
import de.dapole.util.Leveling;
import de.dapole.util.homework.Homework;
import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HelperGUI extends GUI {
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private JPanel view;
    private Homework hw;

    public HelperGUI(GUIManager guiManager, Homework hw) {
        super(guiManager);
        this.setLayout(new GridLayout(1, 1));
        add(mainPanel);
        this.hw = hw;
        view = new JPanel();
        scrollPane.setViewportView(view);

        setupGUI();
        setupListeners();
    }

    private void setupGUI() {
        if (hw.getHelperids().isEmpty()) {
            JLabel label = new JLabel("Dir hat noch keiner seine Hilfe angeboten");
            view.add(label);
        }
        for (int id : hw.getHelperids()) {
            User helper = getGuiManager().getUserManager().retrieveUser(id);
            JLabel label = new JLabel("<html>" + helper.getPrename() + " " + helper.getSurname() + " möchte dir helfen. Hier sind die Kontaktmöglichkeiten:<br>Discord: " + helper.getDiscord() + " Whatsapp: " + helper.getWhatsapp() + " Telegram: " + helper.getTelegram() + "</html>");
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    rateFunction(hw);
                }
            });
            view.add(label);
        }
    }

    private void rateFunction(Homework hw) {
        for (int id : hw.getHelperids()) {
            User user = getGuiManager().getUserManager().retrieveUser(id);
            String returnVal = JOptionPane.showInputDialog("Wie würdest du seine Hilfe bewerten? (0,1,2,...,10)");
            if (returnVal != null) {
                int rating = -1;
                try {
                    rating = Integer.parseInt(returnVal);
                } catch (Exception ignored) {
                }
                if (rating > -1 && rating < 11) {
                    getGuiManager().getUserManager().updateEXP(user.getUserid(), Leveling.pointsToEXP(rating), 0);
                    getGuiManager().getDbManager().setHomeworkDone(hw.getHwid());
                    getGuiManager().getOwnHomeWorkGUI().updateGUI();
                    getGuiManager().revalidate();
                } else {
                    JOptionPane.showMessageDialog(null, "Rating zu hoch oder zu niedrig!");
                }
            }
        }
    }

    private void setupListeners() {

    }
}

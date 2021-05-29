package de.dapole.gui.loginsignup;

import de.dapole.Application;
import de.dapole.gui.GUI;
import de.dapole.gui.GUIManager;
import de.dapole.util.ModuleInfo;
import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class QuestionGUI extends GUI {
    private JPanel mainPanel;
    private JPanel subPanel;
    private JButton yesButton;
    private JButton noButton;
    private JLabel questionLabel;
    private JPanel subSubPanel;
    private User user;
    private Stack<String> questions;
    private ArrayList<String> modules;
    private ArrayList<Integer> answers;

    public QuestionGUI(GUIManager guiManager, User user) {
        super(guiManager);
        this.user = user;
        this.setLayout(new GridLayout(1, 1));
        add(mainPanel);
        this.answers = new ArrayList<>();
        this.modules = new ArrayList<>();

        this.questions = guiManager.getModuleInfo().getQuestions(user.getModule());

        setupGUI();
        setupListeners();
    }

    private void setupGUI() {

        yesButton.setText("Kann ich gut");
        noButton.setText("Kann ich nicht so gut");
        yesButton.setBackground(Color.GREEN);
        noButton.setBackground(Color.RED);
        String question = questions.pop();
        modules.add(question);
        questionLabel.setFont(getFont().deriveFont(Font.BOLD,20));
        questionLabel.setText(question);
        subSubPanel.setBorder(BorderFactory.createEtchedBorder());
    }

    private void setupListeners(){
        yesButton.addActionListener(e -> yesFunction());
        noButton.addActionListener(e -> noFunction());
    }

    private void backFunction() {
        getGuiManager().switchToTimeChooserGUI(user);
    }

    private void noFunction() {
        answers.add(0);
        if (!questions.isEmpty()){
            String question = questions.pop();
            modules.add(question);
            questionLabel.setText(question);
        } else {
            user.setModuleInfo(getGuiManager().getModuleInfo().setAnswersToQuestions(modules,answers));
            getGuiManager().getDbManager().addStudent(user);

            user.setUserid(getGuiManager().getUserManager().getIDFromEmail(user.getEmail()));
            Application.getApplication().user = user;

            getGuiManager().switchToOverviewGUI();
        }
    }

    private void yesFunction() {
        answers.add(1);
        if (!questions.isEmpty()){
            String question = questions.pop();
            modules.add(question);
            questionLabel.setText(question);
        } else {
            user.setModuleInfo(getGuiManager().getModuleInfo().setAnswersToQuestions(modules,answers));
            getGuiManager().getDbManager().addStudent(user);

            user.setUserid(getGuiManager().getUserManager().getIDFromEmail(user.getEmail()));
            Application.getApplication().user = user;

            getGuiManager().switchToNoticeGUI();
        }
    }
}

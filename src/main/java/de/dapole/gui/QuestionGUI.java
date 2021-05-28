package de.dapole.gui;

import de.dapole.util.ModuleInfo;
import de.dapole.util.user.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class QuestionGUI extends GUI{
    private JPanel mainPanel;
    private JPanel subPanel;
    private JButton yesButton;
    private JButton noButton;
    private JLabel questionLabel;
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
        yesButton.setText("Ja");
        noButton.setText("Nein");
        yesButton.putClientProperty("JComponent.roundRect", false);
        String question = questions.pop();
        modules.add(question);
        questionLabel.setText(question);
    }

    private void setupListeners(){
        yesButton.addActionListener(e -> yesFunction());
        noButton.addActionListener(e -> noFunction());
    }

    private void noFunction() {
        answers.add(0);
        if (!questions.isEmpty()){
            String question = questions.pop();
            modules.add(question);
            questionLabel.setText(question);
        } else {
            user.setModuleInfo(getGuiManager().getModuleInfo().setAnswersToQuestions(modules,answers));
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
        }
    }
}

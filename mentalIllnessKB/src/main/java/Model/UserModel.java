package Model;

import java.util.Observable;
import java.util.*;
import java.util.ArrayList;

public class UserModel extends Observable implements Observer {
    private List<String> questions = new ArrayList<>();
    private List<ArrayList<String>> answers = new ArrayList<ArrayList<String>>();
    public UserModel() {
        this.setChanged();
        this.notifyObservers();
        questions.add("Do you want to run the program for self-use, or do you want to" +
                " use the program as a supervisor?");
        questions.add("Question 1");
        questions.add("Question 2");
        questions.add("Question 3");
        questions.add("Question 4");
        questions.add("Question 5");
        questions.add("Question 6");

        ArrayList<String> firstQAnswers = new ArrayList<>();
        firstQAnswers.add("Self-use");
        firstQAnswers.add("Suprvisor");
        answers.add(firstQAnswers);

        ArrayList<String> Q1ans = new ArrayList<>();
        Q1ans.add("Answer A");
        Q1ans.add("Answer B");
        Q1ans.add("Answer C");
        answers.add(Q1ans);
        ArrayList<String> Q2ans = new ArrayList<>();
        Q2ans.add("Answer A");
        Q2ans.add("Answer B");
        answers.add(Q2ans);
        //System.out.println(answers.get(1).get(1));
    }
    public void update(Observable observable, Object message) {
        this.setChanged();
        this.notifyObservers();
    }

    public List getQuestions() {
        return this.questions;
    }

    public List getAnswers() {
        return this.answers;
    }

}
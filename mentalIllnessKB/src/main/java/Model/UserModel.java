package Model;

import java.util.Observable;
import java.util.*;
import java.util.ArrayList;

public class UserModel extends Observable implements Observer {
    private List<String> questions = new ArrayList<>();
    private List<ArrayList<String>> answers = new ArrayList<ArrayList<String>>();
    public List<String> givenAnswers = new ArrayList<>();

    private List<String> MutismQ = new ArrayList<>();
    private List<ArrayList<String>> MutismA = new ArrayList<ArrayList<String>>();


    public UserModel() {
        this.setChanged();
        this.notifyObservers();
        questions.add("Do you want to run the program for self-use, or do you want to" +
                " use the program as a supervisor?");

        ArrayList<String> firstQAnswers = new ArrayList<>();
        firstQAnswers.add("Self-use");
        firstQAnswers.add("Supervisor");
        answers.add(firstQAnswers);

        questions.add("What kind of disorder would you like to be asked about?");
        ArrayList<String> secondQAnswers = new ArrayList<>();
        secondQAnswers.add("Anxiety Disorder");
        secondQAnswers.add("Phobia");
        secondQAnswers.add("Panic Disorder");
        secondQAnswers.add("Selective Mutism");
        answers.add(secondQAnswers);

    }

    public void choiceSelf(int choice) {
        if (choice == 1) {
            //Selective Mutism
            MutismQ.add("Does the Patient consistently fail to speak in certain social situations whilst speaking in others");
            ArrayList<String> MutQ1ans = new ArrayList<>();
            MutQ1ans.add("Yes");
            MutQ1ans.add("No");
            MutismA.add(MutQ1ans);

            // (similar to question 3)
            MutismQ.add("Does the disturbance interfere with any of the following");
            ArrayList<String> MutQ2ans = new ArrayList<>();
            MutQ2ans.add("Education");
            MutQ2ans.add("Occupation");
            MutQ2ans.add("Social communication");
            MutQ2ans.add("None of the above");
            MutismA.add(MutQ2ans);
            // (similar to question 2)
            MutismQ.add("Has the disturbance persisted for over a month?");
            ArrayList<String> MutQ3ans = new ArrayList<>();
            MutQ3ans.add("Yes");
            MutQ3ans.add("No");
            MutismA.add(MutQ3ans);

            MutismQ.add("Failure to speak is not attributable to to lack of knowledge or comfort with the spoken language required in a social situation");
            ArrayList<String> MutQ4ans = new ArrayList<>();
            MutQ4ans.add("Is attributable");
            MutQ4ans.add("Is not attributable");
            MutQ4ans.add("Does not apply");
            MutismA.add(MutQ4ans);

            // ( same as question 4)
            MutismQ.add("Does the Patient suffer from any of the following Disorders");
            ArrayList<String> MutQ5ans = new ArrayList<>();
            MutQ5ans.add("Autism");
            MutQ5ans.add("Delusions or hallucinations");
            MutQ5ans.add("Psychotic Disorder");
            MutQ5ans.add("Generalized Anxiety disorder");
            MutQ5ans.add("None of the above");
            MutismA.add(MutQ5ans);
        }

    }

    public void choiceSuper(int choice) {
        System.out.println("Supervising...");
    }
    public void update(Observable observable, Object message) {
        this.setChanged();
        this.notifyObservers();
    }

    public List getQuestions(int choice) {
        if (choice == 0) {
            return this.questions;
        } else if (choice == 1) {
            return this.MutismQ;
        } else {
            return null;
        }
    }

    public List getAnswers(int choice) {
        if (choice == 0 ) {
            return this.answers;
        } else if (choice == 1) {
            return this.MutismA;
        } else {
            return null;
        }
    }

    public List getGivenAnswers() {
        return this.givenAnswers;
    }

    public void addAnswer(String answer) {
        this.givenAnswers.add(answer);
    }

}
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
        
        ArrayList<String> firstQAnswers = new ArrayList<>();
        firstQAnswers.add("Self-use");
        firstQAnswers.add("Suprvisor");
        answers.add(firstQAnswers);

        choiceSelf();
  
    }
    
    public void choiceSelf() {
        
        questions.add("Mark the following that applies to the patient concerning their seperation from major attachment figures");
        ArrayList<String> Q1ans = new ArrayList<>();
        Q1ans.add("Recurrent excessive distress when anticipating or experiencing seperation from home or major attachment figures");
        Q1ans.add("Persistent and exessive worry about losing a major attachment figure or that possible harm might befall them");
        Q1ans.add("Persistent and exessive worry about an untoward event that will cause seperation from a major attachment figure");
        Q1ans.add("Persistent reluctance to go out away from home because of fear of seperation");
        Q1ans.add("Persistent and exessive fear or reluctance at being alone or without major attachment figure");
        Q1ans.add("Persistent reluctance or refusal to sleep away from home or without being close to a major attachment figure");
        Q1ans.add("Repeated nightmares involving the theme of seperation");
        Q1ans.add("repeated complaints of negative physical symptoms when seperation occurs or is anticipated");
        Q1ans.add("none of the above apply");
        answers.add(Q1ans);
        
        //this question should be combined with others as a general question
        questions.add("How long has the fear, anxiety and/or avoidance behaviour lasted for?");
        ArrayList<String> Q2ans = new ArrayList<>();
        Q2ans.add("less than 4 weeks");
        Q2ans.add("4 weeks or more");
        Q2ans.add("6 months or more");
        answers.add(Q2ans);
        
        questions.add("Does the disturbance cause the patient to suffer clinically significant distress or impairment in social, academic, occupational or other important areas of functioning?");
        ArrayList<String> Q3ans = new ArrayList<>();
        Q3ans.add("Yes");
        Q3ans.add("No");
        answers.add(Q3ans);
        
        //this question should be combined with others as a general question
        questions.add("Does the Patient suffer from any of the following Disorders");
        ArrayList<String> Q4ans = new ArrayList<>();
        Q4ans.add("Autism");
        Q4ans.add("Delusions or hallucinations");
        Q4ans.add("Psychotic Disorder");
        Q4ans.add("Generalized Anxiety disorder");
        Q4ans.add("None of the above");
        answers.add(Q4ans);
        
        //Selective Mutism
        questions.add("Does the Patient consistently fail to speak in certain social situations whilst speaking in others");
        ArrayList<String> Q5ans = new ArrayList<>();
        Q5ans.add("Yes");
        Q5ans.add("No");
        answers.add(Q5ans);
        
     // (similar to question 3)
        questions.add("Does the disturbance interfere with any of the following");
        ArrayList<String> Q6ans = new ArrayList<>();
        Q6ans.add("Education");
        Q6ans.add("Occupation");
        Q6ans.add("Social commuinication");
        Q6ans.add("None of the above");
        answers.add(Q6ans);
     // (similar to question 2)  
        questions.add("Has the disturbance persisted for over a month?");
        ArrayList<String> Q7ans = new ArrayList<>();
        Q7ans.add("Yes");
        Q7ans.add("NO");
        answers.add(Q7ans);
        
        questions.add("Failure to speak is not attributable to to lack of knowledge or comfort with the spoken language required in a social situation");
        ArrayList<String> Q8ans = new ArrayList<>();
        Q8ans.add("Is attributable");
        Q8ans.add("Is not attributable");
        Q8ans.add("doesn't apply");
        answers.add(Q8ans);
        
        // ( same as question 4)
        questions.add("Does the Patient suffer from any of the following Disorders");
        ArrayList<String> Q9ans = new ArrayList<>();
        Q9ans.add("Autism");
        Q9ans.add("Delusions or hallucinations");
        Q9ans.add("Psychotic Disorder");
        Q9ans.add("Generalized Anxiety disorder");
        Q9ans.add("None of the above");
        answers.add(Q9ans);
        
        //SPECIFIC PHOBIA
        questions.add("Is the patient marked by fear of specific object or situation?");
        ArrayList<String> Q10ans = new ArrayList<>();
        Q10ans.add("Yes");
        Q10ans.add("NO");
        answers.add(Q10ans);
        
        questions.add("Does the phobic object or situation almost always provoke immediate fear or anxiety?");
        ArrayList<String> Q11ans = new ArrayList<>();
        Q11ans.add("Yes");
        Q11ans.add("NO");
        answers.add(Q11ans);
        
        questions.add("Does the patient activley avoid the the phobic object or situation or endure it with immense fear or anxiety when unavoidable?");
        ArrayList<String> Q12ans = new ArrayList<>();
        Q12ans.add("Yes");
        Q12ans.add("NO");
        answers.add(Q12ans);
        
        questions.add("Is the fear or anxiety expressed out of proportion with the danger the object or situation poses?");
        ArrayList<String> Q13ans = new ArrayList<>();
        Q13ans.add("Yes");
        Q13ans.add("NO");
        answers.add(Q13ans);
        
       // (same as Q6)
        questions.add("Does the disturbance cause anxiety or distress in any of the following situations");
        ArrayList<String> Q14ans = new ArrayList<>();
        Q14ans.add("Education");
        Q14ans.add("Occupation");
        Q14ans.add("Social circumstance");
        Q14ans.add("None of the above");
        answers.add(Q14ans);
        
       // (same as question 6)
        questions.add("Has the fear or anxiety persisted for over 6 months?");
        ArrayList<String> Q15ans = new ArrayList<>();
        Q15ans.add("Yes");
        Q15ans.add("NO");
        answers.add(Q15ans);
        
     // ( similar to question 4)
        questions.add("Do any of the following disorders better explain the symptoms portrayed");
        ArrayList<String> Q16ans = new ArrayList<>();
        Q16ans.add("Panic symptoms or Agoraphobia");
        Q16ans.add("Obsessive compulsive behaviour");
        Q16ans.add("Posttraumatic stress");
        Q16ans.add("Seperation anxiety");
        Q16ans.add("None of the above");
        answers.add(Q16ans);
        
        questions.add("Please specify if any of the following phobic stimuli are present");
        ArrayList<String> Q17ans = new ArrayList<>();
        Q17ans.add("Animal");
        Q17ans.add("Natural Environment");
        Q17ans.add("Situational");
        Q17ans.add("Other");
        Q16ans.add("None of the above");
        answers.add(Q17ans);
        
        //SOCIAL ANXIETY DISORDER
        questions.add("Is the patient marked by fear or anxiety about one or more social situations in which they may be exposed to possible scrutiny by others");
        ArrayList<String> Q18ans = new ArrayList<>();
        Q18ans.add("Yes");
        Q18ans.add("No");
        answers.add(Q18ans);
        
    }
    
    public void choiceSuper() {
    	
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
package Model;

import java.util.Observable;
import java.util.*;
import java.util.ArrayList;

public class UserModel extends Observable implements Observer {
    private List<String> questions = new ArrayList<>();
    private List<ArrayList<String>> answers = new ArrayList<ArrayList<String>>();
    
    private List<String> AnxDisQ = new ArrayList<>();
    private List<ArrayList<String>> AnxDisA = new ArrayList<ArrayList<String>>();

    private List<String> MutismQ = new ArrayList<>();
    private List<ArrayList<String>> MutismA = new ArrayList<ArrayList<String>>();

    private List<String> PhobiaQ = new ArrayList<>();
    private List<ArrayList<String>> PhobiaA = new ArrayList<ArrayList<String>>();
    
    private List<String> PanicDisQ = new ArrayList<>();
    private List<ArrayList<String>> PanicdisA = new ArrayList<ArrayList<String>>();
    
    
    
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
        
    	AnxDisQ.add("Mark the following that applies to the patient concerning their seperation from major attachment figures");
        ArrayList<String> AnxQ1ans = new ArrayList<>();
        AnxQ1ans.add("Recurrent excessive distress when anticipating or experiencing seperation from home or major attachment figures");
        AnxQ1ans.add("Persistent and exessive worry about losing a major attachment figure or that possible harm might befall them");
        AnxQ1ans.add("Persistent and exessive worry about an untoward event that will cause seperation from a major attachment figure");
        AnxQ1ans.add("Persistent reluctance to go out away from home because of fear of seperation");
        AnxQ1ans.add("Persistent and exessive fear or reluctance at being alone or without major attachment figure");
        AnxQ1ans.add("Persistent reluctance or refusal to sleep away from home or without being close to a major attachment figure");
        AnxQ1ans.add("Repeated nightmares involving the theme of seperation");
        AnxQ1ans.add("repeated complaints of negative physical symptoms when seperation occurs or is anticipated");
        AnxQ1ans.add("none of the above apply");
        AnxDisA.add(AnxQ1ans);
        
        //this question should be combined with others as a general question
        AnxDisQ.add("How long has the fear, anxiety and/or avoidance behaviour lasted for?");
        ArrayList<String> AnxQ2ans = new ArrayList<>();
        AnxQ2ans.add("less than 4 weeks");
        AnxQ2ans.add("4 weeks or more");
        AnxQ2ans.add("6 months or more");
        AnxDisA.add(AnxQ2ans);
        
        AnxDisQ.add("Does the disturbance cause the patient to suffer clinically significant distress or impairment in social, academic, occupational or other important areas of functioning?");
        ArrayList<String> AnxQ3ans = new ArrayList<>();
        AnxQ3ans.add("Yes");
        AnxQ3ans.add("No");
        AnxDisA.add(AnxQ3ans);
        
        //this question should be combined with others as a general question
        AnxDisQ.add("Does the Patient suffer from any of the following Disorders");
        ArrayList<String> AnxQ4ans = new ArrayList<>();
        AnxQ4ans.add("Autism");
        AnxQ4ans.add("Delusions or hallucinations");
        AnxQ4ans.add("Psychotic Disorder");
        AnxQ4ans.add("Generalized Anxiety disorder");
        AnxQ4ans.add("None of the above");
        AnxDisA.add(AnxQ4ans);
        
        //SOCIAL ANXIETY DISORDER
        AnxDisQ.add("Is the patient marked by fear or anxiety about one or more social situations in which they may be exposed to possible scrutiny by others");
        ArrayList<String> AnxQ5ans = new ArrayList<>();
        AnxQ5ans.add("Yes");
        AnxQ5ans.add("No");
        AnxDisA.add(AnxQ5ans);
        
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
        MutQ2ans.add("Social commuinication");
        MutQ2ans.add("None of the above");
        MutismA.add(MutQ2ans);
     // (similar to question 2)  
        MutismQ.add("Has the disturbance persisted for over a month?");
        ArrayList<String> MutQ3ans = new ArrayList<>();
        MutQ3ans.add("Yes");
        MutQ3ans.add("NO");
        MutismA.add(MutQ3ans);
        
        MutismQ.add("Failure to speak is not attributable to to lack of knowledge or comfort with the spoken language required in a social situation");
        ArrayList<String> MutQ4ans = new ArrayList<>();
        MutQ4ans.add("Is attributable");
        MutQ4ans.add("Is not attributable");
        MutQ4ans.add("doesn't apply");
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
        
        //SPECIFIC PHOBIA
        PhobiaQ.add("Is the patient marked by fear of specific object or situation?");
        ArrayList<String> PhobiaQ1ans = new ArrayList<>();
        PhobiaQ1ans.add("Yes");
        PhobiaQ1ans.add("NO");
        PhobiaA.add(PhobiaQ1ans);
        
        PhobiaQ.add("Does the phobic object or situation almost always provoke immediate fear or anxiety?");
        ArrayList<String> PhobiaQ2ans = new ArrayList<>();
        PhobiaQ2ans.add("Yes");
        PhobiaQ2ans.add("NO");
        PhobiaA.add(PhobiaQ2ans);
        
        PhobiaQ.add("Does the patient activley avoid the the phobic object or situation or endure it with immense fear or anxiety when unavoidable?");
        ArrayList<String> PhobiaQ3ans = new ArrayList<>();
        PhobiaQ3ans.add("Yes");
        PhobiaQ3ans.add("NO");
        PhobiaA.add(PhobiaQ3ans);
        
        PhobiaQ.add("Is the fear or anxiety expressed out of proportion with the danger the object or situation poses?");
        ArrayList<String> PhobiaQ4ans = new ArrayList<>();
        PhobiaQ4ans.add("Yes");
        PhobiaQ4ans.add("NO");
        PhobiaA.add(PhobiaQ4ans);
        
       // (same as Q6)
        PhobiaQ.add("Does the disturbance cause anxiety or distress in any of the following situations");
        ArrayList<String> PhobiaQ5ans = new ArrayList<>();
        PhobiaQ5ans.add("Education");
        PhobiaQ5ans.add("Occupation");
        PhobiaQ5ans.add("Social circumstance");
        PhobiaQ5ans.add("None of the above");
        PhobiaA.add(PhobiaQ5ans);
        
       // (same as question 6)
        PhobiaQ.add("Has the fear or anxiety persisted for over 6 months?");
        ArrayList<String> PhobiaQ6ans = new ArrayList<>();
        PhobiaQ6ans.add("Yes");
        PhobiaQ6ans.add("NO");
        answers.add(PhobiaQ6ans);
        
     // ( similar to question 4)
        PhobiaQ.add("Do any of the following disorders better explain the symptoms portrayed");
        ArrayList<String> PhobiaQ7ans = new ArrayList<>();
        PhobiaQ7ans.add("Panic symptoms or Agoraphobia");
        PhobiaQ7ans.add("Obsessive compulsive behaviour");
        PhobiaQ7ans.add("Posttraumatic stress");
        PhobiaQ7ans.add("Seperation anxiety");
        PhobiaQ7ans.add("None of the above");
        PhobiaA.add(PhobiaQ7ans);
        
        PhobiaQ.add("Please specify if any of the following phobic stimuli are present");
        ArrayList<String> PhobiaQ8ans = new ArrayList<>();
        PhobiaQ8ans.add("Animal");
        PhobiaQ8ans.add("Natural Environment");
        PhobiaQ8ans.add("Situational");
        PhobiaQ8ans.add("Other");
        PhobiaQ8ans.add("None of the above");
        PhobiaA.add(PhobiaQ8ans);
        
        
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
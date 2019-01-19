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
    private List<ArrayList<String>> PanicDisA = new ArrayList<ArrayList<String>>();
    
    
    
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
        
        //4 weeks in children, 6 months in adults for both seperation anxiety and social anxiety
        AnxDisQ.add("How long has the fear, anxiety and/or avoidance behaviour lasted for?");
        ArrayList<String> AnxQ2ans = new ArrayList<>();
        AnxQ2ans.add("less than 4 weeks");
        AnxQ2ans.add("4 weeks or more");
        AnxQ2ans.add("6 months or more");
        AnxDisA.add(AnxQ2ans);
        
        //relevant to social anxiety disorder as well
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
        //under are for social anxiety disorder, as well as autism above
        AnxQ4ans.add("Panic disorder");
        AnxQ4ans.add("Body Dysmorphic disorder");
        //under are for general anxiety disorder
        AnxQ4ans.add("Hyperthyroidism");
        AnxQ4ans.add("Posttraumatic stress");
        AnxQ4ans.add("Anorexia Nervosa");
        AnxQ4ans.add("body dysmorphic disorder");
        AnxQ4ans.add("None of the above");
        AnxQ4ans.add("Body dysmorphic disorder");
        AnxQ4ans.add("Schizophrenia");
        AnxQ4ans.add("Obsesive Compulsive Disorder");
        //attributable to all
        AnxQ4ans.add("drug abuse or medication");
        AnxDisA.add(AnxQ4ans);
        
        //SOCIAL ANXIETY DISORDER
        AnxDisQ.add("Is the patient marked by fear or anxiety about one or more social situations in which they may be exposed to possible scrutiny by others");
        ArrayList<String> AnxQ5ans = new ArrayList<>();
        AnxQ5ans.add("Yes");
        AnxQ5ans.add("No");
        AnxDisA.add(AnxQ5ans);
        
        AnxDisQ.add("The patient fears that they will act in way or show anxiety symptoms that will be negativley evaluated");
        ArrayList<String> AnxQ6ans = new ArrayList<>();
        AnxQ6ans.add("Yes");
        AnxQ6ans.add("No");
        AnxDisA.add(AnxQ6ans);
        
        AnxDisQ.add("Social situations almost always provoke fear or anxiety");
        ArrayList<String> AnxQ7ans = new ArrayList<>();
        AnxQ7ans.add("Yes");
        AnxQ7ans.add("No");
        AnxDisA.add(AnxQ7ans);
        
        AnxDisQ.add("Does the patient activley avoid social situations or endure it with immense fear or anxiety?");
        ArrayList<String> AnxQ8ans = new ArrayList<>();
        AnxQ8ans.add("Yes");
        AnxQ8ans.add("No");
        AnxDisA.add(AnxQ8ans);
        
        AnxDisQ.add("Does the patient activley avoid social situations or endure it with immense fear or anxiety?");
        ArrayList<String> AnxQ9ans = new ArrayList<>();
        AnxQ9ans.add("Yes");
        AnxQ9ans.add("No");
        AnxDisA.add(AnxQ9ans);
        
        AnxDisQ.add("Does the patient exhibit fear or anxiety unproportional to the threat posed ?");
        ArrayList<String> AnxQ10ans = new ArrayList<>();
        AnxQ10ans.add("Yes");
        AnxQ10ans.add("No");
        AnxDisA.add(AnxQ10ans);
        
        AnxDisQ.add("Is the fear, anxiety or avoidance behaviour attributable to physiological effects of a substance or another medical condition?");
        ArrayList<String> AnxQ11ans = new ArrayList<>();
        AnxQ11ans.add("Yes");
        AnxQ11ans.add("No");
        AnxDisA.add(AnxQ11ans);
        
        AnxDisQ.add("If another medical condition is present, is the disturbance clearly unrelated to these, or not but the condition is still very excessive ");
        ArrayList<String> AnxQ12ans = new ArrayList<>();
        AnxQ12ans.add("Unrelated");
        AnxQ12ans.add("Not unrelated but disturbance is exessive");
        AnxQ12ans.add("The disturbance is moderate and related to the medical condition");
        AnxDisA.add(AnxQ12ans);
        
        AnxDisQ.add("Is the fear, restricted to speaking or performing in public?");
        ArrayList<String> AnxQ13ans = new ArrayList<>();
        AnxQ13ans.add("Yes");
        AnxQ13ans.add("No");
        AnxDisA.add(AnxQ13ans); //if yes then redirect to selective MUTISM
        
        //Generalized Anxiety Disorder
        AnxDisQ.add("has the patient showcased excessive anxiety or worry about a number of event more days than not for atleast 6 months?");
        ArrayList<String> AnxQ14ans = new ArrayList<>();
        AnxQ14ans.add("Yes");
        AnxQ14ans.add("No");
        AnxDisA.add(AnxQ14ans);
        
        AnxDisQ.add("does the patient find it difficult to control the worry?");
        ArrayList<String> AnxQ15ans = new ArrayList<>();
        AnxQ15ans.add("Yes");
        AnxQ15ans.add("No");
        AnxDisA.add(AnxQ15ans);
        
        AnxDisQ.add("Is the anxiety exhibited by the patient marked by any of the following symptoms?");
        ArrayList<String> AnxQ16ans = new ArrayList<>();
        AnxQ16ans.add("Continuous feelings of restlessness or being on the edge");
        AnxQ16ans.add("Being easily fatigued");
        AnxQ16ans.add("Difficulty concentrating or mind going blank");
        AnxQ16ans.add("irritability");
        AnxQ16ans.add("Muscle Tension");
        AnxQ16ans.add("Sleep disturbances");
        AnxDisA.add(AnxQ16ans);
        
        //Substance/Medication-induced anxiety Disorder
        
        //Is the patient under any of the influence of any of the following substances        AnxDisQ.add("Is the patient under any of the influence of any of the following substances in excessive amounts?");
        ArrayList<String> AnxQ17ans = new ArrayList<>();
        AnxQ17ans.add("Alcohol");
        AnxQ17ans.add("Caffeine");
        AnxQ17ans.add("Cannabis");
        AnxQ17ans.add("PhenCyclidine");
        AnxQ17ans.add("Other hallucinogen");
        AnxQ17ans.add("Inhalants");
        AnxQ17ans.add("Opioids");
        AnxQ17ans.add("Sedative, hypnotic or anxiolytic substances");
        AnxQ17ans.add("Amphetamines or other stimulants");
        AnxQ17ans.add("Cocaine");
        AnxQ17ans.add("Other or unknown substances");
        AnxDisA.add(AnxQ17ans);
        
        AnxDisQ.add("Do the anxiety symptoms predominantly present themselves in a clinical pciture?");
        ArrayList<String> AnxQ18ans = new ArrayList<>();
        AnxQ18ans.add("Yes");
        AnxQ18ans.add("No");
        AnxDisA.add(AnxQ18ans);
        
        AnxDisQ.add("Does the patients history, physical examination or labratory findings present any ofthe following?");
        ArrayList<String> AnxQ19ans = new ArrayList<>();
        AnxQ19ans.add("Symptoms developed soon after a substance intoxication or withdrawal after exposure to a medication");
        AnxQ19ans.add("The patient is taking a substance/medication that is capable of producing anxiety symptoms ");
        AnxQ19ans.add("The patient is on medication but the symptoms preceded its start");
        AnxQ19ans.add("The patient has taken medication but the disturbannce has persisted for more than a month after cessation");
        AnxDisA.add(AnxQ19ans);
        
        AnxDisQ.add("Does the disturbance occur excessivley during states of delerium?");
        ArrayList<String> AnxQ20ans = new ArrayList<>();
        AnxQ20ans.add("Yes");
        AnxQ20ans.add("No");
        AnxDisA.add(AnxQ20ans);
        
        //Anxiety due to other medical conditions is same questions as above except the substancec question
        
        
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
        
        //applies to agoraphobia as well
        PhobiaQ.add("Is the fear or anxiety expressed unproportional to the danger the object or situation poses?");
        ArrayList<String> PhobiaQ4ans = new ArrayList<>();
        PhobiaQ4ans.add("Yes");
        PhobiaQ4ans.add("NO");
        PhobiaA.add(PhobiaQ4ans);
        
       // (same as Q6) // applies to agoraphobia as well
        PhobiaQ.add("Does the disturbance cause anxiety or distress in any of the following situations");
        ArrayList<String> PhobiaQ5ans = new ArrayList<>();
        PhobiaQ5ans.add("Education");
        PhobiaQ5ans.add("Occupation");
        PhobiaQ5ans.add("Social circumstance");
        PhobiaQ5ans.add("None of the above");
        PhobiaA.add(PhobiaQ5ans);
        
       // (same as question 6) // applies to agoraphobia as well
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
        //below are for agoraphobia as well as OCD and Post traumatic stress and seperation anxiety above
        PhobiaQ7ans.add("Social anxiety");
        PhobiaQ7ans.add("Body Dysmorphic disorder");
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
        
        //Agoraphobia
        
        PhobiaQ.add("Does the Patient exhibit marked fear or anxiety about the following situatuins");
        ArrayList<String> PhobiaQ9ans = new ArrayList<>();
        PhobiaQ9ans.add("Using public transportation");
        PhobiaQ9ans.add("Being in open spaces");
        PhobiaQ9ans.add("Being in enclosed spaces");
        PhobiaQ9ans.add("Standing in line or being in a crowd");
        PhobiaQ9ans.add("Being outside of the home alone");
        PhobiaQ9ans.add("None of the above");
        PhobiaA.add(PhobiaQ9ans);
        
        PhobiaQ.add("Does the Patient fear or avoid situations because they think escape might be difficult or help might not be available if they should experience debilitating symptoms");
        ArrayList<String> PhobiaQ10ans = new ArrayList<>();
        PhobiaQ10ans.add("Yes");
        PhobiaQ10ans.add("No");
        PhobiaA.add(PhobiaQ10ans);
        
        PhobiaQ.add("Do agoraphobic situations almost always provoke fear or anxiety");
        ArrayList<String> PhobiaQ11ans = new ArrayList<>();
        PhobiaQ11ans.add("Yes");
        PhobiaQ11ans.add("No");
        PhobiaA.add(PhobiaQ11ans);
        
        PhobiaQ.add("Does any of the following behaviour apply to the patient in an agoraphobic situation");
        ArrayList<String> PhobiaQ12ans = new ArrayList<>();
        PhobiaQ12ans.add("Avoidance");
        PhobiaQ12ans.add("Need of a companion");
        PhobiaQ12ans.add("Endured with intense fear or anxiety");
        PhobiaA.add(PhobiaQ12ans);
        
        PhobiaQ.add("Does the patient posess any of the following medical conditions");
        ArrayList<String> PhobiaQ13ans = new ArrayList<>();
        PhobiaQ13ans.add("Parkinson's disease");
        PhobiaQ13ans.add("inflammatory bowel disease");
        PhobiaQ13ans.add("Above conditions are present but the present disturbance is significantly excessive");
        PhobiaQ13ans.add("None of the above");
        PhobiaA.add(PhobiaQ13ans);
        
        
        //Panic Disorder 
        PanicDisQ.add("Does the patient suffer from sudden and recurring intense fear or intense discomfort followed by any of the following symptoms ");
        ArrayList<String> PanicDisQ1ans = new ArrayList<>();
        PanicDisQ1ans.add("Pounding heart, accelerated heart rate or heart palpatations");
        PanicDisQ1ans.add("Sweating");
        PanicDisQ1ans.add("Trembling or Shaking");
        PanicDisQ1ans.add("Shortness of breath or sensation of Smothering");
        PanicDisQ1ans.add("Feelings of chocking");
        PanicDisQ1ans.add("Chest pain or discomfort");
        PanicDisQ1ans.add("Nausea or abdominal distress");
        PanicDisQ1ans.add("Feeling dizzy, unsteady, lightheaded or faint");
        PanicDisQ1ans.add("Chills or heat sensations");
        PanicDisQ1ans.add("Paresthesis");//numbness or tingling
        PanicDisQ1ans.add("Dereiliztion or Depersonalization"); //feelings of detachment from reality or oneself
        PanicDisQ1ans.add("Fear of losing control or going crazy");
        PanicDisQ1ans.add("Fear of dying");
        PanicDisA.add(PanicDisQ1ans);
        
        PanicDisQ.add("Has atleast one of the patients panic attacks been followed by a month of one or more of the following symptoms ");
        ArrayList<String> PanicDisQ2ans = new ArrayList<>();
        PanicDisQ2ans.add("persistent concern or worry about additional panic attacks or the consequences that follow");
        PanicDisQ2ans.add("Change in behaviour designed to avoid panic attack");
        PanicDisA.add(PanicDisQ2ans);
        
        PanicDisQ.add("Do one of the following conditions more attributable to the physiological effects presented by the patient");
        ArrayList<String> PanicDisQ3ans = new ArrayList<>();
        PanicDisQ3ans.add("Drug abuse or medication");
        PanicDisQ3ans.add("Hyperthyroidism");
        PanicDisQ3ans.add("Cardiopulmonary disorder");
        PanicDisQ3ans.add("Other medical condition");
        PanicDisQ3ans.add("None of the above");
        PanicDisA.add(PanicDisQ3ans);
        
        PanicDisQ.add("Do the panic attacks occur only in relation to any of the situations listed below");
        ArrayList<String> PanicDisQ4ans = new ArrayList<>();
        PanicDisQ4ans.add("Feared social situation"); //social anxiety
        PanicDisQ4ans.add("Circumscribed phobic objects or situations");
        PanicDisQ4ans.add("Obsessions"); //OCD
        PanicDisQ4ans.add("Traumatic event"); //Truama induced anxiety
        PanicDisQ4ans.add("Seperation of attachment figures");//Seperation anxiety 
        PanicDisA.add(PanicDisQ4ans);
        
        //Panic Attack Specifier
        
    }
    
    
    
    /*public void choiceSuper() {
    	
    }*/
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
    
    public List getMutQ() {
        return this.MutismQ;
    }

    public List getMutA() {
        return this.MutismA;
    }
    
    public List getAnxQ() {
        return this.AnxDisQ;
    }

    public List getAnxA() {
        return this.AnxDisA;
    }
    
    public List getPhobiaQ() {
        return this.PhobiaQ;
    }

    public List getPhobiaA() {
        return this.PhobiaA;
    }
    public List getPanicDisQ() {
        return this.PanicDisQ;
    }

    public List getPanicDisA() {
        return this.PanicDisA;
    }





}
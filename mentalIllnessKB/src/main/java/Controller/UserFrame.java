package Controller;
//import View.*;
import Model.*;
//import javax.scene.control.SplitPane;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class UserFrame extends JFrame implements ActionListener, ItemListener {
    private static final long serialVersionUID = 1L;
    private UserModel userModel = new UserModel();
    private JSplitPane splitPane = new JSplitPane();
    private JFrame userFrame = new JFrame("Mental Illness");
    public JPanel questionPanel = new JPanel();
    public JPanel answerPanel = new JPanel();
    public JPanel formatPanel = new JPanel();
    public JTextArea text = new JTextArea("Welcome to the Mental Illness determiner");
    private int disease = 0;
    private int index = 0;
    private int index2 = 0;
    private int userType;
    private ArrayList listAnswers;
    public ArrayList<String> checkboxList = new ArrayList<>();
    public Answers answers = new Answers();

    public UserFrame(UserModel model) {
        this.setUserModel(model);
        // Set the frame options
        userFrame.setSize(900, 500);
        userFrame.setDefaultCloseOperation(3);
        userFrame.add(splitPane, BorderLayout.CENTER);

        // Create a splitpane which separates the questions from the answers
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(125);
        splitPane.setTopComponent(questionPanel);
        splitPane.setBottomComponent(answerPanel);

        // Create the panel for questions
        text.setFont(new Font("Arial", Font.BOLD, 16));
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setOpaque(false);
        text.setEditable(false);
        text.setColumns(25);
        JScrollPane jsp = new JScrollPane(text);
        questionPanel.add(jsp);

        // Create the panel for answers
        formatPanel.setLayout(new BoxLayout(formatPanel, BoxLayout.Y_AXIS));
        JButton newButton = new JButton("Go");
        newButton.addActionListener(this);
        formatPanel.add(newButton);

        answerPanel.add(formatPanel);
        userFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        // Get the action command and update the answer so that Drools can process the answer

        String performedAction = e.getActionCommand();
        if (performedAction.equals("Next") && checkboxList != null) {
            if (disease == 1 && index2 == 1) {
                if (checkboxList.size() >= 4) {
                    userModel.addAnswer("Yes" + Integer.toString(index2));
                } else {
                    userModel.addAnswer("No");
                }
            } else if (disease == 1 && index2 == 4) {
                if (checkboxList.size() >= 1) {
                    userModel.addAnswer("Yes" + Integer.toString(index2));
                } else {
                    userModel.addAnswer("No");
                }
            } else if (disease == 1 && index2 == 16) {
                if (checkboxList.size() >= 3) {
                    userModel.addAnswer("Yes" + Integer.toString(index2));
                } else {
                    userModel.addAnswer("No");
                }
            } else if (disease == 1 && index2 == 17) {
                if (checkboxList.size() >= 1) {
                    userModel.addAnswer("Yes" + Integer.toString(index2));
                } else {
                    userModel.addAnswer("No");
                }
            } else if (disease == 4 && index2 == 1) {
                if (checkboxList.size() >= 4) {
                    userModel.addAnswer("Yes" + Integer.toString(index2));
                } else {
                    userModel.addAnswer("No");
                }
            } else if (disease == 3 && index2 == 9) {
                if (checkboxList.size() >= 2) {
                    userModel.addAnswer("Yes" + Integer.toString(index2));
                } else {
                    userModel.addAnswer("No");
                }
            } else if (disease == 3 && index2 == 7) {
                if (checkboxList.size() == 0) {
                    userModel.addAnswer("Yes" + Integer.toString(index2));
                } else {
                    userModel.addAnswer("No");
                }
            }  else if (disease == 3 && index2 == 12) {
                if (checkboxList.size() >= 1) {
                    userModel.addAnswer("Yes" + Integer.toString(index2));
                } else {
                    userModel.addAnswer("No");
                }
            }
            checkboxList.clear();
        }
        if (index > 2 && !performedAction.equals("Next")) {
            userModel.addAnswer(performedAction);
        }

        if (index2 >= userModel.getQuestions(disease).size()) {
            index2 = 0;
            index = 0;
            runDrools();
            formatPanel.removeAll();
            text.setText("Diagnosis: " + answers.getString());
            answers.setString("");
            answers.setIdx();
            userFrame.repaint();
            userFrame.setVisible(true);
            return;

        }

        if (index == 1) {
            switch(performedAction) {
                case "Self-use":
                    this.userType = 0;
                    break;
                case "Supervisor":
                    this.userType = 1;
                    break;
            }
        }
        if (index == 2) {
            switch(performedAction) {
                case "Anxiety Disorder":
                    disease = 1;
                    if (this.userType == 0) {
                        this.userModel.choiceSelf(disease);
                    } else {
                        this.userModel.choiceSuper(disease);
                    }
                    break;
                case "Selective Mutism":
                    disease = 2;
                    if (this.userType == 0) {
                        this.userModel.choiceSelf(disease);
                    } else {
                        this.userModel.choiceSuper(disease);
                    }
                    break;
                case "Phobia":
                    disease = 3;
                    if (this.userType == 0) {
                        this.userModel.choiceSelf(disease);
                    } else {
                        System.out.println("6");
                        this.userModel.choiceSuper(disease);
                    }
                    break;
                case "Panic Disorder":
                    disease = 4;
                    if (this.userType == 0) {
                        this.userModel.choiceSelf(disease);
                    } else {
                        this.userModel.choiceSuper(disease);
                    }
                    break;
            }
        }



        // Get new question ready on screen
        // Get new question ready on screen
        if (index < 2) {
            text.setText((String)userModel.getQuestions(disease).get(index));
        } else {
            text.setText((String)userModel.getQuestions(disease).get(index2));
        }
        // Remove former buttons
        formatPanel.removeAll();
        if (index < 2) {
            listAnswers = (ArrayList) userModel.getAnswers(disease).get(index);
        } else {
            listAnswers = (ArrayList) userModel.getAnswers(disease).get(index2);
        }

        // Create the corresponding new buttons with the new question
        if ((disease == 1 && (index2 == 0 || index2 == 3 || index2 == 15 || index2 == 16)) ||
                (disease == 3 && (index2 == 6 || index2 == 8 || index2 == 11))
                || (disease == 4 && (index2 == 0))) {
            createJCheckBoxes(listAnswers);
        } else {
            createJButtons(listAnswers);
        }

        // Update the frame
        splitPane.setDividerLocation(125);
        userFrame.repaint();
        userFrame.setVisible(true);
        index++;
        if (index > 2) {
            index2++;
        }
    }


    public void setUserModel(UserModel model) {
        this.userModel = model;
    }

    public class Answers {
        public List<String> answers;
        private String answer;
        private String diseaseA;
        private int index = 0;
        public void setAnswers(List answers) {
            this.answers = answers;
        }
        public List getAnswers() {
            return this.answers;
        }
        public void updateIdx() {
            this.index++;
        }
        public int getIdx() {
            return this.index;
        }
        public void setIdx() {
            this.index = 0;
        }
        public void setString(String name) {
            this.answer = name;
        }
        public String getString() {
            return this.answer;
        }
        public void setDisease(String diseaseA) {
            this.diseaseA = diseaseA;
        }
        public String getDisease() {
            return this.diseaseA;
        }
    }

    public void runDrools() {
        try {
            // load up the knowledge base
            KnowledgeBase kbase = readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
            // go !

            answers.setAnswers(userModel.getGivenAnswers());
            for (int idx = 0; idx < answers.answers.size(); idx++) {
                if (answers.answers.get(idx).equals("Yes")) {
                    answers.answers.set(idx, "Yes" + Integer.toString(idx+1));
                }
            }
            //System.out.println(answers.getAnswers());
            ksession.insert(answers);
            ksession.fireAllRules();
            logger.close();
            setDiagnosis(answers.getIdx());


        } catch (Throwable t) {
            t.printStackTrace();
        }

    }

    public void setDiagnosis(int index) {
        if (index == 1) {
            if (disease == 2) {
                answers.setString("The patient meets all the requirements for having"
                        + " selective mutism. Further, extensive research is suggested.");
            }
            if (disease == 3) {
                answers.setString("The patient meets all the requirements for having"
                        + " a specific phobia. Further, extensive research is suggested.");
            }
            if (disease == 4) {
                answers.setString("The patient meets all the requirements for having"
                        + " a panic disorder. Further, extensive research is suggested.");
            }

        } else if (index == 0){
            if (disease == 1) {
                String diseaseA = answers.getDisease();
                if (diseaseA == null) {
                    diseaseA = "a";
                }
                switch(diseaseA) {
                    case "SepAnx":
                        answers.setString("The patient meets all the requirements for having"
                                + " separation anxiety disorder. Further, extensive research is suggested.");
                        break;
                    case "SocAnx":
                        answers.setString("The patient meets all the requirements for having"
                                + " social anxiety disorder. Further, extensive research is suggested.");
                        break;
                    case "GenAnx":
                        answers.setString("The patient meets all the requirements for having"
                                + " generalized anxiety disorder. Further, extensive research is suggested.");
                        break;
                    case "SubstAnx":
                        answers.setString("The patient meets all the requirements for having"
                                + " substance/medication anxiety disorder. Further, extensive research is suggested.");
                        break;
                    default: answers.setString("The patient does not meet requirements for any kind of"
                            + " anxiety disorder. Nothing to be worried about :)!");
                        break;
                }

            }
            if (disease == 2) {
                answers.setString("The patient does not meet the requirements for having"
                        + " selective mutism. Nothing to be worried about :)!");
            }
            if (disease == 3) {
                answers.setString("The patient does not meet the requirements for having"
                        + " a specific phobia or agoraphobia. Nothing to be worried about :)!");
            }
            if (disease == 4) {
                answers.setString("The patient does not meet the requirements for having"
                        + " a panic disorder. Nothing to be worried about :)!");
            }
        } else if (index == 2) {
            if (disease == 2) {
                answers.setString("The patient meets all the requirements for having"
                        + " agoraphobia. Further, extensive research is suggested.");
            }
        }
    }

    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("Disorder.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }

    public void createJButtons(ArrayList answerlist) {
        for (int idx = 0; idx < answerlist.size(); idx++ ) {
            JButton newButton = new JButton((String)answerlist.get(idx));
            newButton.addActionListener(this);
            newButton.setActionCommand(newButton.getText());
            newButton.setAlignmentX(Component.LEFT_ALIGNMENT);
            formatPanel.add(newButton);
        }
    }

    public void createJCheckBoxes(ArrayList answerlist) {
        for (int idx = 0; idx < answerlist.size(); idx++ ) {
            JCheckBox newCheckbox = new JCheckBox((String)answerlist.get(idx));
            newCheckbox.addItemListener(this);
            newCheckbox.setAlignmentX(Component.LEFT_ALIGNMENT);
            formatPanel.add(newCheckbox);
        }
        JButton newButton = new JButton("Next");
        newButton.addActionListener(this);
        newButton.setActionCommand("Next");
        newButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        formatPanel.add(newButton);
    }

    public void itemStateChanged(ItemEvent e) {
        JCheckBox box = (JCheckBox) e.getItem();
        int state = e.getStateChange();
        if (state == ItemEvent.SELECTED){
            //System.out.println("Now here");
            checkboxList.add(box.getText());
        }
        if (state == ItemEvent.DESELECTED) {
            //System.out.println("Now here");
            for (int idx = 0; idx < checkboxList.size(); idx++) {
                if (checkboxList.get(idx).equals(box.getText())) {
                    checkboxList.remove(idx);
                }
            }
        }
    }

}
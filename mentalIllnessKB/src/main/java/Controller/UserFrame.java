package Controller;
//import View.*;
import Model.*;
import com.sample.DroolsTest;
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
import java.util.ArrayList;
import java.util.List;


public class UserFrame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private int index = 0;
    private int index2 = 0;
    private int userType;
    private int disease = 0;
    private UserModel userModel;
    private JSplitPane splitPane = new JSplitPane();
    private JFrame userFrame = new JFrame("Mental Illness");
    public JPanel questionPanel = new JPanel();
    public JPanel answerPanel = new JPanel();
    public JPanel formatPanel = new JPanel();
    public JTextArea text = new JTextArea("Welcome to the Mental Illness determiner");
    private ArrayList listAnswers;

    public UserFrame(UserModel model) {
        this.setUserModel(model);
        // Set the frame options
        userFrame.setSize(900, 600);
        userFrame.setDefaultCloseOperation(3);
        userFrame.add(splitPane, BorderLayout.CENTER);

        // Create a splitpane which separates the questions from the answers
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(300);
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
        System.out.println(index);
        System.out.println(index2);
        System.out.println(userModel.getQuestions(disease).size());

        // Get the action command and update the answer so that Drools can process the answer
        String performedAction = e.getActionCommand();
        if (index > 2) {
            userModel.addAnswer(performedAction);
        }
        if (index2 >= userModel.getQuestions(disease).size()) {
            index2 = 0;
            index = 0;
            runDrools();
            formatPanel.removeAll();
            text.setText("Diagnosis");
            userFrame.repaint();
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
                    disease = 4;
                    if (this.userType == 0) {
                        this.userModel.choiceSelf(disease);
                    } else {
                        this.userModel.choiceSuper(disease);
                    }
                    break;
                case "Phobia":
                    disease = 2;
                    if (this.userType == 0) {
                        this.userModel.choiceSelf(disease);
                    } else {
                        this.userModel.choiceSuper(disease);
                    }
                    break;
                case "Panic Disorder":
                    disease = 3;
                    if (this.userType == 0) {
                        this.userModel.choiceSelf(disease);
                    } else {
                        this.userModel.choiceSuper(disease);
                    }
                    break;
                case "Selective Mutism":
                    disease = 1;
                    if (this.userType == 0) {
                        this.userModel.choiceSelf(disease);
                    } else {
                        this.userModel.choiceSuper(disease);
                    }
                    break;
            }
        }

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
        for (int idx = 0; idx < listAnswers.size(); idx++ ) {
            JButton newButton = new JButton((String)listAnswers.get(idx));
            newButton.addActionListener(this);
            newButton.setActionCommand(newButton.getText());
            newButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            formatPanel.add(newButton);
        }
        // Update the frame
        splitPane.setDividerLocation(150);
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
        private List<String> answers;
        private String answer;
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
        public void setString(String name) {
            this.answer = name;
        }
        public String getString() {
            return this.answer;
        }
    }

    public void runDrools() {
        try {
            // load up the knowledge base
            KnowledgeBase kbase = readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
            // go !
            Answers answers = new Answers();
            answers.setAnswers(userModel.getGivenAnswers());
            System.out.println(answers.getAnswers());
            for (int idx = 0; idx < answers.getAnswers().size(); idx++) {
                answers.setString((String)answers.getAnswers().get(idx));
                System.out.println(answers.getString());
                ksession.insert(answers);
            }

            //message.setMessage("Hello World");
            //message.setStatus(Message.HELLO);
            //ksession.insert(message);
            ksession.fireAllRules();
            logger.close();
            System.out.println(answers.getIdx());

        } catch (Throwable t) {
            t.printStackTrace();
        }

    }

    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("Sample.drl"), ResourceType.DRL);
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

}
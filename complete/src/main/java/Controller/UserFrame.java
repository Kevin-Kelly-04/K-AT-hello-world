package Controller;
//import View.*;
import Model.*;
//import javax.scene.control.SplitPane;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class UserFrame extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private int index = 0;
    private UserModel userModel = new UserModel();
    private JSplitPane splitPane = new JSplitPane();
    private JFrame userFrame = new JFrame("Mental Illness");
    public JPanel questionPanel = new JPanel();
    public JPanel answerPanel = new JPanel();
    public JPanel formatPanel = new JPanel();
    public JTextArea text = new JTextArea("Welcome to the Mental Illness determiner");

    public UserFrame(UserModel model) {
        this.setUserModel(model);
        // Set the frame options
        userFrame.setSize(600, 300);
        userFrame.setDefaultCloseOperation(3);
        userFrame.add(splitPane, BorderLayout.CENTER);

        // Create a splitpane which separates the questions from the answers
        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(150);
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


        // Get new question ready on screen
        text.setText((String)userModel.getQuestions().get(index));
        // Remove former buttons
        formatPanel.removeAll();
        ArrayList listAnswers = (ArrayList) userModel.getAnswers().get(index);
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
    }

    public void setUserModel(UserModel model) {
        this.userModel = model;
    }


}
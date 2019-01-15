package Controller;
import View.*;
import Model.*;
import javafx.scene.control.SplitPane;

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
	//private UserPanel userPanel = new UserPanel();
	private UserModel userModel = new UserModel();
	private JSplitPane splitPane = new JSplitPane();
	private JFrame userFrame = new JFrame("Mental Illness");
	public JPanel questionPanel = new JPanel();
    public JPanel answerPanel = new JPanel();
    public JLabel questionLabel = new JLabel("Default label");

    public UserFrame(UserModel model) {
        this.setUserModel(model);
        userFrame.setSize(600, 300);
        userFrame.setDefaultCloseOperation(3);
        userFrame.add(splitPane, BorderLayout.CENTER);

        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(150);
        splitPane.setTopComponent(questionPanel);
        splitPane.setBottomComponent(answerPanel);

        questionPanel.add(questionLabel);

        answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.PAGE_AXIS));
        answerPanel.add(new JButton("Button"));
        JButton newButton = new JButton("Hello");
        newButton.addActionListener(this);
        answerPanel.add(newButton);
        answerPanel.add(new JButton("Button two"));

        userFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        questionLabel.setText((String)userModel.getQuestions().get(index));
        answerPanel.removeAll();
        ArrayList listAnswers = (ArrayList) userModel.getAnswers().get(index);
        for (int idx = 0; idx < listAnswers.size(); idx++ ) {
            JButton newButton = new JButton((String)listAnswers.get(idx));
            newButton.addActionListener(this);
            answerPanel.add(newButton);
        }
        splitPane.setBottomComponent(answerPanel);
        splitPane.setDividerLocation(150);
        userFrame.repaint();
        userFrame.setVisible(true);
        index++;
    }

    public void setUserModel(UserModel model) {
        this.userModel = model;
    }

	
}

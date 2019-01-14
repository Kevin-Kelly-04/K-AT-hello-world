package View;

import Model.*;
import Controller.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;


public class UserPanel extends JPanel implements Observer {
	private UserFrame frame;
	private UserModel userModel;
	private int index = 0;

	public UserPanel() {
		//this.addMouseListener();
		//this.addMouseMotionListener();
		this.setOpaque(true);
		this.setBackground(new Color(222, 212, 169));
	}

	private void paintQuestions(Graphics g) {
		g.drawString((String)userModel.getQuestions().get(index), getWidth()/2, getHeight()/10 );
	}

	private void paintAnswers(Graphics g) {
        frame.basePanel.add(Box.createRigidArea(new Dimension(0, 5)));
		frame.basePanel.add(new JButton("Maybe"));
		frame.setVisible(true);
	}
	public void setModel(UserModel model) {
		this.userModel = model;
		this.repaint();
	}

	public void setUserFrame(UserFrame frame) {
		this.frame = frame;
	}

	public UserFrame getUserFrame() {
		return this.frame;
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.paintQuestions(g);
		//this.paintAnswers(g);
	}

	public void update(Observable observed, Object message) {
		this.repaint();
	}
}

package Controller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	public Frame() {
		initialize();
	}
	public void initialize() {
		JFrame frame = new JFrame("Mental illness - Knowledge Technology Practical");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(900,700);
	    
	    JPanel basePanel = new JPanel();
        basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.Y_AXIS));
        basePanel.setBorder(new EmptyBorder(new Insets(frame.getWidth()/2, frame.getHeight()/2+50, 3, 3)));

        basePanel.add(new JButton("Button"));
        basePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        basePanel.add(new JButton("Button"));
        basePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        basePanel.add(new JButton("Button"));
        basePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        basePanel.add(new JButton("Button"));

        frame.add(basePanel, BorderLayout.CENTER);

        pack();

        setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
}

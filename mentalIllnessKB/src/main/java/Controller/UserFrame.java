package Controller;
import View.*;
import Model.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;


public class UserFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private UserPanel userPanel = new UserPanel();
	private UserModel userModel = new UserModel();
	private JFrame userFrame = new JFrame("Mental Illness");
	public JPanel basePanel = new JPanel();

    public UserFrame(UserModel model) {
        this.setUserModel(model);
        userFrame.setSize(1400, 800);
        userFrame.setDefaultCloseOperation(3);
        //basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.Y_AXIS));
        //basePanel.setBorder(new EmptyBorder(new Insets(getWidth()/2, getHeight()/2+50, 3, 3)));
        basePanel.setBackground(new Color(222, 212, 169));
        basePanel.setLocation(getWidth()/2, getHeight() /20);
        /*JPanel header = new JPanel();
        frame.add(header, "North");
        header.setLayout(new FlowLayout(1, 5, 5));
        header.setBackground(new Color(222, 212, 169));*/
        this.userPanel.setUserFrame(this);
        userFrame.add(this.userPanel);
        //userFrame.add(basePanel);
        userFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        /*if (e.getActionCommand().equals("newGraphModel")) {
            this.setGraphModel(new GraphModel());
        } else if (e.getActionCommand().equals("saveGraphModel")) {
            this.saveGraphModel();
        } else {
            if (e.getActionCommand().equals("openGraphModel")) {
                GraphModel graphModel = this.loadGraphModelDialog();
                if (graphModel != null) {
                    this.setGraphModel(graphModel);
                }
            }

        }*/
    }

    public void setUserModel(UserModel model) {
        this.userModel = model;
        this.userPanel.setModel(model);
        model.addObserver(this.userPanel);
    }

	public void initialize() {
		JFrame frame = new JFrame("Mental illness - Knowledge Technology Practical");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(900,1200);
	    
	    /*JPanel basePanel = new JPanel();

        basePanel.setLayout(new BoxLayout(basePanel, BoxLayout.Y_AXIS));
        basePanel.setBorder(new EmptyBorder(new Insets(frame.getWidth()/2, frame.getHeight()/2+50, 3, 3)));

        basePanel.add(new JButton("Yes"));
        basePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        /*basePanel.add(new JButton("No"));
        basePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        basePanel.add(new JButton("Maybe"));
        basePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        basePanel.add(new JButton("..."));
        //basePanel.setLocation(frame.getWidth(), frame.getHeight());
        basePanel.setLocation(450, 600);
        frame.add(basePanel);*/
        /*FrameDragListener frameDragListener = new FrameDragListener(frame);
        frame.addMouseListener(frameDragListener);
        frame.addMouseMotionListener(frameDragListener);*/
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}

	
}

package Controller;

import java.util.Observable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import View.*;
//import Model.*;

public class ActionControl extends Observable implements ActionListener, MouseListener {
	private UserPanel panel;
	
	public ActionControl(UserPanel panel) {
		this.panel = panel;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mousePressed(MouseEvent m) {
		
	}
	
	
	
	
	public void mouseClicked(MouseEvent m) {
	}
	public void mouseEntered(MouseEvent m) {
	}
	public void mouseExited(MouseEvent m) {
	}
	public void mouseReleased(MouseEvent m) {
	}

}

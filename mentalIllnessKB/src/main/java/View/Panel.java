package View;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class Panel extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	public Panel() {
		this.setOpaque(true);
		this.setBackground(new Color(222, 212, 169));
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
	}
	public void update(Observable observed, Object message) {
		this.repaint();		
	}

}

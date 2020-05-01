package vue;

import java.awt.EventQueue;
import partie.*;

import javax.swing.JFrame;
import Mvc.*;
import moudleOfPlayer.*;
/**
 * This class is part of the visualization
 */

public class Game implements Observer {
	private Round round;

	private JFrame frame;

	/**
	 * Launch the application.
	 * @param r
	 */
	public Game(Round r) {
		this.round=r;
		initialize();
	}
	
	
	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
	}
	
	/**
	 * 
	 */
	@Override
	public void update(Object o) {
		
		
	}

	
}

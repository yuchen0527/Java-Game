package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import Mvc.View;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This class is to choose which game to play : Jest Game and Lucky Game
 * 
 */

public class chooseMode {

	public JFrame frame;
	private View view;
	public chooseMode(View view) {
		this.view=view;
		initialize();
	}
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public chooseMode() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 591, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnJest = new JButton("Jest Game");
		btnJest.addActionListener(new btnJestGame(this));
		btnJest.setBounds(212, 178, 123, 29);
		frame.getContentPane().add(btnJest);
		
		JButton btnLuckyGame = new JButton("Lucky Game");
		btnLuckyGame.addActionListener(new btnLuckyGame(this));
		btnLuckyGame.setBounds(212, 262, 123, 29);
		frame.getContentPane().add(btnLuckyGame);
		
		JLabel lblPleaseChooseThe = new JLabel("Please choose the game you want to play:");
		lblPleaseChooseThe.setBounds(33, 82, 461, 21);
		frame.getContentPane().add(lblPleaseChooseThe);
	}
	private class btnLuckyGame implements ActionListener{
		private chooseMode chooseMode;
		public btnLuckyGame(chooseMode chooseMode) {
			this.chooseMode=chooseMode;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			this.chooseMode.view.setChange();
			this.chooseMode.view.setMode(2);
			this.chooseMode.frame.setVisible(false);
			
		}
		
	}
	private class btnJestGame implements ActionListener{
		private chooseMode chooseMode;
		public btnJestGame(chooseMode chooseMode) {
			this.chooseMode=chooseMode;
		}
		@Override
		/**
		 * override ActionListener
		 */
		public void actionPerformed(ActionEvent e) {
			this.chooseMode.view.setChange();
			this.chooseMode.view.setMode(1);
			this.chooseMode.frame.setVisible(false);
		}
		
	}

}

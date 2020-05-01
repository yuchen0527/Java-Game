package vue;

import java.awt.EventQueue;

/**
 * This class is part of the visualization
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import Mvc.View;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import partie.*;
public class setting {

	private View view;
	private Round round;
	public JFrame frmJest;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblHowManyAis_1;
	private JTextField textField_2;
	private JLabel lblIfYouWant;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * @param View
	 */
	public setting(View view) {
		initialize();
		this.view=view;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJest = new JFrame();
		frmJest.setTitle("Jest");
		frmJest.setBounds(100, 100, 458, 472);
		frmJest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJest.getContentPane().setLayout(null);
		
		JLabel lblHowManyHumans = new JLabel("How many humans?");
		lblHowManyHumans.setBounds(80, 85, 191, 21);
		frmJest.getContentPane().add(lblHowManyHumans);
		
		JLabel lblHowManyAis = new JLabel("How many AIs in eazy level?");
		lblHowManyAis.setBounds(80, 151, 294, 21);
		frmJest.getContentPane().add(lblHowManyAis);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new btnStart(this));
		
		btnStart.setBounds(148, 336, 123, 29);
		frmJest.getContentPane().add(btnStart);
		
		textField = new JTextField();
		
		textField.setBounds(256, 109, 96, 27);
		frmJest.getContentPane().add(textField);
		textField.setColumns(10);
		textField.getText();
		
		textField_1 = new JTextField();
		
		textField_1.setBounds(256, 187, 96, 27);
		frmJest.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblHowManyAis_1 = new JLabel("How many AIs in difficult level?");
		lblHowManyAis_1.setBounds(80, 229, 341, 21);
		frmJest.getContentPane().add(lblHowManyAis_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(256, 265, 96, 27);
		frmJest.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblIfYouWant = new JLabel("If you want to putin in the console,click here");
		lblIfYouWant.setBounds(15, 15, 421, 29);
		frmJest.getContentPane().add(lblIfYouWant);
		
		JButton btnConsole = new JButton("console");
		btnConsole.addActionListener(new btnConsole(this));
		btnConsole.setBounds(148, 41, 123, 29);
		frmJest.getContentPane().add(btnConsole);
		frmJest.setVisible(true);
	}
	private class btnStart implements ActionListener{
		private setting s;
		int numOfHuman;int numOfAIEazy;int numOfAIDF;
		public btnStart(setting s) {
			this.s=s;
		}
		public void actionPerformed(ActionEvent e) {
			
				int a=Integer.parseInt(textField.getText());
				int b=Integer.parseInt(textField_1.getText());
				int c=Integer.parseInt(textField_2.getText());
				s.view.howManyPlayer(a,b,c);
				s.view.setChange();
			
			frmJest.dispose();
			s.view.getJestWindow().frmJest.setVisible(true);
			}
		}
	private class btnConsole implements ActionListener{
		private setting s;
		public btnConsole(setting s) {
			this.s=s;
		}
		
		public void actionPerformed(ActionEvent e) {
			s.view.howManyPlayer();
			
		}
		
	}
}


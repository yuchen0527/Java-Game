package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * This class is part of the visualization
 */
public class rule {

	private JFrame frame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rule window = new rule();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public rule() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 491, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRule = new JLabel("Rule");
		lblRule.setBounds(47, 50, 81, 21);
		frame.getContentPane().add(lblRule);
		
		JLabel lblHello = new JLabel("Welcome to Jest!\r\n");
		lblHello.setBounds(92, 129, 312, 254);
		frame.getContentPane().add(lblHello);
	}

}

package vue;

/**
 * This class is part of the visualization
 */

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;
import Mvc.*;
import moudleOfPlayer.*;
import partie.*;

public class Main extends JFrame implements Observer{
	
	public static boolean start=false;
	private View view;
	JFrame jf;
	Round round = null;
	public void update(Object o) {
		
	}

	public Main(View view) {
		this.view=view;
		 jf = new JFrame("Jest");
	        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        jf.setSize(400, 500);
	        jf.setLocationRelativeTo(null);

	        // Create window
	        SpringLayout layout = new SpringLayout();
	        JPanel panel = new JPanel(layout);
	        jf.setContentPane(panel);
	       

	        panel.setBackground(Color.WHITE);
	        
	        JButton rule =new JButton("rule");
	        

	        // create component
	        JLabel cover = new JLabel();
	        ImageIcon i=new ImageIcon("C:/Users/11508/Desktop/JestPicture/cover.png");
	        JButton btn = new JButton("Start!!");
	        JTextField textField = new JTextField("Text Field");
	        cover.setIcon(i);
	        btn.addActionListener(new BtnActionListener(this));

	        // create module
	        panel.add(rule);
	        panel.add(cover);
	        panel.add(btn);

	        /*
	         * setting of the module(core)
	         */

	        // rotates a shape around upper-left corner (5, 5)
	       

	        SpringLayout.Constraints ruleCons=layout.getConstraints(rule);
	        ruleCons.setX(Spring.constant(5));
	        ruleCons.setY(Spring.constant(5));
	        
	       
	       

	        // Text box constraint: set the upper left horizontal coordinate as the label's eastern coordinate + 5,
	        //and the vertical coordinate as 5
	        SpringLayout.Constraints coverCons = layout.getConstraints(cover);  // Gets the constraint object for the specified component from the layout (if not, it is automatically created)
	        coverCons.setX(
	        		Spring.constant(20)
	        );
	        coverCons.setY(ruleCons.getConstraint(SpringLayout.SOUTH));

	        
	        
	        SpringLayout.Constraints btnCons = layout.getConstraints(btn);
	        btnCons.setX(Spring.constant(20));
	        btnCons.setY(Spring.sum(coverCons.getConstraint(SpringLayout.SOUTH), Spring.constant(5)));
	        btnCons.setConstraint(SpringLayout.EAST, coverCons.getConstraint(SpringLayout.EAST));
	        /*
	         * Constraint Settings for the content panel (container), which
	         *  determines the size of the gap between the right and 
	         * bottom sides of the component and container
	         */
	        SpringLayout.Constraints panelCons = layout.getConstraints(panel);  // Gets the container's constraint object

	        // set east as textbox's east + 5
	        panelCons.setConstraint(
	                SpringLayout.EAST,
	                Spring.sum(
	                        coverCons.getConstraint(SpringLayout.EAST),
	                        Spring.constant(5)
	                )
	        );

	        // caculate the location
	        Spring maxHeightSpring = Spring.max(
	                btnCons.getConstraint(SpringLayout.SOUTH),
	                coverCons.getConstraint(SpringLayout.SOUTH)
	        );

	        // set container: maxHeightSpring + 5
	        panelCons.setConstraint(
	                SpringLayout.SOUTH,
	                Spring.sum(
	                		btnCons.getConstraint(SpringLayout.SOUTH),
	                        Spring.constant(5)
	                )
	        );

	        // show window
	        jf.setVisible(true);
	}
	 private class BtnActionListener implements ActionListener{
		 Main m;
		public BtnActionListener(Main main) {
			m=main;
		}
 		public void actionPerformed(ActionEvent e) {
 			m.jf.dispose();
 			setting s=new setting(m.view);
 			this.updatestart();
 			m.view.setting=s;
 		}	
 		public void updatestart() {
 			m.view.gameStart();
 		}
	 }
	 public static void main(String[]args) {
		
		 
	 }

}

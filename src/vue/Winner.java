package vue;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Mvc.Controller;
import moudle.Card;
/**
 * This class is part of the visualization
 */
public class Winner {

	
	
	private ImageIcon ClubA=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\ClubA.png");
	private ImageIcon ClubFour=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\ClubFour.png");
	private ImageIcon ClubThree=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\ClubThree.png");
	private ImageIcon ClubTwo=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\ClubTwo.png");
	private ImageIcon DiamondeA=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\DiamondeA.png");
	private ImageIcon DiamondeFour=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\DiamondeFour.png");
	private ImageIcon DiamondeThree=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\DiamondeThree.png");
	private ImageIcon DiamondeTwo=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\DiamondeTwo.png");
	private ImageIcon HeartA=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\HeartA.png");
	private ImageIcon HeartFour=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\HeartFour.png");
	private ImageIcon HeartThree=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\HeartThree.png");
	private ImageIcon HeartTwo=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\HeartTwo.png");
	private ImageIcon Joker=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\jest.png");
	private ImageIcon reference=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\reference.png");
	private ImageIcon SpadeA=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\SpadeA.png");
	private ImageIcon SpadeFour=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\SpadeFour.png");
	private ImageIcon SpadeThree=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\SpadeThree.png");
	private ImageIcon SpadeTwo=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\SpadeTwo.png");
	private ImageIcon CardBack=new ImageIcon("C:\\\\Users\\\\11508\\\\Desktop\\\\JestPicture\\\\CardBack.jpg");
	private ImageIcon Nothing=new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\nothing.jpg");
	
	
	
	
	
	
	
	private JFrame frame;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private Controller controller;
	private JLabel lblWinner;
	/**
	 * Launch the application.
	 */
	
/**
 * 
 * Create the application.
 *	
 * @param controller
 */
	public Winner(Controller controller) {
		this.controller=controller;
		initialize();
		this.updateHuman();
		this.updateAIOne();
		this.updateAITwo();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1553, 970);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPlayer = new JLabel("Player1:"+this.controller.getRound().system.getPlayers().get(0).getInformation().getValueJest());
		lblPlayer.setBounds(48, 15, 81, 21);
		frame.getContentPane().add(lblPlayer);
		
		JLabel lblAiplayer = new JLabel("AIPlayer2:"+this.controller.getRound().system.getPlayers().get(1).getInformation().getValueJest());
		lblAiplayer.setBounds(48, 296, 81, 21);
		frame.getContentPane().add(lblAiplayer);
		
		JLabel lblAiplayer_1 = new JLabel("AIPlayer3:"+this.controller.getRound().system.getPlayers().get(2).getInformation().getValueJest());
		lblAiplayer_1.setBounds(48, 548, 81, 21);
		frame.getContentPane().add(lblAiplayer_1);
		
		label = new JLabel("New label");
		label.setBounds(104, 74, 156, 207);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("New label");
		label_1.setBounds(292, 74, 156, 207);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("New label");
		label_2.setBounds(484, 74, 156, 207);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("New label");
		label_3.setBounds(682, 74, 156, 207);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("New label");
		label_4.setBounds(888, 74, 156, 207);
		frame.getContentPane().add(label_4);
		
	
		JLabel lblJest = new JLabel("Jest");
		lblJest.setBounds(631, 15, 81, 21);
		frame.getContentPane().add(lblJest);
		
		label_5 = new JLabel("");
		label_5.setBounds(1092, 74, 156, 207);
		frame.getContentPane().add(label_5);
		
		label_6 = new JLabel("");
		label_6.setBounds(1322, 74, 156, 207);
		frame.getContentPane().add(label_6);
		
		label_7 = new JLabel("");
		label_7.setBounds(104, 332, 156, 207);
		frame.getContentPane().add(label_7);
		
		label_8 = new JLabel("New label");
		label_8.setBounds(292, 332, 156, 207);
		frame.getContentPane().add(label_8);
		
		label_9 = new JLabel("New label");
		label_9.setBounds(484, 332, 156, 207);
		frame.getContentPane().add(label_9);
		
		label_10 = new JLabel("New label");
		label_10.setBounds(682, 332, 156, 207);
		frame.getContentPane().add(label_10);
		
		label_11 = new JLabel("New label");
		label_11.setBounds(888, 332, 156, 207);
		frame.getContentPane().add(label_11);
		
		label_12 = new JLabel("");
		label_12.setBounds(1092, 332, 156, 207);
		frame.getContentPane().add(label_12);
		
		label_13 = new JLabel("");
		label_13.setBounds(1300, 332, 156, 207);
		frame.getContentPane().add(label_13);
		
		label_14 = new JLabel("");
		label_14.setBounds(104, 584, 156, 207);
		frame.getContentPane().add(label_14);
		
		label_15 = new JLabel("");
		label_15.setBounds(292, 584, 156, 207);
		frame.getContentPane().add(label_15);
		
		label_16 = new JLabel("");
		label_16.setBounds(484, 584, 156, 207);
		frame.getContentPane().add(label_16);
		
		label_17 = new JLabel("New label");
		label_17.setBounds(682, 584, 156, 207);
		frame.getContentPane().add(label_17);
		
		label_18 = new JLabel("New label");
		label_18.setBounds(888, 584, 156, 207);
		frame.getContentPane().add(label_18);
		
		label_19 = new JLabel("");
		label_19.setBounds(1092, 584, 156, 207);
		frame.getContentPane().add(label_19);
		
		label_20 = new JLabel("");
		label_20.setBounds(1300, 584, 156, 207);
		frame.getContentPane().add(label_20);
		
		
		lblWinner = new JLabel("Winner:"+this.controller.getRound().winner.getName());
		lblWinner.setBounds(73, 817, 233, 29);
		frame.getContentPane().add(lblWinner);
	}
	public void updateHuman() {
		if(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().size()==5) {
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(0), this.label);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(1), this.label_1);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(2), this.label_2);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(3), this.label_3);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(4), this.label_4);
		}else if(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().size()==6) {
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(0), this.label);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(1), this.label_1);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(2), this.label_2);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(3), this.label_3);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(4), this.label_4);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(5), this.label_5);
		}else if(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().size()==7) {
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(0), this.label);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(1), this.label_1);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(2), this.label_2);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(3), this.label_3);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(4), this.label_4);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(5), this.label_5);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(0).getJest().getJests().get(6), this.label_6);
		}
	}
	public void updateAIOne() {
		if(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().size()==5) {
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(0), this.label_7);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(1), this.label_8);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(2), this.label_9);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(3), this.label_10);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(4), this.label_11);
		}else if(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().size()==6) {
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(0), this.label_7);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(1), this.label_8);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(2), this.label_9);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(3), this.label_10);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(4), this.label_11);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(5), this.label_12);
		}else if(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().size()==7) {
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(0), this.label_7);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(1), this.label_8);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(2), this.label_9);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(3), this.label_10);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(4), this.label_11);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(5), this.label_12);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(1).getJest().getJests().get(6), this.label_13);
		}
	}
	public void updateAITwo() {
		if(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().size()==5) {
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(0), this.label_14);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(1), this.label_15);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(2), this.label_16);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(3), this.label_17);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(4), this.label_18);
		}else if(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().size()==6) {
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(0), this.label_14);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(1), this.label_15);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(2), this.label_16);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(3), this.label_17);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(4), this.label_18);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(5), this.label_19);
		}else if(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().size()==7) {
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(0), this.label_14);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(1), this.label_15);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(2), this.label_16);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(3), this.label_17);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(4), this.label_18);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(5), this.label_19);
			this.updatePicture(this.controller.getRound().system.getPlayers().get(2).getJest().getJests().get(6), this.label_20);
		}
	}
	public void updatePicture(Card c,JLabel j) {
		String suit=c.getSuit().getSuitString();
		int value=c.getRealValue().getValueInt();
		switch(suit) {
		case"Clubs":
			switch(value) {
			case 1:
				j.setIcon(ClubA);break;
			case 2:
				j.setIcon(ClubTwo);break;
			case 3:
				j.setIcon(ClubThree);break;
			case 4:
				j.setIcon(ClubFour);break;
			default: break;
			}
			break;
		case"Diamonds":
			switch(value) {
			case 1:
				j.setIcon(DiamondeA);break;
			case 2:
				j.setIcon(DiamondeTwo);break;
			case 3:
				j.setIcon(DiamondeThree);break;
			case 4:
				j.setIcon(DiamondeFour);break;
			default: break;
			}
			break;
		case"Hearts":
			switch(value) {
			case 1:
				j.setIcon(HeartA);break;
			case 2:
				j.setIcon(HeartTwo);break;
			case 3:
				j.setIcon(HeartThree);break;
			case 4:
				j.setIcon(HeartFour);break;
			default: break;
			}
		    break;
		case"Spades":
			switch(value) {
			case 1:
				j.setIcon(SpadeA);break;
			case 2:
				j.setIcon(SpadeTwo);break;
			case 3:
				j.setIcon(SpadeThree);break;
			case 4:
				j.setIcon(SpadeFour);break;
			default: break;
			}
			break;
		case"Null":
			j.setIcon(Joker);break;
		default: break;
		}
	}
}

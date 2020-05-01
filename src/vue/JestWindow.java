package vue;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mvc.Controller;
import moudle.*;
import moudleOfPlayer.*;
import partie.*;
/**
 * This class is part of the visualization
 */
public class JestWindow {

	/**
	 * the number player choose to represent which card
	 */
	public int whichCard;
	/**
	 * the number player choose to represent who
	 */
	public int who;
	
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
	
	
	
	public JFrame frmJest;
	private Round round;
	private Controller controller;
	private JButton btnAIOneLeft;
	private JButton btnAIOneRight;
	private JButton btAITwoLeft;
	private JButton btAITwoRight;
	private JButton btHumanOneLeft;
	private JButton btHumanOneRight;
	private JLabel Trophy1;
	private JLabel Trophy2;
	private JButton btnAione;
	private JButton btnAitwo;
	private JLabel label;
	private JLabel label_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JestWindow window = new JestWindow();
					window.frmJest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JestWindow() {
		initialize();
	}
	public JestWindow(Controller controller) {
		initialize();
		this.controller=controller;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void setBg(){ 
    	((JComponent) frmJest.getContentPane()).setOpaque(false); 
    	ImageIcon img = new ImageIcon
    			("C:\\Users\\11508\\Desktop\\JestPicture\\ground.jpg"); 
    	JLabel background = new JLabel(img);
    	this.frmJest.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
    	background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); 
    }
	private void initialize() {
		
		
		
		
		
		
		
		
		frmJest = new JFrame();
		frmJest.setTitle("Jest");
		frmJest.setBounds(100, 100, 1218, 790);
		frmJest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJest.getContentPane().setLayout(null);
		this.setBg();
		
		//AI1 left card
		btnAIOneLeft = new JButton("New button");
		btnAIOneLeft.setContentAreaFilled(false); 
		ImageIcon CardBack=new ImageIcon("C:\\\\Users\\\\11508\\\\Desktop\\\\JestPicture\\\\CardBack.jpg");
		CardBack.setImage(CardBack.getImage().getScaledInstance(156, 207,Image.SCALE_DEFAULT));
		
		
		btnAIOneLeft.setIcon(CardBack);
		btnAIOneLeft.setBorderPainted(false);
		btnAIOneLeft.setBorder(null);
		btnAIOneLeft.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnAIOneLeft.addActionListener(new btnAIOneLeft(this));
		btnAIOneLeft.setBounds(83, 76, 165, 207);
		frmJest.getContentPane().add(btnAIOneLeft);
		
		
		
		//AI1 right card
		
		btnAIOneRight = new JButton("New button");
		btnAIOneRight.setContentAreaFilled(false); 
		btnAIOneRight.setBounds(300, 76, 165, 207);
		frmJest.getContentPane().add(btnAIOneRight);
		btnAIOneRight.setIcon(CardBack);
		btnAIOneRight.setBorderPainted(false);
		btnAIOneRight.setBorder(null);
		btnAIOneRight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnAIOneRight.addActionListener(new btnAIOneRight(this));
		
		//AI2 left card
		btAITwoLeft = new JButton("New button");
		btAITwoLeft.setIcon(CardBack);
		btAITwoLeft.setContentAreaFilled(false); 
		btAITwoLeft.setBorderPainted(false);
		btAITwoLeft.setBorder(null);
		btAITwoLeft.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btAITwoLeft.setBounds(719, 76, 156, 207);
		frmJest.getContentPane().add(btAITwoLeft);
		
		btAITwoLeft.addActionListener(new btnAITwoLeft(this));
		
		
		//AI2 right card
		btAITwoRight = new JButton("New button");
		
		btAITwoRight.setIcon(CardBack);
		btAITwoRight.setContentAreaFilled(false); 
		btAITwoRight.setBorderPainted(false);
		btAITwoRight.setBorder(null);
		btAITwoRight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		btAITwoRight.setBounds(936, 76, 156, 207);
		frmJest.getContentPane().add(btAITwoRight);
		
		btAITwoRight.addActionListener(new btnAITwoRight(this));
		
		//player left card
		btHumanOneLeft= new JButton("New button");
		btHumanOneLeft.setIcon(CardBack);
		btHumanOneLeft.setContentAreaFilled(false); 
		btHumanOneLeft.setBorderPainted(false);
		btHumanOneLeft.setBorder(null);
		btHumanOneLeft.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btHumanOneLeft.addActionListener(new btHumanOneLeft(this));
		
		btHumanOneLeft.setBounds(415, 491, 156, 207);
		frmJest.getContentPane().add(btHumanOneLeft);
		
		
		//player right card
		btHumanOneRight = new JButton("New button");
		btHumanOneRight.setIcon(CardBack);
		btHumanOneRight.setContentAreaFilled(false); 
		btHumanOneRight.setBorderPainted(false);
		btHumanOneRight.setBorder(null);
		btHumanOneRight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btHumanOneRight.addActionListener(new btHumanOneRight(this));
		btHumanOneRight.setBounds(647, 491, 156, 207);
		frmJest.getContentPane().add(btHumanOneRight);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\11508\\Desktop\\JestPicture\\reference.png"));
		lblNewLabel.setBounds(514, 255, 156, 207);
		frmJest.getContentPane().add(lblNewLabel);
		
		JLabel lblTrophy = new JLabel("Trophy1");
		lblTrophy.setBounds(26, 453, 81, 21);
		frmJest.getContentPane().add(lblTrophy);
		
		Trophy1 = new JLabel("New label");
		Trophy1.setBounds(26, 491, 156, 207);
		frmJest.getContentPane().add(Trophy1);
		
		Trophy2 = new JLabel("New label");
		Trophy2.setBounds(197, 491, 156, 207);
		frmJest.getContentPane().add(Trophy2);
		
		JLabel lblTrophy_1 = new JLabel("Trophy2");
		lblTrophy_1.setBounds(197, 453, 81, 21);
		frmJest.getContentPane().add(lblTrophy_1);
		
		
		
		
		
		
		
		
		
		btnAione = new JButton("AIOne");
		btnAione.setBounds(197, 310, 123, 29);
		frmJest.getContentPane().add(btnAione);
		btnAione.addActionListener(new btnAIOne(this));
		
		
		
		btnAitwo = new JButton("AITwo");
		btnAitwo.setBounds(853, 310, 123, 29);
		frmJest.getContentPane().add(btnAitwo);
		
		label = new JLabel("");
		label.setBounds(840, 491, 156, 207);
		frmJest.getContentPane().add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(1011, 491, 156, 207);
		frmJest.getContentPane().add(label_1);
		btnAitwo.addActionListener(new btnAITwo(this));
		
		
	}
	
	private class btHumanOneLeft implements ActionListener{
		private JestWindow j;
		public btHumanOneLeft(JestWindow j) {
			this.j=j;
		}
		public void actionPerformed(ActionEvent e) {
			this.j.controller.getView().text.t.stop();
			this.j.controller.getView().setChange();
			this.j.controller.getView().setWhich(1);
		}
	}
	private class btHumanOneRight implements ActionListener{
		private JestWindow j;
		public btHumanOneRight(JestWindow j) {
			this.j=j;
		}
		public void actionPerformed(ActionEvent e) {
			this.j.controller.getView().text.t.stop();
			this.j.controller.getView().setChange();
			this.j.controller.getView().setWhich(2);
			
		}
	}
	
	private class btnAIOneLeft implements ActionListener {
		
		private JestWindow j;
		
		public btnAIOneLeft(JestWindow j) {
			this.j=j;
		}
		
		public void actionPerformed(ActionEvent e) {
			this.j.controller.getView().setChange();
			this.j.controller.getView().setWhich(1);
			this.j.controller.getView().text.t.stop();
		}

	}
	private class btnAIOneRight implements ActionListener {
			
			private JestWindow j;
			
			public btnAIOneRight(JestWindow j) {
				this.j=j;
			}
			
			public void actionPerformed(ActionEvent e) {
				this.j.controller.getView().setChange();
				this.j.controller.getView().setWhich(2);
				this.j.controller.getView().text.t.stop();
			}
	
		}
	private class btnAITwoLeft implements ActionListener {
		
			private JestWindow j;
			
			public btnAITwoLeft(JestWindow j) {
				this.j=j;
			}
			
			public void actionPerformed(ActionEvent e) {
				this.j.controller.getView().setChange();
				this.j.controller.getView().setWhich(1);
				this.j.controller.getView().text.t.stop();
			}
	
		}
	private class btnAITwoRight implements ActionListener {
		
			private JestWindow j;
			
			public btnAITwoRight(JestWindow j) {
				this.j=j;
			}
			
			public void actionPerformed(ActionEvent e) {
				this.j.controller.getView().setChange();
				this.j.controller.getView().setWhich(2);
				this.j.controller.getView().text.t.stop();
			}
	
		}
	private class btnAIOne implements ActionListener {
		
			private JestWindow j;
			
			public btnAIOne(JestWindow j) {
				this.j=j;
			}
			
			public void actionPerformed(ActionEvent e) {
				this.j.controller.getView().text.t.stop();
				this.j.controller.getView().setChange();
				this.j.controller.getView().setWhich(2);
				
			}
	
		}
	
	private class btnAITwo implements ActionListener {
		
		private JestWindow j;
		
		public btnAITwo(JestWindow j) {
			this.j=j;
		}
		
		public void actionPerformed(ActionEvent e) {
			this.j.controller.getView().text.t.stop();
			this.j.controller.getView().setChange();
			this.j.controller.getView().setWhich(3);
			
		}

	}
		
	
	public void updateOffer() {
		
				Card offer1=this.controller.getRound().system.getPlayers().get(0).getOffer().offers.getFirst();
				Card offer2=this.controller.getRound().system.getPlayers().get(0).getOffer().offers.getLast();
				this.updateOfferPicture(offer1, btHumanOneLeft);
				this.updateOfferPicture(offer2, btHumanOneRight);
				this.updateHumanOfferPicture(this.controller.getRound().system.getPlayers().get(0).getOffer().offers.getFirst(), this.label);
				this.updateHumanOfferPicture(this.controller.getRound().system.getPlayers().get(0).getOffer().offers.getLast(), this.label_1);
		
		this.btnAIOneLeft.setIcon(CardBack);
		this.btnAIOneRight.setIcon(CardBack);
		this.btAITwoLeft.setIcon(CardBack);
		this.btAITwoRight.setIcon(CardBack);
		this.controller.getView().cancelChanged();
	}
	
	public void updateOfferPicture(Card c,JButton j) {
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
	
	
	
	public void updateTrophy() {
		Trophy Trophy1;
		Trophy Trophy2;
		Trophy1=this.controller.getRound().system.getTrophy1();
		Trophy2=this.controller.getRound().system.getTrophy2();
		this.updateTrophyPicture(Trophy1, this.Trophy1);
		this.updateTrophyPicture(Trophy2, this.Trophy2);
		
		this.controller.getView().cancelChanged();
		
		this.controller.getView().cancelChanged();
	}
	
	public void updateHumanOfferPicture(Card c,JLabel j) {
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
	public void updateTrophyPicture(Trophy t,JLabel j) { 
		String suit=t.getTrophy().getSuit().getSuitString();
		int value=t.getTrophy().getRealValue().getValueInt();
		
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
	
	public void updateOfferUp() {
		for(int i=0;i<this.controller.getRound().system.getPlayers().size();i++) {
			switch(i) {
			case 0:
				if(this.controller.getRound().system.getPlayers().get(i).getOffer().turn1=="Up") {
					this.updateOfferPicture(this.controller.getRound().system.getPlayers().get(i).getOffer().cardUp, btHumanOneLeft);
					this.btHumanOneRight.setIcon(CardBack);
					this.updateHumanOfferPicture(this.controller.getRound().system.getPlayers().get(i).getOffer().offers.getFirst(), this.label);
					this.updateHumanOfferPicture(this.controller.getRound().system.getPlayers().get(i).getOffer().offers.getLast(), this.label_1);
				}else if(this.controller.getRound().system.getPlayers().get(i).getOffer().turn2=="Up") {
					this.updateOfferPicture(this.controller.getRound().system.getPlayers().get(i).getOffer().cardUp, btHumanOneRight);
					this.btHumanOneLeft.setIcon(CardBack);
					this.updateHumanOfferPicture(this.controller.getRound().system.getPlayers().get(i).getOffer().offers.getFirst(), this.label);
					this.updateHumanOfferPicture(this.controller.getRound().system.getPlayers().get(i).getOffer().offers.getLast(), this.label_1);
				};break;
			case 1:
					if(this.controller.getRound().system.getPlayers().get(i).getOffer().turn1=="Up") {
						this.updateOfferPicture(this.controller.getRound().system.getPlayers().get(i).getOffer().cardUp, btnAIOneLeft);
					}else if(this.controller.getRound().system.getPlayers().get(i).getOffer().turn2=="Up") {
						this.updateOfferPicture(this.controller.getRound().system.getPlayers().get(i).getOffer().cardUp, btnAIOneRight);
					};break;
			case 2:
				if(this.controller.getRound().system.getPlayers().get(i).getOffer().turn1=="Up") {
					this.updateOfferPicture(this.controller.getRound().system.getPlayers().get(i).getOffer().cardUp, btAITwoLeft);
				}else if(this.controller.getRound().system.getPlayers().get(i).getOffer().turn2=="Up") {
					this.updateOfferPicture(this.controller.getRound().system.getPlayers().get(i).getOffer().cardUp, btAITwoRight);
				};break;
			}
			
		}
		
		this.controller.getView().cancelChanged();
	}
	}


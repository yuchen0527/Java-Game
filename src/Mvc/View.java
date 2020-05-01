package Mvc;
import vue.*;
import vue.JestWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.swing.ImageIcon;
import javax.swing.*;

import moudleOfPlayer.*;
import partie.Round;
/**
 * This class forms the graphical interface
 */
public class View implements Runnable,Observer{
	private Controller controller;
	private InputStream input;
	private PrintStream output;
	public static boolean inGame=false;
	public setting setting;
	public int vue;
	private JestWindow jestWindow;
	private static boolean hasChanged=false;
	private static int which;
	private static int who;
	private BufferedReader br;
	public VueText text;
	private static int mode;
	private chooseMode chooseMode;
	
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
	
	
	/**
	 * choose mode via the {@code controller}
	 */
	public void chooseMode() {
		this.controller.chooseMode(this.mode);
		this.cancelChanged();
	}
	/**
	 * constructor
	 * @param controller
	 */
	public View(Controller controller) {
		this.controller=controller;
		this.input=System.in;
		this.output=System.out;
		this.jestWindow=new JestWindow(controller);
		this.text=new VueText(this);
		this.chooseMode=new chooseMode(this);
	}
	/**
	 * start game
	 */
	public void start() {
		this.chooseMode.frame.setVisible(true);
	}
	/**
	 * start game in controller
	 */
	public void gameStart() {
		System.out.println("Game start!!");
		this.inGame=true;
		System.out.println("********************");
	}
	/**
	 * getter
	 * @return
	 */
	public JestWindow getJestWindow() {
		return this.jestWindow;
	}
	/**
	 * decide how many player
	 * @param a
	 * @param b
	 * @param c
	 */
	public void howManyPlayer(int a,int b,int c) {
		
		this.controller.numberOfPlayer(a,b,c);
	}
	/**
	 * decide players
	 */
	public void howManyPlayer() {
			
			System.out.println("How many humans?");
			BufferedReader br=new BufferedReader (new InputStreamReader(input));
			String chaine=null;
			try {
				chaine=br.readLine();
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			int numberOfPlayer=Integer.parseInt(chaine);
			
			System.out.println("How many AIs in eazy level?");
			br=new BufferedReader (new InputStreamReader(input));
			chaine=null;
			try {
				chaine=br.readLine();
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			int numberOfAIsEazy=Integer.parseInt(chaine);
			System.out.println("How many AIs in difficule level?");
			br=new BufferedReader (new InputStreamReader(input));
			chaine=null;
			try {
				chaine=br.readLine();
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			int numberOfAISDifficult=Integer.parseInt(chaine);
			
			this.controller.numberOfPlayer(numberOfPlayer,numberOfAIsEazy,numberOfAISDifficult);
			this.hasChanged=true;
		
		//this.setting.frmJest.dispose();
		this.jestWindow.frmJest.setVisible(true);
	}
	
	/**
	 * player get certain card in this way
	 * @return
	 */
	public int getWhichCard() {
		this.text=new VueText(this);
		this.text.t.start();
			while(this.hasChanged==false) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.hasChanged=false;
			this.text.t.stop();
			this.text=null;
			return this.which;
		}
	
	/**
	 * get card from which player
	 * @return
	 */
	public int getWho() {
		this.text=new VueText(this);
		this.text.t.start();
		while(this.hasChanged==false) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.hasChanged=false;
		return this.which;
		
		
	}
	

	
	/**
	 * play the game again
	 * @return
	 */
	public boolean onceAgain() {
		System.out.println("Do you want to play again?(yes/no)");
		BufferedReader br=new BufferedReader (new InputStreamReader(input));
		String chaine=null;
		try {
			chaine=br.readLine();
			String a=(String)chaine;
			if(a.equals("yes")) {
				return true;
			}else if(a.equals("no")) {
				System.out.println("Game over!");
				return false;
			}
			}catch (IOException e) {
				e.printStackTrace();
			}
		
		return false;
	}
	/**
	 * welcome page
	 */
	public void welcome() {
		new Main(this);
		
	}
	
	/**
	 * setter
	 * @param a
	 */
	public void setVue(int a) {
		this.vue=a;
	}
	
	/**
	 * component of observer mode
	 * @param r
	 */
	public void update(Round r) {
		this.hasChanged=false;
	}
	/**
	 * 
	 */
	public void run() {
		if(this.vue==1) {
			
		}else if(this.vue==2) {
			this.welcome();
		}
		
	}
	/**
	 * method to show offer
	 */
	public void showOffer() {
		for(int i=0;i<this.controller.getRound().system.getPlayers().size();i++) {
			if(this.controller.getRound().system.getPlayers().get(i) instanceof Human) {
				this.jestWindow.updateOffer();
			}
		}
	}
	/**
	 * setter
	 */
	public void setChange(){
		this.hasChanged=true;
	}
	/**
	 * getter
	 * @return
	 */
	public Controller getController() {
		return this.controller;
	}
	/**
	 * getter
	 * @return
	 */
	public boolean getHasChanged() {
		return this.hasChanged;
	}
	/**
	 * getter
	 */
	public void cancelChanged() {
		this.hasChanged=false;
	}
	/**
	 * getter
	 * @param a
	 */
	public void setWhich(int a) {
		this.which=a;
	}
	/**
	 * getter
	 * @param a
	 */
	public void setWho(int a) {
		this.who=a;
	}
	
	
	
	
/**
 * for lucky game decide how many players	
 */
public void howManyPlayerInlucky() {
		
		System.out.println("How many humans?");
		BufferedReader br=new BufferedReader (new InputStreamReader(input));
		String chaine=null;
		try {
			chaine=br.readLine();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int numberOfPlayer=Integer.parseInt(chaine);
		
		System.out.println("How many AI players?");
		br=new BufferedReader (new InputStreamReader(input));
		chaine=null;
		try {
			chaine=br.readLine();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int numberOfAIs=Integer.parseInt(chaine);
		
		
		this.controller.numberOfPlayerInlucky(numberOfPlayer,numberOfAIs);
		this.hasChanged=true;
}
/**
 * for lucky game , decide which card to give on table
 */
public int getWhichluckyCard() {
		System.out.println("Which card you want to choose?");
		BufferedReader br=new BufferedReader (new InputStreamReader(input));
		String chaine=null;
		try {
			chaine=br.readLine();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int whichcard=Integer.parseInt(chaine);
		return whichcard;
	}
	public void setMode(int a) {
		this.mode=a;
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}
}

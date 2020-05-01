package Mvc;

import partie.*;
import vue.Winner;
/**
 * The controller is the medium of interaction between the view and the model
 */
public class Controller {
	private View view;
	private Round round;
	private LuckyGame luckygame;
	/**
	 * structure a controller
	 */
	public Controller() {
		this.view=new View(this);
		this.round=new Round(this);
		this.luckygame=new LuckyGame(this);
	}
	/**
	 * set number of player
	 * @param numOfHuman
	 * @param numOfAIEasy
	 */
	public void numberOfPlayerInlucky(int numOfHuman,int numOfAIEasy) {
		this.luckygame.setLuckySystem(numOfHuman, numOfAIEasy);
	}
	/**
	 * set number of player
	 * @param numOfHuman
	 * @param numOfAIEazy
	 * @param numOfAIDF
	 */
	public void numberOfPlayer(int numOfHuman,int numOfAIEazy,int numOfAIDF) {
		this.round.setSystem(numOfHuman, numOfAIEazy, numOfAIDF);
	}
	
	/**
	 * if play it again
	 */
	public void onceAgain() {
		if(this.view.onceAgain()==true) {
			
		}
	}
	/**
	 * getter
	 * @return
	 */
	public Round getRound() {
		return this.round;
	}
	/**
	 * getter
	 * @return
	 */
	public View getView() {
		return this.view;
	}
	/**
	 * 
	 * @param a
	 */
	public void whichOfferUp(int a) {
		
	}
	/**
	 * Enable to run Lucky game here
	 */
	public void runLucky() {
		this.view.gameStart();
		this.view.howManyPlayerInlucky();
		this.luckygame.system.giveCardFromTable();
		this.luckygame.LuckyCardTrick();
		this.luckygame.decideLuckyKing();
	}
	/**
	 * jest game
	 */
	public void jestGame() {
		  this.view.welcome();
			while(this.view.inGame==false) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.view.cancelChanged();
			while(this.view.getHasChanged()==false) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			this.round.giveTrophy();
			this.round.putTrophyOut();
			
			this.round.system.giveCardFromDraw();
			this.view.showOffer();
			
			
			this.round.offerFaceUp();
			
			this.round.offerRound(this.round.system.whoChooseOffer());
			this.round.gameRound();
			this.round.lastRound();
			
			this.view.getJestWindow().frmJest.setVisible(false);
			System.out.println("*********************");
			this.round.showPlayerJest();
			this.round.showPlayerJestValue();
			this.round.giveTrophyToPlayer();
			this.round.showPlayerJest();
			
			this.round.showPlayerJestValue();
			this.round.chooseWinner();
			Winner w=new Winner(this);
	}
	/**
	 * method to choose mode
	 */
	public void chooseMode(int a) {
		switch(a) {
		case 1:
			this.jestGame();break;
		case 2:
			this.runLucky();break;
		default: break;
		}
	}
	
	public static void main(String[] args) {
		
		Controller c=new Controller();
		c.view.start();
		
		while(c.view.getHasChanged()==false) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		c.view.chooseMode();
		
	}
	
}

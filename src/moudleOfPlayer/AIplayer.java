package moudleOfPlayer;

import java.util.LinkedList;

import moudle.Card;
/**
 * This class is AIplayer, which enable to behave like a human.
 * The AIplayer has its strategy to play.
 */
public class AIplayer extends player{
	private String nom;
	private InformationTable information;
	private Jest Jest;
	private Offer Offer;
	private Strategy strategy;
	/**
	 * level is to choose level of game
	 */
	public int level;
	/**
	 * ifPicked is to decide if the player choose the card
	 */
	public boolean ifPicked=false;
	/**
	 * give name to AI player
	 * @param nom
	 */
	public AIplayer(char nom) {
		this.nom="AIplayer"+nom;
		Jest=new Jest();
		Offer=new Offer();
		strategy=new Strategy(this);
		level=1;
	}
	/**
	 * structure a AI player
	 */
	public AIplayer() {
		Jest=new Jest();
		Offer=new Offer();
	}
	/**
	 * component of visitor mode
	 */
	public LinkedList<Card> visit(Jest Jest) {
		return Jest.getJests();
	}
	/**
	 * getter
	 */
	public String getName() {
		return this.nom;
	}
	int num = (int)(Math.random()*2+1);
	/**
	 * method choose level
	 */
	public void chooseOfferUp(Offer Offer) {
		if(this.level==1) {
			this.strategy.chooseOfferUpEazy(Offer);
		}
		if(this.level==2) {
			this.strategy.chooseOfferUpDF(Offer);
		}
	}
	
	/**
	 * Here gives choice for players to choose the level they want
	 */
	public void takeOffer(player player) {
		if(this.level==1) {
			this.strategy.takeOfferEazy(player);
		}
		if(this.level==2) {
			this.strategy.takeOfferDF(player);
		}
		
	}
	/**
	 * getter
	 */
	public Offer getOffer() {
		return this.Offer;
	}
	/**
	 * getter
	 */
	public Jest getJest() {
		return this.Jest;
	}
	/**
	 * getter
	 */
	public InformationTable getInformation() {
		this.information=new InformationTable(this);
		return this.information;
	}


}

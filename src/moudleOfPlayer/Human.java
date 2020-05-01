package moudleOfPlayer;
import java.util.*;
/**
 * Inherited player class, used to identify whether the player is a real player when taking offer
 */

import moudle.Card;
import moudle.*;
public class Human extends player implements PlayerVisitor {
	private String nom;
	private Jest Jest;
	private Offer Offer;
	private InformationTable information;
	/**
	 * constructor
	 * @param nom
	 */
	public Human(char nom) {
		this.nom="player"+nom;
		Jest=new Jest();
		Offer=new Offer();
	}
	/**
	 * constructor
	 */
	public Human() {
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
	 * component of visitor mode
	 */
	public LinkedList<Card> visit(Offer Offer){
		return Offer.offers;
	}
	/**
	 * getter
	 */
	public String getName() {
		return this.nom;
	}
	/**
	 * method to choose a card face up
	 */
	public void chooseOfferUp(Offer Offer,int a) {
		if(a==1) {
			Offer.faceUp1();
			Offer.cardUp=Offer.offers.getFirst();
		}
		else if(a==2) {
			Offer.faceUp2();
			Offer.cardUp=Offer.offers.getLast();
		}else {
			System.out.println("You have to choose from offer1 or offer2.");
		}
	}
	/**
	 * method to take a offer from other
	 */
	public void takeOffer(player player,int a) {
		Card takeCard=new Card();
		if(this.tip) {
			if(player.getOffer().offers.size()==2) {
				if(a==1) {
				takeCard=player.getOffer().offers.pollFirst();
				this.Jest.getJests().add(takeCard);
				this.tip=false;
			}
			if(a==2) {
				takeCard=player.getOffer().offers.pollLast();
				this.Jest.getJests().add(takeCard);
				this.tip=false;
			}
			}else {
				System.out.println("You have to choose the player who has two offers.");
			}
		}else {
			System.out.println("You have chosen,so you can't choose again.");
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

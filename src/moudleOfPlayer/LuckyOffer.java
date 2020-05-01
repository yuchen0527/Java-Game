package moudleOfPlayer;

import java.util.LinkedList;
import moudle.Card;
import moudle.*;
/**
 * This class is to structure a play's offer.
 */
public class LuckyOffer {
	public luckyCard card1;
	public luckyCard card2;
	public LinkedList<luckyCard> luckyoffers;

	/**
	 * constructor
	 */
public LuckyOffer() {
		this.luckyoffers=new LinkedList<luckyCard>();
	
		this.card1=new luckyCard();
		this.card2=new luckyCard();
	}
/**
 * ture structure of offer
 * @param card1
 * @param card2
 */
	public LuckyOffer(luckyCard card1,luckyCard card2) {
		this.luckyoffers=new LinkedList<luckyCard>();
	
		this.card1=card1;
		this.card2=card2;
		this.luckyoffers.add(card1);
		this.luckyoffers.add(card2);
		
	}
	public void addLucky(luckyCard e) {
		luckyoffers.add(e);
	}
	/**
	 * print the offer
	 */
	public String toString() {
		return this.card1+" "+this.card2+" "+"turn:";
	}
}

package moudleOfPlayer;

import java.util.LinkedList;


import moudle.luckyCard;
/**
 * Cards obtained by the player, and finally a number of card collections for lucky game
 */
public class LuckyJest {
	private LinkedList<luckyCard> luckyjests;
	/**
	 * constructor
	 */
	public LuckyJest() {
		this.luckyjests=new LinkedList<luckyCard>();
	}
	/**
	 * getter
	 * @return
	 */
	public LinkedList<luckyCard> getLuckyJests() {
		return luckyjests;
	}
	/**
	 * method to add card to lucky jest
	 * @param Card
	 */
	public void addluckyJest(luckyCard Card) {
		luckyjests.add(Card);
	}
}

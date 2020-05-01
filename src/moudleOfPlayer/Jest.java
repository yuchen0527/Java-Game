package moudleOfPlayer;
import java.util.*;
/**
 * Cards obtained by the player, and finally a number of card collections
 */

import moudle.Card;
import moudle.*;
public class Jest implements Element{
	private LinkedList<Card> jests;
	/**
	 * constructor
	 */
	public Jest() {
		this.jests=new LinkedList<Card>();
	}
	/**
	 * getter
	 * @return
	 */
	public LinkedList<Card> getJests() {
		return jests;
	}
	/**
	 * add card to jest
	 * @param Card
	 */
	public void addJest(Card Card) {
		jests.add(Card);
	}
	/**
	 * component of visitor mode
	 */
	public void accept(player player) {
		player.visit(this);
	}

}

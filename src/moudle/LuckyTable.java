package moudle;
import moudleOfPlayer.*;
import java.util.Collections;
import java.util.LinkedList;

import moudleOfPlayer.player;

public class LuckyTable {
	private LinkedList<luckyCard> luckyCards;
	/**
	 * List of player in games
	 */
	public LinkedList<player> players;
	private player player;
	private LuckyOffer LuckyOffer;
	/**
	 * constructor
	 */
	public LuckyTable() {
		players=new LinkedList<player>();
		luckyCards = new LinkedList<luckyCard>();
		luckyValuesOfCard[] v=luckyValuesOfCard.values();
		luckySuit[] s=luckySuit.values();
		for(int i=0 ; i < s.length; i++){
			for(int j=0 ; j < v.length; j++){
				luckyCard newcard = new luckyCard(s[i],v[j],v[j]);
				luckyCards.add(newcard);
			}
		}}

	/**
	 * shuffler
	 */
	public void shuffer() {
		Collections.shuffle(luckyCards);
	}
	/**
	 * give first card
	 * @return
	 */
	public luckyCard giveCard() {
		return luckyCards.poll();
	}
	/**
	 * getter
	 * @return
	 */
	public LinkedList<luckyCard> getLuckyTable(){
		return this.luckyCards;
	}
	/**
	 * give player card's on stack
	 * @return
	 */
	public LinkedList<luckyCard> giveLuckyStack(){
		LinkedList<luckyCard> luckystacks=new LinkedList<luckyCard>();
		for(int i=0;i<players.size();i++) {
			luckystacks.add(this.luckyCards.poll());
		}
		return luckystacks;
	}	
}

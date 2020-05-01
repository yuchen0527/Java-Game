package moudle;

import java.util.Collections;
import java.util.LinkedList;

import moudleOfPlayer.player;
/**
 * This class is to store the cards for player each round for second game.
 */
public class LuckyStack {
	private LinkedList<luckyCard> luckystacks;
	private LinkedList<player> players;
	private LuckyTable luckytable;
	/**
	 * structure the Lucky stack
	 */
	public LuckyStack() {
		this.players=new LinkedList<player> ();
		this.luckystacks=new LinkedList<luckyCard> ();
		this.luckytable=new LuckyTable();
	}
	public LuckyStack(LinkedList<player> player,LuckyTable luckytable) {
		this.luckytable=luckytable;
		this.luckystacks=new LinkedList();
		this.players=player;
		for(int i=0;i<players.size();i++) {
			this.luckystacks.add(this.players.get(i).getLuckyOffer().luckyoffers.poll());
			this.luckystacks.add(luckytable.getLuckyTable().poll());
		}
		
		
	}
	/**
	 * getter
	 * @return
	 */
	public LinkedList<luckyCard> getLuckyStack(){
		return this.luckystacks;
	}
	/**
	 * shuffler
	 */
	public void shufferStack(){
		Collections.shuffle(this.luckystacks);
	}
	/**
	 * getter
	 * @return
	 */
	public luckyCard giveCard() {
		return this.luckystacks.poll();
	}
}

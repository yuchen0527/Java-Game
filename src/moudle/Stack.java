package moudle;
import java.util.*;
/**
 * This class is to store the cards for player each round.
 */
import moudleOfPlayer.*;
public class Stack {
	private LinkedList<Card> stacks;
	private LinkedList<player> players;
	private DrawDeck drawDeck;
/**
 * constructor	
 */
	public Stack() {
		this.players=new LinkedList<player> ();
		this.stacks=new LinkedList<Card> ();
		this.drawDeck=new DrawDeck();
	}
	/**
	 * give player's stack cards
	 * @param player
	 * @param drawDeck
	 */
	public Stack(LinkedList<player> player,DrawDeck drawDeck) {
		this.drawDeck=drawDeck;
		this.stacks=new LinkedList();
		this.players=player;
		for(int i=0;i<players.size();i++) {
			this.stacks.add(this.players.get(i).getOffer().offers.poll());
			this.stacks.add(drawDeck.getDrawDeck().poll());
		}
		this.shufferStack();
		
	}
	/**
	 * getter
	 * @return
	 */
	public LinkedList<Card> getStack(){
		return this.stacks;
	}
	/**
	 * shuffler for stack
	 */
	public void shufferStack(){
		Collections.shuffle(this.stacks);
	}
	/**
	 * card giving to stack
	 */
	public Card giveCard() {
		return this.stacks.poll();
	}

}

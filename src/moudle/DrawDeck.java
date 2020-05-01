package moudle;
import java.util.*;
import moudleOfPlayer.*;
/**
 * This class is to create cards for player. With the value from another two class {@code ValueOfCard} and 
 * {@code SuitOfCard}
 */

public class DrawDeck {
	private LinkedList<Card> Cards;
	public LinkedList<player> players;
	/**
	 * 
	 * Constructor for assigning values to cards
	 *
	 */
	public DrawDeck() {
		players=new LinkedList<player>();
		Cards = new LinkedList<Card>();
		ValuesOfCard[] v=ValuesOfCard.values();
		SuitOfCard[] s=SuitOfCard.values();
		TrophyConditionOfCard[] t=TrophyConditionOfCard.values();
		for(int i=0 ; i < s.length-1; i++){
			for(int j=0 ; j < v.length-5; j++){
				Card newcard = new Card(s[i],v[j],v[j]);
				Cards.add(newcard);
			}
		}

		for(int i=0;i<Cards.size();i++) {
			
			if(i>=13) {
				Cards.get(i).trophyCon=t[t.length-2];
			}
			if(i<13) {Cards.get(i).trophyCon=t[i];}
		}
		Card newcard=new Card(s[s.length-1],v[v.length-5
		                                      ],v[v.length-5]);
		newcard.trophyCon=t[t.length-1];
		Cards.add(newcard);
	}
	
	
	public static void main(String[]args) {
		DrawDeck a=new DrawDeck();
		System.out.println(a.Cards.size());
		for(int i=0;i<a.Cards.size();i++) {
			System.out.println(a.Cards.get(i));
		}
		
		
		
		System.out.println(a.Cards);
		a.shuffer();
		System.out.println(a.Cards);
		System.out.println(a.Cards.get(0).getValues().getValueInt());
		System.out.println(a.Cards.get(0).getSuit().getSuitString());
		System.out.println(a.giveCard());
		System.out.println(a.Cards);
		
	}
	/**
	 * Borrowing collections to implement shuffle operations
	 */
	public void shuffer() {
		Collections.shuffle(Cards);
	}
	public Card giveCard() {
		return Cards.poll();
	}
	public LinkedList<Card> getDrawDeck(){
		return this.Cards;
	}
	public LinkedList<Card> giveStack(){
		LinkedList<Card> stacks=new LinkedList<Card>();
		for(int i=0;i<players.size();i++) {
			stacks.add(this.Cards.poll());
		}
		return stacks;
	}

}

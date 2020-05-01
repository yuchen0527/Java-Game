package moudleOfPlayer;
import java.util.*;
import moudle.*;
/**
 * This class is to structure a play's offer.
 *
 */
public class Offer implements Element{
	public Card card1;
	public Card card2;
	public LinkedList<Card> offers;
	public String turn1;
	public String turn2;
	public Card cardUp;
	/**
	 * constructor
	 */
	public Offer() {
		this.offers=new LinkedList<Card>();
		this.cardUp=new Card();
		this.card1=new Card();
		this.card2=new Card();
	}
	/**
	 * Each player have two card as his offer.
	 * @param card1
	 * @param card2
	 */
	public Offer(Card card1,Card card2) {
		this.offers=new LinkedList<Card>();
		this.cardUp=new Card();
		this.card1=card1;
		this.card2=card2;
		this.offers.add(card1);
		this.offers.add(card2);
		this.turn1="down";
		this.turn2="down";
	}
	/**
	 * face up card 1
	 */
	
	public void faceUp1() {
		this.turn1="Up";
		this.card1=this.offers.getFirst();
		this.cardUp=this.offers.getFirst();
		this.turn2="down";
	}
	/**
	 * face up card 2
	 */
	public void faceUp2() {
		this.turn2="Up";
		this.card2=this.offers.getLast();
		this.cardUp=this.offers.getLast();
		this.turn1="down";
	}
	/**
	 * print player's offer
	 */
	public String toString() {
		return this.card1+" "+"turn:"+this.turn1+" "+this.card2+" "+"turn:"+this.turn2;
	}
	/**
	 * implements of Visitor mode.
	 */
	public void accept(player player) {
		player.visit(this);
		
	}
	public static void main(String[]args) {
		DrawDeck d=new DrawDeck();
		Offer a=new Offer(d.getDrawDeck().pollFirst(),d.getDrawDeck().pollFirst());
		a.faceUp1();
		System.out.println(a.turn1=="Up");
	}
	
}

package moudle;
/**
 * 
 * This class is to define the card property. With the value from another two class {@code ValueOfCard} and 
 * {@code SuitOfCard}
 *
 */
public class Card {
	/**
	 * Suit is suit value for card
	 */
	private SuitOfCard suit;
	/**
	 * ValuesOfCard is the value for card
	 */
	private ValuesOfCard values;
	/**
	 * ValuesOfCard is the real value for card
	 */
	public ValuesOfCard realValue;
	/**
	 * TrophyConditionOfCard is the condition to give a trophy
	 */
	public TrophyConditionOfCard trophyCon;
	ValuesOfCard[] v=ValuesOfCard.values();
	SuitOfCard[] s=SuitOfCard.values();
	/**
	 * Card method is to make a card by using the enums {@code ValueOfCard}
	 * and {@code SuitOfCard}
	 * @param suit
	 * @param values
	 * @param realValue
	 */
	public Card(SuitOfCard suit,ValuesOfCard values,ValuesOfCard realValue){
		this.suit=suit;this.values=values;this.realValue=realValue;
	}
	/**
	 * These methods are for constructing
	 *  cards, initializing the construction
	 * 
	 */
	public Card() {
		this.realValue=v[v.length-1];
		this.suit=s[s.length-1];
		this.values=v[v.length-1];
	}
	/**
	 * get value of suit in this class
	 * @return
	 */
	public SuitOfCard getSuit() {
		return suit;
	}
	/**
	 * get real value of cards in this class
	 * @return
	 */
	public ValuesOfCard getRealValue() {
		return realValue;
	}
	public static void main(String[]args) {
		Card c=new Card();
		int a;
		a=c.values.getValueInt();
		System.out.println(a);
	}
	/**
	 * get value of cards in this class
	 * @return
	 */
	
	public ValuesOfCard getValues() {
		return values;
	}
	/**
	 * get TrophyConditionOfCard
	 * @return
	 */
	public TrophyConditionOfCard getTC() {
		return trophyCon;
	}
	/**
	 * set value
	 * @param value
	 */
	public void setValue(ValuesOfCard value) {
		this.values=value;
	}
	/**
	 * set TrophyConditionOfCard
	 * @param a
	 */
	public void setTC(TrophyConditionOfCard a) {
		this.trophyCon=a;
	}
	/**
	 * clearly show card details
	 */
	public String toString() {
		return this.suit +" "+this.values+" "+this.trophyCon;
	}

}

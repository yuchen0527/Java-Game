package moudle;
/**
 * 
 * Use enums to store the value and suit of the cards in an orderly manner
 *
 */
public enum SuitOfCard {
	SPADES("Spades",4),CLUBS("Clubs",3),DIAMONDS("Diamonds",2),HEARTS("Hearts",1),NULL("Null",0);
	private final String suit;
	private final int strong;
	SuitOfCard(String suit,int strong){
		this.suit=suit;
		this.strong=strong;
	}
	/**
	 * print the suit value
	 * @return
	 */
	public String getSuitString() {
		return this.suit;
	}
	/**
	 * getter
	 * @return
	 */
	public int getSuitStrong() {
		return this.strong;
	}

}

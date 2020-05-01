package moudle;
/**
 * 
 * Use enums to store the value and suit of the cards in an orderly manner
 *
 */
public enum luckySuit {
	SPADES("SPADES",4),CLUBS("CLUBS",3),DIAMONDS("DIAMONDS",2),HEARTS("HEARTS",1);
	private final String suit;
	private final int strong;
	/**
	 * structure lucky suit
	 * @param suit
	 * @param strong
	 */
	luckySuit(String suit,int strong){
		this.suit=suit;
		this.strong=strong;
	}
	/**
	 * print suit
	 * @return
	 */
	public String getSuitString() {
		return this.suit;
	}
	/**
	 * print strong suit
	 * @return
	 */
	public int getSuitStrong() {
		return this.strong;
	}
}

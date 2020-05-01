package moudle;
/**
 * 
 * Use enums to store the value and suit of the cards in an orderly manner
 *
 */
public enum luckyValuesOfCard {
	TWO(2),THREE(3),FOUR(4),ACE(1),FIVE(5),SIX(6),SEVEN(7);
	private final int value;
	 luckyValuesOfCard(int value) {
	        this.value = value;
	    }

	    public int getValueInt() {
	        return value;
	    }
}

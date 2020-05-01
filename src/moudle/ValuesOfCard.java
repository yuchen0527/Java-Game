package moudle;
/**
 * 
 * Use enums to store the value and suit of the cards in an orderly manner
 *
 */
public enum ValuesOfCard {
	TWO(2),THREE(3),FOUR(4),ACE(1),JOKER(0),FIVE(5),NULL(0),SIX(6),NEW(-1);
	private final int value;
	 ValuesOfCard(int value) {
	        this.value = value;
	    }
/**
 * getter
 * @return
 */
	    public int getValueInt() {
	        return value;
	    }

}

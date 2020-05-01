package moudle;
/**
 * 
 * This class is to define the card property for the 
 * second game. With the value from another two class
 *  {@code LuckyValueOfCard} and {@code LuckySuit}
 *
 */
public class luckyCard {
	private luckySuit suit;
	private luckyValuesOfCard values;
	public luckyValuesOfCard realValue;

	luckyValuesOfCard[] v=luckyValuesOfCard.values();
	luckySuit[] s=luckySuit.values();
	public luckyCard(luckySuit suit,luckyValuesOfCard values,luckyValuesOfCard realValue){
		this.suit=suit;this.values=values;this.realValue=realValue;
	}
	public luckyCard() {
		this.realValue=v[v.length-1];
		this.suit=s[s.length-1];
		this.values=v[v.length-1];
	}
	
	public luckySuit getSuit() {
		return suit;
	}
	public luckyValuesOfCard getRealValue() {
		return realValue;
	}
	public static void main(String[]args) {
	
	}
	public luckyValuesOfCard getValues() {
		return values;
	}
	
	public void setValue(luckyValuesOfCard value) {
		this.values=value;
	}

	public String toString() {
		return this.suit +" "+this.values+" ";
	}

}

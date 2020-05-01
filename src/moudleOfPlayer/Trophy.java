package moudleOfPlayer;
import moudle.*;
/**
 * This class constructed a trophy
 *
 */
public class Trophy {
	private Card card;
	/**
	 * constructor
	 * @param card
	 */
	public Trophy(Card card) {
		this.card=card;
	}
	/**
	 * card for trophy
	 */
	public Trophy() {
		this.card=new Card();
	}
	/**
	 * getter
	 * @return
	 */
	public TrophyConditionOfCard getTC() {
		return card.getTC();
	}
	/**
	 * getter
	 * @param card
	 */
	public void setTrophy(Card card) {
		this.card=card;
	}
	/**
	 * getter
	 * @return
	 */
	public Card getTrophy() {
		return this.card;
	}
}

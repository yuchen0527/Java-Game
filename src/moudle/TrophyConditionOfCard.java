package moudle;
/**
 * 
 * Use enums to store the conditon of trophy of the cards in an orderly manner
 *
 */
public enum TrophyConditionOfCard {
	MajorityOfThree("MajorityOfThree"),
	MajorityOfTwo("MajorityOfTwo"),
	LowestOfClubs("LowestOfClubs"),
	HighestOfClubs("HighestOfClubs"),
	LowestOfHearts("LowestOfHearts"),
	HighestOfHearts("HighestOfHearts"),
	LowestOfSpades("LowestOfSpades"),
	HighestOfSpades("HighestOfSpades"),
	HighestOfDiamonds("HighestOfDiamonds"),
	LowestOfDiamonds("LowestOfDiamonds"),
	BestJestNoJoker("BestJestNoJoker"),
	MajorityOfFour("MajorityOfFour"),
	Joker("Joker"),
	BestJest("BestJest");
	private final String TC;
	/**
	 * getter
	 * @param TC
	 */
	TrophyConditionOfCard(String TC){
		this.TC=TC;
	}
	/**
	 * print trophy condition of Card
	 * @return
	 */
	public String getTCString() {
		return this.TC;
	}
}

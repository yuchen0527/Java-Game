package moudleOfPlayer;
/**
 * This interface is create for implemented Stategy
 * mode.
 *
 */
public interface PlayerStrategy {
	public void chooseOfferUpEazy(Offer a);
	public void takeOfferEazy(player a);
	public void chooseOfferUpDF(Offer a);
	public void takeOfferDF(player a);
	
}
package moudleOfPlayer;
import moudle.*;
import java.util.LinkedList;

import moudle.Card;
/**
 * This class is AIplayer for Lucky game, which enable to behave like a human.
 * The AIplayer has its strategy to play.
 */
public class AIplayerEasy extends player{
	private String nom;
	private InformationTable information;
	private Jest Jest;
	private Offer Offer;
	/**
	 * ifPicked is to decide if the player choose the card
	 */
	public boolean ifPicked=false;
	private LuckyOffer LuckyOffer;
	private LuckyJest LuckyJest;
	private LuckyTable LuckyTable;
	/**
	 * structure AI player
	 * @param nom
	 */
	public AIplayerEasy(char nom) {
		this.nom="AIplayer"+nom;
		Jest=new Jest();
		Offer=new Offer();
		LuckyOffer= new LuckyOffer();
		LuckyJest=new LuckyJest();
		LuckyTable=new LuckyTable();
	}
	/**
	 * structure AI player
	 */
	public AIplayerEasy() {
		Jest=new Jest();
		Offer=new Offer();
	}
	/**
	 * component of visitor mode
	 */
	public LinkedList<Card> visit(Jest Jest) {
		return Jest.getJests();
	}
	/**
	 * getter
	 */
	public String getName() {
		return this.nom;
	}
	/**
	 * method to choose offer
	 */
	public void chooseOfferUp(Offer Offer) {
			Offer.faceUp1();
			Offer.cardUp=Offer.offers.getFirst();
	}
	/**
	 * AIplayer gets first card in his hand card.
	 */
	public void takeOffer(player player) {
		Card takeCard=new Card();
		if(this.tip) {
				if(player.getOffer().offers.size()==2) {
					takeCard=player.getOffer().offers.pollFirst();
					this.Jest.getJests().add(takeCard);
					this.tip=false;
					player.ifPicked=true;
			}else {
				System.out.println("You have to choose the player who has two offers.");
			}
			
		}else {
			System.out.println("You have chosen,so you can't choose again.");
		}
		
	}
	/**
	 * give card to table
	 */
	public void giveCardTable(LuckyOffer LuckyOffer) {
		luckyCard showCard=new luckyCard();
		
			showCard=LuckyOffer.luckyoffers.pollFirst();
			LuckyTable.getLuckyTable().add(showCard);
		System.out.println(showCard);
	
	}
	/**
	 * getter
	 */
	public Offer getOffer() {
		return this.Offer;
	}
	/**
	 * getter
	 */
	public Jest getJest() {
		return this.Jest;
	}
	/**
	 * getter
	 */
	public LuckyOffer getLuckyOffer() {
		return this.LuckyOffer;
	}
	/**
	 * getter
	 */
	public InformationTable getInformation() {
		this.information=new InformationTable(this);
		return this.information;
	}

}

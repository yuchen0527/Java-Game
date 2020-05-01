package moudleOfPlayer;

import java.util.LinkedList;

import moudle.*;
/**
 * This class is made for human player, which create players and give property to players.
 * Both jest game and lucky game use this class to structure a list of players.
 */
public class player implements PlayerVisitor{
	private String nom;
	private Jest Jest;
	private Offer Offer;
	private LuckyJest LuckyJest;
	private LuckyOffer LuckyOffer;
	private LuckyTable LuckyTable;
	private LuckyStack LuckyStack;
	/**
	 * tip is used for choose which player can be choosed
	 */
	public boolean tip=true;
	/**
	 * ifPicked is show the player has been picked or not
	 */
	public boolean ifPicked=false;
	private InformationTable information;
	private LuckyInformation luckyinformation;
	/**
	 * set name for player
	 * @param nom
	 */
	public player(char nom) {
		this.nom="player"+nom;
	}
	/**
	 * constructor
	 */
	public player() {
		this.nom="123";
		Jest=new Jest();
		Offer=new Offer();
		LuckyOffer= new LuckyOffer();
		 LuckyJest=new LuckyJest();
		 LuckyTable=new LuckyTable();
	}
	/**
	 * component of visitor mode
	 */
	public LinkedList<Card> visit(Jest Jest) {
		return this.Jest.getJests();
	}
	/**
	 * getter
	 * @return
	 */
	public String getName() {
		return nom;
	}
	/**
	 * 
	 * @param Offer
	 * @param a
	 */
	public void chooseOfferUp(Offer Offer,int a) {
	}
	/**
	 * 
	 * @param offer
	 */
	public void chooseOfferUp(Offer offer) {
		
	}
	/**
	 * 
	 * @param player
	 * @param a
	 */
	public void takeOffer(player player,int a) {
		
	}
	/**
	 * component of visitor mode
	 */
	public LinkedList<Card> visit(Offer Offer){
		return this.Offer.offers;
	}
	/**
	 * getter
	 * @return
	 */
	public Offer getOffer() {
		return this.Offer;
	}
	/**
	 * getter
	 * @return
	 */
	public Jest getJest() {
		return this.Jest;
	}
	/**
	 * print name
	 */
	public String toString() {
		return nom;
	}
	/**
	 * get information table
	 * @return
	 */
	public InformationTable getInformation() {
		this.information=new InformationTable(this);
		return this.information;
	}
	/**
	 * method to take offer
	 * @param first
	 */
	public void takeOffer(player first) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * component of visitor mode
	 */
	public LinkedList<luckyCard> visit(LuckyTable LuckyTable) {
		return this.LuckyTable.getLuckyTable();
	}
	/**
	 * component of visitor mode
	 */
	public LinkedList<luckyCard> visit(LuckyOffer LuckyOffer) {
		return this.LuckyOffer.luckyoffers;
	}
	/**
	 * getter
	 * @return
	 */
	public LuckyOffer getLuckyOffer() {
		return this.LuckyOffer;
	}
	/**
	 * getter
	 * @return
	 */
	public LuckyJest getLuckyJest() {
		return this.LuckyJest;
	}
/**
 * lucky mode 
 * @param card1
 * @param card2
 * @return
 */
	public boolean ifstart(luckyCard card1,luckyCard card2) {
		card1=LuckyTable.getLuckyTable().getLast();
		if(card1.getValues().getValueInt()==card2.getValues().getValueInt()&&card1.getSuit().getSuitString()==card2.getSuit().getSuitString())
			return false;
		else return true;
	}
/**
 * player choose card on the table	
 * @param LuckyOffer
 * @param a
 */
	public void giveCardTable(LuckyOffer LuckyOffer,int a) {
		luckyCard showCard=new luckyCard();
		if(a==1)
			{showCard=LuckyOffer.luckyoffers.pollFirst();
			LuckyTable.getLuckyTable().add(showCard);
			System.out.println(showCard);}
		if(a==2)
			{showCard=LuckyOffer.luckyoffers.pollLast();
			LuckyTable.getLuckyTable().add(showCard);
			System.out.println(showCard);
			if(a!=1&&a!=2)
				System.out.println("You have to choose from cards you have(1 or 2)");}
		
	
	}
	/**
	 * give card on the table
	 * @param LuckyOffer
	 */
	public void giveCardTable(LuckyOffer LuckyOffer) {
		luckyCard showCard=new luckyCard();
		
			showCard=LuckyOffer.luckyoffers.pollFirst();
			LuckyTable.getLuckyTable().add(showCard);
		System.out.println(showCard);
	
	}
	/**
	 * if the cards are in same face value player get bonnus cards
	 * @param LuckyTable
	 */
	public void LuckyJestBonnus(LuckyTable LuckyTable) {
		luckyCard card1=new luckyCard();
		luckyCard card2=new luckyCard();
		card1=LuckyTable.getLuckyTable().getLast();
		for(int i=0;i<LuckyTable.getLuckyTable().size();i++) {
			card2=LuckyTable.getLuckyTable().get(i);
			boolean a=card1.getValues().getValueInt()==card2.getValues().getValueInt();
			boolean b=card1.getSuit().getSuitString()!=card2.getSuit().getSuitString();
			if(a&&b) {
				System.out.println("You got these card as bonus.");
				for(int j=i;j<LuckyTable.getLuckyTable().size();j++) {
					LuckyJest.getLuckyJests().add(LuckyTable.getLuckyTable().get(j));
					
					System.out.println("["+LuckyTable.getLuckyTable().get(j)+"]");
					LuckyTable.getLuckyTable().remove(j);
				}	
				break;
			}
		}
		
	}
	/**
	 * getter
	 */
	public void giveCardStack() {
		LuckyStack.getLuckyStack().add(LuckyOffer.luckyoffers.pollFirst());
	}
	/**
	 * getter
	 * @return
	 */
	public LuckyTable getLuckyTable() {
		return LuckyTable;
	}
	/**
	 * getter
	 * @return
	 */
	public LuckyStack getLuckyStack() {
		return LuckyStack;
	}
	
/**
 * getter
 * @return
 */
	public LuckyInformation getluckyInformation() {
		this.luckyinformation=new LuckyInformation(this);
		return this.luckyinformation;
	}


}

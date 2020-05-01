package moudleOfPlayer;

import moudle.Card;
/*
 * This class is core to implement choosing a level.
 */
public class Strategy implements PlayerStrategy{

	private AIplayer aiplayer;
	private Offer offer;
	private Jest Jest;
	private boolean tip;
	public Strategy() {
		
	}
	public Strategy(AIplayer a) {
		this.aiplayer=a;
		offer=a.getOffer();
		this.tip=a.tip;
		this.Jest=a.getJest();
	}
	int num = (int)(Math.random()*2+1);
	public void chooseOfferUpEazy(Offer offer) {
		if(num==1) {
			offer.faceUp1();
			offer.cardUp=offer.offers.getFirst();
		}
		else if(num==2) {
			offer.faceUp2();
			offer.cardUp=offer.offers.getLast();
		}
	}
// The core to implement choosing a mode
	public void takeOfferEazy(player a) {
		Card takeCard=new Card();
		if(this.aiplayer.tip) {
				if(a.getOffer().offers.size()==2) {
					takeCard=a.getOffer().offers.pollFirst();
					this.aiplayer.getJest().getJests().add(takeCard);
					this.aiplayer.tip=false;
					a.ifPicked=true;
			}else {
				System.out.println("You have to choose the player who has two offers.");
			}
			
		}else {
			System.out.println("You have chosen,so you can't choose again.");
		}
		
	}
	//The difficult mode: the AIplayer will be able to choose the bigger face value card from other.
	public void takeOfferDF(player a) {
		Card takeCard=new Card();
		if(this.aiplayer.tip) {
				if(a.getOffer().offers.size()==2) {
					takeCard=a.getOffer().offers.pollFirst();
					this.aiplayer.getJest().getJests().add(takeCard);
					this.aiplayer.tip=false;
					a.ifPicked=true;
			}else {
				System.out.println("You have to choose the player who has two offers.");
			}
			
		}else {
			System.out.println("You have chosen,so you can't choose again.");
		}
		
	}
	@Override
	public void chooseOfferUpDF(Offer offer) {
		if(offer.card1.realValue.getValueInt()>offer.card2.realValue.getValueInt())
		{
			offer.faceUp1();
			offer.cardUp=offer.offers.getFirst();
		}else{
			offer.faceUp2();
			offer.cardUp=offer.offers.getLast();
			}
		
	}
	
	
	

}

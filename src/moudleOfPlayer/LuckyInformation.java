package moudleOfPlayer;

import java.util.LinkedList;

import moudle.Card;
import moudle.luckySuit;
import moudle.luckyValuesOfCard;
import moudle.luckyCard;
/** 
 * This class is to go through all the cards,
 * collect card information for lucky game, 
 * each player has this information table
 */
public class LuckyInformation {
	private boolean ifHaveJoker=false;
	private boolean ifHaveSameFaceSC=false;
	private int maxInHearts;
	private int maxInClubs;
	private int maxInSpades;
	private int maxInDiamonds;
	private int minInHearts=6;
	private int minInClubs=6;
	private int minInSpades=6;
	private int minInDiamonds=6;
	private int nomOfTwo=0;
	private int nomOfThree=0;
	private int nomOfFour=0;
	private int nomOfAce=0;
	private int nomOfHearts=0;
	private int nomOfSpades=0;
	private int nomOfClubs=0;
	private int nomOfDiamonds=0;
	private luckySuit strongestInTwo;
	private luckySuit strongestInThree;
	private luckySuit strongestInFour;
	private int faceValue;
	private int valueJest;
	private int luckyvalueJest;
	private int luckyJest;
	private LinkedList<luckyCard> luckyjests;

	/**
	 * The constructor method to go through all the cards, gathering 
	 * all information. 
	 * @param player
	 */
	public LuckyInformation(player player) {
		this.luckyjests=new LinkedList<luckyCard>();
		this.luckyjests=player.getLuckyJest().getLuckyJests();
		int locationOfAce=0;
		luckyValuesOfCard[] v=luckyValuesOfCard.values();
		luckySuit[] s=luckySuit.values();
		this.strongestInTwo=s[s.length-2];
		this.strongestInThree=s[s.length-2];
		this.strongestInFour=s[s.length-2];
		
	

			/**
			 * calculate lucky jest value
			 */
			
			
			
				
				/**
				 * calculate the luckyJest value of clubs and spades
				 */
				
				if(nomOfClubs>0&&nomOfSpades>0) {
					if(this.ifHaveSameFaceSC) {
						
						
						
						
						for(int a=0;a<luckyjests.size();a++) {
							if(luckyjests.get(a).getSuit().getSuitString()=="Clubs") {
								int faceValueClubs=luckyjests.get(a).getValues().getValueInt();
								for(int j=0;j<luckyjests.size();j++) {
									if(luckyjests.get(j).getValues().getValueInt()==faceValueClubs) {
										if(luckyjests.get(j).getSuit().getSuitString()=="Spades") {
											this.luckyvalueJest=this.luckyvalueJest+luckyjests.get(a).getValues().getValueInt()+luckyjests.get(j).getValues().getValueInt()+2+2;
										}
									}
								}
							}
						}
					
					
					
					}
				}
				
				/**
				 * calculate the lucky value of Diamonds
				 */
				for(int i=0;i<luckyjests.size();i++) {
					if(luckyjests.get(i).getSuit().getSuitString()=="Diamonds") {
						this.luckyvalueJest=this.luckyvalueJest-luckyjests.get(i).getValues().getValueInt();
					}
				}
				
				
				/**
				 * calculate the jest value of Hearts
				 */
				if(this.ifHaveJoker) {
					if(this.nomOfHearts==0) {
						this.luckyvalueJest=this.luckyvalueJest+4;
					}else if(this.nomOfHearts==4) {
						this.luckyvalueJest+=10;
					}
					if(0<this.nomOfHearts&&this.nomOfHearts<4) {
						for(int b=0;b<luckyjests.size();b++) {
							if(luckyjests.get(b).getSuit().getSuitString()=="Hearts") {
								this.luckyvalueJest=this.luckyvalueJest-luckyjests.get(b).getValues().getValueInt();
							}
						}
					}}}
				
				
		
		
		

	
	
	/**
	 * getter
	 * @return
	 */
	public int getNomOfTwo() {
			return this.nomOfTwo;
		}
	/**
	 * getter
	 * @return
	 */
	public int getNomOfThree() {
		return this.nomOfThree;
	}
	/**
	 * getter
	 * @return
	 */
	public int getNomOfFour() {
		return this.nomOfFour;
	}
	/**
	 * getter
	 * @return
	 */
	public int getNomOfAce() {
		return this.nomOfAce;
	}
	/**
	 * getter
	 * @return
	 */
	public int getNomOfHearts() {
		return nomOfHearts;
	}
	/**
	 * getter
	 * @return
	 */
	public int getNomOfSpades() {
		return nomOfSpades;
	}
	/**
	 * getter
	 * @return
	 */
	public int getNomOfClubs() {
		return nomOfClubs;
	}
	/**
	 * getter
	 * @return
	 */
	public int getNomOfDiamonds() {
		return nomOfDiamonds;
	}
	/**
	 * getter
	 * @return
	 */
	public int getMaxInHearts() {
		return this.maxInHearts;
	}
	/**
	 * getter
	 * @return
	 */
	public int getMaxInClubs() {
		return this.maxInClubs;
	}
	/**
	 * getter
	 * @return
	 */
	public int getMaxInDiamonds() {
		return this.maxInDiamonds;
	}
	/**
	 * getter
	 * @return
	 */
	public int getMaxInSpades() {
		return this.maxInSpades;
	}
	/**
	 * getter
	 * @return
	 */
	public int getMinInHearts() {
		return this.minInHearts;
	}
	/**
	 * getter
	 * @return
	 */
	public int getMinInClubs() {
		return this.minInClubs;
	}
	/**
	 * getter
	 * @return
	 */
	public int getMinInDiamonds() {
		return this.minInDiamonds;
	}
	/**
	 * getter
	 * @return
	 */
	public int getMinInSpades() {
		return this.minInSpades;
	}
	/**
	 * getter
	 * @return
	 */
	public boolean getIfHaveJoker() {
		return this.ifHaveJoker;
	}
	/**
	 * getter
	 * @return
	 */
	public int getValueJest() {
		return valueJest;
	}
	/**
	 * getter
	 * @return
	 */
	public int getLuckyvalueJest() {
		return luckyvalueJest;
	}
	/**
	 * getter
	 * @return
	 */
	public int getFaceValue() {
		return faceValue;
	}
	
		
		
		
}

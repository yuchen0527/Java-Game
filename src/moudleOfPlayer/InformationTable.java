package moudleOfPlayer;
import java.util.*;
import moudle.*;
/**
 * 
 * This class is to go through all the cards,
 * collect card information, each player has this information table
 *
 */
public class InformationTable {
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
	private SuitOfCard strongestInTwo;
	private SuitOfCard strongestInThree;
	private SuitOfCard strongestInFour;
	private int faceValue;
	private int valueJest;
	private LinkedList<Card> jests;
	
	
	/**
	 * constructor
	 * 
	 * Go through all the cards,
     * collect card information
	 * @param player
	 */
	public InformationTable(player player) {
		this.jests=new LinkedList<Card>();
		this.jests=player.getJest().getJests();
		int locationOfAce=0;
		ValuesOfCard[] v=ValuesOfCard.values();
		SuitOfCard[] s=SuitOfCard.values();
		this.strongestInTwo=s[s.length-2];
		this.strongestInThree=s[s.length-2];
		this.strongestInFour=s[s.length-2];
		
		for(int i=0;i<jests.size();i++) {
			this.faceValue=this.faceValue+jests.get(i).getRealValue().getValueInt();
		}
		
		for(int i=0;i<jests.size();i++) {
			if(jests.get(i).getRealValue().getValueInt()==2) {
				if(this.strongestInTwo.getSuitStrong()<jests.get(i).getSuit().getSuitStrong()) {
					this.strongestInTwo=jests.get(i).getSuit();
				}
			}
		}
		for(int i=0;i<jests.size();i++) {
			if(jests.get(i).getRealValue().getValueInt()==3) {
				if(this.strongestInThree.getSuitStrong()<jests.get(i).getSuit().getSuitStrong()) {
					this.strongestInThree=jests.get(i).getSuit();
				}
			}
		}
		for(int i=0;i<jests.size();i++) {
			if(jests.get(i).getRealValue().getValueInt()==4) {
				if(this.strongestInFour.getSuitStrong()<jests.get(i).getSuit().getSuitStrong()) {
					this.strongestInFour=jests.get(i).getSuit();
				}
			}
		}
		
		
		for(int i=0;i<jests.size();i++) {
			/**
			 * calculate the number of Two
			 */
			if(jests.get(i).getValues().getValueInt()==2) {
				nomOfTwo++;
			}
			/**
			 * calculate the number of Three
			 */
			if(jests.get(i).getValues().getValueInt()==3) {
				nomOfThree++;
			}
			/**
			 * calculate the number of Four
			 */
			if(jests.get(i).getValues().getValueInt()==4) {
				nomOfFour++;
			}
			/**
			 * calculate the number of Ace
			 */
			if(jests.get(i).getRealValue().getValueInt()==1) {
				nomOfAce++;
				if(nomOfAce==1) {
					locationOfAce=i;
				}
			}
		}
		/**
		 * reset the face value of Ace
		 */
		if(nomOfAce==1) {
			jests.get(locationOfAce).setValue(v[v.length-4]);
		}else {
			for(int i=0;i<jests.size();i++) {
				if(jests.get(i).getValues().getValueInt()==5) {
					jests.get(i).setValue(v[v.length-6]);
				}
			}
		}
		
		/**
		 * find if there have the same face value of spade and club
		 */
		
		for(int i=0;i<jests.size();i++) {
			if(jests.get(i).getSuit().getSuitString()=="Clubs") {
				int faceValueClubs=jests.get(i).getValues().getValueInt();
				for(int j=0;j<jests.size();j++) {
					if(jests.get(j).getValues().getValueInt()==faceValueClubs) {
						if(jests.get(j).getSuit().getSuitString()=="Spades") {
							this.ifHaveSameFaceSC=true;
						}
					}
				}
			}
		}
		
		
		
		for(int i=0;i<jests.size();i++) {
			/**
			 * if there is a joker
			 */
			if(jests.get(i).getSuit().getSuitString()=="Null") {
				this.ifHaveJoker=true;
			}
			/**
			 * find the max in heart
			 */
			if(jests.get(i).getSuit().getSuitString()=="Hearts") {
				nomOfHearts++;
				if(jests.get(i).getValues().getValueInt()>maxInHearts) {
					maxInHearts=jests.get(i).getValues().getValueInt();
				}
			}
			/**
			 * find the max in clubs
			 */
			if(jests.get(i).getSuit().getSuitString()=="Clubs") {
				nomOfClubs++;
				if(jests.get(i).getValues().getValueInt()>maxInClubs) {
					maxInClubs=jests.get(i).getValues().getValueInt();
				}
			}
			/**find the max in spade
			 */
			if(jests.get(i).getSuit().getSuitString()=="Spades") {
				nomOfSpades++;
				if(jests.get(i).getValues().getValueInt()>maxInSpades) {
					maxInSpades=jests.get(i).getValues().getValueInt();
				}
			}
			/**
			 * find the max in Diamonds
			 */
			if(jests.get(i).getSuit().getSuitString()=="Diamonds") {
				nomOfDiamonds++;
				if(jests.get(i).getValues().getValueInt()>maxInDiamonds) {
					maxInDiamonds=jests.get(i).getValues().getValueInt();
				}
			}
			/**
			 * find the min of Hearts
			 */
			if(jests.get(i).getSuit().getSuitString()=="Hearts") {
				if(jests.get(i).getValues().getValueInt()<minInHearts) {
					minInHearts=jests.get(i).getValues().getValueInt();
				}
			}
			/**
			 * find the min of Clubs
			 */
			if(jests.get(i).getSuit().getSuitString()=="Clubs") {
				if(jests.get(i).getValues().getValueInt()<minInClubs) {
					minInClubs=jests.get(i).getValues().getValueInt();
				}
			}
			/**
			 * find the min of Spades
			 */
			if(jests.get(i).getSuit().getSuitString()=="Spades") {
				if(jests.get(i).getValues().getValueInt()<minInSpades) {
					minInSpades=jests.get(i).getValues().getValueInt();
				}
			}
			/**
			 * find the min of Diamonds
			 */
			if(jests.get(i).getSuit().getSuitString()=="Diamonds") {
				if(jests.get(i).getValues().getValueInt()<minInDiamonds) {
					minInDiamonds=jests.get(i).getValues().getValueInt();
				}
			}
		}
		
		
		
		
		/**
		 * calculate jest value
		 */
		
		
		
			
			/**
			 * calculate the Jest value of clubs and spades
			 */
		
		
		for(int i=0;i<jests.size();i++) {
			if(jests.get(i).getSuit().getSuitString()=="Spades"||jests.get(i).getSuit().getSuitString()=="Clubs") {
				this.valueJest=this.valueJest+jests.get(i).getValues().getValueInt();
			}
		}
			
			if(nomOfClubs>0&&nomOfSpades>0) {
				if(this.ifHaveSameFaceSC) {
					
					
					
					
					for(int a=0;a<jests.size();a++) {
						if(jests.get(a).getSuit().getSuitString()=="Clubs") {
							int faceValueClubs=jests.get(a).getValues().getValueInt();
							for(int j=0;j<jests.size();j++) {
								if(jests.get(j).getValues().getValueInt()==faceValueClubs) {
									if(jests.get(j).getSuit().getSuitString()=="Spades") {
										this.valueJest=this.valueJest+2;
									}
								}
							}
						}
					}
				
				
				
				}
			}
			
			/**
			 * calculate the jest value of Diamonds
			 */
			for(int i=0;i<jests.size();i++) {
				if(jests.get(i).getSuit().getSuitString()=="Diamonds") {
					this.valueJest=this.valueJest-jests.get(i).getValues().getValueInt();
				}
			}
			
			
			/**
			 * calculate the jest value of Hearts
			 */
			
			if(this.ifHaveJoker) {
				if(this.nomOfHearts==0) {
					this.valueJest=this.valueJest+4;
				}else if(this.nomOfHearts==4) {
					if(this.nomOfAce==1) {
						this.valueJest+=14;
					}else if(this.nomOfAce>1) {
						this.valueJest+=10;
					}
				}
				if(0<this.nomOfHearts&&this.nomOfHearts<4) {
					for(int b=0;b<jests.size();b++) {
						if(jests.get(b).getSuit().getSuitString()=="Hearts") {
							this.valueJest=this.valueJest-jests.get(b).getValues().getValueInt();
						}
					}
				}
			}
		
		
		
		
		
		
		
		
	}
	
	
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
	public int getFaceValue() {
		return faceValue;
	}
	/**
	 * getter
	 * @return
	 */
	public SuitOfCard getStrongestInTwo() {
		return strongestInTwo;
	}
	/**
	 * getter
	 * @return
	 */
	public SuitOfCard getStrongestInThree() {
		return strongestInThree;
	}
	/**
	 * getter
	 * @return
	 */
	public SuitOfCard getStrongestInFour() {
		return strongestInFour;
	}
	
	

}

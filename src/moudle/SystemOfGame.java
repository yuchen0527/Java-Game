package moudle;
import java.util.*;

import moudleOfPlayer.*;
/**
 * This class is to  deal with cards, construct players 
 * (select live players, number of virtual players), the
 * cards on the players ’hands,
 * 
 *
 */
public class SystemOfGame implements SystemVisitor{
	private LinkedList<player> players;
	private DrawDeck drawDeck;
	public Stack stack;
	private Trophy trophy1;
	private Trophy tropht2;
	/**
	 * choose number of players
	 * @param realPlayers
	 * @param nomEazy
	 * @param nomDF
	 */
	public SystemOfGame(int realPlayers,int nomEazy,int nomDF)  {
		
		this.players=new LinkedList<player> ();
		this.stack=new Stack();
		this.drawDeck=new DrawDeck();
			this.trophy1=new Trophy();
			this.tropht2=new Trophy();
		if(realPlayers+nomEazy+nomDF>4||realPlayers+nomEazy+nomDF<3) {
			throw new IllegalArgumentException("This game just for 3 or 4 players");
		}
		
		this.drawDeck.shuffer();
		for(int i=0;i<realPlayers;i++) {
			char a;
			a=(char) (49+i);
			Human human=new Human(a);
			players.add(human);
		}
		for(int i=0;i<nomEazy;i++) {
			char a;
			a=(char) (49+realPlayers+i);
			AIplayer AI=new AIplayer(a);
		    players.add(AI);
		}
		for(int i=0;i<nomDF;i++) {
			char a;
			a=(char) (49+realPlayers+nomEazy+i);
			AIplayer AI=new AIplayer(a);
		    players.add(AI);
		    AI.level=2;
		}
	}
	
	
	/**
	 * construct SystemOfGame
	 * @param player
	 */
	public SystemOfGame(player player) {
		this.players=new LinkedList<player> ();
		this.players.add(player);
		this.drawDeck=new DrawDeck();
	}
	/**
	 * give trophy1 to right player
	 * @param player
	 */
	public void giveTrophy1ToPlayer(player player) {
		player.getJest().getJests().add(this.trophy1.getTrophy());
	}
	/**
	 * give trophy1 to right player
	 * @param player
	 */
	public void giveTrophy2ToPlayer(player player) {
		player.getJest().getJests().add(this.tropht2.getTrophy());
	}
	/**
	 * set names for player
	 * @param value
	 * @return
	 */
	public String asciiToString(String value) {
		StringBuffer sbu=new StringBuffer();
		String[] chars=value.split(",");
		for(int i=0;i<chars.length;i++) {
			sbu.append((char)Integer.parseInt(chars[i]));
		}
		return sbu.toString();
	}
	
	/**
	 * for visit mode
	 */
	public LinkedList<Card> visit(DrawDeck DrawDeck) {
		return DrawDeck.getDrawDeck();
	}
	/**
	 * for visit mode
	 */
	public LinkedList<Card> visit(Stack Stack) {
		return Stack.getStack();
	}
	/**
	 * for visit mode
	 */
	public LinkedList<player> getPlayers(){
		return this.players;
	}
	/**
	 * give first trophy
	 */
	public void giveTrophy1() {
		this.trophy1.setTrophy(this.drawDeck.getDrawDeck().pollFirst());
	}
	/**
	 * give second trophy
	 */
	public void giveTrophy2() {
		this.tropht2.setTrophy(this.drawDeck.getDrawDeck().pollFirst());
	}
	/**
	 * give card from draw deck
	 */
	public void giveCardFromDraw() {
		for(int i=0;i<players.size();i++) {
			players.get(i).getOffer().offers.add(this.drawDeck.getDrawDeck().pollFirst());
			players.get(i).getOffer().offers.add(this.drawDeck.getDrawDeck().pollFirst());
		}
	}
	/**
	 * give two card for player when a new round begin
	 */
	public void giveCardFromStack() {
		for(int i=0;i<players.size();i++) {
			players.get(i).getOffer().offers.add(this.visit(this.stack).pollFirst());
			players.get(i).getOffer().offers.add(this.visit(this.stack).pollFirst());
		}
	}
	public void makeTipTrue() {
		for(int i=0;i<this.players.size();i++) {
			this.players.get(i).tip=true;
		}
	}
	/**
	 * This method is to decide which player will be able
	 * to choose card from others card.
	 * @return player
	 */
	public player whoChooseOffer() {
		player chooser=new player();
		Card maxCard=new Card();
		LinkedList<player> playerWhoCanChoose=new LinkedList<player>();
		for(int i=0;i<players.size();i++) {
			if(players.get(i).tip) {
				playerWhoCanChoose.add(players.get(i));
			}
		}
		
		
		if(playerWhoCanChoose.size()==0) {
			return null;
		}
		if(playerWhoCanChoose.size()!=0) {
			for(int i=0;i<playerWhoCanChoose.size();i++) {
				if(maxCard.getRealValue().getValueInt()<playerWhoCanChoose.get(i).getOffer().cardUp.getRealValue().getValueInt()) {
					maxCard=playerWhoCanChoose.get(i).getOffer().cardUp;
				    chooser=playerWhoCanChoose.get(i);
				}
				
			}
			for(int i=0;i<playerWhoCanChoose.size();i++) {
				if(maxCard.getRealValue().getValueInt()==playerWhoCanChoose.get(i).getOffer().cardUp.getRealValue().getValueInt()&&chooser!=players.get(i)) {
					if(maxCard.getSuit().getSuitStrong()<playerWhoCanChoose.get(i).getOffer().cardUp.getSuit().getSuitStrong()) {
						maxCard=playerWhoCanChoose.get(i).getOffer().cardUp;
						chooser=playerWhoCanChoose.get(i);
					}
				}
			}
			return chooser;
		}
		return null;
	
	}
	
	/**
	 * Traverse the cards and decide who will be awarded the trophy
	 * @param getter
	 * @param Trophy
	 */
	public void giveTrophy(Human getter,Trophy Trophy) {
		getter.getJest().getJests().add(Trophy.getTrophy());
		Trophy=null;
	}
	
	/**
	 * give trophy to right player
	 * @param trophy
	 * @return
	 */
	public player chooseWhoGetTrophy(Trophy trophy) {
		String TC;
		TC=trophy.getTC().getTCString();
		
		
		
		/**
		 * the condition of BestJest
		 */
	if(TC=="BestJestNoJoker") {
		player getter=new player();
		int max1=0;
		int max2=0;
		for(int i=0;i<players.size();i++) { 
			
			if(players.get(i).getInformation().getIfHaveJoker()==false) {
				                                               
					if(max1<players.get(i).getInformation().getValueJest()) {                						
						max1=players.get(i).getInformation().getValueJest();                   
						max2=players.get(i).getInformation().getFaceValue();                   
						getter=players.get(i);
						}                                                
					else if(max1==players.get(i).getInformation().getValueJest()) {
						if(max2<players.get(i).getInformation().getFaceValue()) {          
							max1=players.get(i).getInformation().getValueJest();           
					        max2=players.get(i).getInformation().getFaceValue();           
				 	        getter=players.get(i);                                         
						}else if (max2==players.get(i).getInformation().getFaceValue()){   
							if(getter.getInformation().getNomOfSpades()>players.get(i).getInformation().getNomOfSpades()) {
								continue;
							}else if(getter.getInformation().getNomOfSpades()<players.get(i).getInformation().getNomOfSpades()) {
								max1=players.get(i).getInformation().getValueJest();           
						        max2=players.get(i).getInformation().getFaceValue();           
					 	        getter=players.get(i);
							}else if(getter.getInformation().getNomOfSpades()==players.get(i).getInformation().getNomOfSpades()) {
								if(getter.getInformation().getNomOfClubs()>players.get(i).getInformation().getNomOfClubs()) {
									continue;
								}else if(getter.getInformation().getNomOfClubs()<players.get(i).getInformation().getNomOfClubs()) {
									max1=players.get(i).getInformation().getValueJest();           
							        max2=players.get(i).getInformation().getFaceValue();           
						 	        getter=players.get(i);
								 }
							  }
							}     
					      }
								                                                             
					}        
			}
			
			                                                           
		return getter;
	}
		
	  if(TC=="BestJest") {                                                                   
      		player getter=new player();                                                        
			int max1=0;                                                                        
			int max2=0;                                                                        				
			for(int i=0;i<players.size();i++) {                                                
				if(max1<players.get(i).getInformation().getValueJest()) {                						
					max1=players.get(i).getInformation().getValueJest();                   
					max2=players.get(i).getInformation().getFaceValue();                   
					getter=players.get(i);
					}                                                
				else if(max1==players.get(i).getInformation().getValueJest()) {
					if(max2<players.get(i).getInformation().getFaceValue()) {          
						max1=players.get(i).getInformation().getValueJest();           
				        max2=players.get(i).getInformation().getFaceValue();           
			 	        getter=players.get(i);                                         
					}else if (max2==players.get(i).getInformation().getFaceValue()){   
						if(getter.getInformation().getNomOfSpades()>players.get(i).getInformation().getNomOfSpades()) {
							continue;
						}else if(getter.getInformation().getNomOfSpades()<players.get(i).getInformation().getNomOfSpades()) {
							max1=players.get(i).getInformation().getValueJest();           
					        max2=players.get(i).getInformation().getFaceValue();           
				 	        getter=players.get(i);
						}else if(getter.getInformation().getNomOfSpades()==players.get(i).getInformation().getNomOfSpades()) {
							if(getter.getInformation().getNomOfClubs()>players.get(i).getInformation().getNomOfClubs()) {
								continue;
							}else if(getter.getInformation().getNomOfClubs()<players.get(i).getInformation().getNomOfClubs()) {
								max1=players.get(i).getInformation().getValueJest();           
						        max2=players.get(i).getInformation().getFaceValue();           
					 	        getter=players.get(i);
							 }
						  }
						}     
				      }
							                                                             
				}                                                                      
	                                                                                             
	                                                                                             
				return getter;                                                                     
		        }                                                                                          
		
		/**
		 * the condition of Majority
		 */
		
		
		if(TC=="MajorityOfTwo") {
			player getter=new player();
			int nom=0;
			int max=0;
			for(int i=0;i<players.size();i++) {
				if(nom<players.get(i).getInformation().getNomOfTwo()) {
					nom=players.get(i).getInformation().getNomOfTwo();
					max=players.get(i).getInformation().getStrongestInTwo().getSuitStrong();
					getter=players.get(i);
				}else if(nom==players.get(i).getInformation().getNomOfTwo()&&max<players.get(i).getInformation().getStrongestInTwo().getSuitStrong()) {
					nom=players.get(i).getInformation().getNomOfTwo();
					max=players.get(i).getInformation().getStrongestInTwo().getSuitStrong();
					getter=players.get(i);
				}
			}
			return getter;
		}
		if(TC=="MajorityOfThree") {
			player getter=new player();
			int nom=0;
			int max=0;
			for(int i=0;i<players.size();i++) {
				if(nom<players.get(i).getInformation().getNomOfThree()) {
					nom=players.get(i).getInformation().getNomOfThree();
					max=players.get(i).getInformation().getStrongestInThree().getSuitStrong();
					getter=players.get(i);
				}else if(nom==players.get(i).getInformation().getNomOfThree()&&max<players.get(i).getInformation().getStrongestInThree().getSuitStrong()) {
					nom=players.get(i).getInformation().getNomOfThree();
					max=players.get(i).getInformation().getStrongestInThree().getSuitStrong();
					getter=players.get(i);
				}
			}
			return getter;
		}
		
		
		if(TC=="MajorityOfFour") {
			player getter=new player();
			int nom=0;
			int max=0;
			for(int i=0;i<players.size();i++) {
				if(nom<players.get(i).getInformation().getNomOfFour()) {
					nom=players.get(i).getInformation().getNomOfFour();
					max=players.get(i).getInformation().getStrongestInFour().getSuitStrong();
					getter=players.get(i);
				}else if(nom==players.get(i).getInformation().getNomOfFour()&&max<players.get(i).getInformation().getStrongestInFour().getSuitStrong()) {
					nom=players.get(i).getInformation().getNomOfFour();
					max=players.get(i).getInformation().getStrongestInFour().getSuitStrong();
					getter=players.get(i);
				}
			}
			return getter;
		}
		
		
		/**
		 * the condition of lowest
		 */
		
		if(TC=="LowestOfHearts") {
			player getter=new player();
			int nom=6;
			for(int i=0;i<players.size();i++) {
				if(players.get(i).getInformation().getNomOfHearts()!=0) {
					if(nom>players.get(i).getInformation().getMinInHearts()) {
					nom=players.get(i).getInformation().getMinInHearts();
					getter=players.get(i);
				}
				}
			}
			return getter;
		}
		if(TC=="LowestOfSpades") {
			player getter=new player();
			int nom=6;
			for(int i=0;i<players.size();i++) {
				if(players.get(i).getInformation().getNomOfSpades()!=0) {
					if(nom>players.get(i).getInformation().getMinInSpades()) {
					nom=players.get(i).getInformation().getMinInSpades();
					getter=players.get(i);
				}
				}
			}
			return getter;
		}
		if(TC=="LowestOfClubs") {
			player getter=new player();
			int nom=6;
			for(int i=0;i<players.size();i++) {
				if(players.get(i).getInformation().getNomOfClubs()!=0) {
					if(nom>players.get(i).getInformation().getMinInClubs()) {
					nom=players.get(i).getInformation().getMinInClubs();
					getter=players.get(i);
				}
				}
			}
			return getter;
		}
		if(TC=="LowestOfDiamonds") {
			player getter=new player();
			int nom=6;
			for(int i=0;i<players.size();i++) {
				if(players.get(i).getInformation().getNomOfDiamonds()!=0) {
					if(nom>players.get(i).getInformation().getMinInDiamonds()) {
					nom=players.get(i).getInformation().getMinInDiamonds();
					getter=players.get(i);
				}
				}
			}
			return getter;
		}
		/**
		 * condition of the highest
		 */
		if(TC=="HighestOfHearts") {
			player getter=new player();
			int nom=0;
			for(int i=0;i<players.size();i++) {
				if(players.get(i).getInformation().getNomOfHearts()!=0) {
					if(nom<players.get(i).getInformation().getMaxInHearts()) {
					nom=players.get(i).getInformation().getMaxInHearts();	
					getter=players.get(i);
				}
				}
			} 
			return getter;
		}
		if(TC=="HighestOfSpades") {
			player getter=new player();
			int nom=0;
			for(int i=0;i<players.size();i++) {
				if(players.get(i).getInformation().getNomOfSpades()!=0) {
					if(nom<players.get(i).getInformation().getMaxInSpades()) {
					nom=players.get(i).getInformation().getMaxInSpades();	
					getter=players.get(i);
				}
				}
			} 
			return getter;
		}
		if(TC=="HighestOfClubs") {
			player getter=new player();
			int nom=0;
			for(int i=0;i<players.size();i++) {
				if(players.get(i).getInformation().getNomOfClubs()!=0) {
					if(nom<players.get(i).getInformation().getMaxInClubs()) {
					nom=players.get(i).getInformation().getMaxInClubs();	
					getter=players.get(i);
				}
				}
			} 
			return getter;
		}
		if(TC=="HighestOfDiamonds") {
			player getter=new player();
			int nom=0;
			for(int i=0;i<players.size();i++) {
				if(players.get(i).getInformation().getNomOfDiamonds()!=0) {
					if(nom<players.get(i).getInformation().getMaxInDiamonds()) {
					nom=players.get(i).getInformation().getMaxInDiamonds();	
					getter=players.get(i);
				}
				}
			} 
			return getter;
		}
		
		/**
		 * ths condition of joker
		 */
		if(TC=="Joker") {
			 player getter=new player();
			 for(int i=0;i<players.size();i++) {
				 if(players.get(i).getInformation().getIfHaveJoker()) {
					 getter=players.get(i);
			    }
			 }
			 return getter;
		}
		
		
		return null;
	}
	/**
	 * getter
	 * @return
	 */
	public DrawDeck getDrawDeck() {
		return this.drawDeck;
	}
	/**
	 * getter
	 * @return
	 */
	public Trophy getTrophy1() {
		return this.trophy1;
	}
	/**
	 * getter
	 * @return
	 */
	public Trophy getTrophy2() {
		return this.tropht2;
	}
	/**
	 * getter
	 * @return
	 */
	public Stack getStack() {
		return this.stack;
	}
	
	
	
	
}

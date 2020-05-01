package partie;
import moudle.*;

import Mvc.*;
import Mvc.Observable;
import moudle.Stack;
import moudleOfPlayer.*;
import java.util.*;
import vue.*;
/**
 * Round for run Jest Game
 */
public class Round extends Observable implements Runnable{
	public SystemOfGame system;
	public Controller controller;
	public player winner;
	
	
	
	
	 public Round(Controller controller) {
		 this.controller=controller;
	 }
	 
	 
	 public void setSystem(int numOfHuman,int numOfAIEazy,int numOfAIDF) {
		 this.system=new SystemOfGame(numOfHuman,numOfAIEazy,numOfAIDF);
	 }
	 
	 
	 public void offerFaceUp() {
		 System.out.println("********************");
		 System.out.println("Now, it's time to choose one card up!");
		 
		 
		 for(int i=0;i<this.system.getPlayers().size();i++) {
			 
			 System.out.println(this.system.getPlayers().get(i).getOffer().offers);
			 
			 if(this.system.getPlayers().get(i) instanceof Human) {
				 System.out.println("Please choose one card face up");
				int whichCard;
				System.out.println(this.system.getPlayers().get(i).getName()+" choose the card you want to face up:");
				
				
				
				whichCard=(this.controller.getView().getWhichCard());
				this.system.getPlayers().get(i).chooseOfferUp(this.system.getPlayers().get(i).getOffer(), whichCard);
				this.controller.getView().getJestWindow().updateOfferUp();
				
				
				if(whichCard==1) {
					System.out.println("card1:"+this.system.getPlayers().get(i).getOffer().offers.getFirst());
					System.out.println("card2:INVISIBLE");
				}else if(whichCard==2) {
					System.out.println("card1:INVISIBLE");
					System.out.println("card2:"+this.system.getPlayers().get(i).getOffer().offers.getLast());
					}else {
						System.out.println("You should choose from 1 or 2.");
						boolean a=true;
						while(a) {
							 System.out.println("Please choose one card face up");
								System.out.println(this.system.getPlayers().get(i).getName()+" choose the card you want to face up:");
								whichCard=(this.controller.getView().getWhichCard());
								this.controller.getView().text.t.stop();
								this.system.getPlayers().get(i).chooseOfferUp(this.system.getPlayers().get(i).getOffer(), whichCard);
								if(whichCard==1) {
									a=false;
									System.out.println("card1:"+this.system.getPlayers().get(i).getOffer().offers.getFirst());
									System.out.println("card2:INVISIBLE");
								}else if(whichCard==2) {
									a=false;
									System.out.println("card1:INVISIBLE");
									System.out.println("card2:"+this.system.getPlayers().get(i).getOffer().offers.getLast());
									}
						}
					}
				}
			 
			 
			 if(this.system.getPlayers().get(i) instanceof AIplayer) {
				System.out.println("Please choose one card face up");
				System.out.println(this.system.getPlayers().get(i).getName()+" has chosen this card up");
				this.system.getPlayers().get(i).chooseOfferUp(this.system.getPlayers().get(i).getOffer());
				this.controller.getView().getJestWindow().updateOfferUp();
				System.out.println("card1:"+this.system.getPlayers().get(i).getOffer().offers.getFirst());
				System.out.println("card2:INVISIBLE");
			 }
			}
		 }
	 
	 
	 
	 
	 public void offerRound(player player) {
		 LinkedList<player> playersCanBeChosen=new LinkedList();
		 LinkedList<player> playersWhoCanChoose=new LinkedList();
		 int index=this.system.getPlayers().indexOf(player);
		 
		 
		 
		 
		 
		 for(int i=0;i<this.system.getPlayers().size();i++) {
			 if(this.system.getPlayers().get(i).tip==true) {
				 playersWhoCanChoose.add(this.system.getPlayers().get(i)); 
			 }
		 }
		 for(int i=0;i<this.system.getPlayers().size();i++) {
			 playersCanBeChosen.add(this.system.getPlayers().get(i));
		 }
		 
		 
		 
		 
         while(playersWhoCanChoose.size()>0) {
			 
			 
			 if(this.system.getPlayers().get(index).tip==false) {
				 if(this.system.whoChooseOffer()==null) {
					 System.out.println("Choose offer part has finished.");
					 break;
				 }
				 System.out.println(index);
				 index=this.system.getPlayers().indexOf(this.system.whoChooseOffer());
				 System.out.println(index);
			 }
			 
			 
			 playersWhoCanChoose.clear();
			 for(int i=0;i<this.system.getPlayers().size();i++) {
				 if(this.system.getPlayers().get(i).tip) {
					 playersWhoCanChoose.add(this.system.getPlayers().get(i));
				 }
			 }
			 /**
			  * method for human
			  */
			
			 if(this.system.getPlayers().get(index) instanceof Human) {
				 
				 System.out.println("Now,"+this.system.getPlayers().get(index).getName()+" choose offer from other.");
				 playersCanBeChosen.clear();
				 for(int i=0;i<this.system.getPlayers().size();i++) {
					 if(this.system.getPlayers().get(i).getOffer().offers.size()==2&&this.system.getPlayers().get(i)!=this.system.getPlayers().get(index)) {
						 playersCanBeChosen.add(this.system.getPlayers().get(i));
					 }
				 }
				 
				 if(playersCanBeChosen.size()==0) {
					 System.out.println("There aren't other players you can choose,you have to take one card from your own offers.");
					 System.out.println(this.system.getPlayers().get(index).getOffer().offers);
					 System.out.println("Which card you want to choose?(From card 1 or 2)");
					 int chooseWhichCard=this.controller.getView().getWhichCard();
					 
					 if(chooseWhichCard>2||chooseWhichCard<1) {
						 System.out.println("You have to choose from card1 and card2.");
						 this.offerRound(this.system.getPlayers().get(index));
					 }
					 
					 
					 this.system.getPlayers().get(index).takeOffer(this.system.getPlayers().get(index), chooseWhichCard);
				 }else {
					 for(int i=0;i<playersCanBeChosen.size();i++) {
							 if(playersCanBeChosen.get(i).getOffer().cardUp==playersCanBeChosen.get(i).getOffer().card1) {
								 System.out.println(playersCanBeChosen.get(i).getName()+" offers:");
								 System.out.println("card1:"+playersCanBeChosen.get(i).getOffer().card1);
								 System.out.println("card2:INVISIBLE");
								 System.out.println();
							 }else if(playersCanBeChosen.get(i).getOffer().cardUp==playersCanBeChosen.get(i).getOffer().card2) {
								 System.out.println(playersCanBeChosen.get(i).getName()+" offers:");
								 System.out.println("card1:INVISIBLE");
								 System.out.println("card2:"+playersCanBeChosen.get(i).getOffer().card2);
								 System.out.println();
							 }
						 
					 }
					 
					 System.out.println("Who you want to choose?");
				     int chooseWhichPlayer=this.controller.getView().getWho()-1;
				     if(chooseWhichPlayer+1>this.system.getPlayers().size()) {
				    	 System.out.println("You have to choose the players in the game.");
				    	 continue;
				     }
				     
				     if(this.system.getPlayers().get(chooseWhichPlayer)==this.system.getPlayers().get(index)) {
				    	 System.out.println("There are other players who can be taken offer.So you can't choose offer from yourself.");
				    	 continue;
				     }
				     if(this.system.getPlayers().get(chooseWhichPlayer).getOffer().offers.size()<2) {
				    	 System.out.println("This player has been chosen.Please choose another one.");
				    	 continue;
				     }
				     System.out.println("Which card you want to choose?(From card 1 or 2)");
				     int chooseWhichCard=this.controller.getView().getWhichCard();
				     if(chooseWhichCard>2||chooseWhichCard<1) {
						 System.out.println("You have to choose from card1 and card2.");
						 continue;
					 }
				     this.system.getPlayers().get(index).takeOffer(this.system.getPlayers().get(chooseWhichPlayer),chooseWhichCard);
				     index=this.system.getPlayers().indexOf(this.system.getPlayers().get(chooseWhichPlayer));
				 }
				 
				
				/**
				 * AI
				 */
			     
			     
			 }else if(this.system.getPlayers().get(index) instanceof AIplayer) {
				 System.out.println("Now,"+this.system.getPlayers().get(index).getName()+" choose offer from other.(AI)");
				 playersCanBeChosen.clear();
				 
				 for(int i=0;i<this.system.getPlayers().size();i++) {
					 if(this.system.getPlayers().get(i).getOffer().offers.size()==2&&this.system.getPlayers().get(i)!=this.system.getPlayers().get(index)) {
						 playersCanBeChosen.add(this.system.getPlayers().get(i));
					 }
				 }
				 if(playersCanBeChosen.size()==0) {
					 System.out.println("There aren't other players you can choose,you have to take one card from your own offers.");
					 this.system.getPlayers().get(index).takeOffer(this.system.getPlayers().get(index));
					 
				 }else {
					 this.system.getPlayers().get(index).takeOffer(playersCanBeChosen.getFirst());
					 index=this.system.getPlayers().indexOf(playersCanBeChosen.getFirst());
				 }
				 System.out.println("And choose from "+this.system.getPlayers().get(index).getName());
				 System.out.println();
				 
			 }
		 }
         
         
		 System.out.println("The round has finished.");
		 System.out.println("*********************"); 
	 }
	 
	 public void gameRound() {
		 while(this.system.getDrawDeck().getDrawDeck().size()!=0) {
				System.out.println("New round begins!");
				this.system.makeTipTrue();
				this.system.stack=new Stack(this.system.getPlayers(),this.system.getDrawDeck());
				this.system.giveCardFromStack();
				this.controller.getView().getJestWindow().updateOffer();
				this.offerFaceUp();
				this.offerRound(this.system.whoChooseOffer());
			}
	 }
	 
	 
	 
	public void chooseWinner() {
		int win=0;
		winner=new player();
		for(int i=0;i<this.system.getPlayers().size();i++) {
			if(win<this.system.getPlayers().get(i).getInformation().getValueJest()) {
				win=this.system.getPlayers().get(i).getInformation().getValueJest();
				winner=this.system.getPlayers().get(i);
			}
		}
		
		System.out.println(winner.getName()+" is the winner!Congratulations!");
	}
	 
	 
	public void giveTrophy() {
		if(this.system.getPlayers().size()==3) {
			this.system.giveTrophy1();
			this.system.giveTrophy2();
		}else if(this.system.getPlayers().size()==4) {
			this.system.giveTrophy1();
		}
		
	}
	
	public void putTrophyOut() {
		if(this.system.getPlayers().size()==3) {
			this.controller.getView().getJestWindow().updateTrophy();
			System.out.println("Trophy1:"+this.system.getTrophy1().getTrophy());
			System.out.println("Trophy2:"+this.system.getTrophy2().getTrophy());
		}else if(this.system.getPlayers().size()==4) {
			System.out.println("Trophy1:"+this.system.getTrophy1().getTrophy());
		}
	}
	
	
	public void giveTrophyToPlayer() {
		if(this.system.getPlayers().size()==3) {
			System.out.println(this.system.chooseWhoGetTrophy(this.system.getTrophy1()));
			System.out.println(this.system.chooseWhoGetTrophy(this.system.getTrophy2()));
			this.system.giveTrophy1ToPlayer(this.system.chooseWhoGetTrophy(this.system.getTrophy1()));
			this.system.giveTrophy2ToPlayer(this.system.chooseWhoGetTrophy(this.system.getTrophy2()));
		}else if(this.system.getPlayers().size()==4) {
			this.system.giveTrophy1ToPlayer(this.system.chooseWhoGetTrophy(this.system.getTrophy1()));
		}
	}
	 
	
	public void showPlayerJest() {
		for(int i=0;i<this.system.getPlayers().size();i++) {
			System.out.println(this.system.getPlayers().get(i).getName()+" jests:"+this.system.getPlayers().get(i).getJest().getJests());
			System.out.println("*********************");
		}
	}
	public void showPlayerJestValue() {
		for(int i=0;i<this.system.getPlayers().size();i++) {
			System.out.println(this.system.getPlayers().get(i).getName());
			System.out.println(this.system.getPlayers().get(i).getInformation().getValueJest());
		}
	}
	
	public void lastRound() {
		for(int i=0;i<this.system.getPlayers().size();i++) {
			this.system.getPlayers().get(i).getJest().getJests().add(this.system.getPlayers().get(i).getOffer().offers.poll());
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


	
}

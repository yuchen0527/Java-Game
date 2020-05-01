package partie;
import moudle.*;
import Mvc.*;
import Mvc.Observable;
import moudle.Stack;
import moudleOfPlayer.*;
import java.util.*;
import vue.*;
import java.util.Scanner;

import moudle.*;
import moudle.LuckySystem;
import moudleOfPlayer.*;
/**
 * 
 * The class is a round for Lucky game.
 *
 */
public class LuckyGame extends Observable implements Runnable{
	public LuckySystem system;
	public Controller controller;
	Scanner putin;
	private int nomOfHuman;
	private int nomOfAI;
	/*int nomOfHuman;
	int nomOfAI;*/
public LuckyGame(Controller controller) {
	this.controller=controller;
}
public void setLuckySystem(int numOfHuman,int numOfAI) {
	this.system=new LuckySystem(numOfHuman,numOfAI);
}

/**
 * core of the round
 * Each player gets two card as Lucky Offer, then player decide which cards to give on the
 * lucky table. Player gets bonnus by having same card with the card on table
 */
public void LuckyCardTrick() {
	do {
	System.out.println("Now we have "+this.system.getLuckyTable().getLuckyTable().size()+" cards on the table");
	 
	for(int i=0;i<this.system.getPlayers().size();i++) {

		if(this.system.getPlayers().get(i) instanceof Human) {
			int whichCard;
			System.out.println(this.system.getPlayers().get(i).getName()+"'s lucky offers:");
			System.out.println(this.system.getPlayers().get(i).getLuckyOffer().luckyoffers);
			System.out.println(this.system.getPlayers().get(i).getName()+" ,which card do you want to choose?(choose from 1 or 2)");
			whichCard=(this.controller.getView().getWhichluckyCard());
			if (whichCard==1 || whichCard == 2) {
				System.out.println("OK, you've chosen this card: ");
			this.system.getPlayers().get(i).giveCardTable(this.system.getPlayers().get(i).getLuckyOffer(), whichCard);}
			else {System.out.println("You need choose from card1 or card2.");
			whichCard=putin.nextInt();
			System.out.println("OK, you've chosen this card: ");
			this.system.getPlayers().get(i).giveCardTable(this.system.getPlayers().get(i).getLuckyOffer(), whichCard);}
			this.system.getPlayers().get(i).LuckyJestBonnus(this.system.getLuckyTable());
		}
		if(this.system.getPlayers().get(i) instanceof AIplayerEasy) {
			System.out.println(this.system.getPlayers().get(i).getName()+" has chosen this card:");
			this.system.getPlayers().get(i).giveCardTable(this.system.getPlayers().get(i).getLuckyOffer());
			this.system.getPlayers().get(i).LuckyJestBonnus(this.system.getLuckyTable());
		 }
		System.out.println("*********************");
		if(this.system.getLuckyTable().getLuckyTable().size()>this.system.getPlayers().size())
		this.system.giveCardFromTableOne();
	}}
while(this.system.getLuckyTable().getLuckyTable().size()>this.system.getPlayers().size());
}
/**
 * decide winner
 */
public void decideLuckyKing() {
	System.out.println("Now it comes to caluculate:");
	System.out.println("                     ");
	System.out.println("                     ");
	System.out.println("*********************");
	
	 

	for(int i=0;i<this.system.getPlayers().size();i++) {
		System.out.println(this.system.getPlayers().get(i).getName());
		System.out.println("Got that lucky jest value:");
		System.out.println(this.system.getPlayers().get(i).getLuckyJest().getLuckyJests().size() + this.system.getPlayers().get(i).getluckyInformation().getValueJest());
		System.out.println("*********************");
	}
	
	
	int max=0;
	for(int i=0;i<this.system.getPlayers().size();i++) {
			
			if(max<this.system.getPlayers().get(i).getluckyInformation().getValueJest()+this.system.getPlayers().get(i).getLuckyJest().getLuckyJests().size())
				max=this.system.getPlayers().get(i).getluckyInformation().getValueJest()+this.system.getPlayers().get(i).getLuckyJest().getLuckyJests().size();

		}	
	for(int i=0;i<this.system.getPlayers().size();i++) {
		
		if(max==this.system.getPlayers().get(i).getluckyInformation().getValueJest()+this.system.getPlayers().get(i).getLuckyJest().getLuckyJests().size()&& max!=0)
			System.out.println(this.system.getPlayers().get(i).getName()+" is winner!!");

	}
	int everyoneiszero=0;
    for(int i=0;i<this.system.getPlayers().size();i++) {
		if(this.system.getPlayers().get(i).getluckyInformation().getValueJest()+this.system.getPlayers().get(i).getLuckyJest().getLuckyJests().size()==0)
			everyoneiszero++;

	}
    if(everyoneiszero==this.system.getPlayers().size())
   System.out.println("NO ONE WINS HERE, EVERYONE IS LUCKY KING!!");
    
}
/**
 * print end of game
 */
public void endGame() {
	System.out.println("NOW LUCKY GAME OVER");
	System.out.println("*********************");
}
 /*public LuckyGame(int numOfHuman,int numOfAI){
		 this.system=new LuckySystem(numOfHuman,numOfAI);
		 this.nomOfAI=numOfAI;
		 this.nomOfHuman=numOfHuman;
		 this.putin=new Scanner(System.in);
	 }*/
	 public static void main(String[] args) {
		
		}
			
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	 }
	 
			
			
			
			
			
			
	 

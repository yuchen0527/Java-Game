package moudle;
import moudleOfPlayer.*;
import java.util.LinkedList;

public class LuckySystem {
	private LinkedList<player> players;
	private LuckyTable luckytable;
	/**
	 * stack for player to store lucky cards
	 */
	public LuckyStack luckystack;
	/**
	 * hand cards for player each round
	 */
	public LuckyOffer luckyoffer;
	/**
	 * calculated cards for player
	 */
	public LuckyJest LuckyJest;
	/**
	 * if the list is empty
	 */
	public boolean ifempty;
	/**
	 * structure a system for lucky game
	 * @param realPlayers
	 * @param vitualPlayers
	 */
	public LuckySystem(int realPlayers,int vitualPlayers)  {
		this.players=new LinkedList<player> ();
		this.luckystack=new LuckyStack();
		this.luckytable=new LuckyTable();
		this.LuckyJest=new LuckyJest();
			
		if(realPlayers+vitualPlayers>3||realPlayers+vitualPlayers<2) {
			throw new IllegalArgumentException("This game just for 2 or 3 players");
		}
		
		this.luckytable.shuffer();
		for(int i=0;i<realPlayers;i++) {
			char a;
			a=(char) (49+i);
			Human human=new Human(a);
			players.add(human);
		}
		for(int i=0;i<vitualPlayers;i++) {
			char a;
			a=(char) (49+realPlayers+i);
			AIplayerEasy AI=new AIplayerEasy(a);
		    players.add(AI);
		}
		
	}
	/**
	 * structure a system for lucky game
	 * @param player
	 */
	public LuckySystem(player player) {
		this.players=new LinkedList<player> ();
		this.players.add(player);
		this.luckytable=new LuckyTable();
		this.LuckyJest=new LuckyJest();
	}
	/**
	 * give name to player
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
	 * component for visitor mode
	 * @param LuckyJest
	 * @return
	 */
	public LinkedList<luckyCard> visit(LuckyJest LuckyJest) {
		return this.LuckyJest.getLuckyJests();
	}
	/**
	 *  component for visitor mode
	 * @param luckytable
	 * @return
	 */
	public LinkedList<luckyCard> visit(LuckyTable luckytable) {
		return luckytable.getLuckyTable();
	}
	/**
	 *  component for visitor mode
	 * @param luckystack
	 * @return
	 */
	public LinkedList<luckyCard> visit(LuckyStack luckystack) {
		return luckystack.getLuckyStack();
	}
	/**
	 *  component for visitor mode
	 * @return
	 */
	public LinkedList<player> getPlayers(){
		return this.players;
	}
	/**
	 * give two card to player
	 */
	public void giveCardFromTable() {
		for(int i=0;i<players.size();i++) {
			players.get(i).getLuckyOffer().luckyoffers.add(this.luckytable.getLuckyTable().pollFirst());
			players.get(i).getLuckyOffer().luckyoffers.add(this.luckytable.getLuckyTable().pollFirst());
		}
	}
	/**
	 * give one card to player
	 */
	public void giveCardFromTableOne() {
		for(int i=0;i<players.size();i++) {
			players.get(i).getLuckyOffer().luckyoffers.add(this.luckytable.getLuckyTable().pollFirst());
		
		}
	}
	/**
	 * give one card to player's stack
	 */
	public void giveCardFromLuckyStack() {
		for(int i=0;i<players.size();i++) {
			players.get(i).getLuckyOffer().luckyoffers.add(this.visit(luckystack).pollFirst());
			
			
		}
	}
	/**
	 * configure if it is end
	 * @return
	 */
	public boolean endOfGame() {
		if(luckytable.getLuckyTable().isEmpty())
		return false;
		else return true;
	}
	/*public void LuckyJestBonnus(LuckyTable LuckyTable) {
		Card card1=new Card();
		Card card2=new Card();
		card1=luckytable.getLuckyTable().getLast();
		for(int i=0;i<luckytable.getLuckyTable().size();i++) {
			card2=luckytable.getLuckyTable().get(i);
			boolean a=card1.getValues().getValueInt()==card2.getValues().getValueInt();
			boolean b=card1.getSuit().getSuitString()!=card2.getSuit().getSuitString();
			if(a&&b) {
				System.out.println("You got these card as bonus.");
				for(int j=i;j<LuckyTable.getLuckyTable().size();j++) {
					LuckyJest.getLuckyJests().add(luckytable.getLuckyTable().get(j));
					
					System.out.println("["+luckytable.getLuckyTable().get(j)+"]");
					luckytable.getLuckyTable().remove(j);
				}	
				break;
			}
		}
		
	}*/
	
	/**
	 * getter
	 * @return
	 */
	public LuckyTable getLuckyTable() {
		return this.luckytable;
	}
/**
 * getter
 * @return
 */
	public LuckyJest getLuckyJest() {
		return this.LuckyJest;
	}
	/**
	 * getter
	 * @return
	 */
	public LuckyStack getLuckyStack() {
		return this.luckystack;
	}

}

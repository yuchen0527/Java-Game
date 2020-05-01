package moudleOfPlayer;

import java.util.LinkedList;

import moudle.*;
/**
 * 
 * This class is to implements the Visitor mode.
 *
 */
public interface PlayerVisitor {
	public LinkedList<Card> visit(Jest Jest);
	public LinkedList<Card> visit(Offer Offer);

}

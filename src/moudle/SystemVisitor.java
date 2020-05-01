package moudle;

import java.util.LinkedList;
/**
 * 
 * This interface is to implement Visitor mode.
 *
 */
public interface SystemVisitor {
	/**
	 * component for visitor mode
	 * @param DrawDeck
	 * @return
	 */
	public LinkedList<Card> visit(DrawDeck DrawDeck);
	/**
	 *  component for visitor mode
	 * @param stack
	 * @return
	 */
	public LinkedList<Card> visit(Stack stack);

}

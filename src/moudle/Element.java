package moudle;
import moudleOfPlayer.*;
/**
 * 
 * class to implement Visitor mode
 *
 */
public interface Element {
	public void accept(player player);
}

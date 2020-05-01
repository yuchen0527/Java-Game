package Mvc;
/**
 * 
 * The class to implement Observer mode
 *
 */
public class Observable {
	/**
	 * max observer number
	 */
	public final static int MAX_OBSERVERS=4;
	
	private Observer[] observers;
	private int numberOfObservers;
	private boolean hasChanged;
	/**
	 * constructor
	 */
	public Observable() {
		observers=new Observer[Observable.MAX_OBSERVERS];
		numberOfObservers=0;
		hasChanged=false;
	}
	/**
	 * add observer
	 * @param o
	 */
	public void addObserver(Observer o) {
		if(numberOfObservers<Observable.MAX_OBSERVERS) {
			observers[numberOfObservers]=o;
			
			numberOfObservers++;
		}else {
			System.err.println("Error:msx number of observers reached.");
		}
	}
	/**
	 * delete observer
	 * @param o
	 */
	public void deleteObserver (Observer o) {
		boolean foundObserver=false;
		for(int i=0;i<numberOfObservers;i++) {
			if(foundObserver==false) {
				if(observers[i].equals(o)) {
					observers[i]=null;
					foundObserver=true;
				}
			}else {
				observers[i-1]=observers[i];
			}
		}
		if(foundObserver==true) {
			numberOfObservers--;
		}
	}
/**
 * notify the observers
 * @param o
 */
	public void notifyObservers(Object o) {
		if(hasChanged == true) {
			for(int i=0;i<numberOfObservers;i++) {
				observers[i].update(o);
			}
			hasChanged=false;
		}
	}
	/**
	 * set change
	 */
	public void setChanged() {
		hasChanged=true;
	}
	/**
	 * clear change
	 */
	public void clearChanged() {
		hasChanged=false;
	}
}

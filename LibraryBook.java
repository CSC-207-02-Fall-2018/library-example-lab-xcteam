package inheritanceLab;

/**
 * An abstract class to give a structure to CirculatingBook and ReferenceBook.
 * Library book is a sub-class of book.
 * @author Carter Markegard
 * @author Steffie Ochoa
 */
public abstract class LibraryBook extends Book implements Comparable <LibraryBook>{
	/**
	 * @serialField callNumber String Stores the call number of the LibraryBook.
	 */
	protected String callNumber; 

	/**
	 * A constructor for LibraryBook that populates every data-field.
	 * @param author A string with the Author's name.
	 * @param title A String with the Title.
	 * @param num A String with the ISBN.
	 * @param callNum A string with the Call Number.
	 */
	public LibraryBook(String author, String title, String num, String callNum){
		super(author, title, num); 
		callNumber = callNum; 
	}

	// Getter
	/**
	 * Gets the call number.
	 * @return The call number.
	 */
	public String getCallNumber () {
		return callNumber;  
	}

	// Setter
	/**
	 * Sets the call number.
	 * @param callNum A string that sets the call Number.
	 */
	public void setCallNumber(String callNum) {
		callNumber = callNum; 
	}
	
	/**
	 * Checkout is an abstract class to be implemented in subclass.
	 * @param patron A string holding the patron's name.
	 * @param dueDate A String holding the due date of the book.
	 */
	abstract void checkout (String patron, String dueDate);	
	
	/**
	 * Returned is an abstract class to be implemented in subclass.
	 */
	abstract void returned ();
	
	/**
	 * circulationStatus is an abstract class to be implemented in subclass.
	 * @returns a String holding the circulation status.
	 */
	abstract String circulationStatus();

	/** 
	 * implementation of Comparable's compareTo method
	 * @param libro:  Library object being compared
	 * @return 0 if call numbers of this and libro match
	 *         < 0 if call number of this comes before call number of libro
	 *         > 0 otherwise
	 */
	public int compareTo (LibraryBook libro) {
		return callNumber.compareTo(libro.getCallNumber());
	}




	/**
	 * @return title, author, ISBN, call number as a String for printing
	 */

	public String toString () {
		return super.toString()+"\nCirculation status: "+this.circulationStatus()+"\nCall Number: "+callNumber; 
	}

}

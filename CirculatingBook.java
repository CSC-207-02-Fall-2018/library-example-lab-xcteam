package inheritanceLab;

/**
 * A class that defines the gives methods to Object CirculatingBook.
 * CirculatingBook is a sub-class of LibraryBook.
 * @author Carter Markegard
 * @author Steffie Ochoa
 *
 */
public class CirculatingBook extends LibraryBook{
	/**
	 * @serialField currentHold String Stores the current holder of a 
	 * checked-out book.
	 * @serialField dueDate String Stores the date that a checked-out 
	 * book is due back.
	 */
	private String currentHolder = null; 
	private String dueDate = null; 
	
	/**
	 * The constructor for a CirculatingBook.
	 * @param author_ A string that holds the author of the book.
	 * @param title_ A string that holds the title of the book.
	 * @param isbn_ A string that holds the ISBN of the book.
	 * @param callNumber_ A string that holds the callNumber of the book.
	 */
	public CirculatingBook(String author_, String title_, 
			String isbn_, String callNumber_){
		super(author_, title_, isbn_, callNumber_); 
	}

	// Getters
	/**
	 * Gets the name of a Current holder of a checked-out book.
	 * @return A string with the name of a Current holder of a checked-out 
	 * book.
	 */
	public String getCurrentHolder () {
		return currentHolder;  
	}

	/**
	 * Gets the due date of a checked-out book.
	 * @return A string with the due date of a checked-out book.
	 */
	public String getDueDate () {
		return dueDate;  
	}

	// Setters
	/**
	 * Sets the name of the current hold of a checked out book.
	 * @param holder A string with the name of the current holder.
	 */
	public void setCurrentHolder(String holder) {
		currentHolder = holder; 
	}

	/**
	 * Sets the due date of the book.
	 * @param date A string with the date the Circulating book is due.
	 */
	public void setDueDate (String date) {
		dueDate = date;  
	}


	// Other Methods 


	/**
	 * A method that checks out a book.
	 * @param name A string holding the name of the patron checking-out the book.
	 * @param date A string holding the date the CirculatingBook is due.
	 */
	public void checkout(String name, String date) {
		currentHolder = name;
		dueDate = date;
	}

	/**
	 * A method to return a checked-out book. Sets CurrentHolder and dueDate to null.
	 * If the book is already returned and in the library, returned() causes no
	 * effective change.
	 */
	public void returned() {
		setCurrentHolder(null);
		setDueDate(null);
	}

	/**
	 * @returns a String either expressing that the book is checked out or 
	 * available for checkout.
	 */
	public String circulationStatus() {
		if (getCurrentHolder() == null) {
			//If you change this string, make sure to change the string in Library.Java
			//in the method checkout as well.
			return "Book available on shelves.";
		}
		return "Book is checked out to " + currentHolder 
				+ ".\nBook due back by: " + dueDate;
	}

	/**
	 * 
	 * @param libro a circulating book.
	 * @return All of the information in a Circulating book. If the book is
	 * checked-out then it will also return the patron who has the book
	 * and the date it is due back.
	 */
	public String toString(CirculatingBook libro) {
		if (getCurrentHolder() == null) {
			return super.toString();
		} else {
			return super.toString() + "Book is checked out to " 
					+ currentHolder + ".\nBook due back by: " + dueDate;
		}

	}

}

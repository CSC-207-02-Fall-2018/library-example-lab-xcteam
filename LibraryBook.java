package inheritanceLab;

public abstract class LibraryBook extends Book implements Comparable <LibraryBook>{
	protected String callNumber; 
	
	public LibraryBook(String author, String title, String num, String callNum){
		super(author, title, num); 
		callNumber = callNum; 
	}
	
	// Getter
	public String getCallNumber () {
		return callNumber;  
	}
	
	// SetterLibraryBook libro
	public void setCallNumber(String callNum) {
		callNumber = callNum; 
	}
	
	abstract void checkout (String patron, String dueDate);	
	abstract void returned ();
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

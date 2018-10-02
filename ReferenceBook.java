package inheritanceLab;

/**
 * A class that the defines the ReferenceBook Object. Reference book
 * is a sub-class of Library book.
 * @author Carter Markegard
 * @author Steffie Ochoa
 *
 */
public class ReferenceBook extends LibraryBook{
	/**
	 * @serialField Collection String Used to store the location of the Reference book.
	 */
	private String collection;
	
	/**
	 * A constructor that creates a Reference book, populated with the following
	 * information.
	 * @param author_ A string to store the name of the Author.
	 * @param title_ A String to store the title of the book.
	 * @param isbn_ A String to store the ISBN number of the book.
	 * @param callNumber_ A String to store the Call Number of the book.
	 * @param collection_ A String to store the name of the collection where the book resides.
	 */
	public ReferenceBook(String author_, String title_, String isbn_,
			String callNumber_, String collection_){
		super(author_,title_,isbn_,callNumber_);
		collection = collection_;
	}
	
	// Getters
	/**
	 * Gets the collection name of the ReferenceBook.
	 * @return the collection name of the ReferenceBook.
	 */
	public String getCollection () {
		return collection;  
	}
	
	// Setters
	/**
	 * Sets the collection name of the book.
	 * @param set A String that is that new collection of the RefereneBook.
	 */
	public void setCollection(String set) {
		collection = set; 
	}
	
	
	// Other Methods
	/**
	 * This method will print out that you cannot check out a Reference book.
	 * @param patron A String with the name of the patron checking-out the book.
	 * @param dueDate A String with the date the book becomes due.
	 */
	public void checkout (String patron, String dueDate) {
		System.out.println("Patron cannot check out a reference book.");
	}
	
	/**
	 * Prints out that because a Reference book could not have been checked 
	 * out, it cannot be checked back in.
	 */
	public void returned () {
		System.out.println("Reference book could not have been checked out -- "
				+ "return impossible.");
	}
	
	/**
	 * @returns A String that tells the user that the Reference book is never checked out.
	 */
	public String circulationStatus () {
		//If you change this string, make sure to change the string in Library.Java
		//in the method checkout as well.
		return "Non-circulating reference book.";
	}
	
	/**
	 * @returns a String with all of the data fields of the ReferenceBook.
	 */
	public String toString () {
		return super.toString() + "\nCollection: "+collection;
	}
	
}

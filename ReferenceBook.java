package inheritanceLab;

public class ReferenceBook extends LibraryBook{
	private String collection;
	
	public ReferenceBook(String author_, String title_, String isbn_,
			String callNumber_, String collection_){
		super(author_,title_,isbn_,callNumber_);
		collection = collection_;
	}
	
	// Getters
	public String getCollection () {
		return collection;  
	}
	
	// Setters
	public void setCollection(String set) {
		collection = set; 
	}
	
	
	// Other Methods
	public void checkout (String patron, String dueDate) {
		System.out.println("Patron cannot check out a reference book.");
	}
	
	public void returned () {
		System.out.println("Reference book could not have been checked out -- "
				+ "return impossible.");
	}
	
	public String circulationStatus () {
		return "Non-circulating reference book.";
	}
	
	/** 
	 * implementation of Comparable's compareTo method
	 * @param libro:  Library object being compared
	 * @return 0 if call numbers of this and libro match
	 *         < 0 if call number of this comes before call number of libro
	 *         > 0 otherwise
	 */
	public int compareTo (LibraryBook libro) {
		if (getIsbn().equals(libro.getIsbn())) {
		return 0;
		} else if (getIsbn() < libro.getIsbn()) {
			return -1; 
		} else {
		return 1;
		}
	}
	
	
	public String toString () {
		return super.toString() + "\n Collection: "+collection;
	}
	
}

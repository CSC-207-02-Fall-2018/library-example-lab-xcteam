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
	
	public String toString () {
		return super.toString() + "\n Collection: "+collection;
	}
	
}

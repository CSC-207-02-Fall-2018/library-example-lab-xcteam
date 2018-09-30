package inheritanceLab;

public class CirculatingBook extends LibraryBook{
	private String currentHolder = null; 
	private String dueDate = null; 
	
	 public CirculatingBook(String author_, String title_, String isbn_, String callNumber_){
		super(author_, title_, isbn_, callNumber_); 
	}
	
	// Getters
	public String getCurrentHolder () {
		return currentHolder;  
	}
	
	public String getDueDate () {
		return dueDate;  
	}
	
	// Setters
	public void setCurrentHolder(String holder) {
		currentHolder = holder; 
	}
	
	public void setDueDate (String date) {
		dueDate = date;  
	}
	
	
	// Other Methods 
	
	public void checkout(String name, String date) {
		currentHolder = name;
		dueDate = date;
	}
	
	public void returned() {
		setCurrentHolder(null);
		setDueDate(null);
	}
	
	public String circulationStatus() {
		if (getCurrentHolder() == null) {
			return "Book available on shelves.";
		}
		return "Book is checked out to: " + currentHolder 
				+ ".\nBook due back by: " + dueDate;
	}
	
	public String toString(CirculatingBook libro) {
		if (getCurrentHolder() == null) {
			return super.toString();
		} else {
			return super.toString() + "Book is checked out to: " 
		+ currentHolder + ".\nBook due back by: " + dueDate;
		}
		
	}
	
}

package inheritanceLab;

public class Book {
	protected String author;
	protected String title;
	protected String isbn;
	
	public Book(){
		author = "";
		title = "";
		isbn = " ";
	}
	
	Book(String author_, String title_, String isbn_){
		author = author_;
		title = title_;
		isbn = isbn_;		
	}
	
	//Getters
	 public String getAuthor() {
		 return author;
	 }
	 
	 public String getTitle() {
		 return title;
	 }
	 
	 public String getIsbn() {
		 return isbn;
	 }
	 
	 //Setters
	 public void setAuthor(String str) {
		 author = str;
	 }
	 
	 public void setTitle(String titl) {
		 title = titl;
	 }
	 
	 public void setIsbn(String i) {
		 isbn = i;
	 }
	 
	 public String toString() {
		 return "Book name: " + title + "\nAuthor: " + author
				 + "\nISBN: " + isbn;
	 }
}

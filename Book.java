package inheritanceLab;

public class Book {
	protected String author;
	protected String title;
	protected int isbn;
	
	Book(){
		author = "";
		title = "";
		isbn = 0;
	}
	
	Book(String author_, String title_, int isbn_){
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
	 
	 public int getIsbn() {
		 return isbn;
	 }
	 
	 //Setters
	 public void setAuthor(String str) {
		 author = str;
	 }
	 
	 public void setTitle(String titl) {
		 title = titl;
	 }
	 
	 public void setIsbn(int i) {
		 isbn = i;
	 }
	 
	 public String toString() {
		 return "Book name: " + title + "\nAuthor: " + author
				 + "\nISBN: " + isbn;
	 }
}

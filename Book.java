package inheritanceLab;

/**
 * A class for defining a book objects.
 * @author Carter Markegard 
 * @author Steffie Ochoa
 *
 */
public class Book {
	/**
	 * @serialField author String stores the author of a book.
	 * @serialField title String stores the title of a book.
	 * @serialField isbn String stores the ISBN number of a book.
	 */
	protected String author;
	protected String title;
	protected String isbn;

	/**
	 * A constructor the creates an empty book. Empty meaning the author, title and 
	 * isbn fields are "" Strings.
	 */
	Book(){
		author = "";
		title = "";
		isbn = "";
	}

	/**
	 * A constructor that creates a book with the fields occupied by the
	 * specified values.
	 * @param author_ A string the will be the Author's name.
	 * @param title_ A string that will be the title of the book.
	 * @param isbn_ A string that will store the isbn number of the book.
	 */
	Book(String author_, String title_, String isbn_){
		author = author_;
		title = title_;
		isbn = isbn_;		
	}

	//Getters
	/**
	 * Gets the author of the book.
	 * @return Returns the author of the book.
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Gets the title of the book.
	 * @return Returns the title of the book.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Gets the ISBN of the book.
	 * @return Returns the ISBN of the book.
	 */
	public String getIsbn() {
		return isbn;
	}

	//Setters
	/**
	 * Sets the Author of the book.
	 * @param str A String that is the new author.
	 */
	public void setAuthor(String str) {
		author = str;
	}

	/**
	 * Sets the Title of the book.
	 * @param titl that holds the new titl of the book.
	 */
	public void setTitle(String titl) {
		title = titl;
	}

	/**
	 * Sets the ISBN of the book.
	 * @param i a String that is the new ISBN of the book.
	 */
	public void setIsbn(String i) {
		isbn = i;
	}

	/**
	 * @returns A string with all of the information in a book.
	 */
	public String toString() {
		return "Book name: " + title + "\nAuthor: " + author
				+ "\nISBN: " + isbn;
	}
}

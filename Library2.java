package inheritanceLab;

import java.util.ArrayList;
import java.util.Collections;

public class Library2 {
	ArrayList<LibraryBook> bookList;
	
	Library2 () {
		bookList = new ArrayList<LibraryBook> ();
	}
	
	/**
	 * adds the given book to the library
	 * @param book
	 */
	public void addBook2 (LibraryBook book) {
		bookList.add(book);
	}
	
	/**
	 * prints all books in the library
	 */
	public void printLibrary2 () {
		System.out.println ("\nListing of books in the library2\n");
		for (LibraryBook book: bookList)
			System.out.println (book);
		System.out.println ("End of book listing\n");
	}
	
	/**
	 * locates a book in the library
	 * @param book book being search in the library
	 * @return book object if book is found
	 *         null otherwise
	 */
	public LibraryBook findBook2 (LibraryBook book) {
		int index = Collections.binarySearch(bookList, book);
		if (index >= 0)
			return bookList.get(index);
		else
			return null;
	}
	
	/**
	 * sort books in the library by call number
	 */
	public void sortLibrary2 () {
		Collections.sort(bookList);
	}
	
	/**
	 * performs processing for checking a book out of the library
	 * @param patron  person checking out book
	 * @param dueDate date book is due to be returned
	 * @param callNum call number of book
	 */
	public void checkout2 (String patron, String dueDate, String callNum) {
		LibraryBook searchItem = new CirculatingBook ("", "", "", callNum);
		LibraryBook book = findBook2(searchItem);
		if (book == null)
				System.out.println ("Book " + callNum + " not found -- checkout impossible\n");
		else
				book.checkout (patron, dueDate);
	}
	
	/**
	 * processes checked-out book that is being returned
	 * @param callNum call number of book being returned
	 */
	public void returned2 (String callNum) {
		LibraryBook searchItem = new CirculatingBook ("", "", "", callNum);
		LibraryBook book = findBook2(searchItem);
		if (book == null)
			System.out.println ("Book " + callNum + " not found -- return impossible\n");
		else
			book.returned ();
	}
	
	/**
	 * main testing program
	 * @param args  not used
	 */
	public static void main (String args[]) {

		Library2 lib2 = new Library2 ();
		
		// set up library
		lib2.addBook2(new ReferenceBook ("Henry M. Walker", 
					"Problems for Computer Solution using BASIC",
					"0-87626-717-7", "QA76.73.B3W335", "Iowa Room"));
		lib2.addBook2(new ReferenceBook ("Samuel A. Rebelsky",
				"Experiments in Java", 
				"0201612674", "64.2 R25ex", "Iowa Room"));
		lib2.addBook2(new CirculatingBook ("John David Stone",
				"Algorithms for functional programming",
				"in process", "forthcoming"));
		lib2.addBook2(new CirculatingBook ("Henry M. Walker",
				"Computer Science 2:  Principles of Software Engineering, Data Types, and Algorithms",
				"0-673-39829-3", "QA76.758.W35"));

		lib2.addBook2(new CirculatingBook ("Henry M. Walker", 
				"Problems for Computer Solution using FORTRAN",
				"0-87626-654-5", "QA43.W34"));
		lib2.addBook2(new CirculatingBook ("Henry M. Walker",
				"Introduction to Computing and Computer Science with Pascal",
				"0-316-91841-5", "QA76.6.W3275"));
		lib2.addBook2(new CirculatingBook ("Samuel A. Rebelsky and Philip Barker", 
				"ED-MEDIA 2002 : World Conference on Educational Multimedia, Hypermedia & Telecommunications",
				"14. 1-880094-45-2", "64.2 25e"));
		lib2.addBook2(new CirculatingBook ("Henry M. Walker",
				"Pascal:  Problem Solving and Structured Program Design",
				"0-316-91848-2", "QA76.73.P2W35"));
		lib2.addBook2(new CirculatingBook ("Henry M. Walker",
			    "The Limits of Computing",
			    "0-7637-2552-8", "QA76.W185"));
		lib2.addBook2(new CirculatingBook ("Henry M. Walker",
			    "The Tao of Computing",
			    "0-86720-206-8", "QA76.W1855"));
	
		// sort books by call number
		lib2.sortLibrary2();
		
		// print library
		lib2.printLibrary2();
		
		// some users check out and return books
		lib2.checkout2("Donald Duck", "March 1, 2012", "QA43.W34");
		lib2.checkout2("Donald Duck", "March 12, 2012", "QA76.6.W3275");
		lib2.checkout2("Donald Duck", "March 6, 2012", "64.2 R25ex");
		lib2.checkout2("Minnie Mouse", "April 1, 2012", "64.2 25e");
		lib2.checkout2("Goofy", "February 28, 2012", "12345"); // should fail

		lib2.returned2("QA76.6.W3275");
		lib2.returned2("64.2 R25ex");
		
		lib2.checkout2("Goofy", "March 28, 2012", "QA76.6.W3275");
		
		// print final status of library
		lib2.printLibrary2();		
	}
}

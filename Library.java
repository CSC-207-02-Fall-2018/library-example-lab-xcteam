/*
 * This class is an augmentation of the original implementation of the Library testing class
 * that was provided by Henry Walker. We have edited this class' methods to take in 
 * objects with type LibraryBook instead of just one field of the library book. 
 * We did this because at first we were unsure what the problem was with the testing file 
 * (we found out we needed to change the implementation of compareTo back in LibraryBook.java
 * to utilize callNumber(s) instead of isbn. In this implementation of library we have added
 * additional testing to the original testing file which included: 
 * checking out and returning a book that is already checked out
 * returning a book that has not been checked out
 * checking out books prior to sorting
 * checking out a book that does not exist 
 */

package inheritanceLab;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class has some of the methods a library would use to perform basic tasks.
 * @author Steffie Ochoa
 * @author Carter Markegard
 *
 */
public class Library {
	ArrayList<LibraryBook> bookList;

	/**
	 * A constructor for the library. Initializes an ArrayList to store the books in.
	 */
	Library () {
		bookList = new ArrayList<LibraryBook> ();
	}

	/**
	 * adds the given book to the library
	 * @param book
	 */
	public void addBook (LibraryBook book) {
		bookList.add(book);
	}

	/**
	 * prints all books in the library
	 */
	public void printLibrary () {
		System.out.println ("\nListing of books in the library\n");
		for (LibraryBook book: bookList)
			System.out.println (book+"\n");
		System.out.println ("End of book listing\n");
	}

	/**
	 * locates a book in the library
	 * @param book book being search in the library
	 * @return book object if book is found
	 *         null otherwise
	 */
	public LibraryBook findBook (LibraryBook book) {
		int index = Collections.binarySearch(bookList,book);
		if (index >= 0)
			return bookList.get(index);
		else
			return null;
	}

	/**
	 * sort books in the library by call number
	 */
	public void sortLibrary () {
		Collections.sort(bookList);
	}

	/**
	 * performs processing for checking a book out of the library
	 * @param patron  person checking out book
	 * @param dueDate date book is due to be returned
	 * @param libro an object of type LibraryBook
	 */
	public void checkout (String patron, String dueDate, LibraryBook libro) {
		if (libro.circulationStatus().equals("Book available on shelves.")
				|| libro.circulationStatus().equals("Non-circulating reference book.")){
			LibraryBook book = findBook(libro);
			if (book == null)
				System.out.println ("Book " + libro.getTitle() + " not found -- checkout impossible\n");
			else
				libro.checkout (patron, dueDate);
		} else {
			System.out.println("Book already checked out.");
		}
	}

	/**
	 * processes checked-out book that is being returned
	 * @param libro an object of type LibraryBook to be returned
	 */
	public void returned (LibraryBook libro) {
		LibraryBook book = findBook(libro);
		if (book == null)
			System.out.println ("Book " + libro.getTitle() + " not found -- return impossible\n");
		else
			libro.returned ();
	}

	/**
	 * main testing program
	 * @param args  not used
	 */
	public static void main (String args[]) {

		Library lib = new Library ();

		// set up library


		ReferenceBook basic =  new ReferenceBook ("Henry M. Walker", 
				"Problems for Computer Solution using BASIC",
				"0-87626-717-7", "QA76.73.B3W335", "Iowa Room");
		ReferenceBook experiments =  new ReferenceBook ("Samuel A. Rebelsky",
				"Experiments in Java", 
				"0201612674", "64.2 R25ex", "Iowa Room");
		CirculatingBook algorithms =  new CirculatingBook ("John David Stone",
				"Algorithms for functional programming",
				"in process", "forthcoming");
		CirculatingBook  principles =  new CirculatingBook ("Henry M. Walker",
				"Computer Science 2:  Principles of Software Engineering, Data Types, and Algorithms",
				"0-673-39829-3", "QA76.758.W35");

		CirculatingBook  fortran =  new CirculatingBook ("Henry M. Walker", 
				"Problems for Computer Solution using FORTRAN",
				"0-87626-654-5", "QA43.W34");
		CirculatingBook  pascal =  new CirculatingBook ("Henry M. Walker",
				"Introduction to Computing and Computer Science with Pascal",
				"0-316-91841-5", "QA76.6.W3275");
		CirculatingBook  edMedia =  new CirculatingBook ("Samuel A. Rebelsky and Philip Barker", 
				"ED-MEDIA 2002 : World Conference on Educational Multimedia, Hypermedia & Telecommunications",
				"14. 1-880094-45-2", "64.2 25e");
		CirculatingBook  structured =  new CirculatingBook ("Henry M. Walker",
				"Pascal:  Problem Solving and Structured Program Design",
				"0-316-91848-2", "QA76.73.P2W35");
		CirculatingBook  limit =  new CirculatingBook ("Henry M. Walker",
				"The Limits of Computing",
				"0-7637-2552-8", "QA76.W185");
		CirculatingBook  tao =  new CirculatingBook ("Henry M. Walker",
				"The Tao of Computing",
				"0-86720-206-8", "QA76.W1855");

		//Fake Book
		CirculatingBook  tap =  new CirculatingBook ("Henry M. Gwalker",
				"The Tap of Computing",
				"0-86720-206420", "5");



		lib.addBook(basic);
		lib.addBook(experiments);
		lib.addBook(algorithms);
		lib.addBook(principles);
		lib.addBook(fortran);
		lib.addBook(pascal);
		lib.addBook(edMedia);
		lib.addBook(structured);
		lib.addBook(limit);
		lib.addBook(tao);

		/*Both Checkout and returned use binary search to verify if
		 * a book is in the library. Seeing as how the library has not
		 * been sorted, we would expect the following two calls to fail.
		 * However, both methods still work regardless and Fortran is 
		 * checked out and returned like normal. No errors here.
		 */
		System.out.println("a."); //These lettered and numbered print statements
		//add clarity to the output and allow humans to identify where an error 
		//Occurred.
		lib.checkout("Donald Duck", "March 1, 2012", fortran);
		System.out.println("b.");
		lib.returned(fortran);

		// sort books by call number
		lib.sortLibrary();

		// print library
		lib.printLibrary();

		// some users check out and return books
		lib.checkout("Donald Duck", "March 1, 2012", fortran);
		lib.checkout("Donald Duck", "March 12, 2012", pascal);
		lib.checkout("Donald Duck", "March 6, 2012", experiments);//Should fail
		lib.checkout("Minnie Mouse", "April 1, 2012", edMedia);
		System.out.println("c.");
		lib.checkout("Mickie Mouse", "April 21, 2012", edMedia); //Checks to see
		//what happens if we check out a checked-out book. After we found this
		//didn't work we modified the method checkedOut to print an "error".
		lib.checkout("Goofy", "February 28, 2012", tap); // should fail

		System.out.println("1.");
		lib.returned(pascal);//Test for turning in a checked out book; works.
		System.out.println("2.");
		lib.returned(experiments);//Test for returning z reference book; works.
		System.out.println("3.");
		lib.returned(limit);//Checking to see what happens when we return book
		//that has not been checked out. Does nothing as expected.
		System.out.println("4.");
		lib.returned(tap);//Should fail, tap has not been added to the library.

		lib.checkout("Goofy", "March 28, 2012", pascal);//Checking to see if we can
		//checkout a book that has been successfully checked-out and returned; works.

		// print final status of library
		lib.printLibrary();	
	}
}

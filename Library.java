package inheritanceLab;

import java.util.ArrayList;
import java.util.Collections;

public class Library {
	ArrayList<LibraryBook> bookList;

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
		CirculatingBook  tap =  new CirculatingBook ("Henry M. Walker",
				"The Tao of Computing",
				"0-86720-206", "5");

		//Should fail because the library has not been sorted.
		lib.checkout("Donald Duck", "March 1, 2012", fortran);

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

		// sort books by call number
		lib.sortLibrary();

		// print library
		lib.printLibrary();

		// some users check out and return books
		lib.checkout("Donald Duck", "March 1, 2012", fortran);
		lib.checkout("Donald Duck", "March 12, 2012", pascal);
		lib.checkout("Donald Duck", "March 6, 2012", experiments);
		lib.checkout("Minnie Mouse", "April 1, 2012", edMedia);
		System.out.println("a.");
		lib.checkout("Mickie Mouse", "April 21, 2012", edMedia); //Checks to see
		//what happens if we check out a checked-out book. After we found this
		//didn't work we modified the method checkedOut to print an "error".
		lib.checkout("Goofy", "February 28, 2012", tap); // should fail

		System.out.println("1.");
		lib.returned(pascal);
		System.out.println("2.");
		lib.returned(experiments);
		System.out.println("3.");
		lib.returned(limit);//Checking to see what happens when we return book
		//that has not been checked out. Does nothing as expected.
		System.out.println("4.");
		lib.returned(tap);//Should fail, tap has not been added to the library.

		lib.checkout("Goofy", "March 28, 2012", pascal);

		// print final status of library
		lib.printLibrary();		
	}
}

package two.prob1;

import java.util.ArrayList;
import java.util.List;

public class TestData {

	// get test data using these methods
	public static List<LibraryMember> getLibraryMembers() {
		loadLibraryMemberData();
		return members;
	}

	public static List<Book> getAllBooks() {
		return allBooks;
	}

	@SuppressWarnings("serial")
	static List<Address> addresses = new ArrayList<Address>() {
		{
			add(new Address("51 S. George", "Georgetown", "MI", "65434"));
			add(new Address("23 Headley Ave", "Seville", "Georgia", "41234"));
			add(new Address("1 N. Baton", "Fairfield", "IA", "33556"));
			add(new Address("5001 Venice Dr.", "Los Angeles", "CA", "93736"));
			add(new Address("42 Dogwood Dr.", "Fairfield", "IA", "52556"));
			add(new Address("501 Central", "Mountain View", "CA", "94707"));
		}
	};

	@SuppressWarnings("serial")
	// String isbn, title, int numCopies, int maxCheckoutLength
	static List<Book> allBooks = new ArrayList<Book>() {
		{
			add(new Book("28-12331", "Antartica", 1, 7));
			add(new Book("99-22223", "Thinking Java", 1, 21));
			add(new Book("48-56882", "Jimmy's First Day of School", 1, 7));
			add(new Book("28-12331", "PHP in 24 Hours", 2, 7));
			add(new Book("99-22223", "All About Scala", 1, 21));
			add(new Book("48-56882", "MUM's Ideal Education", 1, 7));

		}
	};

	static List<LibraryMember> members = new ArrayList<LibraryMember>();

	public static void loadLibraryMemberData() {
		LibraryMember libraryMember = new LibraryMember("Andy", "Rogers", 18, addresses.get(0));
		libraryMember.addBookCopyToMember(allBooks.get(0).getNextAvailableCopy());

		members.add(libraryMember);

		libraryMember = new LibraryMember("Drew", "Stevens", 17, addresses.get(1));
		libraryMember.addBookCopyToMember(allBooks.get(1).getNextAvailableCopy());
		members.add(libraryMember);

		libraryMember = new LibraryMember("Sarah", "Eagleton", 15, addresses.get(2));
		libraryMember.addBookCopyToMember(allBooks.get(2).getNextAvailableCopy());
		libraryMember.addBookCopyToMember(allBooks.get(3).getNextAvailableCopy());
		members.add(libraryMember);

		libraryMember = new LibraryMember("Ricardo", "Montalbahn", 21, addresses.get(3));
		libraryMember.addBookCopyToMember(allBooks.get(3).getNextAvailableCopy());
		members.add(libraryMember);

		libraryMember = new LibraryMember("Mike", "Green", 21, addresses.get(4));
		libraryMember.addBookCopyToMember(allBooks.get(4).getNextAvailableCopy());
		members.add(libraryMember);

		libraryMember = new LibraryMember("Alice", "Wells", 21, addresses.get(5));
		libraryMember.addBookCopyToMember(allBooks.get(5).getNextAvailableCopy());

		members.add(libraryMember);

	}

}

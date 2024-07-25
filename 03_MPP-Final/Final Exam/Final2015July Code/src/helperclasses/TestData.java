package helperclasses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public enum TestData {
	INSTANCE;
	
	//get test data using these methods
	
	public List<LibraryMember> getMembers() {
		return members;
	}
	public List<Book> getAllBooks() {
		return allBooks;
	}
	
	public List<CheckoutRecord> getAllRecords() {
		return allRecords;
	}
	
	public List<CheckoutRecordEntry> getAllEntries() {
		return allEntries;
	}
	
	//end public interface
	

	List<LibraryMember> members = new ArrayList<LibraryMember>();
	CheckoutRecord firstRecord;
	CheckoutRecord secondRecord;
	CheckoutRecord thirdRecord;
	List<CheckoutRecord> allRecords = new ArrayList<CheckoutRecord>();
	
	@SuppressWarnings("serial")
	List<Address> addresses = new ArrayList<Address>() {
		{
			add(new Address("101 S. Main", "Fairfield", "IA", "52556"));
			add(new Address("51 S. George", "Georgetown", "MI", "65434"));
			add(new Address("23 Headley Ave", "Seville", "Georgia", "41234"));
			add(new Address("1 N. Baton", "Fairfield", "IA", "33556"));
			add(new Address("5001 Venice Dr.", "Los Angeles", "CA", "93736"));
			add(new Address("1435 Channing Ave", "Palo Alto", "CA", "94301"));
			add(new Address("42 Dogwood Dr.", "Fairfield", "IA", "52556"));
			add(new Address("501 Central", "Mountain View", "CA", "94707"));
		}
	};
	Book overdueBook = new Book("23-11451", "The Big Fish", 2, 21);
	
	@SuppressWarnings("serial")
	//String isbn, title, int numCopies, int maxCheckout
	List<Book> allBooks = new ArrayList<Book>() {
		{
			add(overdueBook);
			add(new Book("28-12331", "Antartica", 1, 7));
			add(new Book("99-22223", "Thinking Java", 1, 21));
			add(new Book("48-56882", "Jimmy's First Day of School", 1, 7));
			add(new Book("28-12331", "PHP in 24 Hours", 2, 7));
			add(new Book("99-22223", "All About Scala", 1, 21));
			add(new Book("48-56882", "MUM's Ideal Education", 1, 7));
			
		}
	};
	//CheckoutRecordEntry(LendableCopy copy, LocalDate checkoutDate, LocalDate dueDate)
	@SuppressWarnings("serial")
	List<CheckoutRecordEntry> allEntries = new ArrayList<CheckoutRecordEntry>() {
		{
			add(new CheckoutRecordEntry(
				allBooks.get(0).getCopies().get(0), LocalDate.of(2011,12,1), LocalDate.of(2011,12,22)));
			add(new CheckoutRecordEntry(
				allBooks.get(0).getCopies().get(1), LocalDate.of(2014,6,22), LocalDate.of(2014,7,13)));
			add(new CheckoutRecordEntry(
				allBooks.get(1).getNextAvailableCopy(), LocalDate.of(2015,6,27), LocalDate.of(2015,7,18)));
			add(new CheckoutRecordEntry(
				allBooks.get(2).getNextAvailableCopy(), LocalDate.of(2015,6,27), LocalDate.of(2015,7,18)));	
		}
	};
	
	public static void main(String[] args) {
	
	}
	
    //create library members
	//String id, String fName, String lName, CheckoutRecord rec, Address add
	//String memberId, String fname, String lname, String tel,Address add
	public void libraryMemberData() {
		firstRecord  = new CheckoutRecord();
		firstRecord.addEntry(allEntries.get(0));
		firstRecord.addEntry(allEntries.get(1));
		LibraryMember libraryMember = new LibraryMember("1001", "Andy", "Rogers", firstRecord, "123-45-6789", addresses.get(4));
		members.add(libraryMember);
		
		secondRecord = new CheckoutRecord();
		secondRecord.addEntry(allEntries.get(2));
		//String memberId, String fname, String lname, String tel,Address add
		libraryMember = new LibraryMember("1002", "Drew", "Stevens", secondRecord, "941-23-3312", addresses.get(5));
		members.add(libraryMember);
		
		thirdRecord = new CheckoutRecord();
		thirdRecord.addEntry(allEntries.get(3));
		libraryMember = new LibraryMember("1003", "Sarah", "Eagleton", thirdRecord, "331-21-2213", addresses.get(6));
		members.add(libraryMember);
		
		libraryMember = new LibraryMember("1004", "Germane", "Vlastovok", new CheckoutRecord(), "641-469-2233", addresses.get(3));
		members.add(libraryMember);
		
		allRecords = Arrays.asList(firstRecord, secondRecord, thirdRecord);
	}
	{
		libraryMemberData();
		overdueBook.getCopies().get(1).setAvailable(false);
	}
}

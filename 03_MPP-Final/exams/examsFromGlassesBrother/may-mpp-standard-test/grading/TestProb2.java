package grading;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;
import prob2.Admin;
import prob2.Book;
import prob2.CD;
import prob2.CheckoutRecord;
import prob2.CheckoutRecordEntry;
import prob2.ItemType;
import prob2.LendingItem;
import prob2.LibraryMember;


public class TestProb2 extends TestCase {
	public void testLibraryMemberInstVbles() {
		//memberId, firstName, lastName, phone
		Class<LibraryMember> cl = LibraryMember.class;
		assertTrue("Expected variable 'memberId' in LibraryMember", Auxil.containsInstVariable(cl, "memberId"));
		assertTrue("Expected variable 'firstName' in LibraryMember", Auxil.containsInstVariable(cl, "firstName"));
		assertTrue("Expected variable 'lastName' in LibraryMember", Auxil.containsInstVariable(cl, "lastName"));
		assertTrue("Expected variable 'phone' in LibraryMember", Auxil.containsInstVariable(cl, "phone"));
		assertTrue("Expected variable of type CheckoutRecord in LibraryMember", Auxil.containsInstVariableType(cl, 
			CheckoutRecord.class));
	}
	
	public void testCheckoutRecordEntryInstVbles() {
		//checkoutDate, dueDate
		Class<CheckoutRecordEntry> cl = CheckoutRecordEntry.class;
		assertTrue("Expected variable 'checkoutDate' in CheckoutRecordEntry", Auxil.containsInstVariable(cl, "checkoutDate"));
		assertTrue("Expected variable 'dueDate' in CheckoutRecordEntry", Auxil.containsInstVariable(cl, "dueDate"));
		assertTrue("Expected variable of type ItemType in LibraryMember", Auxil.containsInstVariableType(cl, 
				ItemType.class));
		assertTrue("Expected variable of type LendingItem in LibraryMember", Auxil.containsInstVariableType(cl, 
				LendingItem.class));
	}
	
	public void testLendingItemInstVbles() {
		//numCopiesInLib
		Class<LendingItem> cl = LendingItem.class;
		assertTrue("Expected variable 'numCopiesInLib' in LendingItem", Auxil.containsInstVariable(cl, "numCopiesInLib"));
	}
	
	public void testBookInstVbles() {
		//isbn, title, authorFirstName, authorLastName
		Class<Book> cl = Book.class;
		assertTrue("Expected variable 'isbn' in Book", Auxil.containsInstVariable(cl, "isbn"));
		assertTrue("Expected variable 'title' in Book", Auxil.containsInstVariable(cl, "title"));
		assertTrue("Expected variable 'authorFirstName' in Book", Auxil.containsInstVariable(cl, "authorFirstName"));
		assertTrue("Expected variable 'authorLastName' in Book", Auxil.containsInstVariable(cl, "authorLastName"));
	}
	
	public void testCDInstVbles() {
		//productId, title, company
		Class<CD> cl = CD.class;
		assertTrue("Expected variable 'productId' in CD", Auxil.containsInstVariable(cl, "productId"));
		assertTrue("Expected variable 'title' in CD", Auxil.containsInstVariable(cl, "title"));
		assertTrue("Expected variable 'company' in CD", Auxil.containsInstVariable(cl, "company"));
	}
	
	public void testLibraryMemberConstructor() {
		//LibraryMember(String id, String fname, String lname, String phone) - 4 parameters
		Class<LibraryMember> cl = LibraryMember.class;
		boolean hasCorrectConstructor = Auxil.containsConstructor(cl, "LibraryMember");
		assertTrue("Expected constructor LibraryMember for LibraryMember class", hasCorrectConstructor);
		if(hasCorrectConstructor) {
			assertTrue("Expected constructor LibraryMember to have 4 parameters", 
					Auxil.constructorHasCorrectNumParams(cl, "LibraryMember", 4));
		} else{
			System.out.println("Not checking if LibraryMember constructor has correct num parameters since this constructor not found");
		}
	}
	
	public void testCDConstructor() {
		//CD product, title, company
		Class<CD> cl = CD.class;
		boolean hasCorrectConstructor = Auxil.containsConstructor(cl, "CD");
		assertTrue("Expected constructor CD for CD class", hasCorrectConstructor);
		if(hasCorrectConstructor) {
			assertTrue("Expected constructor CD to have 3 parameters", 
					Auxil.constructorHasCorrectNumParams(cl, "CD", 3));
		} else{
			System.out.println("Not checking if CD constructor has correct num parameters since this constructor not found");
		}
	}
	
	public void testBookConstructor() {
		//Book isbn, title, firstName, lastName product, title, company
		Class<Book> cl = Book.class;
		boolean hasCorrectConstructor = Auxil.containsConstructor(cl, "Book");
		assertTrue("Expected constructor Book for Book class", hasCorrectConstructor);
		if(hasCorrectConstructor) {
			assertTrue("Expected constructor Book to have 4 parameters", 
					Auxil.constructorHasCorrectNumParams(cl, "Book", 4));
		} else{
			System.out.println("Not checking if Book constructor has correct num parameters since this constructor not found");
		}
	}
	
	public void testCheckoutRecordEntryConstructor() {
		//CheckoutRecordEntry item, chDate dueDate itemtype
		Class<CheckoutRecordEntry> cl = CheckoutRecordEntry.class;
		boolean hasCorrectConstructor = Auxil.containsConstructor(cl, "CheckoutRecordEntry");
		assertTrue("Expected constructor CheckoutRecordEntry for CheckoutRecordEntry class", hasCorrectConstructor);
		if(hasCorrectConstructor) {
			assertTrue("Expected constructor CheckoutRecordEntry to have 4 parameters", 
					Auxil.constructorHasCorrectNumParams(cl, "CheckoutRecordEntry", 4));
		} else{
			System.out.println("Not checking if CheckoutRecordEntry constructor has correct num parameters since this constructor not found");
		}
	}
	
	public void testLibraryMemberMethods() {
		//setCheckoutRecord, getCheckoutRecord
		Class<LibraryMember> cl = LibraryMember.class;
		assertTrue("Expected method 'setCheckoutRecord' in LibraryMember", Auxil.containsMethod(cl, "setCheckoutRecord"));
		assertTrue("Expected method 'getCheckoutRecord' in LibraryMember", Auxil.containsMethod(cl, "getCheckoutRecord"));
	}
	public void testCheckoutRecordMethods() {
		//getCheckoutEntryList, addCheckoutEntry
		Class<CheckoutRecord> cl = CheckoutRecord.class;
		assertTrue("Expected method 'getCheckoutEntryList' in CheckoutRecord", Auxil.containsMethod(cl, "getCheckoutEntryList"));
		assertTrue("Expected method 'addCheckoutEntry' in CheckoutRecord", Auxil.containsMethod(cl, "addCheckoutEntry"));
	}
	public void testLendingItemMethods() {
		//setNumCopiesInLib, getNumCopiesInLib
		Class<LendingItem> cl = LendingItem.class;
		assertTrue("Expected method 'setNumCopiesInLib' in LendingItem", Auxil.containsMethod(cl, "setNumCopiesInLib"));
		assertTrue("Expected method 'getNumCopiesInLib' in LendingItem", Auxil.containsMethod(cl, "getNumCopiesInLib"));
	}
	
	public void testInheritance() {
		assertTrue("Book should inherit from LendingItem", Auxil.inheritsFrom(Book.class, LendingItem.class));
		assertTrue("CD should inherit from LendingItem", Auxil.inheritsFrom(CD.class, LendingItem.class));
	}
	
	//333-7806, 347-1111, 717-1235, 802-5716, 923-8756, 989-1256
	public void testOutput_CorrectElements() {
		List<String> expectedPhoneNums = Arrays.asList(new String[] {"333-7806", 
				"347-1111", "717-1235", "802-5716", "923-8756", "989-1256"});
		SetupForAdminTest setup = new SetupForAdminTest();
		LibraryMember[] members = setup.getPopulatedLibMembers();
		CD cd = setup.getCDs()[1];
		List<String> result = Admin.getPhoneNums(members, cd);
		assertTrue("Output list from Admin.getPhoneNums does not contain correct elements", 
				Auxil.sameElements(expectedPhoneNums, result));
	}
	
	//333-7806, 347-1111, 717-1235, 802-5716, 923-8756, 989-1256
	public void testOutput_CorrectlySorted() {
		List<String> expectedPhoneNums = Arrays.asList(new String[] {"333-7806", 
				"347-1111", "717-1235", "802-5716", "923-8756", "989-1256"});
		SetupForAdminTest setup = new SetupForAdminTest();
		LibraryMember[] members = setup.getPopulatedLibMembers();
		CD cd = setup.getCDs()[1];
		List<String> result = Admin.getPhoneNums(members, cd);
		if(Auxil.sameElements(expectedPhoneNums, result)) {
			assertEquals("Output list from Admin.getPhoneNums contains correct elements, but in the wrong order",
					expectedPhoneNums, result);
		} else {
			System.out.println("Test for correct sorted order from Admin.getPhoneNums not done since elements in return list are not correct.");
		}
	}
	
	static class SetupForAdminTest {
		
		CD[] cds = {
				new CD("101", "Happy", "Warner Bros"),
				new CD("102", "Sad", "Warner Bros"),
				new CD("103", "Jumpin", "Mills Bros"),
				new CD("104", "Frowning", "Mills Bros"),
				new CD("105", "Joy", "Warner Bros")
		};
					
		Book[] books = {
				new Book("1040A5", "Gone with the Wind", "Bob", "Gearhart"),
				new Book("5241C3", "The Unhappy Indian", "Richard", "Steigert"),
				new Book("9982D1", "The Unseen Rock", "Stephen", "King"),
				new Book("1112E5", "Hunting", "Danielle", "Steele"),
				new Book("8008T4", "Overdrive", "Cougar", "Fox")
				
		};
		
		
		
		CheckoutRecordEntry[] entries = {
				new CheckoutRecordEntry(books[0], LocalDate.of(2017, 1, 1),LocalDate.of(2017, 3, 1), ItemType.BOOK),
				new CheckoutRecordEntry(books[1], LocalDate.of(2016, 1, 15),LocalDate.of(2016, 3, 15), ItemType.BOOK),
				new CheckoutRecordEntry(books[2], LocalDate.of(2017, 2, 1),LocalDate.of(2017, 4, 1), ItemType.BOOK),
				new CheckoutRecordEntry(books[3], LocalDate.of(2017, 4, 1),LocalDate.of(2017, 6, 1), ItemType.BOOK),
				new CheckoutRecordEntry(books[4], LocalDate.of(2017, 1, 21),LocalDate.of(2017, 3, 21), ItemType.BOOK),
				new CheckoutRecordEntry(books[0], LocalDate.of(2016, 3, 1),LocalDate.of(2016, 5, 1), ItemType.BOOK),
				new CheckoutRecordEntry(books[1], LocalDate.of(2016, 5, 1),LocalDate.of(2016, 7, 1), ItemType.BOOK),
				new CheckoutRecordEntry(books[2], LocalDate.of(2015, 10, 1),LocalDate.of(2015, 12, 1), ItemType.BOOK),
				new CheckoutRecordEntry(books[0], LocalDate.of(2015, 5, 1),LocalDate.of(2015, 7, 1), ItemType.BOOK),
				new CheckoutRecordEntry(books[1], LocalDate.of(2014, 8, 1),LocalDate.of(2014, 9, 1), ItemType.BOOK),
				new CheckoutRecordEntry(cds[0], LocalDate.of(2015, 1, 1),LocalDate.of(2015, 3, 1), ItemType.CD), //10
				new CheckoutRecordEntry(cds[3], LocalDate.of(2015, 6, 1),LocalDate.of(2015, 8, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[4], LocalDate.of(2015,5, 10),LocalDate.of(2015, 7, 10), ItemType.CD),
				new CheckoutRecordEntry(cds[2], LocalDate.of(2015, 1, 1),LocalDate.of(2015, 3, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[1], LocalDate.of(2015, 9, 1),LocalDate.of(2015, 11, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[2], LocalDate.of(2016, 1, 1),LocalDate.of(2016, 3, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[1], LocalDate.of(2016, 2, 15),LocalDate.of(2016, 4, 15), ItemType.CD),
				new CheckoutRecordEntry(cds[2], LocalDate.of(2016, 9, 10),LocalDate.of(2015, 11, 10), ItemType.CD),
				new CheckoutRecordEntry(cds[1], LocalDate.of(2016, 10, 1),LocalDate.of(2016, 12, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[2], LocalDate.of(2017, 1, 1),LocalDate.of(2017, 3, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[1], LocalDate.of(2017, 1, 1),LocalDate.of(2017, 3, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[2], LocalDate.of(2017, 3, 15),LocalDate.of(2017, 5, 11), ItemType.CD),
				new CheckoutRecordEntry(cds[1], LocalDate.of(2015, 1, 1),LocalDate.of(2015, 3, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[3], LocalDate.of(2017, 1, 8),LocalDate.of(2017, 3, 9), ItemType.CD),
				new CheckoutRecordEntry(cds[1], LocalDate.of(2015, 1, 1),LocalDate.of(2015, 3, 1), ItemType.CD),
				new CheckoutRecordEntry(cds[4], LocalDate.of(2017, 1, 12),LocalDate.of(2017, 3, 12), ItemType.CD)//25
		};
		CheckoutRecord[] records = {new CheckoutRecord(), new CheckoutRecord(), new CheckoutRecord(),
				new CheckoutRecord(), new CheckoutRecord(), new CheckoutRecord(),
				new CheckoutRecord(), new CheckoutRecord(), new CheckoutRecord()
		};
		{
			setNumCopies(cds, books);
			records[0].addCheckoutEntry(entries[0]);
			records[0].addCheckoutEntry(entries[1]);
			records[0].addCheckoutEntry(entries[10]);
			records[0].addCheckoutEntry(entries[11]);
			
			records[1].addCheckoutEntry(entries[2]);
			records[1].addCheckoutEntry(entries[3]);
			records[1].addCheckoutEntry(entries[12]);
			records[1].addCheckoutEntry(entries[13]);
			
			records[2].addCheckoutEntry(entries[4]);
			records[2].addCheckoutEntry(entries[14]);
			records[2].addCheckoutEntry(entries[15]);
			
			records[3].addCheckoutEntry(entries[16]);
			records[3].addCheckoutEntry(entries[17]);
			
			records[4].addCheckoutEntry(entries[5]);
			records[4].addCheckoutEntry(entries[6]);
			records[4].addCheckoutEntry(entries[18]);
			
			records[5].addCheckoutEntry(entries[19]);
			records[5].addCheckoutEntry(entries[20]);
			
			records[6].addCheckoutEntry(entries[7]);
			records[6].addCheckoutEntry(entries[8]);
			records[6].addCheckoutEntry(entries[21]);
			records[6].addCheckoutEntry(entries[22]);
			
			records[7].addCheckoutEntry(entries[9]);
			records[7].addCheckoutEntry(entries[23]);
			records[7].addCheckoutEntry(entries[24]);
			
			records[8].addCheckoutEntry(entries[10]);
			records[8].addCheckoutEntry(entries[25]);
		}
		
		//String id, String fname, String lname, String phone
		LibraryMember[] members = {
				new LibraryMember("1001", "Hank", "Reynolds", "323-4556"),
				new LibraryMember("1002", "Bob", "Montelbahn", "377-4112"),
				new LibraryMember("1003", "Methusalah", "King", "923-8756"),
				new LibraryMember("1004", "Moses", "Ofisrael", "802-5716"),
				new LibraryMember("1005", "Abraham", "McDonald", "333-7806"),
				new LibraryMember("1006", "Ricardo", "Thomas", "717-1235"),
				new LibraryMember("1007", "Enrico", "Alvarez", "989-1256"),
				new LibraryMember("1008", "Francois", "Cinquante", "347-1111"),
				new LibraryMember("1009", "Joy", "Johnson", "523-4886")
		};
		{
			setCheckoutRecords(members, records);
		}
		
		public LibraryMember[] getPopulatedLibMembers() {
			return members;
		}
		public CD[] getCDs() {
			return cds;
		}
		public Book[] getBooks() {
			return books;
		}
		
		private static void setNumCopies(CD[] cds, Book[] books) {
			int count = 0;
			for(CD c: cds) {
				c.setNumCopiesInLib(1 + (count++) % 3);
			}
			for(Book b: books) {
				b.setNumCopiesInLib(1 + (count++) % 3);
			}
		}
		private static void setCheckoutRecords(LibraryMember[] members, CheckoutRecord[] records) {
			if(members.length != records.length) 
				throw new IllegalArgumentException("members array has different size from records array");
			for(int i = 0; i < members.length; ++i) {
				members[i].setCheckoutRecord(records[i]);
			}		
		}
	}
	
	
	
	
	
}
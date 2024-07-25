package One.prob1_exam;

import java.util.ArrayList;
import java.util.List;

public class TestCode {
	///////// Testing -- do not modify this code!! ////////////
	public static void main(String[] args) {
		testSomeBookOverdue();
		testEverCheckedOutBy();
		testNonactiveMembers();
	}

	public static void testSomeBookOverdue() {
		List<CheckoutRecord> list = TestData.INSTANCE.getAllRecords();
		List<Boolean> results = new ArrayList<Boolean>();
		for (CheckoutRecord rec : list) {
			// System.out.println(rec);
			results.add(Main.someBookOverdue(rec));
		}
		System.out.println(
				"Test some book overdue results: " + (results.isEmpty() ? "Not attempted" : results.toString()));
	}

	public static void testEverCheckedOutBy() {
		List<LibraryMember> members = TestData.INSTANCE.getMembers();
		List<Book> books = TestData.INSTANCE.getAllBooks();
		List<Boolean> results = new ArrayList<Boolean>();
		for (LibraryMember mem : members) {
			for (Book b : books) {
				for (BookCopy copy : b.getCopies()) {
					results.add(Main.everCheckedOutBy(mem, copy));
				}
			}
		}
		System.out.println("Check each member and each book copy to see if checked out:\n " + results);
	}

	public static void testNonactiveMembers() {
		List<LibraryMember> members = TestData.INSTANCE.getMembers();
		System.out.println("Test nonactive members: " + Main.nonActiveMembers(members));
	}
}

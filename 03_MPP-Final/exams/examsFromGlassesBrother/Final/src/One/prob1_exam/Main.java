package One.prob1_exam;

import java.util.List;

public class Main {

	// Query A (for Problem 1A) given a member's checkout record, determine whether
	// some
	// bookcopy in the record is overdue (a bookcopy is overdue if it is not
	// available
	// and its due date is before now.
	public static boolean someBookOverdue(CheckoutRecord record) {
		return LambdaLibrary.QUERRY1.apply(record);

	}

	// Query B (for Problem 1B) Given a BookCopy copy and a LibraryMember mem,
	// return true if mem has ever checked out this copy
	//
	public static boolean everCheckedOutBy(LibraryMember mem, BookCopy copy) {
		// return
		// mem.getRecord().getCheckoutEntries().stream().filter(x->x.getCopy().equals(copy)).findAny().isPresent();
		// //implement
		return LambdaLibrary.QUERRY2.apply(mem, copy);
	}

	// Query C (for Problem 1C) given a list of all library members, return a list,
	// in
	// reverse sorted order (by first name), of the
	// full names of those library members who have never checked out a book
	public static List<String> nonActiveMembers(List<LibraryMember> list) {
		// return
		// list.stream().filter(x->x.getRecord().getCheckoutEntries().size()==0).sorted((x,y)->x.getFirstName().
		// compareTo(y.getLastName())).map(x->x.getFirstName()).collect(Collectors.toList());
		return LambdaLibrary.QUERRY3.apply(list);
	}

}

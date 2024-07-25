package One.prob1_exam;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaLibrary {
	// Query A (for Problem 1A) given a member's checkout record, determine
	// whether some
	// bookcopy in the record is overdue (a bookcopy is overdue if it is not
	// available
	// and its due date is before now.
	public final static Function<CheckoutRecord, Boolean> QUERRY1 = (list) -> list.getCheckoutEntries().stream()
			.filter(x -> x.getDueDate().compareTo(x.getCheckoutDate()) > 0)
			.filter(y -> !y.getCopy().isAvailable())
			.findAny().isPresent();

	// Query B (for Problem 1B) Given a BookCopy copy and a LibraryMember mem,
	// return true if mem has ever checked out this copy
	//
	public final static BiFunction<LibraryMember, BookCopy, Boolean> QUERRY2 = (mem, copy) -> mem.getRecord()
			.getCheckoutEntries().stream().filter(x -> x.getCopy().equals(copy)).findAny().isPresent();

	// Query C (for Problem 1C) given a list of all library members, return a
	// list, in
	// reverse sorted order (by first name), of the
	// full names (first name + <space> + last name) of those library members
	// who have never checked out a book
	public final static Function<List<LibraryMember>, List<String>> QUERRY3 = (list) -> list.stream()
			.filter(x -> x.getRecord().getCheckoutEntries().size() == 0)
			.sorted((x, y) -> x.getFirstName().compareTo(y.getFirstName()))
			.map(x -> x.getFirstName() + " " + x.getFirstName())
			.collect(Collectors.toList());
}

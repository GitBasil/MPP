package two.prob1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		List<LibraryMember> sampleData = TestData.getLibraryMembers();
		System.out.println("Testing --- Sample Data --- ");
		sampleData.forEach(System.out::println);

		System.out.println("\n Part A");
		// Create a stream pipeline that prints to the console
		// the full names(first name and last name separated by a space)
		// of Library Members who live in the state of CA
		// and whose first name starts after the letter 'M',
		// sorted by age in ascending order.

		System.out.println(sampleData.stream().filter(x -> x.getAddress().getState().equals("CA"))
				.filter(x -> x.getFirstName().toCharArray()[0] > 'M')
				.sorted(Comparator.comparing(LibraryMember::getAge)).map(x -> x.getFullname())
				.collect(Collectors.toList()));

		System.out.println("\n Part B");
		// Turn the stream pipeline from Part A into a LambdaLibrary item
		// and evaluate it here.
		System.out.println(LambdaLibrary.IMPLEMENT);
		System.out.println(sampleData.stream().filter(LambdaLibrary.FILTER_BY_STATE)
				.filter(LambdaLibrary.FILTER_BY_FIRSTNAME).sorted(LambdaLibrary.COMPARE_BY_AGE)
				.map(LambdaLibrary.TO_FULLNAME).collect(Collectors.toList()));

		System.out.println("\n Part C");
		// Replace all lambda expressions in the stream pipeline from Part A
		// with instances of inner classes/functors.

		System.out.println("\n Part D");
		// Extra Credit: Create a stream pipeline that uses the reduce method
		// to get the Library member who has checked out the greatest number of book
		// copies.
		// You may assume there is exactly one such member.

		// System.out.println(sampleData.stream().map(x ->
		// x.getCheckedOutCopies().size()).collect(Collectors.toList()));
		Optional<LibraryMember> lb = sampleData.stream().reduce((x, y) -> {
			if (x.getCheckedOutCopies().size() > y.getCheckedOutCopies().size())
				y = x;
			return y;
		});

		if (lb.isPresent())
			System.out.printf("Name: %s borrows %d copies", lb.get().getFullname(),
					lb.get().getCheckedOutCopies().size());
	}
	
	
}

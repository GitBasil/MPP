package questions.Final2015July.src.prob2;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import questions.Final2015July.src.helperclasses.CheckoutRecordEntry;
import questions.Final2015July.src.helperclasses.TestData;

/*
 * Print to the console the list of book Title � in sorted order -- 
 * in which the book has been checked out on June 27, 2015. 
 * The ordering of the book title is as follows: First sort by the length 
 * of the title (number of characters), then by alphabetical order.  
 */
public class Problem2 {

	public static void main(String[] args) {
		// use this list
		Function<String, Integer> len = (s) -> s.length();
		List<CheckoutRecordEntry> list = TestData.INSTANCE.getAllEntries();
		List<String> str = list.stream().filter(x -> x.getCheckoutDate().equals(LocalDate.of(2015, 6, 27)))
				.map(e -> e.getCopy().getBook().getTitle())
				.sorted(Comparator.comparing((String s) -> s.length()).thenComparing((String s) -> s))
				.collect(Collectors.toList());
		// List<String> result = list.stream()
		// .filter(e -> e.getCheckoutDate().equals(
		// LocalDate.of(2015, 6, 27)))
		// .map(e -> e.getCopy().getBook().getTitle())
		// .sorted(Comparator.comparing((String s) -> s.length())
		// .thenComparing((String s) -> s)).collect(Collectors.toList());
		System.out.println(str);
		List<String> lis=list.stream().filter(x->x.getCheckoutDate().equals(LocalDate.of(2015,6,27))).map(x->x.getCopy().getBook().getTitle()).
				sorted(Comparator.comparing((String x)->x.length()).thenComparing((String x)->x)).collect(Collectors.toList());
	}

}

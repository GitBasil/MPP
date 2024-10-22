package lesson9.labs.prob11b;

import java.util.*;
import java.util.function.BiFunction;


public class Main {

	public static final BiFunction<List<Employee>, Character, String> LetterInNames = (list, c) -> list.stream()
	.filter(f -> f.salary > 100000)
	.filter(f -> f.lastName.charAt(0) >= c)
	.map(m -> m.firstName + " " + m.lastName)
	.sorted()
	.reduce("", (x,y) -> x.isEmpty() ? y : x + ", " + y);

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee("Joe", "Davis", 120000),
				          new Employee("John", "Sims", 110000),
				          new Employee("Joe", "Stevens", 200000),
		                  new Employee("Andrew", "Reardon", 80000),
		                  new Employee("Joe", "Cummings", 760000),
		                  new Employee("Steven", "Walters", 135000),
		                  new Employee("Thomas", "Blake", 111000),
		                  new Employee("Alice", "Richards", 101000),
		                  new Employee("Donald", "Trump", 100000));

						  System.out.println(LetterInNames.apply(list,'N'));
	}

}

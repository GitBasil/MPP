package lesson9.labs.prob11a;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(new Employee("Joe", "Davis", 120000),
				          new Employee("John", "Sims", 110000),
				          new Employee("Joe", "Stevens", 200000),
		                  new Employee("Andrew", "Reardon", 80000),
		                  new Employee("Joe", "Cummings", 760000),
		                  new Employee("Steven", "Walters", 135000),
		                  new Employee("Thomas", "Blake", 111000),
		                  new Employee("Alice", "Richards", 101000),
		                  new Employee("Donald", "Trump", 100000));
		
		
		String str = emps.stream()
							.filter(f -> f.salary > 100000)
							.filter(f -> f.lastName.charAt(0) >= 'N')
							.map(m -> m.firstName + " " + m.lastName)
							.sorted()
							.reduce("", (x,y) -> x.isEmpty() ? y : x + ", " + y);
		System.out.println(str);
	}
	
	
	

}

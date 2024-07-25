package lesson11.exercise_5_soln;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
// Stream<T> filter(Predicate<? super T> predicate)
public class Filter {
	static Employee employeeOfTheYear = new Employee("Brian", 100000, 2004, 2, 17);
	public static void main(String[] args) { 
		List<Manager> managers = Arrays.asList(new Manager("Bob", 100000, 2001, 1, 10),
				new Manager("Rich", 110000, 2002, 3, 15),
				new Manager("Tom", 130000, 2011, 8, 20),
				new Manager("Dennis", 200000, 1991, 11, 8));
		
		//find the managers from the list who are similar to the employee of the year
		List<Manager> similarTo =   //the Predicate is of type Employee but stream is of type Manager
				managers.stream().filter(new MyPredicate())
				                 .collect(Collectors.toList());
		System.out.println(similarTo);
	}
		
	
	static class MyPredicate implements Predicate<Employee> {
        public boolean test(Employee e) {
        	return e.isSimilarTo(employeeOfTheYear);	
        }
    }
}



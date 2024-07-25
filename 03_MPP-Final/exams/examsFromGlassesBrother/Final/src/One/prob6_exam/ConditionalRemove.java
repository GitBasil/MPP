package One.prob6_exam;

import java.time.LocalDate;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.*;

import One.prob5.Employee;

public class ConditionalRemove {
	static class StrLengthCondition implements Predicate<String> {
		public boolean test(String s) {
			return s.length() == 5;
		}
	}

	static class salaryCondition implements Predicate<Employee> {

		@Override
		public boolean test(Employee e) {

			return e.getSalary() < 60000;
		}

	}

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>() {
			{
				add("Hello");
				add("Goodbye");
			}
		};

		ArrayList<Employee> list3 = new ArrayList<Employee>() {
			{
				add(new Employee("Bob", 55000, LocalDate.of(2014, 1, 1)));
				add(new Employee("Bob", 100000, LocalDate.of(2015, 1, 1)));
			}
		};
		System.out.println(conditionalRemove(list, new StrLengthCondition()));
		System.out.println(conditionalRemove(list3, new salaryCondition()));
		list3.stream().filter(d->Hello.apply(d, LocalDate.of(2, 2, 2)));
	}

	public static BiFunction<Employee, LocalDate, Boolean> Hello = new BiFunction<Employee, LocalDate, Boolean>() {
		
		@Override
		public Boolean apply(Employee t, LocalDate u) {
			// TODO Auto-generated method stub
			return true;
		}
	};
	public static <T> List<T> conditionalRemove(ArrayList<T> list, Predicate<T> p) {

		for (T t : list) {
			if (p.test(t)) {
				list.remove(t);
			}
		}
		return list;
	}
}

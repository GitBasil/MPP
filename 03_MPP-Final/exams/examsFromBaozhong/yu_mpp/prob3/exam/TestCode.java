package prob3.exam;
import java.util.*;
public class TestCode {
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		List<Person> testData = new ArrayList<Person>() {
			{
				add(new Person("Jim", 40));
				add(new Person("Tom", 25));
				add(new Person("Bill", 30));
				add(new Person("Rich", 35));
				add(new Person("Anna", 20));
				add(new Person("Ricardo",17));
				add(new Person("Jimenez", 26));
				add(new Person("Jesus", 45));
				add(new Person("Michelle", 30));
				add(new Person("Angelina", 33));
				add(new Person("Julio", 49));
				add(new Person("Andrew", 34));
			}
		};
		System.out.println(FindOldestPerson.findOldestPerson(testData));
	}
}

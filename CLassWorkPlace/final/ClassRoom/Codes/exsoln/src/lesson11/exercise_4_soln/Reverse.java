package lesson11.exercise_4_soln;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reverse {

	
	public static void reverse(List<?> items) {		
		reverseHelper(items);
	}

	private static <T> void reverseHelper(List<T> list) {
		List<T> tmp = new ArrayList<T>(list);   
		for (int i = 0; i < list.size(); i++) { 
	        list.set(i, tmp.get(list.size() - i - 1));
		}
	}
	
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(new Person("Joe"), new Person("Jim"), 
				new Person("Tom"), new Person("Anne"));
		System.out.println("Before reversing: " + persons);
		Reverse.reverse(persons);
		System.out.println("After reversing: " + persons);
		
	}
}

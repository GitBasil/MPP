package lesson7.exercise_1;

public class Main {

	public static void main(String[] args) {

		StringList l = new MyStringList();
		l.add("Bob");
		l.add("Steve");
		l.add("Susan");
		l.add("Mark");
		l.add("Dave");
		System.out.println("Element at position 2: " + l.get(2));
		System.out.println("The list: " + l);
		
	}
}

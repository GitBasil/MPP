package lesson9.exercise_4_soln;

import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		//soln1();
		soln2();
	}
	//Use the reduce method to produce a single space-separated String
	public static void soln1() {
		System.out.println(
			Stream.of("A", "good", "day", "to", "write", "some", "Java")
		          .reduce("", (s, t) -> s + t + " ").trim());
		                    
		
	}
	
	
	//more efficient
	public static void soln2() {
		System.out.println(
			Stream.of("A", "good", "day", "to", "write", "some", "Java")
		          .reduce("", (s, t) -> 
		                    (new StringBuilder(s)).append(t + " ").toString()));
		
	}

}

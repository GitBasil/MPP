package lesson11.exercise_2_soln;

import java.util.stream.Stream;

/** Use streams */
public class CountArbitraryOccurrences2 {
	public static <T> int countOccurrences(T[] arr, T target) {
		return (int)Stream.of(arr)
				   .filter(x -> (x == null && target == null) || x.equals(target)) 
		           .count();
	}

	
	
	
	
	
	
	
	
	
	public static <T> int countOccurrences2(T[] arr, T target) {
		return (int)Stream.of(arr).filter(x ->  
		 {
			if(target == null) return (x == null);
			else return target.equals(x);
		 }).count();
		
	}
	
	public static void main(String[] args) {
		String[] arr = {"a", "b", "c", "b"};
		System.out.println(countOccurrences(arr, "b"));
		System.out.println(countOccurrences2(arr, "b"));
		
		Object[] arr2 = {"a", null, "c", null};
		System.out.println(countOccurrences(arr2, null));
		System.out.println(countOccurrences2(arr2, null));
	}
}

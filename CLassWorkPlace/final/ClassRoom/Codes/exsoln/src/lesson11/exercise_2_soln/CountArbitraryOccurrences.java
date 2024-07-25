package lesson11.exercise_2_soln;

import java.util.stream.Stream;

public class CountArbitraryOccurrences {
	public static <T> int countOccurrences(T[] arr, T target) {
		int count = 0;
		if (target == null) {
			for (T item : arr) {
				if (item == null) {
					count++;
				}
			}
		} else {
			for (T item : arr) {
				if (target.equals(item)) {
					count++;
				}
			}
		}
		return count;
	}

	
	public static void main(String[] args) {
		String[] arr = {"a", "b", "c", "b"};
		System.out.println(countOccurrences(arr, "b"));
		
		Object[] arr2 = {"a", null, "c", null};
		System.out.println(countOccurrences(arr2, null));
	}
}

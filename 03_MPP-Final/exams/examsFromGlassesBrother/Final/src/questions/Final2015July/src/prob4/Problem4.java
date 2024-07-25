package questions.Final2015July.src.prob4;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Problem4 {
	// IMPLEMENT
	public static <T> ArrayList<T> combine(Stream<ArrayList<T>> stream) {
		// return new ArrayList<T>();
		return stream.reduce(new ArrayList<T>(), (a, b) -> {
			a.addAll(b);
			return a;

		});
	}

	public static void testCombine() {
		ArrayList<ArrayList<String>> mainList = new ArrayList<>();
		ArrayList<String> list1 = new ArrayList<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add("hello");
				add("there");
			}
		};
		ArrayList<String> list2 = new ArrayList<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add("goodbye");
				add("there");
			}
		};
		mainList.add(list1);
		mainList.add(list2);
		System.out.println(combine(mainList.stream()));
	}

	public static void main(String[] args) {
		testCombine();
	}
}

package prog6_4_soln;

import java.util.Arrays;
import java.util.Comparator;

public class MainAnonymous {
	public static void main(String[] args) {
		StringSort ss = new StringSort(new  Comparator<String>() {
							public int compare(String s1,String s2) {
								return s1.length() - s2.length();
							}
						});
		String[] arr = {"jad","Anonymous","alhassan","ibrahim"};
		ss.stringSort(arr);
		System.out.println(Arrays.asList(arr));
	}
}

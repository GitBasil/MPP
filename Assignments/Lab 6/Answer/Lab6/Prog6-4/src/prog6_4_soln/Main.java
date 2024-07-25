package prog6_4_soln;
import java.util.Arrays;
public class Main {
	public static void main(String[] args) {
		StringSort ss = new StringSort(new StringLengthComparator());
		String[] arr = {"jad","alhassan","ibrahim"};
		ss.stringSort(arr);
		System.out.println(Arrays.asList(arr));
	}
}
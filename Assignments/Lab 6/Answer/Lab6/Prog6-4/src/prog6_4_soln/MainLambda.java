package prog6_4_soln;
import java.util.Arrays;
public class MainLambda {
	public static void main(String[] args) {
		StringSort ss = new StringSort((String s1,String s2)->s1.length()-s2.length());
		String[] arr = {"jad","samah","Lambda","alhassan","ibrahim"};
		ss.stringSort(arr);
		System.out.println(Arrays.asList(arr));
	}
}

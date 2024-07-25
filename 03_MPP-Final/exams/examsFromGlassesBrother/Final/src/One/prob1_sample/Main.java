package One.prob1_sample;

import java.util.Comparator;
import java.util.List;

public class Main {

	//QUERY: Given a list of Strings, find a string of shortest length
	
	//85% solution
	public static String findAShortest1(List<String> list) {
		return list.stream().min(Comparator.comparing(str -> str.length())).get();
	}
	
	//100% solution
	public static String findAShortest2(List<String> list) {
		return LambdaLibrary.SHORTEST.apply(list);
	}

	

}

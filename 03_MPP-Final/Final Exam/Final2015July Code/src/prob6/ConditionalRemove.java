package prob6;

import java.util.function.Predicate;
import java.util.*;
public class ConditionalRemove {
	static class StrLengthCondition implements Predicate<String> {
		public boolean test(String s) {
			return s.length() == 5;
		}
	}
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>() {
			{
				add("Hello");add("Goodbye");
			}
		};
		System.out.println(conditionalRemove(list));
	}
	public static List<String> conditionalRemove(ArrayList<String> list) {
		StrLengthCondition cond = new StrLengthCondition();
		for(String s : list) {
			if(cond.test(s)) {
				list.remove(s);
			}
		}
		return list;
	}
}

package two.prob1;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLibrary {

	public static final String IMPLEMENT = "IMPLEMENT";
	public static Predicate<LibraryMember> FILTER_BY_STATE = new Predicate<LibraryMember>() {
		
		@Override
		public boolean test(LibraryMember t) {
			return t.getAddress().getState().equals("CA");
		}
	};
	
	public static Predicate<LibraryMember> FILTER_BY_FIRSTNAME = new Predicate<LibraryMember>() {
		
		@Override
		public boolean test(LibraryMember t) {
			return t.getFirstName().toCharArray()[0] > 'M';
		}
	};
	
	public static Comparator<LibraryMember> COMPARE_BY_AGE = new Comparator<LibraryMember>() {
		
		@Override
		public int compare(LibraryMember o1, LibraryMember o2) {
			if(o1.getAge() > o2.getAge())
				return 1;
			else if(o1.getAge() < o2.getAge())
				return -1;
			return 0;
		}
	};
	
	public static Function<LibraryMember, String> TO_FULLNAME = new Function<LibraryMember, String>() {
		
		@Override
		public String apply(LibraryMember t) {
			return t.getFullname();
		}
	};
}

package prob2.exam.partC;

import java.util.Comparator;
import java.util.function.BiPredicate;

//The lambda:   (Long a, Long b) -> a.compareTo(b)
//NOTE: You may NOT type this as a BiFunction
public class PartC {
	
	//provide a functional interface type for the lambda - do NOT use BiFunction
	BiPredicate<Long,Long> f1 = (Long a, Long b) -> a.compareTo(b)>0?true:false;

	//provide a method reference and the type of method reference
	//TYPE: 
	public static boolean compare(Long a, Long b){
		return a.compareTo(b)>0?true:false;
	}
	BiPredicate<Long,Long> f2 =PartC::compare;

	// provide an inner class that behaves the same way as the labmda
	//class My--- implements --- { }
	class MyClass implements BiPredicate<Long,Long> {
		@Override
		public boolean test(Long a, Long b) {
			return a.compareTo(b)>0?true:false;
		}
	}
		
	
	public void evaluator() {
		Long a = 100L;
		Long b = 200L;
		System.out.println(f1.test(a,b));
		System.out.println(f2.test(a,b));

		MyClass myClass = new MyClass();
		System.out.println(myClass.test(a,b));

	}
	
	public static void main(String[] args) {
		PartC pa = new PartC();
		pa.evaluator();
	}
}

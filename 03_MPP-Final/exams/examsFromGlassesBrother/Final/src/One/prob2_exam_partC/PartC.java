package One.prob2_exam_partC;

import java.util.Comparator;

//The lambda:   (Long a, Long b) -> a.compareTo(b)
//NOTE: You may NOT type this as a BiFunction
public class PartC {

	// provide a functional interface type for the lambda - do NOT use
	// BiFunction
	Mycomp my = new Mycomp();
	Comparator<Long> ss = (o1, o2) -> my.compare(o1, o2);

	// provide a method reference and the type of method reference
	// TYPE:
	Comparator<Long> ss1 = Long::compare;

	// provide an inner class that behaves the same way as the labmda
	class Mycomp implements Comparator<Long> {

		@Override
		public int compare(Long o1, Long o2) {
			// TODO Auto-generated method stub
			return o1.compareTo(o2);
		}

	}

	public void evaluator() {
		// System.out.println(new longCompa().compare(2300000L, 3400000L);
		System.out.println(new Mycomp().compare(1230000L, 1278901L));
	}

	public static void main(String[] args) {
		PartC pa = new PartC();
		pa.evaluator();
	}
}

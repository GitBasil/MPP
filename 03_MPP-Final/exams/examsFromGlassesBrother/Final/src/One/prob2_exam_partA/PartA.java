package One.prob2_exam_partA;

import java.util.function.Supplier;

//The lambda:   () -> Math.random()
public class PartA {
	// provide a functional interface type for the lambda
	MyClass mycl = new MyClass();
	Supplier<Double> spl = () -> Math.random();

	// provide a method reference and the type of method reference
	// TYPE:

	Supplier<Double> spl1 = Math::random;

	// provide an inner class that behaves the same way as the labmda
	class MyClass implements Supplier<Double> {

		@Override
		public Double get() {
			// TODO Auto-generated method stub
			return Math.random();
		}

	}

	public void evaluator() {
		// implement the lambda, the method reference, and the inner class operation
		System.out.println(spl1.get());
	}

	public static void main(String[] args) {
		PartA pa = new PartA();
		pa.evaluator();
	}
}

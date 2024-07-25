package prob2.exam.partA;


import java.util.function.Supplier;

//The lambda:   () -> Math.random()
public class PartA {
	//provide a functional interface type for the lambda
	Supplier f1 = () ->Math.random();
	
	//provide a method reference and the type of method reference
	//TYPE: Class::staticMethod
	Supplier f2 = Math::random;
	
	// provide an inner class that behaves the same way as the labmda
	//class MyClass implements ... { }
	class MyClass implements Supplier{

		@Override
		public Double get() {
			return Math.random();
		}
	}
	
	
	public void evaluator() {
		//implement the lambda, the method reference, and the inner class operation
		System.out.println(f1.get());
		System.out.println(f2.get());

		MyClass myClass = new MyClass();
		System.out.println(myClass.get());
	}
	
	public static void main(String[] args) {
		PartA pa = new PartA();
		pa.evaluator();
	}
}

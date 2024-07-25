package prob2.sample;

import java.util.function.Consumer;

//obj::instanceMethod
	//Consumer<String> print = x -> System.out.println(x);

//The lambda:   (String x) -> System.out.println(x);

public class Sample {
	
	//provide a functional interface type for the lambda - do NOT use BiFunction
	Consumer<String> print = x -> System.out.println(x);
	
	//provide a method reference and the type of method reference
	//TYPE: obj::instanceMethod
	Consumer<String> print2 = System.out::println;
	
	// provide an inner class that behaves the same way as the labmda
	//class My--- implements --- { }
	class MyConsumer implements Consumer<String> {

		@Override
		public void accept(String str) {
			System.out.println(str);		
		}
		
	}
		
	
	public void evaluator() {
		print.accept("Hello");
		print2.accept("Hello");
		(new MyConsumer()).accept("Hello");
	}
	
	public static void main(String[] args) {
		Sample pa = new Sample();
		pa.evaluator();
	}
}

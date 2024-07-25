package prob1;

import java.util.function.BiFunction;

// working with lambda expression:   (Integer x, Integer y) -> x * x + y * y
public class SampleProblem1 {
	// name and type of lambda goes here
	BiFunction<Integer, Integer, Integer> bifunction =
			(x, y) -> x * x + y * y;
	
	// representing lambda as a method refrence
	BiFunction<Integer, Integer, Integer> bifunction2 =
			SampleProblem1::sumSquares;
	
	//representing lambda as a static nested class
	static class BiFunc implements BiFunction<Integer, Integer, Integer> {
		public Integer apply(Integer x, Integer y) {
			return x * x + y * y;
		}
	}
	
	private static int sumSquares(int x, int y) {
		return x * x + y * y;
	}
	
	//evaluate with Integer inputs 2, 7
	public void evaluator() {
		System.out.println(bifunction.apply(2, 7));
		System.out.println(bifunction2.apply(2,7));
		System.out.println((new BiFunc()).apply(2,  7));
	}
	public static void main(String[] args) {
		SampleProblem1 p = new SampleProblem1();
		p.evaluator();
	}
	
	
	

}

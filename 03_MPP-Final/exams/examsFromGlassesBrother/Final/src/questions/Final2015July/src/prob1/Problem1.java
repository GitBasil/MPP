package questions.Final2015July.src.prob1;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

//work with this lambda expression:   (Double x, Double y) -> x * y < x + y
public class Problem1 {
	// name and type of lambda goes here
	BiPredicate<Double,Double> bifunc=(x,y)-> x * y < x + y;
	
	// representing lambda as a method refrence
	
	BiPredicate<Double,Double> lambda=this::myMethod;
	StaticClass ss=new StaticClass();
	//representing lambda as a static nested class
	static class StaticClass implements BiPredicate<Double,Double>{

		@Override
		public boolean test(Double x, Double y) {
			// TODO Auto-generated method stub
			return x * y < x + y;
		}
		
	}
	public boolean myMethod(Double x,Double y){
		return x*x<x+y;
	}
	
	//evaluate with Double inputs 2.1, 0.35
	public void evaluator() {
		
		System.out.println(ss.test(2.0, 3.0));
		System.out.println(bifunc.test(2.0, 3.0));
	}
	public static void main(String[] args) {
		Problem1 p = new Problem1();
		p.evaluator();
	}
	
	
}

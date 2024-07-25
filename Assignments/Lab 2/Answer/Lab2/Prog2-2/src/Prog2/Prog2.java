package Prog2;
public class Prog2 {

	public static void main(String[] args) {
		int num1 = RandomNumbers.getRandomInt(1,9);
		double pi = Math.PI;
		System.out.println("First Random Number is:"+num1+"\nAfter compute: "+Math.pow(pi, num1));
		
		int num2 = RandomNumbers.getRandomInt(3,14);
		System.out.println("Second Random Number is:"+num2+"\nAfter compute: "+Math.pow(num2,pi));
	}

}

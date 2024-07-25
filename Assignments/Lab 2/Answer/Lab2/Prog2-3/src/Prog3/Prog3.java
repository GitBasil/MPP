package Prog3;

public class Prog3 {

	public static void main(String[] args) {
		float num1 = 1.27f,num2 = 3.881f,num3 = 9.6f;
		int sum = (int) (num1+num2+num3);
		System.out.println("Sum: "+sum);
		
		sum = (int) (Math.round(num1+num2+num3));
		System.out.println("Sum with round: "+sum);
	}

}

package Prog5;
import java.util.Scanner;

public class Prog5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Type String: ");
		String text = sc.nextLine();
		sc.close();
		
		int len =text.length();
		String reverse="";
		for(int i=len-1;i>=0;i--)
			reverse = reverse + text.charAt(i);
		System.out.print("Reverse: "+reverse);
	}

}

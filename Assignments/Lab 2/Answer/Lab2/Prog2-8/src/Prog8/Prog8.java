package Prog8;

public class Prog8 {
	public static void main(String[] args) {
	
	}
	public static int min(int[] numbers) {
		int minValue = numbers[0];
		for(int i=1;i<numbers.length;i++){
		    if(numbers[i] < minValue){
		      minValue = numbers[i];
		    }
		}
		return minValue;
	}
}
package lesson7.exercise_2_soln;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		System.out.println(Consts.COMPANY.strval());
		System.out.println(Consts.SALES_TARGET.intval());
		System.out.println("All constants: " + Arrays.toString(Consts.values()));

	}

}

package two.prob3;

import java.util.Arrays;


public class QuarterlySalary {
	
	public int[] getSalaries() {
		return salaries;
	}
	private int[] salaries;
	public QuarterlySalary(int[] salaries) {
		this.salaries = salaries;
	}

	public boolean equals(QuarterlySalary ob) {
		 return Arrays.equals(getSalaries(), ob.getSalaries());
	}
	
}

package two.prob3;

import java.util.Arrays;

public class Employee {
	private String name;
	private int[] threeMonthSalary;
	public Employee(String name, int[] threeMonthSalary) {
		this.name = name;
		this.threeMonthSalary = threeMonthSalary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getThreeMonthSalary() {
		return threeMonthSalary;
	}
	public void setThreeMonthSalary(int[] threeMonthSalary) {
		this.threeMonthSalary = threeMonthSalary;
	}
	@Override 
	public String toString() {
		return "(" + name + ", " + Arrays.toString(threeMonthSalary) + ")";
	}
	
}

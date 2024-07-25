package prog11_1_soln;

import java.util.HashMap;
//import java.util.Iterator;

public class Employee {
	private String firstName;
	private String lastName;
	private HashMap<String, Double> salaryRecord = new HashMap<String,Double>();
	
	public void addEntry(String date, double salary) {
		salaryRecord.put(date, salary);
	}
	public void printPaymentAmount(String date) {
		if(salaryRecord.get(date) != null) {
			System.out.println(this.firstName+" "+this.lastName+" was paid "+salaryRecord.get(date)+" on "+date);
		} else {
			System.out.println(this.firstName+" "+this.lastName+" did not receive a paycheck on "+date);
		}		
	}
	public void printAveragePaycheck() {
		double total = 0;
		for (String  s: salaryRecord.keySet()) {
			total = total + salaryRecord.get(s);
		}
		System.out.println("Average paycheck for "+this.firstName+" "+this.lastName+" was "+(total / salaryRecord.size()));//13,344
	}
	
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setFirstName("Jim");
		e.setLastName("Jones");
		e.addEntry("1/15/2011", 3005.50);
		e.addEntry("2/15/2011", 3150.00);
		e.addEntry("3/15/2011", 4200.00);
		e.addEntry("4/15/2011", 2988.50);
		
		e.printPaymentAmount("3/15/2011");
		e.printPaymentAmount("5/15/2010");
		e.printAveragePaycheck();
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

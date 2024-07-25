package prog4_1_soln;

import java.util.GregorianCalendar;

public class Professor extends DeptEmployee {
	private int numberOfPublications;
	public Professor(String name,double salary,int aYear,int aMonth, int aDay,int numberOfPublications) {
		setName(name);
		this.salary = salary;
		GregorianCalendar cal = new GregorianCalendar(aYear,aMonth - 1,aDay);
		setHireDate(cal.getTime());
		this.setNumberOfPublications(numberOfPublications);
	}
	public int getNumberOfPublications() {
		return numberOfPublications;
	}
	public void setNumberOfPublications(int numberOfPublications) {
		this.numberOfPublications = numberOfPublications;
	}	
}

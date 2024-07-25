package prog4_1_soln;

import java.util.GregorianCalendar;

public class Secretary extends DeptEmployee {
	private double overtimeHours;
	public Secretary(String name,double salary,int aYear,int aMonth, int aDay,double overtimeHours) {
		setName(name);
		this.salary = salary;
		GregorianCalendar cal = new GregorianCalendar(aYear,aMonth - 1,aDay);
		setHireDate(cal.getTime());
		this.setOvertimeHours(overtimeHours);
	}
	public double getOvertimeHours() {
		return overtimeHours;
	}
	public void setOvertimeHours(double overtimeHours) {
		this.overtimeHours = overtimeHours;
	}
	@Override
	public double computeSalary() {
		return (this.salary + (12 * this.overtimeHours));
	}
}

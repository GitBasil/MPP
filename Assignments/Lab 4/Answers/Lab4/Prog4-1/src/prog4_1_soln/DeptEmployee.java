package prog4_1_soln;

import java.util.Date;

public class DeptEmployee {
	private String name;
	public double salary;
	private Date hireDate;
	
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public void setName(String s) {
		this.name = s;
	}
	public String getName() {
		return this.name;
	}
	public double computeSalary() {
		return this.salary;
	}
}
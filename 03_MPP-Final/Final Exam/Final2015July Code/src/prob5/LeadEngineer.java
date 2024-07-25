package prob5;
import java.time.LocalDate;
import java.util.*;
public class LeadEngineer extends Employee {
	private List<Project> projects;
	public LeadEngineer(String name, double salary, LocalDate hireDate, List<Project> projects) {
		super(name, salary, hireDate);
		this.projects = projects;
	}
	
	public double getSalary() {
		return getSalary() + computeBonus();
	}
	
	double computeBonus() {
		int hireYear = getHireDate().getYear();
		int thisYear = LocalDate.now().getYear();
		return 400 * (thisYear - hireYear);
	}
		
}

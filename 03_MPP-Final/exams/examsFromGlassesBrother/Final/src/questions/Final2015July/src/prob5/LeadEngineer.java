package questions.Final2015July.src.prob5;
import java.time.LocalDate;
import java.util.*;
public class LeadEngineer extends Employee implements Default{
	private List<Project> projects;
	public LeadEngineer(String name, double salary, LocalDate hireDate, List<Project> projects) {
		super(name, salary, hireDate);
		this.projects = projects;
	}
	
	public double getSalary() {
		return getSalary() + computeBonus();
	}
	
	
		
}

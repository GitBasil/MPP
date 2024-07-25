package prob5;

import java.time.LocalDate;
import java.util.List;

public class Manager extends Employee{
	List<SeminarsConducted> seminars;
	public Manager(String name, double salary, LocalDate hireDate, List<SeminarsConducted> seminars) {
		super(name, salary, hireDate);
		this.seminars = seminars;	
	}
	
	@Override
	public double getSalary() {
		return getSalary() + computeBonus();
	}
	
	double computeBonus() {
		int hireYear = getHireDate().getYear();
		int thisYear = LocalDate.now().getYear();
		return 400 * (thisYear - hireYear);
	}
}

